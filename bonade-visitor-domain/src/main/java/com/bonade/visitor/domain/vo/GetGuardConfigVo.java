package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "GetGuardConfigVo", description = "入参vo")
public class GetGuardConfigVo {

	@NotNull(message = "企业id不能为空")
	@ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
	private Long enterpriseId;
	
	@NotNull(message = "userId不能为空")
	@ApiModelProperty(value = "userId", name = "name", example = "", required = true)
	private Long userId;
	
	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
