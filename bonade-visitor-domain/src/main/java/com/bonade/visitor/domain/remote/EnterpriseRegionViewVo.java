package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;
import com.bonade.visitor.domain.enums.RelationType;

import java.io.Serializable;

/**
 * description 企业区域联系人
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2020/1/6.</p>
 */
@ApiModel(description = "企业区域联系人")
public class EnterpriseRegionViewVo implements  Serializable {

    private static final long serialVersionUID = 5891416483723814290L;

    /**
     * 用户ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "用户ID")
    private Long employeeId;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String username;

    /**
     * 联系人号码
     */
    @ApiModelProperty(value = "联系人号码")
    private String phone;

    /**
     * 关系类型
     */
    @ApiModelProperty(value = "关系类型")
    private RelationType relationType;

    /**
     * 关系ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "关系ID")
    private Long relationId;

    /**
     * 相关机构全程
     */
    @ApiModelProperty(value = "相关机构全程")
    private String fullOrganName;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getFullOrganName() {
        return fullOrganName;
    }

    public void setFullOrganName(String fullOrganName) {
        this.fullOrganName = fullOrganName;
    }
}
