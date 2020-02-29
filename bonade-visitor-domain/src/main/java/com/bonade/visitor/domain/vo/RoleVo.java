package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;

@ApiModel(value = "RoleVo", description = "角色对象")
public class RoleVo {

    @ApiModelProperty(value = "角色ID", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1")
    @PreventOverflow
    private Long enterpriseId;

    @ApiModelProperty(value = "来源（1、角色权限管理，2、访问信息配置，3、客户权限配置）", name = "source", example = "1")
    private Integer source;

    @ApiModelProperty(value = "角色名称", name = "name", example = "1")
    private String name;

    @ApiModelProperty(value = "角色描述", name = "desc", example = "1")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
