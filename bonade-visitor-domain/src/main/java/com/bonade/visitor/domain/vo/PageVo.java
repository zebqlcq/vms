package com.bonade.visitor.domain.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName:  PageVo   
 * @author: lcq 
 * @date:   2019年12月11日 下午2:59:48   
 * @version 1.0
 */
public abstract class PageVo {

	@NotNull(message = "pageSize不能为空")
	@Max(value = 500, message = "最大值不能大于500")
	@ApiModelProperty(name = "pageSize", value = "每页多少数据", required = true, dataType = "Integer")
	private Integer pageSize;

	@NotNull(message = "currentPage不能为空")
	@Min(value = 1, message = "最小值不能小于1")
	@ApiModelProperty(name = "currentPage", value = "当前页,从1开始", required = true, dataType = "Integer")
	private Integer currentPage;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
}
