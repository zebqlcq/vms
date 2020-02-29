package com.bonade.visitor.domain.remote;

import com.bonade.visitor.domain.enums.RelationType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * description 员工查询信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/7.</p>
 */
@ApiModel(description = "员工查询信息")
public class EmpQueryVo {

    /**
     * 员工ID
     */
    @ApiModelProperty(value = "员工ID", hidden = true)
    private Long employeeId;
    /**
     * 员工名称
     */
    @ApiModelProperty(value = "员工名称")
    private String username;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

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
    @ApiModelProperty(value = "关系ID", required = true)
    private Long relationId;

    /**
     * 关系类型 默认部门
     */
    @ApiModelProperty(value = "关系类型（1 部门，2 岗位，3 自定义组织）", allowableValues = "1,2,3")
    private RelationType relationType;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }
}
