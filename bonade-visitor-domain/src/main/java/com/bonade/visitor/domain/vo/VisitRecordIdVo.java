package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "VisitRecordIdVo", description = "入参vo")
public class VisitRecordIdVo {

	@NotNull(message = "visitRecordId不能为空")
	@ApiModelProperty(value = "visitRecordId", name = "visitRecordId", example = "", required = true)
	private Long visitRecordId;

	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

}
