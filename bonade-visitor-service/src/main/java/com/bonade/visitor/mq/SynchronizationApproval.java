package com.bonade.visitor.mq;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spin.common.util.QueryBuilder;
import org.spin.core.util.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.bonade.visitor.domain.dto.UserViewDto;
import com.bonade.visitor.domain.entity.Approval;
import com.bonade.visitor.domain.entity.ApprovalDetail;
import com.bonade.visitor.domain.entity.VisitRecord;
import com.bonade.visitor.domain.entity.VisitRecordBehaviorTrace;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.NoticeType;
import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.vo.SynchronizationInfoVo;
import com.bonade.visitor.mapper.VisitApprovalDetailMapper;
import com.bonade.visitor.mapper.VisitApprovalMapper;
import com.bonade.visitor.mapper.VisitRecordBehaviorTraceMapper;
import com.bonade.visitor.mapper.VisitRecordMapper;
import com.bonade.visitor.mapper.VisitorMapper;
import com.bonade.visitor.service.VisitRecordService;
import com.bonade.visitor.service.remote.UaacService;
import com.bonade.visitor.service.sms.SmsConstants;


@Component
public class SynchronizationApproval {

    private static Logger logger = LoggerFactory.getLogger(SynchronizationApproval.class);

    @Autowired
    private VisitApprovalMapper visitApprovalMapper;

    @Autowired
    private VisitApprovalDetailMapper visitApprovalDetailMapper;

    @Autowired
    private VisitRecordMapper visitRecordMapper;

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private VisitRecordService visitRecordService;

    @Autowired
    private VisitRecordBehaviorTraceMapper visitRecordBehaviorTraceMapper;
    
    @Autowired
    private UaacService uaacService;


