package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AccessTrafficOutVo", description = "基础访问能力配置对象")
public class AccessTrafficOutVo {

    @ApiModelProperty(value = "曾经来访登记", name = "once", example = "true")
    private boolean once;

    @ApiModelProperty(value = "来访登出", name = "logout", example = "true")
    private boolean logout;

    @ApiModelProperty(value = "刷脸签到", name = "face", example = "true")
    private boolean face;

    @ApiModelProperty(value = "二维码签到", name = "qrCode", example = "true")
    private boolean qrCode;

    @ApiModelProperty(value = "数字码签到", name = "numericCode", example = "true")
    private boolean numericCode;

    @ApiModelProperty(value = "通行验证码生效期(0:即时)", name = "onTime", example = "1")
    private Integer onTime;

    @ApiModelProperty(value = "通行验证码失效期(0:即时)", name = "offTime", example = "1")
    private Integer offTime;

    public boolean isOnce() {
        return once;
    }

    public void setOnce(boolean once) {
        this.once = once;
    }

    public boolean isLogout() {
        return logout;
    }

    public void setLogout(boolean logout) {
        this.logout = logout;
    }

    public boolean isFace() {
        return face;
    }

    public void setFace(boolean face) {
        this.face = face;
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

    public Integer getOnTime() {
        return onTime;
    }

    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    public Integer getOffTime() {
        return offTime;
    }

    public void setOffTime(Integer offTime) {
        this.offTime = offTime;
    }
}
