package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.GardenArea;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @description 门岗VO
 * @author chenmeng
 * @date 2019-12-26 9:11
*/
@ApiModel(value = "GateSentryInVo", description = "园区区域入参vo")
public class GateSentryInVo implements VoEntityMapper<GateSentryInVo, GardenArea> {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName", example = "", required = true)
    private String enterpriseName;

    @ApiModelProperty(value = "姓名", name = "name", example = "", required = true)
    private String name;


    @PreventOverflow
    @ApiModelProperty(value = "管辖区域id", name = "areaId", example = "", required = true)
    private Long areaId;


    @ApiModelProperty(value = "人脸图像url", name = "faceImg", example = "", required = true)
    private String faceImg;

    @ApiModelProperty(value = "人脸图像url 文件id", name = "faceImgId", example = "", required = true)
    private Long faceImgId;

    @ApiModelProperty(value = "证件信息图像（正面）", name = "cardNoPositive", example = "", required = true)
    private String cardNoPositive;

    @ApiModelProperty(value = "证件信息图像（正面）文件id", name = "cardNoPositiveId", example = "", required = true)
    private Long cardNoPositiveId;

    @ApiModelProperty(value = "证件信息图像（反面）", name = "cardNoNegative", example = "", required = true)
    private String cardNoNegative;

    @ApiModelProperty(value = "证件信息图像（反面）文件id", name = "cardNoNegativeId", example = "", required = true)
    private Long cardNoNegativeId;

    @ApiModelProperty(value = "人脸图像url上传人", name = "faceImgUploader", example = "", required = true)
    private String faceImgUploader;

    @ApiModelProperty(value = "人脸图像url上传时间", name = "faceImgTime", example = "", required = true)
    private LocalDateTime faceImgTime;

    @ApiModelProperty(value = "证件信息图像（正面）上传人", name = "cardNoPositiveUploader", example = "", required = true)
    private String cardNoPositiveUploader;

    @ApiModelProperty(value = "证件信息图像（正面）上传时间", name = "cardNoPositiveTime", example = "", required = true)
    private LocalDateTime cardNoPositiveTime;

    @ApiModelProperty(value = "证件信息图像（反面）上传人", name = "cardNoNegativeUploader", example = "", required = true)
    private String cardNoNegativeUploader;

    @ApiModelProperty(value = "证件信息图像（反面）上传时间", name = "cardNoNegativeTime", example = "", required = true)
    private LocalDateTime cardNoNegativeTime;

    @ApiModelProperty(value = "证件类型 1身份证", name = "cartType", example = "", required = true)
    private Integer cartType;

    @ApiModelProperty(value = "身份证号码", name = "cartNo", example = "", required = true)
    private String cartNo;

    @ApiModelProperty(value = "关联权限id", name = "roleId", example = "", required = true)
    private Long roleId;

    @ApiModelProperty(value = "负责人手机号码", name = "tel", example = "", required = true)
    private String tel;

    @ApiModelProperty(value = "在岗状态 1在岗 2休假", name = "status", example = "", required = true)
    private Integer status;

    @ApiModelProperty(value = "用户id", name = "userId", example = "")
    private Long userId;

    @ApiModelProperty(value = "员工id", name = "employeeId", example = "")
    private Long employeeId;

    @ApiModelProperty(value = "国籍" ,name = "nationality", example = "")
    private String nationality;

    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getCardNoPositive() {
        return cardNoPositive;
    }

    public void setCardNoPositive(String cardNoPositive) {
        this.cardNoPositive = cardNoPositive;
    }

    public String getCardNoNegative() {
        return cardNoNegative;
    }

    public void setCardNoNegative(String cardNoNegative) {
        this.cardNoNegative = cardNoNegative;
    }

    public Integer getCartType() {
        return cartType;
    }

    public void setCartType(Integer cartType) {
        this.cartType = cartType;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getFaceImgUploader() {
        return faceImgUploader;
    }

    public void setFaceImgUploader(String faceImgUploader) {
        this.faceImgUploader = faceImgUploader;
    }

    public LocalDateTime getFaceImgTime() {
        return faceImgTime;
    }

    public void setFaceImgTime(LocalDateTime faceImgTime) {
        this.faceImgTime = faceImgTime;
    }

    public String getCardNoPositiveUploader() {
        return cardNoPositiveUploader;
    }

    public void setCardNoPositiveUploader(String cardNoPositiveUploader) {
        this.cardNoPositiveUploader = cardNoPositiveUploader;
    }

    public LocalDateTime getCardNoPositiveTime() {
        return cardNoPositiveTime;
    }

    public void setCardNoPositiveTime(LocalDateTime cardNoPositiveTime) {
        this.cardNoPositiveTime = cardNoPositiveTime;
    }

    public String getCardNoNegativeUploader() {
        return cardNoNegativeUploader;
    }

    public void setCardNoNegativeUploader(String cardNoNegativeUploader) {
        this.cardNoNegativeUploader = cardNoNegativeUploader;
    }

    public LocalDateTime getCardNoNegativeTime() {
        return cardNoNegativeTime;
    }

    public void setCardNoNegativeTime(LocalDateTime cardNoNegativeTime) {
        this.cardNoNegativeTime = cardNoNegativeTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getFaceImgId() {
        return faceImgId;
    }

    public void setFaceImgId(Long faceImgId) {
        this.faceImgId = faceImgId;
    }

    public Long getCardNoPositiveId() {
        return cardNoPositiveId;
    }

    public void setCardNoPositiveId(Long cardNoPositiveId) {
        this.cardNoPositiveId = cardNoPositiveId;
    }

    public Long getCardNoNegativeId() {
        return cardNoNegativeId;
    }

    public void setCardNoNegativeId(Long cardNoNegativeId) {
        this.cardNoNegativeId = cardNoNegativeId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
