package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import com.bonade.visitor.domain.enums.VisitorRegistration;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: VisitRecordForGuardDto
 * @Description:
 * @author: lcq
 * @date: 2019年12月11日 下午2:44:09
 * @version 1.0
 */
public class VisitRecordForGuardDto {

	@ApiModelProperty(value = "访客记录id", name = "visitRecordId", dataType = "String")
	private String visitRecordId;

	@ApiModelProperty(value = "通行状态：1允许通行，2拒绝通行", name = "passStatus", dataType = "Integer")
	private Integer passStatus;

	@ApiModelProperty(value = "通行状态名称：同意、拒绝", name = "passStatusName", dataType = "String")
	private String passStatusName;

	@ApiModelProperty(value = "证件信息图像（正面）", name = "cardNoPositive", dataType = "String")
	private String cardNoPositive;

	@ApiModelProperty(value = "证件信息图像（反面）", name = "cardNoNegative", dataType = "String")
	private String cardNoNegative;

	@ApiModelProperty(value = "人脸图像", name = "faceImg", dataType = "String")
	private String faceImg;

	@ApiModelProperty(value = "访客姓名", name = "visitorName", dataType = "String")
	private String visitorName;

	@ApiModelProperty(value = "访客手机号", name = "visitorTel", dataType = "String")
	private String visitorTel;

	@ApiModelProperty(value = "访问事由", name = "visitCause", dataType = "VisitCause")
	private VisitCause visitCause;

	@ApiModelProperty(value = "访问事由名称", name = "visitCauseName", dataType = "String")
	private String visitCauseName;

	@ApiModelProperty(value = "访客属性", name = "visitorAttribute", dataType = "VisitorAttribute")
	private VisitorAttribute visitorAttribute;

	@ApiModelProperty(value = "访客属性名称", name = "visitorAttributeName", dataType = "String")
	private String visitorAttributeName;

	@ApiModelProperty(value = "访问起始时间", name = "appointmentStartTime", dataType = "String")
	private String appointmentStartTime;

	@ApiModelProperty(value = "访问截止时间", name = "appointmentEndTime", dataType = "String")
	private String appointmentEndTime;

	@ApiModelProperty(value = "随访人数", name = "followNum", dataType = "Integer")
	private Integer followNum;

	@ApiModelProperty(value = "邀请码", name = "visitorCode", dataType = "String")
	private String visitorCode;

	@ApiModelProperty(value = "二维码", name = "qrCode", dataType = "String")
	private String qrCode;

	@ApiModelProperty(value = "发起人用户id", name = "internalStaffUserId", dataType = "String")
	private String internalStaffUserId;

	@ApiModelProperty(value = "发起人姓名", name = "internalStaffUserName", dataType = "String")
	private String internalStaffUserName;

	@ApiModelProperty(value = "发起人手机号", name = "internalStaffUserTel", dataType = "String")
	private String internalStaffUserTel;

	@ApiModelProperty(value = "发起人部门", name = "internalStaffUserDept", dataType = "String")
	private String internalStaffUserDept;

	@ApiModelProperty(value = "发起人岗位", name = "internalStaffUserStation", dataType = "String")
	private String internalStaffUserStation;

	@ApiModelProperty(value = "审批状态", name = "approvalState", dataType = "ApprovalState")
	private ApprovalState approvalState;

	@ApiModelProperty(value = "审批状态名称", name = "approvalStateName", dataType = "String")
	private String approvalStateName;

	@ApiModelProperty(value = "登记形式（1内部邀约,2访客预约）", name = "registration", dataType = "VisitorRegistration")
	private VisitorRegistration registration;

	@ApiModelProperty(value = "登记形式名称", name = "registrationName", dataType = "String")
	private String registrationName;
	
	@ApiModelProperty(value = "验证发起时间", name = "createTime", dataType = "String")
	private String createTime;
	
	@ApiModelProperty(value = "验证发起人姓名", name = "originatorName", dataType = "String")
	private String originatorName;
	
	@ApiModelProperty(value = "验证发起人企业名称", name = "originatorEnterpriseName", dataType = "String")
	private String originatorEnterpriseName;

