package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScheduleVo", description = "日程清单")
public class ScheduleVo {

	@NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id", name = "userId", example = "1", required = true)
    private Long userId;
	
	@ApiModelProperty(value = "标题", name = "scheduleTitle", example = "1")
	private String scheduleTitle;
	
	@NotBlank(message = "日程内容不能为空")
	@ApiModelProperty(value = "日程内容", name = "scheduleContent", example = "1", required = true)
	private String scheduleContent;
	
	@NotBlank(message = "提醒时间不能为空")
    @ApiModelProperty(value = "提醒时间", name = "reminderDate", example = "2020-01-01 18:18", required = true)
    private String reminderDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public String getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}

}