    @RabbitListener(queues = "${queueName}")
    @RabbitHandler
    public void SynchronizationApprovalInfo(Message message) {
        String resultMessage = StringUtils.newStringUtf8(message.getBody());
        logger.info("resultMessage：{}", resultMessage);
        SynchronizationInfoVo synchronizationInfoVo = JSON.parseObject(resultMessage, SynchronizationInfoVo.class);
        if (Objects.isNull(synchronizationInfoVo)) {
            return;
        }
        Wrapper<Approval> wrapper = QueryBuilder.<Approval>lambdaQuery()
                .eq(Approval::getUaacApprovalId,synchronizationInfoVo.getApprovalId());
        Approval approval = null;
        try {
        	approval = visitApprovalMapper.selectOne(wrapper);
		} catch (Exception e) {
			logger.error("approval数据异常：{}",e.toString());
			return;
		}
        if(ObjectUtils.isEmpty(approval)) {
        	logger.info("没有查询到审批单");
			return;
        }
        Wrapper<VisitRecord> visitRecordWrapper = QueryBuilder.<VisitRecord>lambdaQuery()
                .eq(VisitRecord::getId,approval.getVisitRecordId());
        VisitRecord visitRecord = null;
        try {
        	visitRecord = visitRecordMapper.selectOne(visitRecordWrapper);
        } catch (Exception e) {
            logger.error("visitRecord访客数据异常：{}",e.toString());
			return;
        }
        if(ObjectUtils.isEmpty(visitRecord)) {
        	logger.info("详情数据异常：空");
 			return;
        }

    	Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
                .eq(Visitor::getId,visitRecord.getVisitorId());
		Visitor visitor = null;
        try {
        	visitor = visitorMapper.selectOne(visitorWrapper);
        } catch (Exception e) {
            logger.error("visitor数据异常：{}",e.toString());
			return;
        }
        if(ObjectUtils.isEmpty(visitor)) {
        	logger.info("访客数据异常：访客不存在");
    		return;
        }

        Wrapper<ApprovalDetail> detailWrapper = QueryBuilder.<ApprovalDetail>lambdaQuery()
                .eq(ApprovalDetail::getApprovalId,approval.getId())
                .eq(ApprovalDetail::getUserId,synchronizationInfoVo.getUserId())
                .eq(ApprovalDetail::getType,synchronizationInfoVo.getType());
		ApprovalDetail detail = null;
        try {
        	detail = visitApprovalDetailMapper.selectOne(detailWrapper);
        } catch (Exception e) {
        	logger.error("审批详情数据异常！");
    		return;
        }
        if(ObjectUtils.isEmpty(detail)) {
        	logger.info("审批详情数据异常：空");
    		return;
        }

        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();

        if(approval.getState().getValue() != synchronizationInfoVo.getState()) {//结束
			if(synchronizationInfoVo.getState() == 1) {//同意
				detail.setState(ApprovalState.STATE_1);
				approval.setState(ApprovalState.STATE_1);
				visitRecord.setVisitStatus(VisitStatus.VISITWAIT_1.getValue());
				trace.setVisitStatus(VisitStatus.PASS);

				visitRecordService.getConfig(visitRecord,visitor);
				visitRecordService.sendNotify(NoticeType.SPJGTZ, SmsConstants.YYTG, visitRecord, visitor, null, null, null, null, null,null);
			}else if(synchronizationInfoVo.getState() == 2){//拒绝
				detail.setState(ApprovalState.STATE_2);
				approval.setState(ApprovalState.STATE_2);
				visitRecord.setVisitStatus(VisitStatus.APPROVALREFUSE.getValue());
				trace.setVisitStatus(VisitStatus.APPROVALREFUSE);

				visitRecordService.getConfig(visitRecord,visitor);
				visitRecordService.sendNotify(NoticeType.SPJGTZ, SmsConstants.YYBTG, visitRecord, visitor, null, null, null, null, null,null);


			}else if(synchronizationInfoVo.getState() == 3){//撤销
				//INVITATION_REVOKE
				approval.setState(ApprovalState.STATE_REVOKE);
				visitRecord.setVisitStatus(VisitStatus.APPOINTMENT_REVOKE.getValue());
				visitRecordService.getConfig(visitRecord,visitor);
				visitRecordService.sendNotify(NoticeType.SPJGTZ, SmsConstants.YYBTG, visitRecord, visitor, null, null, null, null, null,null);

		        trace.setVisitStatus(VisitStatus.APPOINTMENT_REVOKE);//待来访即为用户已验证
			}
        }else if(approval.getState().getValue() == 0){
        	if(synchronizationInfoVo.getPass()) {//同意
				detail.setState(ApprovalState.STATE_1);
				trace.setVisitStatus(VisitStatus.PASS);
				trace.setPassStatus(ApprovalState.STATE_1.getValue());
			}else if(!synchronizationInfoVo.getPass()){//拒绝
				detail.setState(ApprovalState.STATE_2);
				approval.setState(ApprovalState.STATE_2);
				visitRecord.setVisitStatus(VisitStatus.APPROVALREFUSE.getValue());
				trace.setVisitStatus(VisitStatus.APPROVALREFUSE);
				trace.setPassStatus(ApprovalState.STATE_2.getValue());
			}
        }else {
        	return;
        }

//        trace.setApprovalDetailId(detail.getId());
        trace.setUserId(detail.getUserId());
        UserViewDto dto = uaacService.getUserDetail(detail.getUserId());
        trace.setUserName(dto.getRealName());
        trace.setVisitRecordId(visitRecord.getId());
        trace.setOperationTime(visitRecord.getUpdateTime());
        trace.setOpinion(synchronizationInfoVo.getRemarks());
        
        visitRecordBehaviorTraceMapper.insert(trace);

        detail.setApprovalOpinion(synchronizationInfoVo.getRemarks());
		//审批人表
		visitApprovalDetailMapper.updateById(detail);
		//审批主表
		visitApprovalMapper.updateById(approval);
		//访客记录表
		visitRecordMapper.updateById(visitRecord);
    }
}
