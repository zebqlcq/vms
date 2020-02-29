package com.bonade.visitor.domain.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bonade.visitor.domain.enums.ContentType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "站内信表单信息")
public class MailFormVo {


    /**
     * 消息类型
     */
    @NotBlank(message = "类型不能为空")
    @ApiModelProperty(value = "站内信类型")
    private String type;

    /**
     * 消息标题
     */
//    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "站内信标题")
    private String title;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;
    /**
     * 图标
     */
    @ApiModelProperty(value = "摘要")
    private String summary;

    /**
     * 内容类型
     */
    @NotNull(message = "内容类型不能为空")
    @ApiModelProperty(value = "站内信内容类型")
    private ContentType contentType;
    
    /**
     * 消息内容
     */
    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(value = "站内信内容")
    private String content;

    /**
     * 所属模块
     */
    @ApiModelProperty(value = "可见范围")
    private String scope;
    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人信息")
    private List<MailReceiverFormVo> receivers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<MailReceiverFormVo> getReceivers() {
        return receivers;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setReceivers(List<MailReceiverFormVo> receivers) {
        this.receivers = receivers;
    }

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
    
}
