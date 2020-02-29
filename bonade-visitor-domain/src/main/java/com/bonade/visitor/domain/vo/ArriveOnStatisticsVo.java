package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArriveOnStatisticsVo", description = "访客到访人次统计对象")
public class ArriveOnStatisticsVo {

    @ApiModelProperty(value = "邀约到访", name = "rc1", example = "1")
    private Integer rc1;

    @ApiModelProperty(value = "预约到访", name = "rc2", example = "1")
    private Integer rc2;

    public Integer getRc1() {
        return rc1;
    }

    public void setRc1(Integer rc1) {
        this.rc1 = rc1;
    }

    public Integer getRc2() {
        return rc2;
    }

    public void setRc2(Integer rc2) {
        this.rc2 = rc2;
    }
}
