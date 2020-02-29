package com.bonade.visitor.domain.dto;

import java.util.List;

import com.bonade.visitor.domain.entity.ApprovalDetail;
import com.bonade.visitor.domain.entity.VisitFollowUser;
import com.bonade.visitor.domain.entity.VisitRecordBehaviorTrace;
import com.bonade.visitor.domain.entity.VisitRecordGateSentry;
import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.enums.VisitorAttribute;

import io.swagger.annotations.ApiModelProperty;

/**
 * @version 1.0
 * @ClassName: VisitRecordDetailDto
 * @Description:
 * @author: lcq
 * @date: 2019年11月15日 下午3:09:13
 */
public class VisitRecordDetailDto {

	@ApiModelProperty(value = "访客记录id", name = "id", dataType = "String")
	private String id;

	@ApiModelProperty(value = "邀约发起人/被访人(内部人员)", name = "internalStaffUserName", dataType = "String")
	private String internalStaffUserName;

	@ApiModelProperty(value = "内部人员联系电话", name = "internalStaffUserTel", dataType = "String")
	private String internalStaffUserTel;

	@ApiModelProperty(value = "内部人员企业", name = "enterpriseName", dataType = "String")
	private String enterpriseName;

	@ApiModelProperty(value = "内部人员部门", name = "internalStaffUserDept", dataType = "String")
	private String internalStaffUserDept;

	@ApiModelProperty(value = "内部人员岗位", name = "internalStaffUserStation", dataType = "String")
	private String internalStaffUserStation;

	@ApiModelProperty(value = "访问事由", name = "visitCause", dataType = "VisitCause")
	private VisitCause visitCause;

	@ApiModelProperty(value = "访问事由名称", name = "visitCauseName", dataType = "String")
	private String visitCauseName;

	@ApiModelProperty(value = "访问状态", name = "visitStatus", dataType = "VisitStatus")
	private VisitStatus visitStatus;

	@ApiModelProperty(value = "访问状态名称", name = "visitStatusName", dataType = "String")
	private String visitStatusName;

	@ApiModelProperty(value = "访问开始时间", name = "appointmentStartTime", dataType = "String")
	private String appointmentStartTime;

	@ApiModelProperty(value = "访问结束时间", name = "appointmentEndTime", dataType = "String")
	private String appointmentEndTime;
	
	@ApiModelProperty(value = "失效时间", name = "effectiveDate", dataType = "String")
	private String effectiveDate;
	
	@ApiModelProperty(value = "失效时间", name = "expirationDate", dataType = "String")
	private String expirationDate;

	@ApiModelProperty(value = "随访人数", name = "followNum", dataType = "Integer")
	private Integer followNum;

	@ApiModelProperty(value = "车牌号", name = "carNum", dataType = "String")
	private String carNum;

	@ApiModelProperty(value = "访客姓名", name = "visitorName", dataType = "String")
	private String visitorName;

	@ApiModelProperty(value = "访客公司", name = "companyName", dataType = "String")
	private String companyName;

	@ApiModelProperty(value = "访客部门", name = "deptName", dataType = "String")
	private String deptName;

	@ApiModelProperty(value = "访客职位", name = "userStation", dataType = "String")
	private String userStation;

	@ApiModelProperty(value = "创建时间", name = "createTime", dataType = "String")
	private String createTime;

	@ApiModelProperty(value = "审批人集合", name = "flowsList", dataType = "List")
	private List<ApprovalDetail> flowsList;

	@ApiModelProperty(value = "抄送人集合", name = "copysList", dataType = "List")
	private List<ApprovalDetail> copysList;

	@ApiModelProperty(value = "随访人员集合", name = "followUserList", dataType = "List")
	private List<VisitFollowUser> followUserList;

	@ApiModelProperty(value = "行为跟踪集合", name = "followUserList", dataType = "List")
	private List<VisitRecordBehaviorTrace> recordBehaviorTraceList;

