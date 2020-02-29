package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * description 员工信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/9/3.</p>
 */
@ApiModel(description = "企业员工注册信息")
public class EmpFormVo implements Serializable {

    private static final long serialVersionUID = -1257364672605760419L;

    /**
     * 员工编码
     */
    @ApiModelProperty(value = "员工编码")
    private String code;

    /**
     * 员工名称
     */
    @NotBlank(message = "员工名称不能为空")
    @ApiModelProperty(value = "员工名称")
    private String realName;

    /**
     * 企业id
     */
    @PreventOverflow
    @ApiModelProperty(value = "企业ID", hidden = true)
    private Long enterpriseId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "关联的用户ID")
    private Long userId;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号码格式不正确")
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
    @NotNull(message = "证件类型不能为空")
    @ApiModelProperty(value = "证件类型: 1.身份证,2.护照号")
    private Integer certificateType;

    /**
     * 企业类型
     */
    @NotNull(message = "证件号码不能为空")
    @ApiModelProperty(value = "证件号码")
    private String certificateCard;

    /**
     * 性别 ['0未知', '1男', '2女']
     */
    @ApiModelProperty(value = "性别 ['0未知', '1男', '2女']", example = "1")
    private Integer gender;

    /**
     * 入职日期
     */
    @NotNull(message = "入职日期不能为空")
    @ApiModelProperty(value = "入职日期（默认当前时间）")
    private LocalDate employmentDate = LocalDate.now();

    /**
     * 在职状态
     */
    @ApiModelProperty(value = "在职状态", allowableValues = "1,2", required = true)
    private WorkStatus workStatus = WorkStatus.ON_JOB;

    /**
     * 证件信息
     */
    @NotEmpty(message = "证件信息不能为空")
    @ApiModelProperty(value = "员工证件信息", required = true)
    private List<LicenseFormVo> licenses;

    @Valid
    @ApiModelProperty(value = "员工相关机构信息", required = true)
    private EmpOrganFormVo empOrganFormVo;

    /**
     * 国籍
     */
    @ApiModelProperty(value = "国籍", required = true)
    @NotBlank(message = "国籍不能为空")
    private String nationality;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public EmpOrganFormVo getEmpOrganFormVo() {
        return empOrganFormVo;
    }

    public void setEmpOrganFormVo(EmpOrganFormVo empOrganFormVo) {
        this.empOrganFormVo = empOrganFormVo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<LicenseFormVo> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseFormVo> licenses) {
        this.licenses = licenses;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
