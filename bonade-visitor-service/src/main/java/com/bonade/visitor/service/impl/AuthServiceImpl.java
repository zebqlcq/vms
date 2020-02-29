package com.bonade.visitor.service.impl;

import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.vo.SmsTemplateMessageVo;
import com.bonade.visitor.mapper.VisitorMapper;
import com.bonade.visitor.service.AuthService;
import com.bonade.visitor.service.remote.MessageService;
import com.bonade.visitor.service.remote.UaacService;
import org.spin.common.util.Env;
import org.spin.common.util.QueryBuilder;
import org.spin.core.Assert;
import org.spin.core.util.CollectionUtils;
import org.spin.core.util.MapUtils;
import org.spin.core.util.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * description
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2020/1/14.</p>
 */
@Service
public class AuthServiceImpl implements AuthService {

    private static final String SMS_LOGIN_CODE = "VERIFY_CODE:LOGIN:";

    private static final String SMS_VERIFY_CODE = "VERIFY_CODE";

    private static final Pattern PHONE_PATTERN = Pattern.compile("1\\d{10}");

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private MessageService messageService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UaacService uaacService;

    @Override
    public void sendVerifyCode(String phone) {
        List<String> decrypt = uaacService.decrypt(CollectionUtils.ofArrayList(phone));
        phone = decrypt.get(0);

        Assert.isTrue(PHONE_PATTERN.matcher(phone).matches(), "手机号码格式不正确");
        // 查询是否有该手机号码 访客信息
        List<Visitor> visitors = visitorMapper.selectList(QueryBuilder.<Visitor>lambdaQuery().eq(Visitor::getTel, phone));
        Assert.notEmpty(visitors, "访客信息不存在");

        String verifyCode = RandomStringUtils.randomNumeric(6);
        SmsTemplateMessageVo smsTemplateVo = new SmsTemplateMessageVo();
        smsTemplateVo.setTemplateCode(SMS_VERIFY_CODE);
        smsTemplateVo.setPhone(phone);

        // 开发环境
        if (Env.isDev()) {
            verifyCode = "123456";
        }
        smsTemplateVo.setParam(MapUtils.ofMap("verifyCode", verifyCode));
        messageService.sendSms(smsTemplateVo);

        // 缓存短信验证码
        redisTemplate.opsForValue().set(SMS_LOGIN_CODE + phone,
            verifyCode + "/" + visitors.get(0).getName() + "/MODULE:VISITOR-WECHAT-PROGRAM",
            5L, TimeUnit.MINUTES);
    }
}
