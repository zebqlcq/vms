package com.bonade.visitor.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zoushaopeng
 * @title: VisitorDetailDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/1/20 9:40
 */
public class VisitorDetailDto {

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "主键", name = "id", example = "")
    private Long id;

    /**
     * 人脸图像
     */
    @ApiModelProperty(value = "人脸图像", name = "faceImg", example = "")
    private String faceImg;

    /**
     * 人脸图像上传时间
     */
    @ApiModelProperty(value = "人脸图像上传时间", name = "faceImgUploadTime", example = "")
    private LocalDateTime faceImgUploadTime;

    /**
     * 证件信息图像（正面）
     */
    @ApiModelProperty(value = "证件信息图像（正面）", name = "cardNoPositive", example = "")
    private String cardNoPositive;

    /**
     * 证件信息图像（反面）
     */
    @ApiModelProperty(value = "证件信息图像（反面）", name = "cardNoNegative", example = "")
    private String cardNoNegative;

    /**
     * 身份证上传时间
     */
    @ApiModelProperty(value = "身份证上传时间", name = "cardUploadTime", example = "")
    private LocalDateTime cardUploadTime;

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码", name = "cartNo", example = "")
    private String cartNo;

    /**
     * 访客公司名称
     */
    @ApiModelProperty(value = "访客公司名称", name = "companyName", example = "")
    private String companyName;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", name = "tel", example = "")
    private String tel;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位", name = "userStation", example = "")
    private String userStation;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号", name = "carNo", example = "")
    private String carNo;

    /**
     *  来访记录次数
     */
    @ApiModelProperty(value = "来访记录次数", name = "visitNum", example = "")
    private Integer visitNum;

    /**
     *  来访记录
     */
    @ApiModelProperty(value = "来访记录", name = "visitIndexRecordList", example = "")
    private List<VisitIndexRecordDto> visitIndexRecordList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public LocalDateTime getFaceImgUploadTime() {
        return faceImgUploadTime;
    }

    public void setFaceImgUploadTime(LocalDateTime faceImgUploadTime) {
        this.faceImgUploadTime = faceImgUploadTime;
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

    public LocalDateTime getCardUploadTime() {
        return cardUploadTime;
    }

    public void setCardUploadTime(LocalDateTime cardUploadTime) {
        this.cardUploadTime = cardUploadTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public List<VisitIndexRecordDto> getVisitIndexRecordList() {
        return visitIndexRecordList;
    }

    public void setVisitIndexRecordList(List<VisitIndexRecordDto> visitIndexRecordList) {
        this.visitIndexRecordList = visitIndexRecordList;
    }
}
