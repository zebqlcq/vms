package com.bonade.visitor.domain.entity;

import java.time.LocalDateTime;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @ClassName: VisitRecord
 * @Description:来访记录
 * @author: lcq
 * @date: 2019年12月10日 下午4:10:38
 * @version 1.0
 */
@TableName("vms_visit_record")
public class VisitRecord extends AbstractEntity {

	private static final long serialVersionUID = 3164975665294941225L;

	/**
	 * 企业ID
	 */
	private Long enterpriseId;

	/**
	 * 企业名称
	 */
	private String enterpriseName;

	/**
	 * 邀约模板id
	 */
	private Long visitInviteTemplateId;

	/**
	 * 访客id
	 */
	private Long visitorId;

	/**
	 * 关联内部人员
	 */
	private Long internalStaffUserId;

	/**
	 * 关联内部人员名称
	 */
	private String internalStaffUserName;

	/**
	 * 关联内部人员手机号
	 */
	private String internalStaffUserTel;
	/**
	 * 关联内部人员部门
	 */
	private String internalStaffUserDept;
	/**
	 * 关联内部人员岗位
	 */
	private String internalStaffUserStation;

	/**
	 * 权限 0未激活 1激活
	 */
	private Integer permission;

	/**
	 * 登记形式
	 */
	private Integer registration;

//	/**
//	 * 访客来源
//	 */
//	private Integer source;

	/**
	 * 邀访/预访开始时间
	 */
	private LocalDateTime appointmentStartTime;

	/**
	 * 邀访/预访开始时间
	 */
	private LocalDateTime appointmentEndTime;
	/**
	 * 失效日期
	 */
	private LocalDateTime effectiveDate;

	/**
	 * 失效日期
	 */
	private LocalDateTime expirationDate;

	/**
	 * 访问事由
	 */
	private Integer visitCause;

	/**
	 * 实际到访状态
	 */
	private Integer visitStatus;

	/**
	 * 车牌号
	 */
	private String carNum;

	/**
	 * 随访人数
	 */
	private Integer followNum;

	/**
	 * 访客码
	 */
	private String visitorCode;
	/**
	 * 二维码
	 */
	private String qrCode;

	/**
	 * 第一次签入时间
	 */
	private LocalDateTime firstCheckInTime;

	/**
	 * 会议室/约见室
	 */
	private Long meetingRoom;

	/**
	 * 操作状态 0-未核实 1-已核实 2-已失效
	 */
	private Integer operationStatus;

	/**
	 * 操作(核实)人ID
	 */
	private Long operationUserId;

	/**
	 * 操作(核实)备注
	 */
	private String operationRemark;

	/**
	 * 操作(核实)时间
	 */
	private LocalDateTime operationTime;

	/**
	 * 区域id,多个用逗号隔开
	 */
	private String areaIds;

	/**
	 * 开放时间起
	 */
	@TableField(exist = false)
	private String openTimeStart;
	/**
	 * 开放时间止
	 */
	@TableField(exist = false)
	private String openTimeEnd;

	@TableField(exist = false)
	private Integer visitorAttribute;

	@TableField(exist = false)
	private String visitorAttributeName;

	/**
	 * 邀约详情
	 */
	private String invitationExplain;

    /**
     * 拜访地址
     */
	private String address;


	public Integer getVisitorAttribute() {
		return visitorAttribute;
	}

	public void setVisitorAttribute(Integer visitorAttribute) {
		this.visitorAttribute = visitorAttribute;
	}

	public String getVisitorAttributeName() {
		return visitorAttributeName;
	}

	public void setVisitorAttributeName(String visitorAttributeName) {
		this.visitorAttributeName = visitorAttributeName;
	}

	public String getOpenTimeStart() {
		return openTimeStart;
	}

	public void setOpenTimeStart(String openTimeStart) {
		this.openTimeStart = openTimeStart;
	}

	public String getOpenTimeEnd() {
		return openTimeEnd;
	}

	public void setOpenTimeEnd(String openTimeEnd) {
		this.openTimeEnd = openTimeEnd;
	}

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

	public Long getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}

	public Long getInternalStaffUserId() {
		return internalStaffUserId;
	}

	public void setInternalStaffUserId(Long internalStaffUserId) {
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

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public Integer getRegistration() {
		return registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

//	public Integer getSource() {
//		return source;
//	}
//
//	public void setSource(Integer source) {
//		this.source = source;
//	}

	public LocalDateTime getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public LocalDateTime getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	public Integer getVisitCause() {
		return visitCause;
	}

	public void setVisitCause(Integer visitCause) {
		this.visitCause = visitCause;
	}

	public Integer getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(Integer visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
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

	public LocalDateTime getFirstCheckInTime() {
		return firstCheckInTime;
	}

	public void setFirstCheckInTime(LocalDateTime firstCheckInTime) {
		this.firstCheckInTime = firstCheckInTime;
	}

	public Long getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(Long meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public Integer getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(Integer operationStatus) {
		this.operationStatus = operationStatus;
	}

	public Long getOperationUserId() {
		return operationUserId;
	}

	public void setOperationUserId(Long operationUserId) {
		this.operationUserId = operationUserId;
	}

	public String getOperationRemark() {
		return operationRemark;
	}

	public void setOperationRemark(String operationRemark) {
		this.operationRemark = operationRemark;
	}

	public LocalDateTime getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(LocalDateTime operationTime) {
		this.operationTime = operationTime;
	}

	public LocalDateTime getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(String areaIds) {
		this.areaIds = areaIds;
	}

	public String getInvitationExplain() {
		return invitationExplain;
	}

	public void setInvitationExplain(String invitationExplain) {
		this.invitationExplain = invitationExplain;
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
