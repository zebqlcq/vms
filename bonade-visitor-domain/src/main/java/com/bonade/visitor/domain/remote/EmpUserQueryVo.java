package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * description 员工查询信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/7.</p>
 */
@ApiModel(description = "员工查询信息(无机构信息）")
public class EmpUserQueryVo {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID", hidden = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "手机号码")
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
