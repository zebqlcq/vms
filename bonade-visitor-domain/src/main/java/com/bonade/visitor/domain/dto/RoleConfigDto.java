package com.bonade.visitor.domain.dto;

import org.spin.core.gson.annotation.PreventOverflow;

import io.swagger.annotations.ApiModelProperty;

public class RoleConfigDto {

    @ApiModelProperty(value = "用户id", name = "userId", example = "1")
    @PreventOverflow
    private Long userId;

    @ApiModelProperty(value = "指定区域id", name = "areaIds", example = "1")
    private String areaIds;

    @ApiModelProperty(value = "开放时间起", name = "openTimeStart", example = "08:30:00")
    private String openTimeStart;

    @ApiModelProperty(value = "开放时间止", name = "openTimeEnd", example = "05:30:00")
    private String openTimeEnd;
    
    @ApiModelProperty(value = "数字码", name = "visitorCode", example = "")
    private String numericCode;
    
    @ApiModelProperty(value = "二维码", name = "QrCode", example = "")
    private String qrCode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(String areaIds) {
		this.areaIds = areaIds;
	}

	public String getOpenTimeStart() {
		return openTimeStart;
	}

	public void setOpenTimeStart(String openTimeStart) {
		this.openTimeStart = openTimeStart;
	}

	public String getOpenTimeEnd() {
		return openTimeEnd;
	}

	public void setOpenTimeEnd(String openTimeEnd) {
		this.openTimeEnd = openTimeEnd;
	}

	public String getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
    
}
