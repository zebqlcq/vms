package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.VisitRegisterTemplateType;

/**
 * 来访登记模板
 * @author lqx
 */
@TableName("vms_visit_register_template")
public class VisitRegisterTemplate extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 来访登记模板类型
     */
    private VisitRegisterTemplateType templateType;

    //上传异常图像信息

    private String faceImg = "人脸图像上传";

    /**
     * 人脸图像开关(开启人脸图像上传能力)
     */
    private boolean faceImgDisjunctor;

    /**
     * 人脸图像上传选项（1:可选，2:必选）
     */
    private Integer faceImgUpload;

    private String idcardImg = "身份证图像上传";

    /**
     * 身份证图像开关(开启身份证图像上传能力)
     */
    private boolean idcardImgDisjunctor;

    /**
     * 身份证图像上传选项（1:可选，2:必选）
     */
    private Integer idcardImgUpload;

    private String businessCard = "企业名片图像上传";

    /**
     * 企业名片图像开关(开启企业名片图像上传能力)
     */
    private boolean businessCardImgDisjunctor;

    /**
     * 企业名片图像上传选项（1:可选，2:必选）
     */
    private Integer businessCardImgUpload;

    //需登记的基本信息

    /**
     * 默认项姓名
     */
    private String baseItemName = "您的姓名";

    /**
     * 默认项手机号
     */
    private String baseItemPhone = "您的手机号";

    /**
     * 您的企业/单位开关
     */
    private boolean onBusiness;

    /**
     * 您的企业/单位（1:可选，2:必选）
     */
    private Integer business;

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

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getIdcardImg() {
        return idcardImg;
    }

    public void setIdcardImg(String idcardImg) {
        this.idcardImg = idcardImg;
    }

    public boolean isOnBusiness() {
        return onBusiness;
    }

    public void setOnBusiness(boolean onBusiness) {
        this.onBusiness = onBusiness;
    }

    public String getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(String businessCard) {
        this.businessCard = businessCard;
    }
}
