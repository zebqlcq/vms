package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * @author zoushaopeng
 * @title: ConfirmInternalAlarmVo
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/19 9:10
 */
public class ConfirmInternalAlarmVo {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "访客ID", name = "visitorId", example = "")
    private Long visitorId;

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    /**
     * 拜访企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "拜访企业ID", name = "enterpriseId", example = "")
    private Long enterpriseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

}
