package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.dto.*;
import com.bonade.visitor.domain.entity.*;
import com.bonade.visitor.domain.enums.*;
import com.bonade.visitor.domain.remote.EmpQueryVo;
import com.bonade.visitor.domain.remote.EmpViewVo;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.mapper.*;
import com.bonade.visitor.service.remote.MessageService;
import com.bonade.visitor.service.remote.UaacService;
import com.bonade.visitor.service.sms.SmsConstants;
import com.bonade.visitor.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.util.RemoteClient;
import org.spin.core.ErrorCode;
import org.spin.core.util.BeanUtils;
import org.spin.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zoushaopeng
 * @title: VisitIndexService
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/23 9:06
 */
@Service
public class VisitIndexService {

    private static final Logger logger = LoggerFactory.getLogger(VisitIndexService.class);

    @Autowired
    private VisitIndexMapper visitorIndexMapper;

    @Autowired
    private VisitRecordMapper visitRecordMapper;

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private GateSentryMapper gateSentryMapper;

    @Autowired
    private VisitRecordGateSentryMapper visitRecordGateSentryMapper;

    @Autowired
    private VisitNotifyMapper visitNotifyMapper;

    @Autowired
    private VisitFollowUserMapper visitFollowUserMapper;

    @Autowired
    private VisitRecordBehaviorTraceMapper visitRecordBehaviorTraceMapper;

    @Autowired
    private MessageNoticeTemplateService messageNoticeTemplateService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UaacService uaacService;