	public String getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(String visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

	public Integer getPassStatus() {
		return passStatus;
	}

	public void setPassStatus(Integer passStatus) {
		this.passStatus = passStatus;
	}

	public String getPassStatusName() {
		return passStatusName;
	}

	public void setPassStatusName(String passStatusName) {
		this.passStatusName = passStatusName;
	}

	public String getCardNoPositive() {
		return cardNoPositive;
	}

	public void setCardNoPositive(String cardNoPositive) {
		this.cardNoPositive = cardNoPositive;
	}

	public String getCardNoNegative() {
		return cardNoNegative;
	}

	public void setCardNoNegative(String cardNoNegative) {
		this.cardNoNegative = cardNoNegative;
	}

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorTel() {
		return visitorTel;
	}

	public void setVisitorTel(String visitorTel) {
		this.visitorTel = visitorTel;
	}

	public String getVisitCause() {
		return visitCause.getDescription();
	}

	public void setVisitCause(VisitCause visitCause) {
		this.visitCause = visitCause;
	}

	public String getVisitCauseName() {
		return visitCauseName;
	}

	public void setVisitCauseName(String visitCauseName) {
		this.visitCauseName = visitCause != null ? EnumUtil.getByValue(visitCause.getValue(), VisitCause.class, "") : null;
	}

	public VisitorAttribute getVisitorAttribute() {
		return visitorAttribute;
	}

	public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
		this.visitorAttribute = visitorAttribute;
	}

	public String getVisitorAttributeName() {
		return visitorAttributeName;
	}

	public void setVisitorAttributeName(String visitorAttributeName) {
		this.visitorAttributeName = visitorAttribute != null ? EnumUtil.getByValue(visitorAttribute.getValue(), VisitorAttribute.class, "") : null;
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

	public Integer getFollowNum() {
		return followNum;
	}

	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}

	public String getVisitorCode() {
		return visitorCode;
	}

	public void setVisitorCode(String visitorCode) {
		this.visitorCode = visitorCode;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getInternalStaffUserId() {
		return internalStaffUserId;
	}

	public void setInternalStaffUserId(String internalStaffUserId) {
		this.internalStaffUserId = internalStaffUserId;
	}

	public String getInternalStaffUserName() {
		return internalStaffUserName;
	}

	public void setInternalStaffUserName(String internalStaffUserName) {
		this.internalStaffUserName = internalStaffUserName;
	}

	public String getInternalStaffUserTel() {
		return internalStaffUserTel;
	}

	public void setInternalStaffUserTel(String internalStaffUserTel) {
		this.internalStaffUserTel = internalStaffUserTel;
	}

	public String getInternalStaffUserDept() {
		return internalStaffUserDept;
	}

	public void setInternalStaffUserDept(String internalStaffUserDept) {
		this.internalStaffUserDept = internalStaffUserDept;
	}

	public String getInternalStaffUserStation() {
		return internalStaffUserStation;
	}

	public void setInternalStaffUserStation(String internalStaffUserStation) {
		this.internalStaffUserStation = internalStaffUserStation;
	}

	public ApprovalState getApprovalState() {
		return approvalState;
	}

	public void setApprovalState(ApprovalState approvalState) {
		this.approvalState = approvalState;
	}

	public String getApprovalStateName() {
		return approvalStateName;
	}

	public void setApprovalStateName(String approvalStateName) {
		this.approvalStateName = approvalState != null ? EnumUtil.getByValue(approvalState.getValue(), ApprovalState.class, "") : null;
	}

	public VisitorRegistration getRegistration() {
		return registration;
	}

	public void setRegistration(VisitorRegistration registration) {
		this.registration = registration;
	}

	public String getRegistrationName() {
		return registrationName;
	}

	public void setRegistrationName(String registrationName) {
		this.registrationName = registration != null ? EnumUtil.getByValue(registration.getValue(), VisitorRegistration.class, "") : null;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOriginatorName() {
		return originatorName;
	}

	public void setOriginatorName(String originatorName) {
		this.originatorName = originatorName;
	}

	public String getOriginatorEnterpriseName() {
		return originatorEnterpriseName;
	}

	public void setOriginatorEnterpriseName(String originatorEnterpriseName) {
		this.originatorEnterpriseName = originatorEnterpriseName;
	}
	
}
