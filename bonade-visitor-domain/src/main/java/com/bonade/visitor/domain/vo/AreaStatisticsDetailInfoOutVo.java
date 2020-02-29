package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-26 15:21
 */
@ApiModel(value = "AreaStatisticsDetailOutVo", description = "出参vo")
public class AreaStatisticsDetailInfoOutVo {

    @ApiModelProperty(value = "区域名称", name = "areaName", example = "", required = true)
    private String areaName;

    @ApiModelProperty(value = "异常数", name = "count", example = "", required = true)
    private Integer count;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
