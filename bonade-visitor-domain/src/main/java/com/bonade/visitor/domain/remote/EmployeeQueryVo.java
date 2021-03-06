package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * description 员工查询信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/7.</p>
 */
@ApiModel(description = "员工查询信息")
public class EmployeeQueryVo {

    /**
     * 员工名称
     */
    @ApiModelProperty(value = "员工名称")
    private String name;

    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID", hidden = true)
    private Long enterpriseId;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phone;

    /**
     * 关系ID
     */
    @NotNull(message = "关系ID不能为空")
    @ApiModelProperty(value = "关系ID")
    private Long relationId;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

}
