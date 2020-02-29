package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "GetEmpConfigVo", description = "入参vo")
public class GetEmpConfigVo {

	@NotNull(message = "userId不能为空")
	@ApiModelProperty(value = "userId", name = "name", example = "", required = true)
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
