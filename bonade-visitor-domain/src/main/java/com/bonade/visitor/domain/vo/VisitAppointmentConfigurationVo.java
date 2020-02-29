package com.bonade.visitor.domain.vo;

import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitAppointmentConfigurationVo", description = "访客预约配置对象")
public class VisitAppointmentConfigurationVo {

    @ApiModelProperty(value = "访客预约模板ID", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @ApiModelProperty(value = "曾经来访登记(访客已访问过即无需下次登记通行)", name = "registered", example = "true")
    private boolean registered;

    @ApiModelProperty(value = "来访登出(访客签出需核对离开区域)", name = "out", example = "true")
    private boolean out;

    @ApiModelProperty(value = "刷脸签到(支持用户刷脸通行)", name = "face", example = "true")
    private boolean face;

    @ApiModelProperty(value = "二维码签到(支持终端二维码通行)", name = "twoDimensionalCode", example = "true")
    private boolean twoDimensionalCode;

    @ApiModelProperty(value = "数字码签到(支持现场数字码验证通行)", name = "numericCode", example = "true")
    private boolean numericCode;

    @ApiModelProperty(value = "前台验证码有效期", name = "time", example = "1")
    private Integer time;

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

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public boolean isFace() {
        return face;
    }

    public void setFace(boolean face) {
        this.face = face;
    }

    public boolean isTwoDimensionalCode() {
        return twoDimensionalCode;
    }

    public void setTwoDimensionalCode(boolean twoDimensionalCode) {
        this.twoDimensionalCode = twoDimensionalCode;
    }

    public boolean isNumericCode() {
        return numericCode;
    }

    public void setNumericCode(boolean numericCode) {
        this.numericCode = numericCode;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
