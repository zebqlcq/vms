package com.bonade.visitor.domain.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.spin.core.gson.annotation.PreventOverflow;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: ApprovalSubmitVo
 * @Description:提交审批vo
 * @author: lcq
 * @date: 2019年12月20日 下午1:53:00
 * @version 1.0
 */
public class ApprovalSubmitVo {

	/**
	 * relationCode
	 */
	@ApiModelProperty(value = "模板编码", name = "relationCode", dataType = "String", example = "LX00001", required = true)
	@NotBlank(message = "模板编码不能为空")
	private String relationCode;

	/**
	 * 用户id
	 */
	@PreventOverflow
	@ApiModelProperty(value = "用户id", name = "userId", dataType = "Long", example = "1", required = true)
	@NotNull(message = "用户id不能为空")
	private Long userId;

	/**
	 * 企业id
	 */
	@PreventOverflow
	@ApiModelProperty(value = "企业id", name = "organizationId", dataType = "Long", example = "1", required = true)
	@NotNull(message = "企业id不能为空")
	private Long organizationId;

	/**
	 * 描述
	 */
	@ApiModelProperty(value = "描述", name = "approvalDescribe", dataType = "String", example = "描述", required = true)
	@Size(min = 2, max = 200, message = "描述输入长度不合法")
	private String approvalDescribe;

	/**
	 * 审核申请表单
	 */
	@ApiModelProperty(value = "审核申请表单", name = "applyFiles", dataType = "List<ApplyFiles>", example = "", required = true)
	private List<ApplyFiles> applyFiles;

	/**
	 * 审核人列表
	 */
	@ApiModelProperty(value = "审核人列表", name = "approvalFlowUserList", dataType = "List<ApprovalFlowUserV2Vo>", example = "", required = true)
	private List<ApprovalUserVo> approvalFlowUserList;

	/**
	 * 抄送人列表
	 */
	@ApiModelProperty(value = "抄送人列表", name = "approvalCopeUserList", dataType = "List<ApprovalFlowUserV2Vo>", example = "")
	private List<ApprovalUserVo> approvalCopeUserList;

	public String getRelationCode() {
		return relationCode;
	}

	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}

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

	public String getApprovalDescribe() {
		return approvalDescribe;
	}

	public void setApprovalDescribe(String approvalDescribe) {
		this.approvalDescribe = approvalDescribe;
	}

	public List<ApplyFiles> getApplyFiles() {
		return applyFiles;
	}

	public void setApplyFiles(List<ApplyFiles> applyFiles) {
		this.applyFiles = applyFiles;
	}

	public List<ApprovalUserVo> getApprovalFlowUserList() {
		return approvalFlowUserList;
	}

	public void setApprovalFlowUserList(List<ApprovalUserVo> approvalFlowUserList) {
		this.approvalFlowUserList = approvalFlowUserList;
	}

	public List<ApprovalUserVo> getApprovalCopeUserList() {
		return approvalCopeUserList;
	}

	public void setApprovalCopeUserList(List<ApprovalUserVo> approvalCopeUserList) {
		this.approvalCopeUserList = approvalCopeUserList;
	}
}
