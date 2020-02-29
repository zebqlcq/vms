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

/**
 * description 员工信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/9/3.</p>
 */
@ApiModel(description = "企业员工注册信息")
public class EmployeeFormVo implements Serializable {

    private static final long serialVersionUID = -1257364672605760419L;

    /**
     * 员工编号
     */
    @NotBlank(message = "员工编号不能为空")
    @ApiModelProperty(value = "员工编号")
    private String code;

    /**
     * 企业员工名称
     */
    @ApiModelProperty(value = "员工名称")
    private String realName;

    /**
     * 企业id
     */
    @PreventOverflow
    @ApiModelProperty(value = "企业ID")
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
    @ApiModelProperty(value = "证件类型: 1.身份证,2护照号")
    private Integer certificateType;

    /**
     * 企业类型
     */
    @ApiModelProperty(value = "证件号码")
    private String certificateCard;

    /**
     * 性别 [''0未知'', ''1男'', ''2女'']
     */
    @ApiModelProperty(value = "性别 [''0未知'', ''1男'', ''2女'']", example = "1")
    private Integer gender;

    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
    private LocalDate employmentDate = LocalDate.now();

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    private String position;

    /**
     * 在职状态
     */
    @NotNull(message = "在职状态不能为空")
    @ApiModelProperty(value = "在职状态", allowableValues = "1,2", required = true)
    private WorkStatus workStatus;

    /**
     * 人脸信息图像
     */
    @NotEmpty(message = "人脸信息图像不能为空")
    @ApiModelProperty(value = "人脸信息图像", required = true)
    private String faceInfo;

    /**
     * 证件信息图像（正面）
     */
    @NotEmpty(message = "证件信息图像（正面）不能为空")
    @ApiModelProperty(value = "证件信息图像（正面）不能为空", required = true)
    private String cartNoPositive;

    /**
     * 证件信息图像（反面）
     */
    @NotEmpty(message = "证件信息图像（反面）不能为空")
    @ApiModelProperty(value = "证件信息图像（反面）不能为空", required = true)
    private String cartNoNegative;

    @Valid
    @NotNull(message = "员工相关机构信息不能为空")
    @ApiModelProperty(value = "员工相关机构信息", required = true)
    private EmpOrganFormVo empOrganFormVo;

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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public String getFaceInfo() {
        return faceInfo;
    }

    public void setFaceInfo(String faceInfo) {
        this.faceInfo = faceInfo;
    }

    public String getCartNoPositive() {
        return cartNoPositive;
    }

    public void setCartNoPositive(String cartNoPositive) {
        this.cartNoPositive = cartNoPositive;
    }

    public String getCartNoNegative() {
        return cartNoNegative;
    }

    public void setCartNoNegative(String cartNoNegative) {
        this.cartNoNegative = cartNoNegative;
    }

    public EmpOrganFormVo getEmpOrganFormVo() {
        return empOrganFormVo;
    }

    public void setEmpOrganFormVo(EmpOrganFormVo empOrganFormVo) {
        this.empOrganFormVo = empOrganFormVo;
    }
}
