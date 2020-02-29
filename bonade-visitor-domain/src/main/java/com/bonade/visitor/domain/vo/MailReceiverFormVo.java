package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "站内信接收人信息")
public class MailReceiverFormVo{


    /**
     * 未读
     */
    @ApiModelProperty(value = "是否未读")
    private Boolean unRead = true;

    /**
     * 企业ID
     */
    @ApiModelProperty(value = "接收人企业ID")
    private Long enterpriseId;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "接收人企业名称")
    private String enterpriseName;

    /**
     * 接受人ID
     */
    @NotBlank(message = "接收人不存在")
    @ApiModelProperty(value = "手机号")
    private String receiver;

    /**
     * 接受人名称
     */
    @ApiModelProperty(value = "接收人名称")
    private String receiverName;

    public Boolean getUnRead() {
        return unRead;
    }

    public void setUnRead(Boolean unRead) {
        this.unRead = unRead;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
