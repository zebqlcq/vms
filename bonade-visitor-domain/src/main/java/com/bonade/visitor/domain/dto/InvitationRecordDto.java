package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitStatus;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: InvitationRecordDto
 * @projectName bonade-vms
 * @description: 邀约记录(企业控制台)
 * @date 2019/12/27 9:21
 */
public class InvitationRecordDto {

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    /**
     * 访客预约时间
     */
    @ApiModelProperty(value = "访客预约时间", name = "appointmentStartTime", example = "")
    private LocalDateTime appointmentStartTime;

    /**
     * 模板名称
     */
    @ApiModelProperty(value = "模板名称", name = "tempName", example = "")
    private String tempName;

    /**
     * 邀约主题
     */
    @ApiModelProperty(value = "邀约主题", name = "theme", example = "")
    private String theme;

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
     * 发起（邀约）人名称
     */
    @ApiModelProperty(value = "发起（邀约）人名称", name = "internalStaffUserName", example = "")
    private String internalStaffUserName;

    /**
     * 发起（邀约）人所在部门
     */
    @ApiModelProperty(value = "发起（邀约）人所在部门", name = "internalStaffUserDept", example = "")
    private String internalStaffUserDept;

    /**
     * 状态/类型
     */
    @ApiModelProperty(value = "状态/类型[1-待审核, 2-待验证, 3-待拜访,4-待来访,5-已拒绝,6-已拒绝,7-已入场, 8-已完成, 9-访问超时, 10-访问异常,11-通过,12-请求验证,0-撤销邀约,-1 - 撤销预约]", name = "visitStatus", example = "")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "状态名称", name = "visitStatus", example = "")
    private String visitStatusName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

    public String getInternalStaffUserName() {
        return internalStaffUserName;
    }

    public void setInternalStaffUserName(String internalStaffUserName) {
        this.internalStaffUserName = internalStaffUserName;
    }

    public String getInternalStaffUserDept() {
        return internalStaffUserDept;
    }

    public void setInternalStaffUserDept(String internalStaffUserDept) {
        this.internalStaffUserDept = internalStaffUserDept;
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
}
