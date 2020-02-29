package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "站内信Vo")
public class MailTemplateMessageVo {

    
    @NotNull(message = "接收人ID不能为空")
    @ApiModelProperty(value = "接收人ID", example = "18226266767", required = true)
    private Long receiverId;

    @NotNull(message = "站内信内容不能为空")
    @ApiModelProperty(value = "站内信内容", example = "123123123", required = true)
    private String content;
}
