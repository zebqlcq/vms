package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;

@ApiModel(value = "AccessRuleVo", description = "准入规则对象")
public class AccessRuleVo {

    @ApiModelProperty(value = "准入规则ID", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @ApiModelProperty(value = "准入规则名称", name = "name", example = "默认规则")
    private String name = "默认规则";

    @NotNull(message = "来源不能为空")
    @ApiModelProperty(value = "来源（1、系统运营台，2、企业控制台）", name = "source", example = "1", required = true)
    private Integer source;

    @ApiModelProperty(value = "支持人脸识别核对", name = "face", example = "true")
    private boolean face;

    @ApiModelProperty(value = "支持身份证识别核对", name = "idCard", example = "true")
    private boolean idCard;

    @ApiModelProperty(value = "支持二维码识别核对", name = "qrCode", example = "true")
    private boolean qrCode;

    @ApiModelProperty(value = "支持数字码识别核对", name = "numericCode", example = "true")
    private boolean numericCode;

    @ApiModelProperty(value = "支持车牌号识别核对", name = "carNumber", example = "true")
    private boolean carNumber;

    @ApiModelProperty(value = "支持车辆准入通行卡核对", name = "carPassCard", example = "true")
    private boolean carPassCard;

    @ApiModelProperty(value = "现场身份证核对", name = "sceneIdCard", example = "true")
    private boolean sceneIdCard;

    @ApiModelProperty(value = "现场数字码核对", name = "sceneNumericCode", example = "true")
    private boolean sceneNumericCode;

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
