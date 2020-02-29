package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitorListVo", description = "入参vo")
public class VisitorListVo{
	
	@NotNull(message = "企业id不能为空")
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "123", required = true)
	private Long enterpriseId;
	
	@ApiModelProperty(value = "姓名或手机号", name = "nameOrTel", example = "123")
	private String nameOrTel;

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getNameOrTel() {
		return nameOrTel;
	}

	public void setNameOrTel(String nameOrTel) {
		this.nameOrTel = nameOrTel;
	}
}
