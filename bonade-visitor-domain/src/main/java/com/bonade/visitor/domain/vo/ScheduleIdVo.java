package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "ScheduleIdVo", description = "入参vo")
public class ScheduleIdVo {

	@NotNull(message = "scheduleId不能为空")
	@ApiModelProperty(value = "scheduleId", name = "scheduleId", example = "", required = true)
	private Long scheduleId;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	
}
