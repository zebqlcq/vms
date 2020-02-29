package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.MessageNoticeTemplate;
import com.bonade.visitor.domain.entity.MessageNoticeUser;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.enums.NoticeType;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.mapper.MessageNoticeTemplateMapper;
import com.bonade.visitor.mapper.MessageNoticeUserMapper;
import com.bonade.visitor.mapper.VisitorMapper;
import com.bonade.visitor.service.remote.UaacService;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.Assert;
import org.spin.core.collection.Pair;
import org.spin.core.util.BeanUtils;
import org.spin.core.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class MessageNoticeTemplateService extends ServiceImpl<MessageNoticeTemplateMapper, MessageNoticeTemplate> {

    @Autowired
    private MessageNoticeUserMapper messageNoticeUserMapper;

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private UaacService uaacService;

    /**
     * @description 保存或修改
     * @author chenmeng
     * @date 2019-12-19 10:18
     */
    public MessageNoticeTemplateOutVo saveOrUpdate(MessageNoticeTemplateInVo vo) {
        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
        if (sessionEnterprise.c2.longValue() == 0L)
            throw new BizException("查不到企业信息，请切换企业登录");
        MessageNoticeTemplateOutVo messageNoticeTemplateOutVo = new MessageNoticeTemplateOutVo();
        if (vo.getId() != null) {
            //更新
            MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(vo.getId());
            if (messageNoticeTemplate == null)
                throw new BizException("查不到消息模板");
            String code = messageNoticeTemplate.getCode();
            BeanUtils.copyTo(vo, messageNoticeTemplate);
            messageNoticeTemplate.setCode(code);
            messageNoticeTemplate.setEnterpriseId(sessionEnterprise.c2.longValue());
            baseMapper.updateById(messageNoticeTemplate);
            BeanUtils.copyTo(messageNoticeTemplate, messageNoticeTemplateOutVo);
        } else {
            //新增
            MessageNoticeTemplate messageNoticeTemplate = new MessageNoticeTemplate();
            String code = vo.getNoticeType().getDescription() + "-" + sessionEnterprise.c2.longValue() + "-" + DateUtils.formatDateForDay(LocalDateTime.now());
            List<MessageNoticeTemplate> list = getList(code);
            while (list.size() > 0) {
                Integer i = 1;
                code = vo.getNoticeType().getDescription() + "-" + sessionEnterprise.c2.longValue() + "-" + DateUtils.formatDateForDay(LocalDateTime.now()) + "-" + i;
                i++;
                list = getList(code);
            }
            vo.setCode(code);
            BeanUtils.copyTo(vo, messageNoticeTemplate);
            messageNoticeTemplate.setEnterpriseId(sessionEnterprise.c2.longValue());
            baseMapper.insert(messageNoticeTemplate);
            vo.setId(messageNoticeTemplate.getId());
            BeanUtils.copyTo(messageNoticeTemplate, messageNoticeTemplateOutVo);
        }

        if (vo.getAllUser() == 1) {
            LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
                .eq(MessageNoticeUser::getMessageId, vo.getId());
            messageNoticeUserMapper.delete(queryWrapper);
        }
        return messageNoticeTemplateOutVo;
    }

    public void saveUserOrVisitList(MessageNoticeUserInVo vo) {
        MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(vo.getMessageId());
        if (messageNoticeTemplate == null)
            throw new BizException("查不到消息模板");
//        LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
//            .eq(MessageNoticeUser::getMessageId, vo.getMessageId());
        if (1 == vo.getAutoSync()) {
//            LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
//                .eq(MessageNoticeUser::getMessageId, vo.getMessageId())
//                .isNotNull(MessageNoticeUser::getVisitorId);
//            messageNoticeUserMapper.delete(queryWrapper);
            for (VisitorAttribute visitorAttribute : vo.getVisitorAttributeList()) {
                if (visitorAttribute.equals(VisitorAttribute.BLACK)) {
                    messageNoticeTemplate.setBlackSync(1);
                }
                if (visitorAttribute.equals(VisitorAttribute.VIP)) {
                    messageNoticeTemplate.setVipSync(1);
                }
                if (visitorAttribute.equals(VisitorAttribute.PLAIN)) {
                    messageNoticeTemplate.setPlainSync(1);
                }
            }
            baseMapper.updateById(messageNoticeTemplate);
        }
        if (0 == vo.getAutoSync()) {
            for (VisitorAttribute visitorAttribute : vo.getVisitorAttributeList()) {
                if (visitorAttribute.equals(VisitorAttribute.BLACK)) {
                    messageNoticeTemplate.setBlackSync(0);
                }
                if (visitorAttribute.equals(VisitorAttribute.VIP)) {
                    messageNoticeTemplate.setVipSync(0);
                }
                if (visitorAttribute.equals(VisitorAttribute.PLAIN)) {
                    messageNoticeTemplate.setPlainSync(0);
                }
            }
            baseMapper.updateById(messageNoticeTemplate);
        }
        //访客列表保存
        if (vo.getVisitorIdList() != null) {
            for (Long id : vo.getVisitorIdList()) {
                MessageNoticeUser messageNoticeUser = new MessageNoticeUser();
                messageNoticeUser.setMessageId(vo.getMessageId());
                messageNoticeUser.setVisitorId(id);
                messageNoticeUserMapper.insert(messageNoticeUser);
            }
        }
        //删除指定访客
        if (vo.getDelVisitorIdList() != null) {
            LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
                .eq(MessageNoticeUser::getMessageId, vo.getMessageId())
                .in(MessageNoticeUser::getVisitorId, vo.getDelVisitorIdList());
            messageNoticeUserMapper.delete(queryWrapper);
        }
        //删除全部访客
        if (1 == vo.getDelAllVisit()) {
            LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
                .eq(MessageNoticeUser::getMessageId, vo.getMessageId())
                .isNotNull(MessageNoticeUser::getVisitorId);
            messageNoticeUserMapper.delete(queryWrapper);
        }
        //内部员工列表保存
        if (vo.getUserIdList() != null) {
            LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
                .eq(MessageNoticeUser::getMessageId, vo.getMessageId())
                .isNotNull(MessageNoticeUser::getUserId);
            messageNoticeUserMapper.delete(queryWrapper);
            for (Long id : vo.getUserIdList()) {
                MessageNoticeUser messageNoticeUser = new MessageNoticeUser();
                messageNoticeUser.setMessageId(vo.getMessageId());
                messageNoticeUser.setUserId(id);
                messageNoticeUserMapper.insert(messageNoticeUser);
            }
        }
        //删除指定员工
        if (vo.getDelUserIdList() != null) {
            LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
                .eq(MessageNoticeUser::getMessageId, vo.getMessageId())
                .in(MessageNoticeUser::getUserId, vo.getDelUserIdList());
            messageNoticeUserMapper.delete(queryWrapper);
        }
        //删除全部员工
        if (1 == vo.getDelAllUser()) {
            LambdaQueryWrapper<MessageNoticeUser> queryWrapper = QueryBuilder.<MessageNoticeUser>lambdaQuery()
                .eq(MessageNoticeUser::getMessageId, vo.getMessageId())
                .isNotNull(MessageNoticeUser::getUserId);
            messageNoticeUserMapper.delete(queryWrapper);
        }

        //保存部门 岗位 自定义组织
        if (vo.getStaffType() != null) {
            MessageNoticeUser messageNoticeUser = new MessageNoticeUser();
            messageNoticeUser.setMessageId(vo.getMessageId());
            messageNoticeUser.setStaffType(vo.getStaffType());
            messageNoticeUser.setTypeId(vo.getTypeId());
            messageNoticeUserMapper.insert(messageNoticeUser);
        }
    }

    public MessageNoticeTemplateOutVo getById(Long id) {
        MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(id);
        if (messageNoticeTemplate == null)
            throw new BizException("查不到消息模板");
        MessageNoticeTemplateOutVo messageNoticeTemplateOutVo = new MessageNoticeTemplateOutVo();
        BeanUtils.copyTo(messageNoticeTemplate, messageNoticeTemplateOutVo);
        return messageNoticeTemplateOutVo;
    }

    public MessageNoticeTemplate getByVo(MessageNoticeUserSerachVo vo) {
        LambdaQueryWrapper<MessageNoticeTemplate> query = QueryBuilder.<MessageNoticeTemplate>lambdaQuery()
            .eq(MessageNoticeTemplate::getEnterpriseId, vo.getEnterpriseId())
            .eq(MessageNoticeTemplate::getNoticeType, vo.getNoticeType());
        List<MessageNoticeTemplate> messageNoticeTemplateList = baseMapper.selectList(query);
        if (messageNoticeTemplateList.size() == 0)
            throw new BizException("查不到消息模板");
        MessageNoticeTemplate messageNoticeTemplate = messageNoticeTemplateList.get(0);
        if (messageNoticeTemplate.getAllUser() == 1) {
            return messageNoticeTemplate;
        }
        LambdaQueryWrapper<MessageNoticeUser> userQuery = QueryBuilder.<MessageNoticeUser>lambdaQuery()
            .eq(MessageNoticeUser::getMessageId, messageNoticeTemplate.getId());
        List<MessageNoticeUser> userList = messageNoticeUserMapper.selectList(userQuery);
        if (vo.getVisitorId() != null) {
            Visitor visitor = visitorMapper.selectById(vo.getVisitorId());
            if (visitor == null)
                throw new BizException("查不到访客信息");
            if (visitor.getVisitorAttribute().equals(VisitorAttribute.PLAIN) && messageNoticeTemplate.getPlainSync() != null && messageNoticeTemplate.getPlainSync() == 1)
                return messageNoticeTemplate;
            if (visitor.getVisitorAttribute().equals(VisitorAttribute.VIP) && messageNoticeTemplate.getVipSync() != null && messageNoticeTemplate.getVipSync() == 1)
                return messageNoticeTemplate;
            if (visitor.getVisitorAttribute().equals(VisitorAttribute.BLACK) && messageNoticeTemplate.getBlackSync() != null && messageNoticeTemplate.getBlackSync() == 1)
                return messageNoticeTemplate;
            for (MessageNoticeUser user : userList) {
                if (visitor.getId().equals(user.getVisitorId()) || visitor.getVisitorAttribute().equals(user.getVisitorAttribute()))
                    return messageNoticeTemplate;
            }

        }
        if (vo.getUserId() != null) {
            if (messageNoticeTemplate.getAllChoose() != null && messageNoticeTemplate.getAllChoose() == 1)
                return messageNoticeTemplate;
            EmployeeQueryVo employeeQueryVo = new EmployeeQueryVo();
            employeeQueryVo.setEnterpriseId(vo.getEnterpriseId());
            List<EmployeeOrganViewVo> organViewVoList = uaacService.listUserOrgan(employeeQueryVo);

            for (MessageNoticeUser user : userList) {
                if (user.getUserId() != null && vo.getUserId().equals(user.getUserId()))
                    return messageNoticeTemplate;
                if (user.getStaffType() != null) {
                    for (EmployeeOrganViewVo o : organViewVoList) {
                        if (user.getStaffType().equals(o.getRelationType()) && user.getTypeId().equals(o.getRelationId()))
                            return messageNoticeTemplate;
                    }
                }
            }
        }
        return null;
    }

    public void del(Long id) {
        MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(id);
        if (messageNoticeTemplate == null)
            throw new BizException("查不到消息模板");
        baseMapper.deleteById(id);
    }

    public IPage<MessageNoticeTemplateOutVo> getPage(MessageNoticeTemplateInVo vo) {
        Page<MessageNoticeTemplate> page = new Page<>(vo.getCurrent(), vo.getSize());
        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
        if (sessionEnterprise.c2.longValue() == 0L)
            throw new BizException("查不到企业信息，请切换企业登录");
        vo.setEnterpriseId(sessionEnterprise.c2.longValue());
        return baseMapper.getPage(page, vo);
    }


    public IPage<VisitOutVo> getMessageNoticevisitorList1(MessageNoticeTemplateInVo vo) {
        Page<MessageNoticeTemplate> page = new Page<>(vo.getCurrent(), vo.getSize());
        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
        if (sessionEnterprise.c2.longValue() == 0L)
            throw new BizException("查不到企业信息，请切换企业登录");
        vo.setEnterpriseId(sessionEnterprise.c2.longValue());
        if (vo.getId() != null) {
            MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(vo.getId());
            if (messageNoticeTemplate == null)
                throw new BizException("查询不到模板信息");
            return baseMapper.getMessageNoticeUserConPage(page, vo);
        }
        return baseMapper.getMessageNoticeUserPage(page, vo);
    }

    public Map<VisitorAttribute, List<NoticeVisitorVo>> getMessageNoticeVisitorList(MessageNoticeUserSerachVo vo) {
        Map<VisitorAttribute, List<NoticeVisitorVo>> map = new HashMap<>();
        LambdaQueryWrapper<Visitor> visitQuery = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getEnterpriseId, vo.getEnterpriseId());
        if (vo.getVisitorAttribute() != null)
            visitQuery.eq(Visitor::getVisitorAttribute, vo.getVisitorAttribute());
        if (vo.getKeyWord() != null && !vo.getKeyWord().equals(""))
            visitQuery.like(Visitor::getName, vo.getKeyWord());
        List<Visitor> visitorList = visitorMapper.selectList(visitQuery);
        MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(vo.getMessageId());
        if (messageNoticeTemplate == null)
            throw new BizException("查询不到模板信息");
        LambdaQueryWrapper<MessageNoticeUser> userQuery = QueryBuilder.<MessageNoticeUser>lambdaQuery()
            .eq(MessageNoticeUser::getMessageId, vo.getMessageId()).isNotNull(MessageNoticeUser::getVisitorId);
        List<MessageNoticeUser> messageNoticeUserList = messageNoticeUserMapper.selectList(userQuery);
        List<Long> idList = messageNoticeUserList.stream().map(e -> e.getVisitorId()).collect(Collectors.toList());
        for (Visitor v : visitorList) {
            if (map.get(v.getVisitorAttribute()) == null) {
                List<NoticeVisitorVo> voList = new ArrayList<>();
                NoticeVisitorVo noticeVisitorVo = new NoticeVisitorVo();
                if (idList.contains(v.getId()))
                    noticeVisitorVo.setChoose(1);
                else
                    noticeVisitorVo.setChoose(0);
                noticeVisitorVo.setId(v.getId());
                noticeVisitorVo.setName(v.getName());
                noticeVisitorVo.setVisitorAttribute(v.getVisitorAttribute());
                voList.add(noticeVisitorVo);
                map.put(v.getVisitorAttribute(), voList);
            } else {
                NoticeVisitorVo noticeVisitorVo = new NoticeVisitorVo();
                if (idList.contains(v.getId()))
                    noticeVisitorVo.setChoose(1);
                else
                    noticeVisitorVo.setChoose(0);
                noticeVisitorVo.setId(v.getId());
                noticeVisitorVo.setName(v.getName());
                map.get(v.getVisitorAttribute()).add(noticeVisitorVo);
            }
        }
        return map;
    }

    public List<MessageNoticeUser> getMessageNoticeUserList(MessageNoticeUserSerachVo vo) {
        MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(vo.getMessageId());
        if (messageNoticeTemplate == null)
            throw new BizException("查询不到模板信息");
        LambdaQueryWrapper<MessageNoticeUser> userQuery = QueryBuilder.<MessageNoticeUser>lambdaQuery()
            .eq(MessageNoticeUser::getMessageId, vo.getMessageId());
        if (vo.getStaffType() != null)
            userQuery.eq(MessageNoticeUser::getStaffType, vo.getStaffType());
        List<MessageNoticeUser> messageNoticeUserList = messageNoticeUserMapper.selectList(userQuery);
        return messageNoticeUserList;
    }

    public List<MessageNoticeUser> getMessageNoticeList(MessageNoticeUserSerachVo vo) {
        MessageNoticeTemplate messageNoticeTemplate = baseMapper.selectById(vo.getMessageId());
        if (messageNoticeTemplate == null)
            throw new BizException("查询不到模板信息");
        LambdaQueryWrapper<MessageNoticeUser> userQuery = QueryBuilder.<MessageNoticeUser>lambdaQuery()
            .eq(MessageNoticeUser::getMessageId, vo.getMessageId());
        if (vo.getFlag() != null && vo.getFlag() == 1)
            userQuery.isNotNull(MessageNoticeUser::getVisitorId);
        if (vo.getFlag() != null && vo.getFlag() == 2)
            userQuery.isNotNull(MessageNoticeUser::getUserId);
        List<MessageNoticeUser> messageNoticeUserList = messageNoticeUserMapper.selectList(userQuery);
        return messageNoticeUserList;
    }

    /**
     * @description 根据条件查询列表
     * @author chenmeng
     * @date 2019-12-19 15:03
     */
    public List<MessageNoticeTemplate> getList(String code) {
        LambdaQueryWrapper<MessageNoticeTemplate> query = QueryBuilder.<MessageNoticeTemplate>lambdaQuery();
        query.eq(MessageNoticeTemplate::getCode, code);
        return baseMapper.selectList(query);
    }

    public List<MessageNoticeTemplate> getList(NoticeType noticeType) {
        LambdaQueryWrapper<MessageNoticeTemplate> query = QueryBuilder.<MessageNoticeTemplate>lambdaQuery();
        query.eq(MessageNoticeTemplate::getNoticeType, noticeType);
        return baseMapper.selectList(query);
    }


}
