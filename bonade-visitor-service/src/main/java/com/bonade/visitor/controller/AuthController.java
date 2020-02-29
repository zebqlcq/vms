package com.bonade.visitor.controller;

import com.bonade.visitor.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.GetApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * description 认证
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2020/1/14.</p>
 */
@Validated
@RestController
@RequestMapping("v1/auth")
@Api(value = "访客认证接口", tags = "访客认证接口")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 发送登录短信验证码
     *
     * @param phone 手机号
     */
    @ApiOperation(value = "获取访客登录短信验证码")
    @GetApi(auth = AuthLevel.NONE, authors = "汪洋", value = "verifyCode")
    @ApiImplicitParam(name = "phone", value = "手机号码，需要RSA加密", required = true, paramType = "form")
    public void sendVerifyCode(@NotBlank(message = "手机号码不能为空") String phone) {
        authService.sendVerifyCode(phone);
    }
}
