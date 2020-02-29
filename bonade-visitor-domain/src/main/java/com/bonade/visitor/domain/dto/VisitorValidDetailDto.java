package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VisitorValidDetailDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/1/9 9:38
 */
public class VisitorValidDetailDto {

    @PreventOverflow
    @ApiModelProperty(value = "主键", name = "id", example = "")
    private Long id;

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
     * 访客属性:1普通访客 2贵宾访客 3黑名单访客
     */
    @ApiModelProperty(value = "访客属性:1普通访客 2贵宾访客 3黑名单访客", name = "visitorAttribute", example = "")
    private VisitorAttribute visitorAttribute;

    /**
     * 访客属性名称
     */
    @ApiModelProperty(value = "访客属性名称", name = "visitorAttributeName", example = "")
    private String visitorAttributeName;

    /**
     * 访问事由
     */
    @ApiModelProperty(value = "访问事由", name = "visitCause", example = "")
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
     * 关联内部人员名称
     */
    @ApiModelProperty(value = "关联内部人员名称", name = "internalStaffUserName", example = "")
    private String internalStaffUserName;

    /**
     * 关联内部人员手机号
     */
    @ApiModelProperty(value = "关联内部人员手机号", name = "internalStaffUserTel", example = "")
    private String internalStaffUserTel;

    /**
     * 关联内部人员部门
     */
    @ApiModelProperty(value = "关联内部人员部门", name = "internalStaffUserDept", example = "")
    private String internalStaffUserDept;

    /**
     * 访客码
     */
    @ApiModelProperty(value = "访客码", name = "visitorCode", example = "")
    private String visitorCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVisitorCode() {
        return visitorCode;
    }

    public void setVisitorCode(String visitorCode) {
        this.visitorCode = visitorCode;
    }
}
