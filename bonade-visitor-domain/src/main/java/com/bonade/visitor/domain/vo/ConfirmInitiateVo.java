package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: ConfirmInitiateVo
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/18 9:29
 */
public class ConfirmInitiateVo {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    /**
     * 拜访企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "拜访企业ID", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "", required = true)
    private String name;

    /**
     * 访客属性:1普通访客 2贵宾访客 3黑名单访客
     */
    @ApiModelProperty(value = "访客属性:1普通访客 2贵宾访客 3黑名单访客", name = "visitorAttribute", example = "", required = true)
    private Integer visitorAttribute;

    /**
     * 访客预约时间
     */
    @ApiModelProperty(value = "访客预约时间", name = "appointmentStartTime", example = "", required = true)
    private LocalDateTime appointmentStartTime;

    /**
     * 发起人ID[登录人]
     */
    @ApiModelProperty(value = "发起人ID[登录人]", name = "originatorId", example = "", required = true)
    private Long originatorId;

    /**
     * 发起人名称[登录人]
     */
    @ApiModelProperty(value = "发起人名称[登录人]", name = "originatorName", example = "", required = true)
    private String originatorName;

    /**
     * 发起人企业ID[登录人]
     */
    @ApiModelProperty(value = "发起人企业ID[登录人]", name = "originatorEnterpriseId", example = "", required = true)
    private Long originatorEnterpriseId;

    /**
     * 发起人企业名称[登录人]
     */
    @ApiModelProperty(value = "发起人企业名称[登录人]", name = "originatorEnterpriseName", example = "", required = true)
    private String originatorEnterpriseName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(Integer visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public Long getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(Long originatorId) {
        this.originatorId = originatorId;
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public void setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
    }

    public Long getOriginatorEnterpriseId() {
        return originatorEnterpriseId;
    }

    public void setOriginatorEnterpriseId(Long originatorEnterpriseId) {
        this.originatorEnterpriseId = originatorEnterpriseId;
    }

    public String getOriginatorEnterpriseName() {
        return originatorEnterpriseName;
    }

    public void setOriginatorEnterpriseName(String originatorEnterpriseName) {
        this.originatorEnterpriseName = originatorEnterpriseName;
    }
}
