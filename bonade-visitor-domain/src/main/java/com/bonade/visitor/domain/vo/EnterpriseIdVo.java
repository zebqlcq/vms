package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "EnterpriseIdVo", description = "访问入参vo")
public class EnterpriseIdVo {

	@NotNull(message = "企业id不能为空")
	@ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
	private Long enterpriseId;

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
}
