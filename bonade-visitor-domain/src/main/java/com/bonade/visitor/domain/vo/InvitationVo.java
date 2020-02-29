package com.bonade.visitor.domain.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: InvitationVo
 * @Description:发起邀约 VO
 * @author: lcq
 * @date: 2019年12月9日 下午3:11:08
 * @version 1.0
 */
@ApiModel(value = "InvitationVo", description = "访问入参vo")
public class InvitationVo {

	@NotNull(message = "企业id不能为空")
	@ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
	private Long enterpriseId;

	@NotBlank(message = "企业名称不能为空")
	@ApiModelProperty(value = "企业名称", name = "enterpriseName", example = "", required = true)
	private String enterpriseName;

	@NotNull(message = "邀约模板id不能为空")
	@ApiModelProperty(value = "邀约模板id", name = "visitInviteTemplateId", example = "", required = true)
	private Long visitInviteTemplateId;

	@NotNull(message = "内部人员userId不能为空")
	@ApiModelProperty(value = "内部人员userId", name = "internalStaffUserId", example = "", required = true)
	private Long internalStaffUserId;

	@NotBlank(message = "被邀请人姓名不能为空")
	@ApiModelProperty(value = "被邀请人姓名", name = "inviteeName", example = "", required = true)
	private String inviteeName;

	@NotBlank(message = "被邀请人联系方式不能为空")
	@ApiModelProperty(value = "被邀请人联系方式", name = "inviteeTelephone", example = "", required = true)
	private String inviteeTelephone;

	@NotBlank(message = "邀访/预访开始时间不能为空")
	@ApiModelProperty(value = "邀访/预访开始时间", name = "appointmentStartTime", example = "", required = true)
	private String appointmentStartTime;

	@NotBlank(message = "邀访/预访结束时间不能为空")
	@ApiModelProperty(value = "邀访/预访结束时间", name = "appointmentEndTime", example = "", required = true)
	private String appointmentEndTime;

	@NotNull(message = "访问事由不能为空")
	@ApiModelProperty(value = "访问事由", name = "visitCause", example = "", required = true)
	private Integer visitCause;

	@Pattern(regexp="^[\\u4e00-\\u9fa5A-Za-z0-9-]+$",message="车牌只能是：中文、英文、数字和横线'-'",groups= CarNum.class)
	@ApiModelProperty(value = "车牌号", name = "carNum", example = "")
	private String carNum;
	
	@ApiModelProperty(value = "随访人数，默认0，最大30", name = "followNum", example = "")
	private Integer followNum = 0;
	
	@ApiModelProperty(value = "随访人员集合", name = "followUserList", example = "")
	private List<VisitFollowUserVo> followUserList;

	@NotNull(message = "访客属性不能为空")
	@ApiModelProperty(value = "访客属性", name = "visitorAttribute", example = "")
	private Integer visitorAttribute;

//	@NotNull(message = "审批人不能为空")
	@ApiModelProperty(value = "审批人集合", name = "approvalUserList", example = "")
	private List<ApprovalUserVo> approvalUserList;

	@ApiModelProperty(value = "抄送人集合", name = "copyUserList", example = "")
	private List<ApprovalUserVo> copyUserList;
	
	@Pattern(regexp="^[\\u4e00-\\u9fa5A-Za-z0-9!@#$%^&*()+= {}【】:：''‘’，。、`~《》？?<>;,./\"\"！“”\\|\\[\\]_\\t\\s\\n——￥—]+$",message="邀约详情不能有表情等特殊字符",groups=InvitationExplain.class)
	@ApiModelProperty(value = "邀约详情", name = "invitationExplain", example = "")
	private String invitationExplain;

	@NotNull(message = "接待会议室不能为空")
	@ApiModelProperty(value = "会议室", name = "meetingRoom", example = "", required = true)
	private Long meetingRoom;
	
	@NotBlank(message = "公司地址不能为空")
	@ApiModelProperty(value = "来访地址", name = "address", example = "", required = true)
	private String address;
	
	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public Long getVisitInviteTemplateId() {
		return visitInviteTemplateId;
	}

	public void setVisitInviteTemplateId(Long visitInviteTemplateId) {
		this.visitInviteTemplateId = visitInviteTemplateId;
	}

	public Long getInternalStaffUserId() {
		return internalStaffUserId;
	}

	public void setInternalStaffUserId(Long internalStaffUserId) {
		this.internalStaffUserId = internalStaffUserId;
	}

	public String getInviteeName() {
		return inviteeName;
	}

	public void setInviteeName(String inviteeName) {
		this.inviteeName = inviteeName;
	}

	public String getInviteeTelephone() {
		return inviteeTelephone;
	}

	public void setInviteeTelephone(String inviteeTelephone) {
		this.inviteeTelephone = inviteeTelephone;
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

	public Integer getVisitCause() {
		return visitCause;
	}

	public void setVisitCause(Integer visitCause) {
		this.visitCause = visitCause;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public List<VisitFollowUserVo> getFollowUserList() {
		return followUserList;
	}

	public void setFollowUserList(List<VisitFollowUserVo> followUserList) {
		this.followUserList = followUserList;
	}

	public Integer getVisitorAttribute() {
		return visitorAttribute;
	}

	public void setVisitorAttribute(Integer visitorAttribute) {
		this.visitorAttribute = visitorAttribute;
	}

	public List<ApprovalUserVo> getApprovalUserList() {
		return approvalUserList;
	}

	public void setApprovalUserList(List<ApprovalUserVo> approvalUserList) {
		this.approvalUserList = approvalUserList;
	}

	public List<ApprovalUserVo> getCopyUserList() {
		return copyUserList;
	}

	public void setCopyUserList(List<ApprovalUserVo> copyUserList) {
		this.copyUserList = copyUserList;
	}

	public String getInvitationExplain() {
		return invitationExplain;
	}

	public void setInvitationExplain(String invitationExplain) {
		this.invitationExplain = invitationExplain;
	}

	public Long getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(Long meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public Integer getFollowNum() {
		return followNum;
	}

	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public interface CarNum{};
	public interface InvitationExplain{};
}
