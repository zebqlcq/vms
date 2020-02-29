package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;

/**
 * 
 * @ClassName:  ApprovalOperationVo   
 * @Description:uaac审批参数
 * @author: lcq 
 * @date:   2019年12月21日 下午2:26:56   
 * @version 1.0
 */
public class ApprovalOperationVo {

    /**
     * 用户id
     */
    @PreventOverflow
    @ApiModelProperty(value = "用户id",name = "userId",dataType = "Long",example = "1", required = true)
    @NotNull(message="用户id不能为空")
    private Long userId;

    /**
     * 企业id
     */
    @PreventOverflow
    @ApiModelProperty(value = "企业id",name = "organizationId",dataType = "Long",example = "1", required = true)
    @NotNull(message="企业id不能为空")
    private Long organizationId;

    /**
     * 审批id
     */
    @PreventOverflow
    @ApiModelProperty(value = "uaac审批id",name = "uaacApprovalId",dataType = "Long",example = "1", required = true)
    @NotNull(message="审批id不能为空")
    private Long uaacApprovalId;

    /**
     * 审批意见
     */
    @ApiModelProperty(value = "审批意见",name = "approvalOpinion",dataType = "String",example = "1")
    private String approvalOpinion;

    /**
     * 审批操作[审批同意 --> 1;审批拒绝 --> 2]
     */
    @ApiModelProperty(value = "审批操作[审批同意 --> 1;审批拒绝 --> 2]",name = "operationType",dataType = "int",example = "1", required = true)
    @NotNull(message="审批操作不能为空")
    private Integer operationType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getUaacApprovalId() {
		return uaacApprovalId;
	}

	public void setUaacApprovalId(Long uaacApprovalId) {
		this.uaacApprovalId = uaacApprovalId;
	}

	public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }
}
