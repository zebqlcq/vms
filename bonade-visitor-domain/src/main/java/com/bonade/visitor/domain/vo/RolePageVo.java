package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "RolePageVo", description = "角色分页查询对象")
public class RolePageVo {

    @NotNull(message = "企业id不能为空")
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "1" ,required = true)
    private Long enterpriseId;

    @NotNull(message = "来源不能为空")
    @ApiModelProperty(value = "来源（1、角色权限管理，2、访问信息配置，3、客户权限配置）", name = "source", example = "1" ,required = true)
    private Integer source;

    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }
}
