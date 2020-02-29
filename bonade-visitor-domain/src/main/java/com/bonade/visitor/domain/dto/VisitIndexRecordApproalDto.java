package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitStatus;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VisitIndexRecordApproalDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/21 9:28
 */
public class VisitIndexRecordApproalDto {

    /**
     * 访客记录ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "访客记录ID", name = "id", example = "")
    private Long id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "")
    private LocalDateTime createTime;

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    /**
     * 访客公司名称
     */
    @ApiModelProperty(value = "访客公司名称", name = "companyName", example = "")
    private String companyName;

    /**
     * 关联内部人员名称
     */
    @ApiModelProperty(value = "关联内部人员名称", name = "internalStaffUserName", example = "")
    private String internalStaffUserName;

    /**
     * 拜访企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "拜访企业ID", name = "enterpriseId", example = "")
    private Long enterpriseId;

    /**
     * 拜访企业名称
     */
    @ApiModelProperty(value = "拜访企业名称", name = "enterpriseName", example = "")
    private String enterpriseName;

    /**
     * 访问事由[1-业务洽谈,2-事务办理,10-其他]
     */
    @ApiModelProperty(value = "访问事由[1-业务洽谈,2-事务办理,10-其他]", name = "visitCause", dataType = "VisitCause")
    private VisitCause visitCause;

    /**
     * 访问事由名称
     */
    @ApiModelProperty(value = "访问事由名称", name = "visitCauseName", example = "")
    private String visitCauseName;

    /**
     * 访客预约时间(来访时间)
     */
    @ApiModelProperty(value = "访客预约时间(来访时间)(开始)", name = "appointmentStartTime", example = "")
    private LocalDateTime appointmentStartTime;

    /**
     * 访客预约时间
     */
    @ApiModelProperty(value = "访客预约时间(来访时间)(结束)", name = "appointmentEndTime", example = "")
    private LocalDateTime appointmentEndTime;

    /**
     * 审批id
     */
    @ApiModelProperty(value = "审批id", name = "approvalId", dataType = "Long")
    private Long approvalId;

    /**
     *  审批人审批状态: 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） 3待阅览（抄送人）4 已阅览（抄送人）
     */
    @ApiModelProperty(value = "审批人审批状态: 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） 3待阅览（抄送人）4 已阅览（抄送人）", name = "state", dataType = "Integer")
    private Integer state;

    @ApiModelProperty(value = "审批人审批状态名称", name = "stateName", dataType = "String")
    private String stateName;

    /**
     * 审批状态: 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） -1已撤销
     */
    @ApiModelProperty(value = "审批状态: 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） -1已撤销", name = "state", dataType = "Integer")
    private Integer approvalState;

    @ApiModelProperty(value = "审批状态名称", name = "approvalStateName", dataType = "String")
    private String approvalStateName;

    /****************************************************************************/

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态[1-待审核, 2-待验证, 3-待拜访,4-待来访,5-已拒绝,6-已拒绝,7-已入场, 8-已完成, 9-访问超时, 10-访问异常,11-通过,12-请求验证,0-撤销邀约,-1 - 撤销预约]", name = "visitStatus", example = "")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "状态名称", name = "visitStatusName", dataType = "String")
    private String visitStatusName;

    /**
     * 审批意见
     */
    @ApiModelProperty(value = "审批意见", name = "approvalOpinion", example = "")
    private String approvalOpinion;

    /**
     * 审批时间
     */
    @ApiModelProperty(value = "审批时间", name = "approvalTime", example = "")
    private LocalDateTime approvalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInternalStaffUserName() {
        return internalStaffUserName;
    }

    public void setInternalStaffUserName(String internalStaffUserName) {
        this.internalStaffUserName = internalStaffUserName;
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

    public LocalDateTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = state != null ? EnumUtil.getByValue(state, ApprovalState.class, "") : null;
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

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public LocalDateTime getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(LocalDateTime approvalTime) {
        this.approvalTime = approvalTime;
    }
}
