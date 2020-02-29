package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName:  VisitRecordForGuardDto   
 * @Description:
 * @author: lcq 
 * @date:   2019年12月11日 下午2:44:09   
 * @version 1.0
 */
@ApiModel(value = "VisitRecordForGuardVo", description = "vo")
public class VisitRecordForGuardVo extends PageVo{

	@NotNull(message ="安防人员用户id不能为空！")
    @ApiModelProperty(value = "安防人员用户id", name = "guardUserId", dataType = "Long" ,required = true)
    private Long guardUserId;
	
	@NotNull(message ="企业id不能为空！")
	@ApiModelProperty(value = "企业id", name = "enterpriseId", dataType = "Long" ,required = true)
	private Long enterpriseId;
	
	@ApiModelProperty(value = "访客、被访人、企业 名称", name = "name", dataType = "String")
	private String name;
	
	@ApiModelProperty(value = "通行状态： 1允许通行 2拒绝通行", name = "passStatus", dataType = "Integer")
	private Integer passStatus;
	
	@ApiModelProperty(value = "访客类型：1普通访客  2贵宾访客 3黑名单访客 ", name = "visitorAttribute", dataType = "Integer")
	private Integer visitorAttribute;
	
	@ApiModelProperty(value = "来访事件起，格式：yyyy-MM-dd", name = "startTime", dataType = "String")
	private String startTime;
	
	@ApiModelProperty(value = "来访事件止，格式：yyyy-MM-dd", name = "endTime", dataType = "String")
	private String endTime;

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getGuardUserId() {
		return guardUserId;
	}

	public void setGuardUserId(Long guardUserId) {
		this.guardUserId = guardUserId;
	}

	public Integer getPassStatus() {
		return passStatus;
	}

	public void setPassStatus(Integer passStatus) {
		this.passStatus = passStatus;
	}

	public Integer getVisitorAttribute() {
		return visitorAttribute;
	}

	public void setVisitorAttribute(Integer visitorAttribute) {
		this.visitorAttribute = visitorAttribute;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}