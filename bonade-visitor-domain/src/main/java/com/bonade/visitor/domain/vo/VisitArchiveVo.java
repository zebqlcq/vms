package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.VisitorAttribute;
import com.bonade.visitor.domain.enums.VisitorStatus;
import com.bonade.visitor.domain.enums.VisitorType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ApiModel(value = "VisitArchiveVo", description = "访客档案对象")
public class VisitArchiveVo {

    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    private Long id;

    @NotNull(message = "名称不能为空")
    @ApiModelProperty(value = "名称", name = "name", example = "1", required = true)
    private String name;

    @NotNull(message = "访客属性不能为空")
    @ApiModelProperty(value = "访客属性", name = "visitorAttribute", example = "1", required = true)
    private VisitorAttribute visitorAttribute;

    @ApiModelProperty(value = "当属企业", name = "companyName", example = "1")
    private String companyName;

    @ApiModelProperty(value = "当属岗位", name = "userStation", example = "1")
    private String userStation;

    @NotNull(message = "手机号码不能为空")
    @ApiModelProperty(value = "手机号码", name = "tel", example = "1", required = true)
    private String tel;

    @ApiModelProperty(value = "身份证号码", name = "cartNo", example = "1")
    private String cartNo;

    @ApiModelProperty(value = "车牌号", name = "carNo", example = "1")
    private String carNo;

    @ApiModelProperty(value = "证件信息图像（正面）", name = "cartNoPositive", example = "1")
    private String cardNoPositive;

    @ApiModelProperty(value = "证件信息图像（反面）", name = "cartNoNegative", example = "1")
    private String cardNoNegative;

    @ApiModelProperty(value = "人脸图像", name = "faceImg", example = "1")
    private String faceImg;

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "身份证上传时间", name = "cardUploadTime", example = "2019-12-09 17:11:11")
    private LocalDateTime cardUploadTime;

    @ApiModelProperty(value = "人脸图像上传时间", name = "faceImgUploadTime", example = "2019-12-09 17:11:11")
    private LocalDateTime faceImgUploadTime;

//    @NotNull(message = "最新访客记录不能为空")
//    @ApiModelProperty(value = "最新访客记录", name = "visitArchiveRecord", required = true)
//    private VisitArchiveRecordVo visitArchiveRecord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
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

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public LocalDateTime getCardUploadTime() {
        return cardUploadTime;
    }

    public void setCardUploadTime(LocalDateTime cardUploadTime) {
        this.cardUploadTime = cardUploadTime;
    }

    public LocalDateTime getFaceImgUploadTime() {
        return faceImgUploadTime;
    }

    public void setFaceImgUploadTime(LocalDateTime faceImgUploadTime) {
        this.faceImgUploadTime = faceImgUploadTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public VisitArchiveRecordVo getVisitArchiveRecord() {
        return visitArchiveRecord;
    }

    public void setVisitArchiveRecord(VisitArchiveRecordVo visitArchiveRecord) {
        this.visitArchiveRecord = visitArchiveRecord;
    }*/
}
