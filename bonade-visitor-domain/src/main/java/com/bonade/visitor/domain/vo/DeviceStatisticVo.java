package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "DeviceStatisticVo", description = "设备数统计对象")
public class DeviceStatisticVo {

    @ApiModelProperty(value = "新增设备", name = "newDevice", example = "1")
    private Integer newDevice;

    @ApiModelProperty(value = "运行中的设备", name = "runingDevice", example = "1")
    private Integer runingDevice;

    @ApiModelProperty(value = "维护中的设备", name = "defendDevice", example = "1")
    private Integer defendDevice;

    @ApiModelProperty(value = "已报废的设备", name = "invalidDevice", example = "1")
    private Integer invalidDevice;

    @ApiModelProperty(value = "区域", name = "areaName", example = "1")
    private String areaName;

    @ApiModelProperty(value = "区域设备数", name = "areaDevice", example = "1")
    private Integer areaDevice;

    @ApiModelProperty(value = "设备类型详情", name = "deviceTypeList")
    private List<DeviceTypeStatisticVo> deviceTypeList;

    public Integer getNewDevice() {
        return newDevice;
    }

    public void setNewDevice(Integer newDevice) {
        this.newDevice = newDevice;
    }

    public Integer getRuningDevice() {
        return runingDevice;
    }

    public void setRuningDevice(Integer runingDevice) {
        this.runingDevice = runingDevice;
    }

    public Integer getDefendDevice() {
        return defendDevice;
    }

    public void setDefendDevice(Integer defendDevice) {
        this.defendDevice = defendDevice;
    }

    public Integer getInvalidDevice() {
        return invalidDevice;
    }

    public void setInvalidDevice(Integer invalidDevice) {
        this.invalidDevice = invalidDevice;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaDevice() {
        return areaDevice;
    }

    public void setAreaDevice(Integer areaDevice) {
        this.areaDevice = areaDevice;
    }

    public List<DeviceTypeStatisticVo> getDeviceTypeList() {
        return deviceTypeList;
    }

    public void setDeviceTypeList(List<DeviceTypeStatisticVo> deviceTypeList) {
        this.deviceTypeList = deviceTypeList;
    }
}
