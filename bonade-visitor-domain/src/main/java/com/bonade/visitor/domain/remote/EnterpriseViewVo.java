package com.bonade.visitor.domain.remote;

import com.bonade.visitor.domain.enums.EnterpriseAuditStatus;
import com.bonade.visitor.domain.enums.EnterpriseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chenmeng
 * @description 企业信息
 * @date 2019-11-11 11:20
 */
@ApiModel(description = "企业信息")
public class EnterpriseViewVo implements Serializable {

    private static final long serialVersionUID = 4884081879835962408L;

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String name;

    /**
     * 企业编码
     */
    @ApiModelProperty(value = "企业编码")
    private String code;
    /**
     * 企业简称
     */
    @ApiModelProperty(value = "企业简称")
    private String shortName;

    /**
     * 纳税人识别号（18位）
     */
    @ApiModelProperty(value = "纳税人识别号（18位）")
    private String taxNo;

    /**
     * 统一社会信用代码（中台与纳税人识别号一致）
     */
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;

    /**
     * 企业类型
     */
    @ApiModelProperty(value = "企业类型 1.客户企业 2.运营企业 3.合作企业 4.管理员企业 5.客户运营企业", allowableValues = "1,2,3,4,5")
    private EnterpriseType enterpriseType;

    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    private EnterpriseAuditStatus auditStatus;

    /**
     * 状态 状态(1.启用/2.停用/-1.删除)
     */
    @ApiModelProperty(value = "状态(1.启用/2.停用/-1.删除)")
    private Integer status;

    /**
     * 审核备注
     */
    @ApiModelProperty(value = "审核备注")
    private String auditRemark;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private LocalDateTime auditTime;

    /**
     * 法人
     */
    @ApiModelProperty(value = "法人", example = "张")
    private String legalPerson;

    /**
     * 法人身份证号
     */
    @ApiModelProperty(value = "法人身份证号")
    private String legalPersonNo;

    /**
     * 中台 openId
     */
    @ApiModelProperty(value = "中台 openId", hidden = true)
    private String platformOpenId;

    /**
     * 管理员账号
     */
    @ApiModelProperty(value = "管理员账号", hidden = true)
    private String adminAccount;

    /**
     * 管理员手机号
     */
    @ApiModelProperty(value = "管理员手机号", hidden = true)
    private String adminPhoneNumber;

    /**
     * 管理员姓名
     */
    @ApiModelProperty(value = "管理员姓名", hidden = true)
    private String adminName;

    /**
     * 是否是集团  0：不是，1：是
     */
    @ApiModelProperty(value = "是否是集团  0：不是，1：是")
    private Byte isGroup;

    /**
     * 父级企业ID（各业务线的企业ID）。
     * 注意：
     * 1、0为顶级企业，isGroup = 1是 parentId必须为0
     * 2、不能将子级企业或自己设为父级企业
     * 3、必须先同步父级企业
     */
    @ApiModelProperty(value = "父级企业ID")
    private String parentId;

    /**
     * 扩展信息
     */
    @ApiModelProperty(value = "扩展信息")
    private String ext1;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private Integer version;

    /**
     * 企业logo
     */
    @ApiModelProperty(value = "企业logo")
    private String logo;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 企业负责人
     */
    @ApiModelProperty(value = "企业负责人")
    private String manager;

    @ApiModelProperty(value = "企业区域信息")
    private List<EnterpriseRegionViewVo> regions;

    @ApiModelProperty(value = "下级企业")
    private List<EnterpriseViewVo> child;

    /**
     * 省
     */
    @ApiModelProperty(value = "区域编码（省）")
    private String provinceCode;

    /**
     * 市
     */
    @ApiModelProperty(value = "区域编码（市）")
    private String cityCode;

    /**
     * 区
     */
    @ApiModelProperty(value = "区域编码（区）")
    private String districtCode;

    /**
     * 位置全称
     */
    @ApiModelProperty(value = "位置全称")
    private String regionName;

    /**
     * 企业简介
     */
    @ApiModelProperty(value = "企业简介")
    private String summary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public EnterpriseAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public LocalDateTime getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(LocalDateTime auditTime) {
        this.auditTime = auditTime;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPersonNo() {
        return legalPersonNo;
    }

    public void setLegalPersonNo(String legalPersonNo) {
        this.legalPersonNo = legalPersonNo;
    }

    public String getPlatformOpenId() {
        return platformOpenId;
    }

    public void setPlatformOpenId(String platformOpenId) {
        this.platformOpenId = platformOpenId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Byte getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Byte isGroup) {
        this.isGroup = isGroup;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuditStatus(EnterpriseAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<EnterpriseRegionViewVo> getRegions() {
        return regions;
    }

    public void setRegions(List<EnterpriseRegionViewVo> regions) {
        this.regions = regions;
    }

    public List<EnterpriseViewVo> getChild() {
        return child;
    }

    public void setChild(List<EnterpriseViewVo> child) {
        this.child = child;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
