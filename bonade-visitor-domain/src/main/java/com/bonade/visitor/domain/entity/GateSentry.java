package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.spin.common.db.entity.AbstractEntity;

import java.time.LocalDateTime;

/**
 * @description 门岗表
 * @author chenmeng
 * @date 2020-1-13 13:41
*/
@TableName("vms_gate_sentry")
public class GateSentry extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 管辖区域id
     */
    private Long areaId;

    /**
     * 人脸图像url
     */
    private String faceImg;

    /**
     * 证件信息图像（正面）
     */
    private String cardNoPositive;

    /**
     * 证件信息图像（反面）
     */
    private String cardNoNegative;

    /**
     * 人脸图像url上传人
     */
    private String faceImgUploader;

    /**
     * 人脸图像url上传时间
     */
    private LocalDateTime faceImgTime;

    /**
     * 证件信息图像（正面）上传人
     */
    private String cardNoPositiveUploader;

    /**
     * 证件信息图像（正面）上传时间
     */
    private LocalDateTime cardNoPositiveTime;

    /**
     * 证件信息图像（反面）上传人
     */
    private String cardNoNegativeUploader;

    /**
     * 证件信息图像（反面）上传时间
     */
    private LocalDateTime cardNoNegativeTime;

    /**
     * 证件类型 1身份证
     */
    private Integer cartType;

    /**
     * 身份证号码
     */
    private String cartNo;

    /**
     * 关联权限id
     */
    private Long roleId;

    /**
     * 企业负责人手机号码
     */
    private String tel;

    /**
     * 在岗状态 1在岗 2休假
     */
    private Integer status;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 员工id
     */
    private Long employeeId;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
