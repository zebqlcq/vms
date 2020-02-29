package com.bonade.visitor.domain.vo;

import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "模板短信Vo")
public class SmsTemplateMessageVo {

    /**
     * 需要发送的手机号
     */
    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "1\\d{10}")
    @ApiModelProperty(value = "手机号码", example = "18226266767", required = true)
    private String phone;

    /**
     * 模板CODE
     */
    @NotBlank(message = "模板代码不能为空")
    @ApiModelProperty(value = "模板CODE", example = "SMS_161592311", required = true)
    private String templateCode;

    /**
     * 是否需要状态报告
     */
    @ApiModelProperty(value = "是否需要状态报告, 默认不需要", example = "false")
    private Boolean report = false;

    /**
     * 发送时间
     */
    @ApiModelProperty(value = "发送时间, 默认为立即发送，最长可预约7天以内", example = "2019-11-29 12:00:00")
    private LocalDateTime sendTime = LocalDateTime.now();

    /**
     * 模板参数
     */
    @ApiModelProperty(value = "模板参数", example = "{\"code\":\"1111\",\"number\":\"123\"}")
    private Map<String, Object> param;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public Boolean getReport() {
        return report;
    }

    public void setReport(Boolean report) {
        this.report = report;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }
}
