package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AddUpStatisticsVo", description = "访问累计概况对象")
public class AddUpStatisticsVo {

    @ApiModelProperty(value = "签入", name = "rc1", example = "1")
    private Integer rc1;

    @ApiModelProperty(value = "签出", name = "rc2", example = "1")
    private Integer rc2;

    @ApiModelProperty(value = "滞留", name = "rc3", example = "1")
    private Integer rc3;

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

    public Integer getRc3() {
        return rc3;
    }

    public void setRc3(Integer rc3) {
        this.rc3 = rc3;
    }
}
