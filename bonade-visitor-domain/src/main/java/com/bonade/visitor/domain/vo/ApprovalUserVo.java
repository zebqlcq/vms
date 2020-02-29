package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @ClassName:  ApprovalFlowUserVo   
 * @Description:审批人信息
 * @author: lcq 
 * @date:   2019年12月20日 下午1:55:10   
 * @version 1.0
 */
public class ApprovalUserVo {

    /**
     * 用户id
     */
    @PreventOverflow
    @ApiModelProperty(value = "用户id",name = "userId",example = "1", required = true)
    @NotNull(message="用户id不能为空")
    private Long userId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名",name = "realName",example = "张三五", required = true)
    @NotBlank(message="真实姓名不能为空")
    private String realName;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话",name = "userTel",example = "13000000000", required = true)
    @NotBlank(message="联系电话不能为空")
    private String userTel;

    /**
     * 企业id
     */
    @PreventOverflow
    @ApiModelProperty(value="企业id",name="organizationId",example="100223", required = true)
    @NotNull(message="企业id不能为空")
    private Long organizationId;

    /**
     * 类型 0审批人 1抄送人
     */
    @ApiModelProperty(value="类型 0审批人 1抄送人",name="type",example="0", required = true)
    @NotNull(message="类型不能为空")
    private Integer type;

    /**
     * 审批人/抄送人顺序（越小越靠前）
     */
    @ApiModelProperty(value="审批人/抄送人顺序（越小越靠前）",name="sort",example="0", required = true)
    @NotNull(message="审批人/抄送人顺序不能为空")
    private Integer sort;

    /**
     * 中台员工ID
     */
    @ApiModelProperty(value = "中台员工ID[不用传参]",name = "ztStaffId",example = "4bb09aa72d52423aaee3fe11228739ee")
    private String ztStaffId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getZtStaffId() {
        return ztStaffId;
    }

    public void setZtStaffId(String ztStaffId) {
        this.ztStaffId = ztStaffId;
    }

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
    
}
