package com.bonade.visitor.domain.vo;

import org.spin.core.gson.annotation.PreventOverflow;

import com.bonade.visitor.domain.enums.VisitRegisterTemplateType;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitRegisterTemplateVo", description = "来访登记模板对象")
public class VisitRegisterTemplateVo {

    @ApiModelProperty(value = "来访登记模板ID", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @NotNull(message = "来访登记模板类型不能为空")
    @ApiModelProperty(value = "来访登记模板类型", name = "templateType", example = "1", required = true)
    private VisitRegisterTemplateType templateType;

    @ApiModelProperty(value = "人脸图像上传", name = "faceImg", example = "人脸图像上传")
    private String faceImg = "人脸图像上传";

    @ApiModelProperty(value = "人脸图像开关(开启人脸图像上传能力)", name = "faceImgDisjunctor", example = "true")
    private boolean faceImgDisjunctor;

    @ApiModelProperty(value = "人脸图像上传选项（1:可选，2:必选）", name = "faceImgUpload", example = "1")
    private Integer faceImgUpload;

    @ApiModelProperty(value = "身份证图像上传", name = "idcardImg", example = "身份证图像上传")
    private String idcardImg = "身份证图像上传";

    @ApiModelProperty(value = "身份证图像开关(开启身份证图像上传能力)", name = "idcardImgDisjunctor", example = "true")
    private boolean idcardImgDisjunctor;

    @ApiModelProperty(value = "身份证图像上传选项（1:可选，2:必选）", name = "idcardImgUpload", example = "1")
    private Integer idcardImgUpload;

    @ApiModelProperty(value = "企业名片图像上传", name = "businessCard", example = "企业名片图像上传")
    private String businessCard = "企业名片图像上传";

    @ApiModelProperty(value = "企业名片图像开关(开启企业名片图像上传能力)", name = "businessCardImgDisjunctor", example = "true")
    private boolean businessCardImgDisjunctor;

    @ApiModelProperty(value = "企业名片图像上传选项（1:可选，2:必选）", name = "businessCardImgUpload", example = "1")
    private Integer businessCardImgUpload;

    @ApiModelProperty(value = "您的姓名", name = "baseItemName", example = "您的姓名")
    private String baseItemName = "您的姓名";

    @ApiModelProperty(value = "您的手机号", name = "baseItemPhone", example = "您的手机号")
    private String baseItemPhone = "您的手机号";

    @ApiModelProperty(value = "您的企业/单位开关", name = "idcardImgDisjunctor", example = "true")
    private boolean onBusiness;

    @ApiModelProperty(value = "您的企业/单位（1:可选，2:必选）", name = "business", example = "1")
    private Integer business;

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

    public VisitRegisterTemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(VisitRegisterTemplateType templateType) {
        this.templateType = templateType;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public boolean isFaceImgDisjunctor() {
        return faceImgDisjunctor;
    }

    public void setFaceImgDisjunctor(boolean faceImgDisjunctor) {
        this.faceImgDisjunctor = faceImgDisjunctor;
    }

    public Integer getFaceImgUpload() {
        return faceImgUpload;
    }

    public void setFaceImgUpload(Integer faceImgUpload) {
        this.faceImgUpload = faceImgUpload;
    }

    public String getIdcardImg() {
        return idcardImg;
    }

    public void setIdcardImg(String idcardImg) {
        this.idcardImg = idcardImg;
    }

    public boolean isIdcardImgDisjunctor() {
        return idcardImgDisjunctor;
    }

    public void setIdcardImgDisjunctor(boolean idcardImgDisjunctor) {
        this.idcardImgDisjunctor = idcardImgDisjunctor;
    }

    public Integer getIdcardImgUpload() {
        return idcardImgUpload;
    }

    public void setIdcardImgUpload(Integer idcardImgUpload) {
        this.idcardImgUpload = idcardImgUpload;
    }

    public String getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(String businessCard) {
        this.businessCard = businessCard;
    }

    public boolean isBusinessCardImgDisjunctor() {
        return businessCardImgDisjunctor;
    }

    public void setBusinessCardImgDisjunctor(boolean businessCardImgDisjunctor) {
        this.businessCardImgDisjunctor = businessCardImgDisjunctor;
    }

    public Integer getBusinessCardImgUpload() {
        return businessCardImgUpload;
    }

    public void setBusinessCardImgUpload(Integer businessCardImgUpload) {
        this.businessCardImgUpload = businessCardImgUpload;
    }

    public String getBaseItemName() {
        return baseItemName;
    }

    public void setBaseItemName(String baseItemName) {
        this.baseItemName = baseItemName;
    }

    public String getBaseItemPhone() {
        return baseItemPhone;
    }

    public void setBaseItemPhone(String baseItemPhone) {
        this.baseItemPhone = baseItemPhone;
    }

    public boolean isOnBusiness() {
        return onBusiness;
    }

    public void setOnBusiness(boolean onBusiness) {
        this.onBusiness = onBusiness;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }
}
