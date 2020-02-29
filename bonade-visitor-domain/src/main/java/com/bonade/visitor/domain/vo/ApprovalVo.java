package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: ApprovalVo
 * @Description:审批
 * @author: lcq
 * @date: 2019年12月21日 下午2:18:57
 * @version 1.0
 */
@ApiModel(value = "ApprovalVo", description = "访问入参vo")
public class ApprovalVo {

	@NotNull(message = "访客记录id不能为空")
	@ApiModelProperty(value = "访客记录id", name = "visitRecordId", example = "123", required = true)
	private Long visitRecordId;
	
	@NotNull(message = "审批id不能为空")
	@ApiModelProperty(value = "审批id(内部)", name = "approvalId", example = "123", required = true)
	private Long approvalId;
	
	@NotNull(message = "审批人用户id不能为空")
	@ApiModelProperty(value = "用户id", name = "userId", example = "123", required = true)
	private Long userId;
	
	@NotNull(message = "审批人企业id不能为空")
	@ApiModelProperty(value = "企业id", name = "organizationId", example = "123", required = true)
	private Long organizationId;

	@NotNull(message = "审批状态不能为空")
	@ApiModelProperty(value = "审批状态[1同意   2拒绝]", name = "operationType", example = "1", required = true)
	private Integer operationType;
	
	@ApiModelProperty(value = "审批意见", name = "approvalOpinion", example = "1")
	private String approvalOpinion;

	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public String getApprovalOpinion() {
		return approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	
}
