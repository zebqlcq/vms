package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VisitorEnterpriseDto
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/23 15:42
 */
public class VisitorEnterpriseDto {

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
     * 访客公司名称
     */
    @ApiModelProperty(value = "访客公司名称", name = "companyName", example = "")
    private String companyName;

    /**
     * 访客预约时间(来访时间)
     */
    @ApiModelProperty(value = "访客预约时间", name = "appointmentStartTime", example = "")
    private LocalDateTime appointmentStartTime;

    /**
     * 访客属性[1普通访客 2贵宾访客 3黑名单访客]
     */
    @ApiModelProperty(value = "访客属性[1普通访客 2贵宾访客 3黑名单访客]", name = "visitorAttribute", example = "")
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
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码", name = "cartNo", example = "")
    private String cartNo;

    /**
     * 操作状态 0-未核实 1-已核实 2-已失效
     */
    @ApiModelProperty(value = "操作状态 0-未核实 1-已核实 2-已失效", name = "operationStatus", example = "")
    private Integer operationStatus;

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "visitorId", name = "visitorId", example = "")
    private Long visitorId;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
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

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public Integer getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(Integer operationStatus) {
        this.operationStatus = operationStatus;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }
}
