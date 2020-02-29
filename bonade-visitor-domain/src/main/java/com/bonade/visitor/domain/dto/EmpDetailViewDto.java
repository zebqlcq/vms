package com.bonade.visitor.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.spin.core.gson.annotation.PreventOverflow;

import com.bonade.visitor.domain.enums.RelationType;
import com.bonade.visitor.domain.vo.EmpRelationViewVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName:  EmpDetailViewDto   
 * @Description:
 * @author: lcq 
 * @date:   2020年2月20日 上午11:04:19   
 * @version 1.0
 */
@ApiModel(description = "企业员工详细信息")
public class EmpDetailViewDto {

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "员工ID")
    private Long id;

    /**
     * 员工编码
     */
    @ApiModelProperty(value = "员工编码")
    private String code;

    /**
     * 关联的用户ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "关联的用户ID")
    private Long userId;

    /**
     * 员工名称
     */
    @ApiModelProperty(value = "员工名称")
    private String username;

    /**
     * 企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "企业ID")
    private Long enterpriseId;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 证件类型: 1.身份证,2护照号
     */
    @ApiModelProperty(value = "证件类型: 1.身份证,2护照号")
    private Integer certificateType;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    private String certificateCard;


    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
    private LocalDate employmentDate;

    /**
     * 头像URL
     */
    @ApiModelProperty(value = "头像URL")
    private String headImg;

    /**
     * 认证类型（String）
     */
    @ApiModelProperty(value = "认证类型（String）", hidden = true)
    private String license;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


    Map<RelationType, List<EmpRelationViewVo>> relationMap;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Long getEnterpriseId() {
		return enterpriseId;
	}


	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getCertificateType() {
		return certificateType;
	}


	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}


	public String getCertificateCard() {
		return certificateCard;
	}


	public void setCertificateCard(String certificateCard) {
		this.certificateCard = certificateCard;
	}


	public LocalDate getEmploymentDate() {
		return employmentDate;
	}


	public void setEmploymentDate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}


	public String getHeadImg() {
		return headImg;
	}


	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public LocalDateTime getCreateTime() {
		return createTime;
	}


	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}


	public Map<RelationType, List<EmpRelationViewVo>> getRelationMap() {
		return relationMap;
	}

	public void setRelationMap(Map<RelationType, List<EmpRelationViewVo>> relationMap) {
		this.relationMap = relationMap;
	}


	@Override
	public String toString() {
		return "EmpDetailViewDto [id=" + id + ", code=" + code + ", userId=" + userId + ", username=" + username
				+ ", enterpriseId=" + enterpriseId + ", phone=" + phone + ", email=" + email + ", certificateType="
				+ certificateType + ", certificateCard=" + certificateCard + ", employmentDate=" + employmentDate
				+ ", headImg=" + headImg + ", license=" + license + ", createTime=" + createTime + ", relationMap="
				+ relationMap + "]";
	}
   
}
