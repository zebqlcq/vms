package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "申请统计对象")
public class ApplyStatisticsVo {

    @ApiModelProperty(value = "人次", name = "rc", example = "1")
    private Integer rc;

    @ApiModelProperty(value = "环比人次", name = "preRc", example = "1")
    private Integer preRc;

    @ApiModelProperty(value = "环比", name = "hb", example = "1")
    private Integer hb;

    private List<VisitArchiveStatisticsDetailVo> applyDetailStatistics;

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public Integer getPreRc() {
        return preRc;
    }

    public void setPreRc(Integer preRc) {
        this.preRc = preRc;
    }

    public Integer getHb() {
        return hb;
    }

    public void setHb(Integer hb) {
        this.hb = hb;
    }

    public List<VisitArchiveStatisticsDetailVo> getApplyDetailStatistics() {
        return applyDetailStatistics;
    }

    public void setApplyDetailStatistics(List<VisitArchiveStatisticsDetailVo> applyDetailStatistics) {
        this.applyDetailStatistics = applyDetailStatistics;
    }
}
