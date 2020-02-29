package com.bonade.visitor.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VerifyVisitorApprovalDetailDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/18 15:26
 */
public class VerifyVisitorApprovalDetailDto {

    /**
     * 用户ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "用户ID", name = "userId", example = "")
    private Long userId;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名", name = "userName", example = "")
    private String userName;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话", name = "userTel", example = "")
    private String userTel;

    /**
     * 用户所属企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "用户所属企业ID", name = "organizationId", example = "")
    private Long organizationId;

    /**
     * 审批人顺序（越小越靠前）
     */
    @ApiModelProperty(value = "审批人顺序（越小越靠前）", name = "sort", example = "")
    private Integer sort;

    /**
     * 类型 0审批人 1抄送人
     */
    @ApiModelProperty(value = "类型 0审批人 1抄送人", name = "type", example = "")
    private Integer type;

    /**
     * 审批状态 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） 3待阅览（抄送人）4 已阅览（抄送人）
     */
    @ApiModelProperty(value = "审批状态 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） 3待阅览（抄送人）4 已阅览（抄送人）", name = "state", example = "")
    private Integer state;

    /**
     * 审批意见
     */
    @ApiModelProperty(value = "审批意见", name = "approvalOpinion", example = "")
    private String approvalOpinion;

    /**
     * 审批时间
     */
    @ApiModelProperty(value = "审批时间", name = "approvalTime", example = "")
    private LocalDateTime approvalTime;

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

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public LocalDateTime getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(LocalDateTime approvalTime) {
        this.approvalTime = approvalTime;
    }
}
