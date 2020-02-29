package com.bonade.visitor.domain.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;

import io.swagger.annotations.ApiModelProperty;


public class EmployeeHomePageDto {
	
	@ApiModelProperty(value = "审批信息", name = "page")
	private IPage<VisitRecordDto> page;
	
	@ApiModelProperty(value = "日程清单待办事项", name = "waitProces")
	private Integer waitProces;

	public IPage<VisitRecordDto> getPage() {
		return page;
	}

	public void setPage(IPage<VisitRecordDto> page) {
		this.page = page;
	}

	public Integer getWaitProces() {
		return waitProces;
	}

	public void setWaitProces(Integer waitProces) {
		this.waitProces = waitProces;
	}

}
