package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "VisitorIdVo", description = "入参vo")
public class VisitorIdVo {

	@NotNull(message = "visitorId不能为空")
	@ApiModelProperty(value = "visitorId", name = "visitorId", example = "", required = true)
	private Long visitorId;

	public Long getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}

}