    public IPage<VisitIndexRecordApproalDto> getVisitIndexRecordApproalPageList(VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo) {
        IPage<VisitIndexRecordApproalDto> list;
        try {
            IPage<VisitIndexRecordApproalDto> page = new Page<>(visitIndexRecordApproalPageVo.getCurrent(), visitIndexRecordApproalPageVo.getSize());
            List<Integer> stateList = new ArrayList<>();
            stateList.add(0);
            list = visitorIndexMapper.getVisitIndexRecordApproalPageList(page, visitIndexRecordApproalPageVo, stateList, 0);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, e);
        }
        return list;
    }

    public IPage<VisitIndexRecordApproalDto> getVisitIndexRecordAlreadyApproalPageList(VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo) {
        IPage<VisitIndexRecordApproalDto> list;
        try {
            IPage<VisitIndexRecordApproalDto> page = new Page<>(visitIndexRecordApproalPageVo.getCurrent(), visitIndexRecordApproalPageVo.getSize());
            List<Integer> stateList = new ArrayList<>();
            stateList.add(1);
            stateList.add(2);
            list = visitorIndexMapper.getVisitIndexRecordApproalPageList(page, visitIndexRecordApproalPageVo, stateList, 0);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, e);
        }
        return list;
    }

    public IPage<VisitIndexRecordCopyApproalDto> getVisitIndexRecordCopyApproalPageList(VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo) {
        IPage<VisitIndexRecordCopyApproalDto> list;
        try {
            IPage<VisitIndexRecordCopyApproalDto> page = new Page<>(visitIndexRecordApproalPageVo.getCurrent(), visitIndexRecordApproalPageVo.getSize());
            list = visitorIndexMapper.getVisitIndexRecordCopyApproalPageList(page, visitIndexRecordApproalPageVo, 1);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, e);
        }
        return list;
    }

    public ApproalRecordDetailDto getApproalRecordDetail(Long id) {
        return visitorIndexMapper.getApproalRecordDetail(id);
    }

    public IPage<VisitorDto> getVisitorPageList(VisitorPageVo visitorPageVo) {
        IPage<VisitorDto> list;
        try {
            IPage<VisitorDto> page = new Page<>(visitorPageVo.getCurrent(), visitorPageVo.getSize());
            if (StringUtils.isNotBlank(visitorPageVo.getDateSelected())) {
                visitorPageVo.setDateSpareBegin(visitorPageVo.getDateSelected() + " 00:00:00");
                visitorPageVo.setDateSpareEnd(visitorPageVo.getDateSelected() + " 23:59:59");
            }
            list = visitorIndexMapper.getVisitorPageList(page, visitorPageVo);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, e);
        }
        return list;
    }

    public IPage<VisitorEnterpriseDto> getVisitorEnterprisePageList(VisitorEnterprisePageVo visitorEnterprisePageVo) {
        IPage<VisitorEnterpriseDto> list;
        try {
            IPage<VisitorEnterpriseDto> page = new Page<>(visitorEnterprisePageVo.getCurrent(), visitorEnterprisePageVo.getSize());
            if (StringUtils.isNotBlank(visitorEnterprisePageVo.getDateSelected())) {
                visitorEnterprisePageVo.setDateSpareBegin(visitorEnterprisePageVo.getDateSelected() + " 00:00:00");
                visitorEnterprisePageVo.setDateSpareEnd(visitorEnterprisePageVo.getDateSelected() + " 23:59:59");
            }
            list = visitorIndexMapper.getVisitorEnterprisePageList(page, visitorEnterprisePageVo);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, e);
        }
        return list;
    }

    public VisitorDetailDto getVisitorDetail(Long visitorId) {
        VisitorDetailDto visitorDetailDto = new VisitorDetailDto();
        Visitor visitor = visitorMapper.selectById(visitorId);
        if (visitor != null) {
            visitorDetailDto.setId(visitorId);
            if (StringUtils.isNotBlank(visitor.getFaceImg())) {
                visitorDetailDto.setFaceImg(visitor.getFaceImg());
            }
            if (!ObjectUtils.isEmpty(visitor.getFaceImgUploadTime())) {
                visitorDetailDto.setFaceImgUploadTime(visitor.getFaceImgUploadTime());
            }
            if (StringUtils.isNotBlank(visitor.getCardNoPositive())) {
                visitorDetailDto.setCardNoPositive(visitor.getCardNoPositive());
            }
            if (StringUtils.isNotBlank(visitor.getCardNoNegative())) {
                visitorDetailDto.setCardNoNegative(visitor.getCardNoNegative());
            }
            if (!ObjectUtils.isEmpty(visitor.getCardUploadTime())) {
                visitorDetailDto.setCardUploadTime(visitor.getCardUploadTime());
            }
            if (StringUtils.isNotBlank(visitor.getName())) {
                visitorDetailDto.setName(visitor.getName());
            }
            if (StringUtils.isNotBlank(visitor.getCartNo())) {
                visitorDetailDto.setCartNo(visitor.getCartNo());
            }
            if (StringUtils.isNotBlank(visitor.getCompanyName())) {
                visitorDetailDto.setCompanyName(visitor.getCompanyName());
            }
            if (StringUtils.isNotBlank(visitor.getTel())) {
                visitorDetailDto.setTel(visitor.getTel());
            }
            if (StringUtils.isNotBlank(visitor.getUserStation())) {
                visitorDetailDto.setUserStation(visitor.getUserStation());
            }
            if (StringUtils.isNotBlank(visitor.getCarNo())) {
                visitorDetailDto.setCarNo(visitor.getCarNo());
            }
        }

        List<VisitIndexRecordDto> visitIndexRecordList = visitorIndexMapper.getVisitIndexRecordList(visitorId);
        if (visitIndexRecordList != null && !visitIndexRecordList.isEmpty()) {
            visitorDetailDto.setVisitNum(visitIndexRecordList.size());
            visitorDetailDto.setVisitIndexRecordList(visitIndexRecordList);
        } else {
            visitorDetailDto.setVisitNum(0);
        }

        return visitorDetailDto;
    }

    public VerifyVisitorDetailDto verifyVisitorDetail(Long id) {
        VerifyVisitorDetailDto verifyVisitorDetailDto = visitorIndexMapper.verifyVisitorDetail(id);
        /*List<VerifyVisitorApprovalDetailDto> verifyVisitorApprovalDetailList = visitorIndexMapper.getVerifyVisitorApprovalDetailList(id);
        if (verifyVisitorDetailDto != null && verifyVisitorApprovalDetailList != null && !verifyVisitorApprovalDetailList.isEmpty()) {
            verifyVisitorDetailDto.setVerifyVisitorApprovalDetailList(verifyVisitorApprovalDetailList);
        }*/
        List<VerifyVisitorBehaviorTraceDetailDto> verifyVisitorBehaviorTraceDetailList = visitorIndexMapper.getVerifyVisitorBehaviorTraceDetailList(id);
        if (verifyVisitorDetailDto != null && verifyVisitorBehaviorTraceDetailList != null && !verifyVisitorBehaviorTraceDetailList.isEmpty()) {
            verifyVisitorDetailDto.setVerifyVisitorBehaviorTraceDetailList(verifyVisitorBehaviorTraceDetailList);
        }
        return verifyVisitorDetailDto;
    }

    public void verifyVisitorStatus(VerifyVisitorStatusVo verifyVisitorStatusVo) {
        VisitRecord visitRecord = visitRecordMapper.selectById(verifyVisitorStatusVo.getId());
        visitRecord.setRemark(verifyVisitorStatusVo.getVisitStatus() + "");
        visitRecord.setVisitStatus(verifyVisitorStatusVo.getVisitStatus());
        visitRecord.setOperationStatus(1);
        visitRecord.setOperationUserId(verifyVisitorStatusVo.getOperationUserId());
        if (StringUtils.isNotBlank(verifyVisitorStatusVo.getOperationRemark())) {
            visitRecord.setOperationRemark(verifyVisitorStatusVo.getOperationRemark());
        }
        visitRecord.setOperationTime(LocalDateTime.now());
        visitRecordMapper.updateById(visitRecord);
    }

    public IPage<InvitationRecordDto> getInvitationRecordPageList(InvitationRecordPageVo invitationRecordPageVo) {
        IPage<InvitationRecordDto> list;
        try {
            IPage<InvitationRecordDto> page = new Page<>(invitationRecordPageVo.getCurrent(), invitationRecordPageVo.getSize());
            list = visitorIndexMapper.getInvitationRecordPageList(page, invitationRecordPageVo);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, e);
        }
        return list;
    }

    public InvitationRecordDetailDto getInvitationRecordDetail(Long id) {
        InvitationRecordDetailDto invitationRecordDetailDto = visitorIndexMapper.getInvitationRecordDetail(id);
        List<VerifyVisitorBehaviorTraceDetailDto> verifyVisitorBehaviorTraceDetailList = visitorIndexMapper.getVerifyVisitorBehaviorTraceDetailList(id);
        if (invitationRecordDetailDto != null && verifyVisitorBehaviorTraceDetailList != null && !verifyVisitorBehaviorTraceDetailList.isEmpty()) {
            invitationRecordDetailDto.setVerifyVisitorBehaviorTraceDetailList(verifyVisitorBehaviorTraceDetailList);
        }
        return invitationRecordDetailDto;
    }

    public IPage<VisitorValidDto> getVisitorValidPageList(VisitorValidPageVo visitorValidPageVo) {
        IPage<VisitorValidDto> list;
        try {
            IPage<VisitorValidDto> page = new Page<>(visitorValidPageVo.getCurrent(), visitorValidPageVo.getSize());
            list = visitorIndexMapper.getVisitorValidPageList(page, visitorValidPageVo);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, e);
        }
        return list;
    }

    public VisitorValidDetailDto getVisitorValidDetail(Long id) {
        return visitorIndexMapper.getVisitorValidDetail(id);
    }

    @Transactional
    public void confirmInitiate(ConfirmInitiateVo confirmInitiateVo) {
        /*LambdaQueryWrapper<VisitRecordBehaviorTrace> visitRecordBehaviorTraceQuery = QueryBuilder.<VisitRecordBehaviorTrace>lambdaQuery()
            .eq(VisitRecordBehaviorTrace::getVisitRecordId, confirmInitiateVo.getId());
        List<VisitRecordBehaviorTrace> visitRecordBehaviorTraceList = visitRecordBehaviorTraceMapper.selectList(visitRecordBehaviorTraceQuery);
        if(visitRecordBehaviorTraceList != null && !visitRecordBehaviorTraceList.isEmpty()){
            visitRecordBehaviorTraceMapper.deleteById(visitRecordBehaviorTraceList.get(0).getId());
        }*/

        //行为记录
        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();
        trace.setVisitRecordId(confirmInitiateVo.getId());
        trace.setVisitStatus(VisitStatus.REQUESTVALIDA);
        trace.setOperationTime(LocalDateTime.now());
        trace.setUserId(confirmInitiateVo.getOriginatorId());
        trace.setUserName(confirmInitiateVo.getOriginatorName());
        visitRecordBehaviorTraceMapper.insert(trace);

        String visitorAttributeName = "普通访客";
        if (confirmInitiateVo.getVisitorAttribute() == 1) {
            visitorAttributeName = "普通访客";
        } else if (confirmInitiateVo.getVisitorAttribute() == 2) {
            visitorAttributeName = "贵宾访客";
        } else if (confirmInitiateVo.getVisitorAttribute() == 3) {
            visitorAttributeName = "黑名单访客";
        }

        LambdaQueryWrapper<VisitRecordGateSentry> visitRecordGateSentryQuery = QueryBuilder.<VisitRecordGateSentry>lambdaQuery()
            .eq(VisitRecordGateSentry::getEnterpriseId, confirmInitiateVo.getEnterpriseId());
        List<VisitRecordGateSentry> visitRecordGateSentryList = visitRecordGateSentryMapper.selectList(visitRecordGateSentryQuery);
        if (visitRecordGateSentryList != null && !visitRecordGateSentryList.isEmpty()) {
            for(VisitRecordGateSentry visitRecordGateSentry : visitRecordGateSentryList){
                visitRecordGateSentryMapper.deleteById(visitRecordGateSentry.getId());
            }
        }

        LambdaQueryWrapper<GateSentry> gateSentryQuery = QueryBuilder.<GateSentry>lambdaQuery()
            .eq(GateSentry::getEnterpriseId, confirmInitiateVo.getEnterpriseId());
        List<GateSentry> gateSentryList = gateSentryMapper.selectList(gateSentryQuery);
        if (gateSentryList != null && !gateSentryList.isEmpty()) {
            for (GateSentry gateSentry : gateSentryList) {
                //保存访客记录ID与安防人员ID
                VisitRecordGateSentry visitRecordGateSentry = new VisitRecordGateSentry();
                visitRecordGateSentry.setRecordId(confirmInitiateVo.getId());
                visitRecordGateSentry.setEnterpriseId(confirmInitiateVo.getEnterpriseId());
                visitRecordGateSentry.setAreaId(gateSentry.getAreaId());
                visitRecordGateSentry.setGateSentryId(gateSentry.getId());
                visitRecordGateSentry.setGateSentryUserId(gateSentry.getUserId());
                visitRecordGateSentry.setOriginatorId(confirmInitiateVo.getOriginatorId());
                visitRecordGateSentry.setOriginatorName(confirmInitiateVo.getOriginatorName());
                visitRecordGateSentry.setOriginatorEnterpriseId(confirmInitiateVo.getOriginatorEnterpriseId());
                visitRecordGateSentry.setOriginatorEnterpriseName(confirmInitiateVo.getOriginatorEnterpriseName());
                visitRecordGateSentryMapper.insert(visitRecordGateSentry);

                //向安防人员发送站内信
                VisitNotify visitNotify = new VisitNotify();
                String newsCopy = "【请求验证提醒】核对来访人信息并验证相关证件审批通行";
                String notifyTitle = "请求验证提醒";
                StringBuffer notifyContent = new StringBuffer();
                notifyContent.append("来访对象：" + confirmInitiateVo.getName());
                notifyContent.append("<br/>访客属性：" + visitorAttributeName);
                notifyContent.append("<br/>来访时间：" + DateUtil.format(DateUtil.localDateTime2Date(confirmInitiateVo.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM));
                notifyContent.append("<br/>温馨提示：请对该访客进行身份验证，如遇异常，可请求验证发起方支援。");

                visitNotify.setUserId(gateSentry.getUserId());
                visitNotify.setNewsCopy(newsCopy);
                visitNotify.setNotifyTitle(notifyTitle);
                visitNotify.setNotifyContent(notifyContent.toString());
                visitNotify.setVisitRecordId(confirmInitiateVo.getId());
                visitNotifyMapper.insert(visitNotify);

                // 站内信
                MailFormVo mailVo = new MailFormVo();
                mailVo.setTitle(notifyTitle);
                mailVo.setContent(notifyContent.toString());
                mailVo.setScope(SmsConstants.SCOPE);
                mailVo.setType("请求验证提醒");

                MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                receiversVo.setReceiver(gateSentry.getTel());
                List<MailReceiverFormVo> receivers = new ArrayList<>();
                receivers.add(receiversVo);

                mailVo.setSummary(newsCopy);
                mailVo.setIcon("message");
                mailVo.setContentType(ContentType.TEXT);

                mailVo.setReceivers(receivers);
                try {
                    messageService.sendMail(mailVo);
                } catch (Exception e) {
                    logger.error("站内信发送失败:{}", e.toString());
                    throw new BizException("站内信发送失败");
                }
            }
        } else {
            throw new BizException("根据该企业未查询到对应的安防人员");
        }
    }

    public void confirmInternalAlarm(ConfirmInternalAlarmVo confirmInternalAlarmVo) {
        //查询消息通知模板
        MessageNoticeUserSerachVo msgTepleteVo = new MessageNoticeUserSerachVo();
        msgTepleteVo.setEnterpriseId(confirmInternalAlarmVo.getEnterpriseId());
        msgTepleteVo.setNoticeType(NoticeType.JBTXZZ);
        MessageNoticeTemplate msgTeplete = null;
        try {
            msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
        } catch (Exception e) {
            throw new BizException(e.getMessage());
        }

        String abnormalArea = "未知";
        String abnormalReason = "未知";
        //查询黑名单访客异常原因
        AbnormalDto abnormalDto = visitorIndexMapper.getAbnormalByVisitorId(confirmInternalAlarmVo.getEnterpriseId(), confirmInternalAlarmVo.getVisitorId());
        if(!ObjectUtils.isEmpty(abnormalDto)){
            abnormalArea = abnormalDto.getAbnormalAreaName();
            abnormalReason = abnormalDto.getAbnormalCaseName();
        }

        if (!ObjectUtils.isEmpty(msgTeplete)) {
            if (msgTeplete.getAllUser() == 1) { //全员
                //@todo
                EmpQueryVo empQueryVo = new EmpQueryVo();
                empQueryVo.setEnterpriseId(confirmInternalAlarmVo.getEnterpriseId());
                List<EmpViewVo> empViewList = uaacService.listEmp(empQueryVo);
                if(empViewList != null && !empViewList.isEmpty()){
                    for(EmpViewVo empViewVo : empViewList){
                        convertInternalAlarm(msgTeplete,confirmInternalAlarmVo,abnormalArea,abnormalReason,empViewVo.getUserId(),empViewVo.getPhone());
                    }
                }

            } else { //指定人员
                //查询消息模板关联人员
                MessageNoticeUserSerachVo messageNoticeUserSerachVo = new MessageNoticeUserSerachVo();
                messageNoticeUserSerachVo.setEnterpriseId(confirmInternalAlarmVo.getEnterpriseId());
                messageNoticeUserSerachVo.setNoticeType(NoticeType.JBTXZZ);
                messageNoticeUserSerachVo.setFlag(2);
                List<MessageNoticeUser> messageNoticeUserList = messageNoticeTemplateService.getMessageNoticeUserList(messageNoticeUserSerachVo);
                if (messageNoticeUserList != null && !messageNoticeUserList.isEmpty()) {
                    for (MessageNoticeUser messageNoticeUser : messageNoticeUserList) {
                        //获取用户详情
                        UserViewDto userViewDto = uaacService.getUserDetail(messageNoticeUser.getUserId());

                        convertInternalAlarm(msgTeplete,confirmInternalAlarmVo,abnormalArea,abnormalReason,messageNoticeUser.getUserId(),userViewDto.getPhone());
                    }
                }
            }
        }
    }

    private void convertInternalAlarm(MessageNoticeTemplate msgTeplete, ConfirmInternalAlarmVo confirmInternalAlarmVo,
                    String abnormalArea,String abnormalReason,Long userId,String phone){
        if (msgTeplete.getEmaill() == 1) {
            String newsCopy = "【安全警示】请注意" + abnormalArea + "出现异常情况";
            String notifyTitle = "安全警示";
            StringBuffer notifyContent = new StringBuffer();
            notifyContent.append("异常访客：" + confirmInternalAlarmVo.getName());
            notifyContent.append("<br/>异常区域：" + abnormalArea);
            notifyContent.append("<br/>异常原因：" + abnormalReason);
            notifyContent.append("<br/>温馨提示：请保护好个人人身安全与财产安全，如遇情况危急，请勿慌乱，有序离场！");
            VisitNotify visitNotify = new VisitNotify();
            //visitNotify.setUserId(messageNoticeUser.getUserId());
            visitNotify.setUserId(userId);
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(notifyContent.toString());
            visitNotify.setVisitRecordId(confirmInternalAlarmVo.getId());
            visitNotifyMapper.insert(visitNotify);

            //站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(notifyContent.toString());
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("安全警示");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setEnterpriseId(confirmInternalAlarmVo.getEnterpriseId());
            //receiversVo.setReceiver(userViewDto.getPhone());
            receiversVo.setReceiver(phone);
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.TEXT);

            mailVo.setReceivers(receivers);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败:{}", e.toString());
                throw new BizException("站内信发送失败");
            }
        }
        if (msgTeplete.getShortMessage() == 1) {
            //短信
            SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
            //smsVo.setPhone(userViewDto.getPhone());
            smsVo.setPhone(phone);
            smsVo.setTemplateCode(SmsConstants.YCTX);
            Map<String, Object> param = new HashMap<>();
            param.put("abnormalArea", abnormalArea);
            try {
                messageService.sendSms(smsVo);
            } catch (Exception e) {
                logger.error("短信发送失败:{}", e.toString());
                throw new BizException("短信发送失败");
            }
        }
    }

    public IPage<VisitRecordVo> getVisitInfo(VisitInVo vo) {
        Page<VisitRecord> page = new Page<>(vo.getCurrent(), vo.getSize());
        IPage<VisitRecordVo> voPage;
        Map<String, Object> map = new HashMap<>();
        map.put("tel", vo.getTel());
        if (vo.getIsAll() == null || vo.getIsAll() == 0) {
            voPage = visitRecordMapper.getRecordList(page, map);
        } else {
            voPage = visitRecordMapper.getRecordAllList(page, map);
        }
        for (VisitRecordVo r : voPage.getRecords()) {
            if (r.getVisitStatus() != null)
                r.setVisitStatusName(r.getVisitStatus().getDescription());
            LambdaQueryWrapper<VisitFollowUser> followUserQuery = QueryBuilder.<VisitFollowUser>lambdaQuery()
                .eq(VisitFollowUser::getVisitRecordId, r.getId());
            List<VisitFollowUser> visitFollowUserList = visitFollowUserMapper.selectList(followUserQuery);
            r.setFollowUserList(visitFollowUserList);
        }
        return voPage;
    }

    public Visitor addInfo(VisitInVo vo) {
        if (vo.getTel() != null)
            vo.setTel(RemoteClient.decryptInfo(vo.getTel()).get(0));
        vo.setAuth(null);
        if (vo.getAuthStr() != null) {
            String temp = RemoteClient.decryptInfo(vo.getAuthStr()).get(0);
            if (temp.split("-").length == 3 && temp.split("-")[0].equals(vo.getTel())) {
                Long timeTemp = Long.parseLong(temp.split("-")[2]);
                LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timeTemp/1000, 0, ZoneOffset.ofHours(8));
                if (localDateTime.isBefore(LocalDateTime.now().minusMinutes(5)) || localDateTime.isAfter(LocalDateTime.now().plusMinutes(5))) {
                    throw new BizException("请求时间异常");
                }
                vo.setAuth(Integer.parseInt(temp.split("-")[1]));
            } else {
                throw new BizException("加密数据或手机号码不匹配");
            }
        }
        LambdaQueryWrapper<Visitor> query = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getTel, vo.getTel()).isNull(Visitor::getEnterpriseId);
        List<Visitor> visitorList = visitorMapper.selectList(query);
        if (visitorList.size() > 0) {
            Visitor visitor = visitorList.get(0);
            if (vo.getCartNoPositive() != null)
                visitor.setCardNoPositive(vo.getCartNoPositive());
            if (vo.getCartNoNegative() != null)
                visitor.setCardNoNegative(vo.getCartNoNegative());
            if (vo.getFaceImg() != null)
                visitor.setFaceImg(vo.getFaceImg());
            if (vo.getName() != null)
                visitor.setName(vo.getName());
            if (vo.getCartNo() != null)
                visitor.setCartNo(RemoteClient.decryptInfo(vo.getCartNo()).get(0));
            if (vo.getTel() != null)
                visitor.setTel(vo.getTel());
            if (vo.getCompanyName() != null)
                visitor.setCompanyName(vo.getCompanyName());
            if (vo.getAuth() != null)
                visitor.setAuth(vo.getAuth());
            if (vo.getSigning() != null)
                visitor.setSigning(vo.getSigning());
            if (vo.getUserStation() != null)
                visitor.setUserStation(vo.getUserStation());
            if (vo.getCardImg() != null)
                visitor.setCardImg(vo.getCardImg());
            visitorMapper.updateById(visitor);
            return visitor;
        } else {
            Visitor visitor = new Visitor();
            if (vo.getCartNoPositive() != null)
                visitor.setCardNoPositive(vo.getCartNoPositive());
            if (vo.getCartNoNegative() != null)
                visitor.setCardNoNegative(vo.getCartNoNegative());
            if (vo.getFaceImg() != null)
                visitor.setFaceImg(vo.getFaceImg());
            if (vo.getName() != null)
                visitor.setName(vo.getName());
            if (vo.getCartNo() != null)
                visitor.setCartNo(RemoteClient.decryptInfo(vo.getCartNo()).get(0));
            if (vo.getTel() != null)
                visitor.setTel(vo.getTel());
            if (vo.getCompanyName() != null)
                visitor.setCompanyName(vo.getCompanyName());
            if (vo.getAuth() != null)
                visitor.setAuth(vo.getAuth());
            if (vo.getSigning() != null)
                visitor.setSigning(vo.getSigning());
            if (vo.getUserStation() != null)
                visitor.setUserStation(vo.getUserStation());
            if (vo.getCardImg() != null)
                visitor.setCardImg(vo.getCardImg());
            visitor.setVisitorType(VisitorType.VISITOR);
            visitor.setVisitorAttribute(VisitorAttribute.PLAIN);
            visitorMapper.insert(visitor);
            return visitor;
        }
    }

    public VisitOutVo getInfo(String tel) {
        VisitOutVo vo = new VisitOutVo();
        LambdaQueryWrapper<Visitor> query = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getTel, tel).isNull(Visitor::getEnterpriseId);
        List<Visitor> visitorList = visitorMapper.selectList(query);
        if (visitorList.size() > 0) {
            BeanUtils.copyTo(visitorList.get(0), vo);
        }
        return vo;
    }

    public VisitOutVo getInfoById(Long id) {
        Visitor visitor = visitorMapper.selectById(id);
        if (visitor == null || visitor.getTel() == null)
            throw new BizException("访客不存在");
        return getInfo(visitor.getTel());
    }


}
