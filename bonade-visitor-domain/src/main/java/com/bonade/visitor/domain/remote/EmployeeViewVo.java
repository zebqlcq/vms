package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * description 员工信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/9/3.</p>
 */
@ApiModel(description = "企业员工注册信息")
public class EmployeeViewVo implements Serializable {


    private static final long serialVersionUID = -3518926986760439667L;

    @PreventOverflow
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "员工编码")
    private String code;

    @PreventOverflow
    @ApiModelProperty(value = "关联的用户ID")
    private Long userId;

    @ApiModelProperty(value = "上级员工")
    @PreventOverflow
    private Long superior;

    @ApiModelProperty(value = "员工在集团平台系统的唯一Id")
    private String staffOpenId;

    @ApiModelProperty(value = "企业ID")
    @PreventOverflow
    private Long enterpriseId;

    /**
     * 企业员工名称
     */
    @ApiModelProperty(value = "企业员工名称")
    private String userName;

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
     * 企业类型
     */
    @ApiModelProperty(value = "证件号码")
    private String certificateCard;



    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
    private LocalDate employmentDate;

    /**
     * 新员工来源
     */
    @ApiModelProperty(value = "新员工来源")
    private String userFrom;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位信息")
    private String title;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;


    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称")
    private String stationName;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "自定义组织名称")
    private String organName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSuperior() {
        return superior;
    }

    public void setSuperior(Long superior) {
        this.superior = superior;
    }

    public String getStaffOpenId() {
        return staffOpenId;
    }

    public void setStaffOpenId(String staffOpenId) {
        this.staffOpenId = staffOpenId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }
}
