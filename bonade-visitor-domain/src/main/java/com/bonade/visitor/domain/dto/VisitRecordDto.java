package com.bonade.visitor.domain.dto;

import org.spin.core.gson.annotation.PreventOverflow;

import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitStatus;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: VisitRecordDto
 * @Description:dto
 * @author: lcq
 * @date: 2019年11月14日 下午5:15:46
 * @version 1.0
 */
public class VisitRecordDto {

	@PreventOverflow
	@ApiModelProperty(value = "主键", name = "id", dataType = "String")
	private String id;

	@ApiModelProperty(value = "创建时间", name = "createTime", dataType = "String")
	private String createTime;

	@ApiModelProperty(value = "拜访事由", name = "visitCause", dataType = "Integer")
	private Integer visitCause;

	@ApiModelProperty(value = "拜访事由名称 ", name = "visitCauseName", dataType = "String")
	private String visitCauseName;

	@ApiModelProperty(value = "访问开始时间", name = "appointmentStartTime", dataType = "String")
	private String appointmentStartTime;

	@ApiModelProperty(value = "访问结束时间", name = "appointmentEndTime", dataType = "String")
	private String appointmentEndTime;

	@ApiModelProperty(value = "访客企业", name = "visitorCompany", dataType = "String")
	private String visitorCompany;

	@ApiModelProperty(value = "审批人审批状态: 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） 3待阅览（抄送人）4 已阅览（抄送人） -1已撤销", name = "state", dataType = "Integer")
	private Integer state;

	@ApiModelProperty(value = "审批人审批状态名称", name = "stateName", dataType = "String")
	private String stateName;

	@ApiModelProperty(value = "审批状态: 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） -1已撤销", name = "state", dataType = "Integer")
	private Integer approvalState;

	@ApiModelProperty(value = "审批状态名称", name = "approvalStateName", dataType = "String")
	private String approvalStateName;

	@ApiModelProperty(value = "访客id", name = "visitorId", dataType = "String")
	private String visitorId;

	@ApiModelProperty(value = "访客姓名", name = "visitorName", dataType = "String")
	private String visitorName;

	@ApiModelProperty(value = "访客记录状态", name = "visitStatus", dataType = "VisitStatus")
	private VisitStatus visitStatus;

	@ApiModelProperty(value = "访客记录状态名称", name = "visitStatusName", dataType = "String")
	private String visitStatusName;
	
	@ApiModelProperty(value = "审批id", name = "approvalId", dataType = "Long")
	private Long approvalId;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getVisitCause() {
		return visitCause;
	}

	public void setVisitCause(Integer visitCause) {
		this.visitCause = visitCause;
	}

	public String getVisitCauseName() {
		return visitCauseName;
	}

	public void setVisitCauseName(String visitCauseName) {
		this.visitCauseName = visitCause != null ? EnumUtil.getByValue(visitCause, VisitCause.class, "") : null;
	}

	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public String getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(String appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	public String getVisitorCompany() {
		return visitorCompany;
	}

	public void setVisitorCompany(String visitorCompany) {
		this.visitorCompany = visitorCompany;
	}

	public Integer getState() {
		return state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = state != null ? EnumUtil.getByValue(state, ApprovalState.class, "") : null;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getApprovalState() {
		return approvalState;
	}

	public void setApprovalState(Integer approvalState) {
		this.approvalState = approvalState;
	}

	public String getApprovalStateName() {
		return approvalStateName;
	}

	public void setApprovalStateName(String approvalStateName) {
		this.approvalStateName = approvalState != null ? EnumUtil.getByValue(approvalState, ApprovalState.class, "") : null;
	}

	public String getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public VisitStatus getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(VisitStatus visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getVisitStatusName() {
		return visitStatusName;
	}

	public void setVisitStatusName(String visitStatusName) {
		this.visitStatusName = visitStatus != null ? EnumUtil.getByValue(visitStatus.getValue(), VisitStatus.class, "") : null;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}
	
}
