package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.spin.common.db.entity.AbstractEntity;

/**
 * 准入规则
 * 企业id值为-1时，为系统默认规则
 */
@TableName("vms_access_rule")
public class AccessRule extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 准入规则名称
     */
    private String name = "默认规则";

    /**
     * 来源（1、系统运营台，2、企业控制台）
     */
    private Integer source;

    /**
     * 支持人脸识别核对
     */
    private boolean face;

    /**
     * 支持身份证识别核对
     */
    private boolean idCard;

    /**
     * 支持二维码识别核对
     */
    private boolean qrCode;

    /**
     * 支持数字码识别核对
     */
    private boolean numericCode;

    /**
     * 支持车牌号识别核对
     */
    private boolean carNumber;

    /**
     * 支持车辆准入通行卡核对
     */
    private boolean carPassCard;

    /**
     * 现场身份证核对
     */
    private boolean sceneIdCard;

    /**
     * 现场数字码核对
     */
    private boolean sceneNumericCode;

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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public boolean isFace() {
        return face;
    }

    public void setFace(boolean face) {
        this.face = face;
    }

    public boolean isIdCard() {
        return idCard;
    }

    public void setIdCard(boolean idCard) {
        this.idCard = idCard;
    }

    public boolean isQrCode() {
        return qrCode;
    }

    public void setQrCode(boolean qrCode) {
        this.qrCode = qrCode;
    }

    public boolean isNumericCode() {
        return numericCode;
    }

    public void setNumericCode(boolean numericCode) {
        this.numericCode = numericCode;
    }

    public boolean isCarNumber() {
        return carNumber;
    }

    public void setCarNumber(boolean carNumber) {
        this.carNumber = carNumber;
    }

    public boolean isCarPassCard() {
        return carPassCard;
    }

    public void setCarPassCard(boolean carPassCard) {
        this.carPassCard = carPassCard;
    }

    public boolean isSceneIdCard() {
        return sceneIdCard;
    }

    public void setSceneIdCard(boolean sceneIdCard) {
        this.sceneIdCard = sceneIdCard;
    }

    public boolean isSceneNumericCode() {
        return sceneNumericCode;
    }

    public void setSceneNumericCode(boolean sceneNumericCode) {
        this.sceneNumericCode = sceneNumericCode;
    }
}
