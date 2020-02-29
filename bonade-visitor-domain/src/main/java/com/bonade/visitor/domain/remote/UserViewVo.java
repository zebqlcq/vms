package com.bonade.visitor.domain.remote;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.io.Serializable;

@ApiModel(value = "UserViewVo", description = "用户信息")
public class UserViewVo implements Serializable {

    private static final long serialVersionUID = 7484151880534378160L;

    @PreventOverflow
    @ApiModelProperty(value = "用户ID", name = "id")
    private Long id;

    @ApiModelProperty(value = "用户姓名", name = "realName")
    private String realName;

    @ApiModelProperty(value = "手机号码", name = "phone")
    private String phone;

    @ApiModelProperty(value = "是否有企业", name = "hasEnterprise")
    private Integer hasEnterprise;

    @ApiModelProperty(value = "证件信息 身份证 0，军官证 1，护照 2，港澳通行证3", name = "certificateType")
    private CertificateType certificateType;

    @ApiModelProperty(value = "证件名称", hidden = true)
    private String certificateName;

    @ApiModelProperty(value = "证件号码", name = "cartNo")
    private String cartNo;

    @ApiModelProperty(value = "用户来源", name = "userFrom")
    private String userFrom;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName")
    private String enterpriseName;

    @ApiModelProperty(value = "企业简称", name = "enterpriseShortName")
    private String enterpriseShortName;

    @ApiModelProperty(value = "是否实名认证 0：否 1：是", name = "realVerification")
    private Integer realVerification;

    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;

    @ApiModelProperty(value = "性别 ['0 未知', '1 男', '2 女']", allowableValues = "1,2,0")
    private GenderType gender;

    @ApiModelProperty(value = "启用1 禁用本地系统访问2 禁用所有系统3", required = true)
    private UserStatus status;

    /**
     * 国籍
     */
    @ApiModelProperty(value = "国籍")
    private String nationality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Integer getHasEnterprise() {
        return hasEnterprise;
    }

    public void setHasEnterprise(Integer hasEnterprise) {
        this.hasEnterprise = hasEnterprise;
    }

    public CertificateType getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(CertificateType certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {

        this.certificateName = certificateName;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseShortName() {
        return enterpriseShortName;
    }

    public void setEnterpriseShortName(String enterpriseShortName) {
        this.enterpriseShortName = enterpriseShortName;
    }

    public Integer getRealVerification() {
        return realVerification;
    }

    public void setRealVerification(Integer realVerification) {
        this.realVerification = realVerification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
