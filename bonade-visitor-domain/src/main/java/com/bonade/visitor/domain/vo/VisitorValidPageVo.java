package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zoushaopeng
 * @title: VisitorValidPageVo
 * @projectName bonade-vms
 * @description:
 * @date 2020/1/2 9:14
 */
public class VisitorValidPageVo {

    /**
     * 当前页:默认1
     */
    @PreventOverflow
    @ApiModelProperty(value = "当前页", name = "current", example = "1", required = true)
    @NotNull(message = "页面值不能为空")
    @Min(value = 1, message = "最小值不能小于1")
    private Long current;

    /**
     * 页面大小
     */
    @PreventOverflow
    @ApiModelProperty(value = "页面大小", name = "size", example = "10", required = true)
    @NotNull(message = "页面大小值不能为空")
    @Min(value = 1, message = "最小值不能小于1")
    private Long size;

    @PreventOverflow
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @NotNull(message = "企业ID为空")
    private Long enterpriseId;

    /**
     * 访客属性:1普通访客 2贵宾访客 3黑名单访客
     */
    @ApiModelProperty(value = "访客属性:1普通访客 2贵宾访客 3黑名单访客", name = "visitorAttribute", example = "1")
    private Integer visitorAttribute;

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(Integer visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }
}
