package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.GuardType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeviceTypeStatisticVo", description = "设备类型统计对象")
public class DeviceTypeStatisticVo {

    public DeviceTypeStatisticVo() {
    }

    public DeviceTypeStatisticVo(GuardType guardType, String guardTypeName, Integer device) {
        this.guardType = guardType;
        this.guardTypeName = guardTypeName;
        this.device = device;
    }

    @ApiModelProperty(value = "设备类型", name = "guardType", example = "1")
    private GuardType guardType;

    @ApiModelProperty(value = "设备类型名称", name = "guardTypeName", example = "1")
    private String guardTypeName;

    @ApiModelProperty(value = "设备数", name = "runingDevice", example = "1")
    private Integer device;

    public GuardType getGuardType() {
        return guardType;
    }

    public void setGuardType(GuardType guardType) {
        this.guardType = guardType;
    }

    public String getGuardTypeName() {
        return guardTypeName;
    }

    public void setGuardTypeName(String guardTypeName) {
        this.guardTypeName = guardTypeName;
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }
}
