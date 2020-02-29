package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.management.relation.RelationType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * description 员工信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/9/3.</p>
 */
@ApiModel(description = "企业员工信息")
public class EmpViewVo implements Serializable {

    private static final long serialVersionUID = -3518926986760439667L;

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "ID")
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
     * 上级员工
     */
    @PreventOverflow
    @ApiModelProperty(value = "上级员工")
    private Long superior;

    /**
     * 员工在集团平台系统的唯一Id
     */
    @ApiModelProperty(value = "员工在集团平台系统的唯一Id", hidden = true)
    private String staffOpenId;

    /**
     * 企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "企业ID")
    private Long enterpriseId;

    /**
     * 企业员工名称
     */
    @ApiModelProperty(value = "企业员工名称")
    private String username;

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
     * 性别 [''0未知'', ''1男'', ''2女'']
     */
    @ApiModelProperty(value = "性别 [0未知, 1男, 2女]", allowableValues = "0,1,2", example = "1")
    private GenderType gender;


    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
    private LocalDate employmentDate;

    /**
     * 新员工来源
     */
    @ApiModelProperty(value = "新员工来源", hidden = true)
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
     * 自定义组织名称
     */
    @ApiModelProperty(value = "自定义组织名称")
    private String customOrganName;

    /**
     * 头像URL
     */
    @ApiModelProperty(value = "头像URL")
    private String headImg;

    /**
     * 相关机构
     */
    @ApiModelProperty(value = "相关机构")
    private String organName;

    /**
     * 机构全称
     */
    @ApiModelProperty(value = "相关机构全称")
    private String fullOrganName;

    /**
     * 关系类型
     */
    @ApiModelProperty(value = "关系类型")
    private RelationType relationType;

    /**
     * 关系ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "关系ID")
    private Long relationId;

    /**
     * 在职状态
     */
    @ApiModelProperty(value = "在职状态（1 在职， 2 离职）", allowableValues = "1,2")
    private WorkStatus workStatus;

    /**
     * 人脸信息图像
     */
    @ApiModelProperty(value = "人脸信息图像")
    private String faceInfo;

    /**
     * 证件信息图像（正面）
     */
    @ApiModelProperty(value = "证件信息图像（正面）")
    private String cartNoPositive;

    /**
     * 证件信息图像（反面）
     */
    @ApiModelProperty(value = "证件信息图像（反面）")
    private String cartNoNegative;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createUsername;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCustomOrganName() {
        return customOrganName;
    }

    public void setCustomOrganName(String customOrganName) {
        this.customOrganName = customOrganName;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getFullOrganName() {
        return fullOrganName;
    }

    public void setFullOrganName(String fullOrganName) {
        this.fullOrganName = fullOrganName;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
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

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