	@ApiModelProperty(value = "访客手机号", name = "tel", dataType = "String")
	private String tel;

	@ApiModelProperty(value = "审批编号", name = "approvalId", dataType = "Long")
	private Long approvalId;

	@ApiModelProperty(value = "uaac审批编号", name = "uaacApprovalId", dataType = "Long")
	private Long uaacApprovalId;

	@ApiModelProperty(value = "审批状态", name = "state", dataType = "ApprovalState")
	private ApprovalState state;

	@ApiModelProperty(value = "审批状态名称", name = "stateName", dataType = "String")
	private String stateName;

	@ApiModelProperty(value = "访客码", name = "visitorCode", dataType = "String")
	private String visitorCode;

	@ApiModelProperty(value = "邀约详情", name = "invitationExplain", dataType = "String")
	private String invitationExplain;

	@ApiModelProperty(value = "来访地址", name = "address", dataType = "String")
	private String address;

	@ApiModelProperty(value = "证件信息图像（正面）", name = "cardNoPositive", dataType = "String")
	private String cardNoPositive;

	@ApiModelProperty(value = "人脸图像", name = "faceImg", dataType = "String")
	private String faceImg;

	@ApiModelProperty(value = "门岗数据", name = "gateSentry", dataType = "VisitRecordGateSentry")
	private VisitRecordGateSentry gateSentry;

	@ApiModelProperty(value = "访客属性", name = "visitorAttribute", dataType = "VisitorAttribute")
	private VisitorAttribute visitorAttribute;

	@ApiModelProperty(value = "访客属性名称", name = "visitorAttributeName", dataType = "String")
	private String visitorAttributeName;

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

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
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

	public VisitCause getVisitCause() {
		return visitCause;
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

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserStation() {
		return userStation;
	}

	public void setUserStation(String userStation) {
		this.userStation = userStation;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public List<ApprovalDetail> getFlowsList() {
		return flowsList;
	}

	public void setFlowsList(List<ApprovalDetail> flowsList) {
		this.flowsList = flowsList;
	}

	public List<ApprovalDetail> getCopysList() {
		return copysList;
	}

	public void setCopysList(List<ApprovalDetail> copysList) {
		this.copysList = copysList;
	}

	public List<VisitFollowUser> getFollowUserList() {
		return followUserList;
	}

	public void setFollowUserList(List<VisitFollowUser> followUserList) {
		this.followUserList = followUserList;
	}

	public List<VisitRecordBehaviorTrace> getRecordBehaviorTraceList() {
		return recordBehaviorTraceList;
	}

	public void setRecordBehaviorTraceList(List<VisitRecordBehaviorTrace> recordBehaviorTraceList) {
		this.recordBehaviorTraceList = recordBehaviorTraceList;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public Long getUaacApprovalId() {
		return uaacApprovalId;
	}

	public void setUaacApprovalId(Long uaacApprovalId) {
		this.uaacApprovalId = uaacApprovalId;
	}

	public ApprovalState getState() {
		return state;
	}

	public void setState(ApprovalState state) {
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = state != null ? EnumUtil.getByValue(state.getValue(), ApprovalState.class, "") : null;
	}

	public String getVisitorCode() {
		return visitorCode;
	}

	public void setVisitorCode(String visitorCode) {
		this.visitorCode = visitorCode;
	}

	public String getInvitationExplain() {
		return invitationExplain;
	}

	public void setInvitationExplain(String invitationExplain) {
		this.invitationExplain = invitationExplain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardNoPositive() {
		return cardNoPositive;
	}

	public void setCardNoPositive(String cardNoPositive) {
		this.cardNoPositive = cardNoPositive;
	}

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public VisitRecordGateSentry getGateSentry() {
		return gateSentry;
	}

	public void setGateSentry(VisitRecordGateSentry gateSentry) {
		this.gateSentry = gateSentry;
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

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

}
