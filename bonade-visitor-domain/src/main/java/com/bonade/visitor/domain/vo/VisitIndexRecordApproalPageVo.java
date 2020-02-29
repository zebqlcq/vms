package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zoushaopeng
 * @title: VisitIndexRecordApproalPageVo
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/21 10:00
 */
public class VisitIndexRecordApproalPageVo {

    @PreventOverflow
    @NotNull(message = "用户ID不能为空")
    @ApiModelProperty(value = "用户ID", name = "userId", example = "123", required = true)
    private Long userId;

    @PreventOverflow
    @NotNull(message = "企业ID")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "123", required = true)
    private Long enterpriseId;

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
}
