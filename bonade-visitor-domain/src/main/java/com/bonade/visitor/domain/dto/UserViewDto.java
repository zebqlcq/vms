package com.bonade.visitor.domain.dto;


import org.spin.core.gson.annotation.PreventOverflow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserViewVo", description = "用户信息")
public class UserViewDto {

    @PreventOverflow
    @ApiModelProperty(value = "用户ID", name = "id")
    private Long id;

    @ApiModelProperty(value = "用户姓名", name = "realName")
    private String realName;

    @ApiModelProperty(value = "手机号码", name = "phone")
    private String phone;

    @ApiModelProperty(value = "是否有企业", name = "hasEnterprise")
    private Integer hasEnterprise;

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

    /**
     * 国籍
     */
    @ApiModelProperty(value = "国籍")
    private String nationality;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private Integer version;

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

	public Integer getHasEnterprise() {
		return hasEnterprise;
	}

	public void setHasEnterprise(Integer hasEnterprise) {
		this.hasEnterprise = hasEnterprise;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
   
}
