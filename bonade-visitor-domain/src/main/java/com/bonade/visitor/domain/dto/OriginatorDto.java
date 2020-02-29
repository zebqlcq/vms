package com.bonade.visitor.domain.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OriginatorVo", description = "入参vo")
public class OriginatorDto {

	@NotNull(message = "scheduleId不能为空")
	@ApiModelProperty(value = "scheduleId", name = "scheduleId", example = "", required = true)
	private Long scheduleId;
}

