package com.bonade.visitor.domain.vo;

import org.spin.core.gson.annotation.PreventOverflow;

import com.bonade.visitor.domain.enums.RelationType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * description
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2020/1/19.</p>
 */
@ApiModel(description = "员工机构信息")
public class EmpRelationViewVo {

    /**
     * 员工ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "员工ID")
    private Long employeeId;

    /**
     * 关系类型
     */
    @ApiModelProperty(value = "关系类型（1 部门，2 岗位，3 自定义组织）", allowableValues = "1,2,3")
    private RelationType relationType;

    /**
     * 关系ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "关系ID")
    private Long relationId;

    /**
     * 相关机构名称
     */
    @ApiModelProperty(value = "相关机构名称")
    private String organName;

    /**
     * 相关机构全称
     */
    @ApiModelProperty(value = "相关机构全称")
    private String fullOrganName;

    /**
     * 头衔
     */
    @ApiModelProperty(value = "头衔")
    private String title;

    /**
     * 默认组织
     */
    @ApiModelProperty(value = "默认组织")
    private Boolean active;

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

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getFullOrganName() {
        return fullOrganName;
    }

    public void setFullOrganName(String fullOrganName) {
        this.fullOrganName = fullOrganName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

	@Override
	public String toString() {
		return "EmpRelationViewVo [employeeId=" + employeeId + ", relationType=" + relationType + ", relationId="
				+ relationId + ", organName=" + organName + ", fullOrganName=" + fullOrganName + ", title=" + title
				+ ", active=" + active + "]";
	}
    
}
