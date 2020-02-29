package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import com.bonade.visitor.domain.enums.VisitorType;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VisitorValidDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/1/2 9:16
 */
public class VisitorValidDto {

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    /**
     * 人脸图像
     */
    @ApiModelProperty(value = "人脸图像", name = "faceImg", example = "")
    private String faceImg;

    /**
     * 访客公司名称
     */
    @ApiModelProperty(value = "访客公司名称", name = "companyName", example = "")
    private String companyName;

    /**
     * 访客部门名称
     */
    @ApiModelProperty(value = "访客部门名称", name = "depName", example = "")
    private String depName;

    /**
     * 访客职位
     */
    @ApiModelProperty(value = "访客职位", name = "userStation", example = "")
    private String userStation;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", name = "tel", example = "")
    private String tel;


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
     * 访客类型:1访客（主动预约） 2来宾（被邀请）
     */
    @ApiModelProperty(value = "访客类型:1访客（主动预约） 2来宾（被邀请）", name = "visitorType", example = "")
    private VisitorType visitorType;

    /**
     * 访客类型名称
     */
    @ApiModelProperty(value = "访客类型名称", name = "visitorTypeName", example = "")
    private String visitorTypeName;

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
     * 关联内部人员名称
     */
    @ApiModelProperty(value = "关联内部人员名称", name = "internalStaffUserName", example = "")
    private String internalStaffUserName;

    /**
     * 登记形式 1内部邀约,2访客预约
     */
    @ApiModelProperty(value = "登记形式 1内部邀约,2访客预约", name = "registration", example = "")
    private Integer registration;

    @PreventOverflow
    @ApiModelProperty(value = "主键", name = "id", example = "")
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "访客ID", name = "visitorId", example = "")
    private Long visitorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public VisitorType getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(VisitorType visitorType) {
        this.visitorType = visitorType;
    }

    public String getVisitorTypeName() {
        return visitorTypeName;
    }

    public void setVisitorTypeName(String visitorTypeName) {
        this.visitorTypeName = visitorType != null ? EnumUtil.getByValue(visitorType.getValue(), VisitorType.class, "") : null;
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

    public String getInternalStaffUserName() {
        return internalStaffUserName;
    }

    public void setInternalStaffUserName(String internalStaffUserName) {
        this.internalStaffUserName = internalStaffUserName;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }
}
