package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.PermissionRange;
import com.bonade.visitor.domain.enums.PermissionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalTime;

@ApiModel(value = "Access4VisitorOutVo", description = "进出口门禁权限配置")
public class Access4VisitorOutVo {

    @ApiModelProperty(value = "权限范围", name = "permissionRange", example = "1")
    private PermissionRange permissionRange;

    @ApiModelProperty(value = "全部（权限范围）", name = "total", example = "1")
    private boolean whole;

    @ApiModelProperty(value = "指定范围ids(指定区域id，以逗号分隔)", name = "rangeId", example = "1")
    private String rangeIds;

    @ApiModelProperty(value = "开放时间起", name = "openTimeStart", example = "08:30:00")
    private LocalTime openTimeStart;

    @ApiModelProperty(value = "开放时间止", name = "openTimeEnd", example = "05:30:00")
    private LocalTime openTimeEnd;

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

    public String getRangeIds() {
        return rangeIds;
    }

    public void setRangeIds(String rangeIds) {
        this.rangeIds = rangeIds;
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
}
