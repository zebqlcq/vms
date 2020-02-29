package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.PermissionRange;
import com.bonade.visitor.domain.enums.PermissionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@ApiModel(value = "AccessApprovalPermissionVo", description = "门禁和审批权限对象")
public class AccessApprovalPermissionVo {

    @ApiModelProperty(value = "属性（1、一般访客，2、贵宾访客，3、黑名单）", name = "permissionType", example = "1")
    private Integer attribute;

    @ApiModelProperty(value = "权限类型", name = "permissionType", example = "1")
    private PermissionType permissionType;

    @ApiModelProperty(value = "权限范围", name = "permissionRange", example = "1")
    private PermissionRange permissionRange;

    @ApiModelProperty(value = "全部（权限范围）", name = "whole", example = "1")
    private boolean whole;

    @ApiModelProperty(value = "全部值", name = "wholeValue", example = "1")
    private Integer wholeValue;

    @ApiModelProperty(value = "指定范围id", name = "rangeIds")
    private Long[] rangeIds;

    @ApiModelProperty(value = "指定范围名称", name = "rangeName", example = "1")
    private String rangeName;

    @ApiModelProperty(value = "开放时间起", name = "openTimeStart", example = "08:30:00")
    private LocalTime openTimeStart;

    @ApiModelProperty(value = "开放时间止", name = "openTimeEnd", example = "05:30:00")
    private LocalTime openTimeEnd;

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    public PermissionRange getPermissionRange() {
        return permissionRange;
    }

    public void setPermissionRange(PermissionRange permissionRange) {
        this.permissionRange = permissionRange;
    }

    public boolean isWhole() {
        return whole;
    }

    public void setWhole(boolean whole) {
        this.whole = whole;
    }

    public Long[] getRangeIds() {
        return rangeIds;
    }

    public void setRangeIds(Long[] rangeIds) {
        this.rangeIds = rangeIds;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public LocalTime getOpenTimeStart() {
        return openTimeStart;
    }

    public void setOpenTimeStart(LocalTime openTimeStart) {
        this.openTimeStart = openTimeStart;
    }

    public LocalTime getOpenTimeEnd() {
        return openTimeEnd;
    }

    public void setOpenTimeEnd(LocalTime openTimeEnd) {
        this.openTimeEnd = openTimeEnd;
    }

    public Integer getWholeValue() {
        return wholeValue;
    }

    public void setWholeValue(Integer wholeValue) {
        this.wholeValue = wholeValue;
    }
}
