package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;
import java.util.Date;

@ApiModel(value = "VisitRecordDetailVo", description = "访客来访记录对象")
public class VisitRecordDetailVo {

    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    private LocalDateTime createTime;

    @ApiModelProperty(value = "关联内部人员", name = "internalStaffUserId", example = "1")
    @PreventOverflow
    private Long internalStaffUserId;

    @ApiModelProperty(value = "关联内部人员名称", name = "internalStaffUserName", example = "1")
    private String internalStaffUserName;

    @ApiModelProperty(value = "关联内部人员手机号", name = "internalStaffUserTel", example = "1")
    private String internalStaffUserTel;

    @ApiModelProperty(value = "来访性质", name = "registration", example = "1")
    private VisitorRegistration registration;

    @ApiModelProperty(value = "来访性质描述", name = "registrationDesc", example = "1")
    private String registrationDesc;

    @ApiModelProperty(value = "邀访/预访开始时间", name = "appointmentSartTime", example = "2019-12-09 17:11:11")
    private Date appointmentSartTime;

    @ApiModelProperty(value = "邀访/预访开始时间", name = "appointmentEndTime", example = "2019-12-09 17:11:11")
    private Date appointmentEndTime;

    @ApiModelProperty(value = "访问事由", name = "visitCause", example = "1")
    private VisitCause visitCause;

    @ApiModelProperty(value = "访问事由描述", name = "visitCauseDesc", example = "1")
    private String visitCauseDesc;

    @ApiModelProperty(value = "实际到访状态", name = "visitStatus", example = "1")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "实际到访状态描述", name = "visitStatusDesc", example = "1")
    private String visitStatusDesc;

    @ApiModelProperty(value = "到访时间", name = "firstCheckInTime", example = "2019-12-09 17:11:11")
    private Date firstCheckInTime;

    @ApiModelProperty(value = "签出时间", name = "operationTime", example = "2019-12-09 17:11:11")
    private Date operationTime;

    @ApiModelProperty(value = "来访区域", name = "areaName")
    private String areaName;

    @ApiModelProperty(value = "审批状态", name = "state")
    private ApprovalState state;

    @ApiModelProperty(value = "审批状态描述", name = "stateDesc")
    private String stateDesc;

    @ApiModelProperty(value = "审批人", name = "userName")
    private String userName;

    @ApiModelProperty(value = "是否异常", name = "abnormalMsg")
    private String abnormalMsg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public VisitorRegistration getRegistration() {
        return registration;
    }

    public void setRegistration(VisitorRegistration registration) {
        this.registration = registration;
    }

    public Date getAppointmentSartTime() {
        return appointmentSartTime;
    }

    public void setAppointmentSartTime(Date appointmentSartTime) {
        this.appointmentSartTime = appointmentSartTime;
    }

    public Date getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(Date appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public VisitCause getVisitCause() {
        return visitCause;
    }

    public void setVisitCause(VisitCause visitCause) {
        this.visitCause = visitCause;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public Date getFirstCheckInTime() {
        return firstCheckInTime;
    }

    public void setFirstCheckInTime(Date firstCheckInTime) {
        this.firstCheckInTime = firstCheckInTime;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public ApprovalState getState() {
        return state;
    }

    public void setState(ApprovalState state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAbnormalMsg() {
        return abnormalMsg;
    }

    public void setAbnormalMsg(String abnormalMsg) {
        this.abnormalMsg = abnormalMsg;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getRegistrationDesc() {
        return registrationDesc;
    }

    public void setRegistrationDesc(String registrationDesc) {
        this.registrationDesc = registrationDesc;
    }

    public String getVisitCauseDesc() {
        return visitCauseDesc;
    }

    public void setVisitCauseDesc(String visitCauseDesc) {
        this.visitCauseDesc = visitCauseDesc;
    }

    public String getVisitStatusDesc() {
        return visitStatusDesc;
    }

    public void setVisitStatusDesc(String visitStatusDesc) {
        this.visitStatusDesc = visitStatusDesc;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }
}
