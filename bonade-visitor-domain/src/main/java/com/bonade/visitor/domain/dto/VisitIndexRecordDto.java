package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VisitIndexRecordDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/1/20 9:45
 */
public class VisitIndexRecordDto {

    /**
     * 来访区域
     */
    @ApiModelProperty(value = "来访区域", name = "enterpriseName", dataType = "String")
    private String enterpriseName;

    /**
     * 登记形式 1内部邀约,2访客预约
     */
    @ApiModelProperty(value = "登记形式 1内部邀约,2访客预约", name = "registration", example = "")
    private Integer registration;

    /**
     * 内部人员
     */
    @ApiModelProperty(value = "邀约发起人/被访人(内部人员)", name = "internalStaffUserName", dataType = "String")
    private String internalStaffUserName;

    /**
     * 访问事由
     */
    @ApiModelProperty(value = "访问事由[1-业务洽谈,2-事务办理,10-其他]", name = "visitCause", dataType = "VisitCause")
    private VisitCause visitCause;

    /**
     * 访问事由名称
     */
    @ApiModelProperty(value = "访问事由名称", name = "visitCauseName", example = "")
    private String visitCauseName;

    /**
     * 访客预约时间
     */
    @ApiModelProperty(value = "访客预约时间", name = "appointmentStartTime", example = "")
    private LocalDateTime appointmentStartTime;

    /**
     * 签入时间
     */
    @ApiModelProperty(value = "签入时间", name = "checkInTime",  example = "2019-08-27 15:37:14")
    private LocalDateTime checkInTime;

    /**
     * 签出时间
     */
    @ApiModelProperty(value = "签出时间", name = "checkOutTime",  example = "2019-08-27 15:37:14")
    private LocalDateTime checkOutTime;

    /**
     * 审批状态 0:待审批,1:通过,2:拒绝,-1:已撤销
     */
    @ApiModelProperty(value = "审批状态 0:待审批,1:通过,2:拒绝,-1:已撤销", name = "approvalState",  example = "0")
    private Integer approvalState;

    /**
     * 审批状态名称
     */
    @ApiModelProperty(value = "审批状态名称", name = "approvalStateName", dataType = "String")
    private String approvalStateName;

    /**
     * 异常访问：0-无，1-有
     */
    @ApiModelProperty(value = "异常访问：0-无，1-有", name = "abnormalState",  example = "0")
    private Integer abnormalState;

    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人", name = "approvalPerson", example = "")
    private String approvalPerson;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public String getInternalStaffUserName() {
        return internalStaffUserName;
    }

    public void setInternalStaffUserName(String internalStaffUserName) {
        this.internalStaffUserName = internalStaffUserName;
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

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
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
        this.approvalStateName = approvalStateName;
        this.approvalStateName = approvalState != null ? EnumUtil.getByValue(approvalState, ApprovalState.class, "") : null;
    }

    public Integer getAbnormalState() {
        return abnormalState;
    }

    public void setAbnormalState(Integer abnormalState) {
        this.abnormalState = abnormalState;
    }

    public String getApprovalPerson() {
        return approvalPerson;
    }

    public void setApprovalPerson(String approvalPerson) {
        this.approvalPerson = approvalPerson;
    }
}
