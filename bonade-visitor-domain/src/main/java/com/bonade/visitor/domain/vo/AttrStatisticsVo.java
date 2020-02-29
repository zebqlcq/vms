package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AttrStatisticsVo", description = "访客角色占比统计对象")
public class AttrStatisticsVo {

    @ApiModelProperty(value = "普通访客", name = "pt", example = "1")
    private Integer pt;

    @ApiModelProperty(value = "贵宾访客", name = "gb", example = "1")
    private Integer gb;

    @ApiModelProperty(value = "黑名单访客", name = "hmd", example = "1")
    private Integer hmd;

    public Integer getPt() {
        return pt;
    }

    public void setPt(Integer pt) {
        this.pt = pt;
    }

    public Integer getGb() {
        return gb;
    }

    public void setGb(Integer gb) {
        this.gb = gb;
    }

    public Integer getHmd() {
        return hmd;
    }

    public void setHmd(Integer hmd) {
        this.hmd = hmd;
    }
}
