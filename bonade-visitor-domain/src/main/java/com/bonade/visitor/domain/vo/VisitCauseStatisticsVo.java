package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitCauseStatisticsVo", description = "来访事由占比统计对象")
public class VisitCauseStatisticsVo {

    @ApiModelProperty(value = "项目对接", name = "xmdj", example = "1")
    private Integer xmdj;

    @ApiModelProperty(value = "业务洽谈", name = "ywqt", example = "1")
    private Integer ywqt;

    @ApiModelProperty(value = "日常维护", name = "rcwh", example = "1")
    private Integer rcwh;

    @ApiModelProperty(value = "面试邀约", name = "msyy", example = "1")
    private Integer msyy;

    public Integer getXmdj() {
        return xmdj;
    }

    public void setXmdj(Integer xmdj) {
        this.xmdj = xmdj;
    }

    public Integer getYwqt() {
        return ywqt;
    }

    public void setYwqt(Integer ywqt) {
        this.ywqt = ywqt;
    }

    public Integer getRcwh() {
        return rcwh;
    }

    public void setRcwh(Integer rcwh) {
        this.rcwh = rcwh;
    }

    public Integer getMsyy() {
        return msyy;
    }

    public void setMsyy(Integer msyy) {
        this.msyy = msyy;
    }
}
