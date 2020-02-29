package com.bonade.visitor.domain.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName:    
 * @Description:员工主页
 * @author: lcq 
 * @date:   2019年11月14日 下午5:16:46   
 * @version 1.0
 */
public class HomeVo implements Serializable {
	
	private static final long serialVersionUID = -7871496224931968217L;

	@NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id", name = "userId", example = "123", required = true)
	private Long userId;
	
//    @NotBlank(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "123")
	private String enterpriseId;
    
	@NotNull(message = "pageSize不能为空")
	@Max(value=500,message="最大值不能大于500")
    @ApiModelProperty(name = "pageSize", value = "每页多少数据", required = true, dataType = "Integer")
    private Integer pageSize;

	@NotNull(message = "currentPage不能为空")
    @Min(value=1,message="最小值不能小于1")
    @ApiModelProperty(name = "currentPage", value = "当前页,从1开始", required = true, dataType = "Integer")
    private Integer currentPage;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

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
