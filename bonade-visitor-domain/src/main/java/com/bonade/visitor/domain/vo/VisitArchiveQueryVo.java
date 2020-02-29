package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value = "VisitArchiveQueryVo", description = "访客档案查询对象")
public class VisitArchiveQueryVo {

    @NotNull(message = "企业id不能为空")
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "1" ,required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "访客姓名", name = "name", example = "1")
    private String name;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
