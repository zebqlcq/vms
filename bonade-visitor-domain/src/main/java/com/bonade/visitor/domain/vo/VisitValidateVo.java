package com.bonade.visitor.domain.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


public class VisitValidateVo implements Serializable {
	
	private static final long serialVersionUID = -4172847471888397935L;

	@NotNull(message = "访客记录id不能为空")
    @ApiModelProperty(value = "访客记录id", name = "visitRecordId", example = "123", required = true)
	private Long visitRecordId;
	
	@NotNull(message = "通行状态不能为空")
	@ApiModelProperty(value = "通行状态：1允许通行，2拒绝通行", name = "passStatus", example = "", required = true)
	private Integer passStatus;
	
	@ApiModelProperty(value = "拒绝通行原因：1信息异常，2事务延迟，3危险关系人，4其他", name = "refusalReason", example = "")
	private Integer refusalReason;
	
	@NotNull(message = "安防人员用户id不能为空")
	@ApiModelProperty(value = "安防人员用户id", name = "guardUserId", example = "", required = true)
	private Long guardUserId;
	
	@NotBlank(message = "安防人员姓名不能为空")
	@ApiModelProperty(value = "安防人员姓名", name = "guardUserName", example = "", required = true)
	private String guardUserName;

	
	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

	public Integer getPassStatus() {
		return passStatus;
	}

	public void setPassStatus(Integer passStatus) {
		this.passStatus = passStatus;
	}

	public Integer getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(Integer refusalReason) {
		this.refusalReason = refusalReason;
	}

	public Long getGuardUserId() {
		return guardUserId;
	}

	public void setGuardUserId(Long guardUserId) {
		this.guardUserId = guardUserId;
	}

	public String getGuardUserName() {
		return guardUserName;
	}

	public void setGuardUserName(String guardUserName) {
		this.guardUserName = guardUserName;
	}
}
