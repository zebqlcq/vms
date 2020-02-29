package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.RelationType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * description 员工机构信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/9/3.</p>
 */
@ApiModel(description = "员工相关机构信息")
public class EmployeeOrganViewVo implements Serializable {

    private static final long serialVersionUID = 6663549796750645210L;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 企业员工名称
     */
    @ApiModelProperty(value = "企业员工名称")
    private String userName;

    /**
     * 相关机构名称
     */
    @ApiModelProperty(value = "相关机构名称")
    private String organName;

    /**
     * 关系类型
     */
    @ApiModelProperty(value = "关系类型", allowableValues = "1,2,3")
    private RelationType relationType;

    /**
     * 关系ID
     */
    @ApiModelProperty(value = "关系ID")
    private Long relationId;
    /**
     * 员工ID
     */
    @ApiModelProperty(value = "员工ID")
    private Long employeeId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
