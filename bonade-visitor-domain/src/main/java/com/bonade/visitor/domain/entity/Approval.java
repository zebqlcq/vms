package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;
import org.spin.core.gson.annotation.PreventOverflow;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.ApprovalState;

/**
 * 
 * @ClassName: Approval
 * @Description:预约、邀约审批 实体
 * @author: lcq
 * @date: 2019年12月9日 下午2:42:32
 * @version 1.0
 */
@TableName("vms_approval")
public class Approval extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 发起人ID
	 */
	@PreventOverflow
	private Long originatorId;

	/**
	 * 访客记录id
	 */
	private Long visitRecordId;

	/**
	 * 审批状态 0待审批 1通过 2拒绝 -1已撤销
	 */
	private ApprovalState state;
	/**
	 * 失败原因
	 */
	private String failReason;
	/**
	 * 审批申请描述
	 */
	private String ApprovalDesc;
	/**
	 * uaac审批id
	 */
	private Long uaacApprovalId;

	public Long getOriginatorId() {
		return originatorId;
	}

	public void setOriginatorId(Long originatorId) {
		this.originatorId = originatorId;
	}

	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

	public ApprovalState getState() {
		return state;
	}

	public void setState(ApprovalState state) {
		this.state = state;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public String getApprovalDesc() {
		return ApprovalDesc;
	}

	public void setApprovalDesc(String approvalDesc) {
		ApprovalDesc = approvalDesc;
	}

	public Long getUaacApprovalId() {
		return uaacApprovalId;
	}

	public void setUaacApprovalId(Long uaacApprovalId) {
		this.uaacApprovalId = uaacApprovalId;
	}
	
}
