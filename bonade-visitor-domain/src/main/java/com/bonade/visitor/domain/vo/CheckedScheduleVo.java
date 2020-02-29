package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CheckedScheduleVo", description = "vo")
public class CheckedScheduleVo {

	@NotNull(message = "scheduleId不能为空")
    @ApiModelProperty(value = "scheduleId", name = "scheduleId", example = "1", required = true)
    private Long scheduleId;
	
	@NotNull(message = "checked不能为空")
	@ApiModelProperty(value = "是否选中0未选中  1选中", name = "checked", example = "1", required = true)
	private Integer checked;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}
   
}
