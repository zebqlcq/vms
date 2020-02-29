package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScheduleListVo", description = "查询日程清单")
public class ScheduleListVo {

	@NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id", name = "userId", example = "1", required = true)
    private Long userId;
	
    @ApiModelProperty(value = "提醒时间", name = "reminderDate", example = "2020-01-01")
    private String reminderDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}
	
}
