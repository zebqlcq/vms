package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.VisitStatus;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * @author zoushaopeng
 * @title: VerifyVisitorStatusVo
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/26 10:03
 */
public class VerifyVisitorStatusVo {

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    /**
     * 来访状态
     */
    @ApiModelProperty(value = "来访状态", name = "visitStatus", example = "", required = true)
    private Integer visitStatus;

    /**
     * 操作(核实)人ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "operationUserId", name = "operationUserId", example = "", required = true)
    private Long operationUserId;

    /**
     * 操作(核实)备注
     */
    @ApiModelProperty(value = "操作(核实)备注", name = "operationRemark", example = "")
    private String operationRemark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(Integer visitStatus) {
        this.visitStatus = visitStatus;
    }

    public Long getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Long operationUserId) {
        this.operationUserId = operationUserId;
    }

    public String getOperationRemark() {
        return operationRemark;
    }

    public void setOperationRemark(String operationRemark) {
        this.operationRemark = operationRemark;
    }
}
