package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * 
 * @ClassName:  SynchronizationInfoVo   
 * @Description:mq消息参数
 * @author: lcq 
 * @date:   2020年1月14日 下午3:51:10   
 * @version 1.0
 */
public class SynchronizationInfoVo {

    /**
     * 审批ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "审批ID", name = "approvalId", example = "123")
    private Long approvalId;

    /**
     * 用户ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "用户ID", name = "userId", example = "1234")
    private Long userId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "remarks", example = "备注")
    private String remarks;

    /**
     * 状态：审批状态 0待审批 1通过 2拒绝 3已撤销
     */
    @ApiModelProperty(value = "状态：审批状态 0待审批 1通过 2拒绝 3已撤销", name = "state", example = "1")
    private Integer state;

    /**
     * 类型：0审批 1阅览
     */
    @ApiModelProperty(value = "类型：0审批 1阅览", name = "type", example = "0")
    private String type;

    /**
     * 审批结果：true 通过 false 拒绝
     */
    @ApiModelProperty(value = "审批结果：true 通过 false 拒绝", name = "isPass", example = "true")
    private Boolean isPass;

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPass() {
        return isPass;
    }

    public void setPass(Boolean pass) {
        isPass = pass;
    }
}
