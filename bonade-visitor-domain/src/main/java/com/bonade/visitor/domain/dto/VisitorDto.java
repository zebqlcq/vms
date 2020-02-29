package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitStatus;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VisitorDto
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/23 9:16
 */
public class VisitorDto {

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    /**
     * 人脸图像
     */
    @ApiModelProperty(value = "人脸图像", name = "faceImg", example = "")
    private String faceImg;

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

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
     * 访客预约时间
     */
    @ApiModelProperty(value = "访客预约时间", name = "appointmentStartTime", example = "")
    private LocalDateTime appointmentStartTime;

    /**
     * 来访状态
     */
    @ApiModelProperty(value = "来访状态", name = "visitStatus", example = "")
    private VisitStatus visitStatus;

    /**
     * 状态名称
     */
    @ApiModelProperty(value = "状态名称", name = "visitStatusName", dataType = "String")
    private String visitStatusName;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
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
}
