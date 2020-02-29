package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;

@ApiModel(value = "InviteTempQueryVo", description = "邀约模板查询对象")
public class InviteTempQueryVo {

    @NotNull(message = "邀约模板ID不能为空")
    @ApiModelProperty(value = "邀约模板ID", name = "id", example = "1", required = true)
    @PreventOverflow
    private Long id;

    @ApiModelProperty(value = "来访者名字", name = "visitor")
    private String visitor;

    @ApiModelProperty(value = "公司名称", name = "company")
    private String company;

    @ApiModelProperty(value = "预约员工", name = "empid")
    private String empid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }
}
