package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "VisitArchiveStatisticsDetailVo", description = "访客档案统计细节对象")
public class VisitArchiveStatisticsDetailVo {

    public VisitArchiveStatisticsDetailVo() {
    }

    public VisitArchiveStatisticsDetailVo(Integer rc, String rq) {
        this.rc = rc;
        this.rq = rq;
    }

    @ApiModelProperty(value = "访问人次", name = "rc", example = "1", notes = "按照所选条件统计条件的细分人次，如选择本周，则代表一天的访问人次")
    private Integer rc;

    @ApiModelProperty(value = "日期", name = "rq", example = "2019-12-10")
    private String rq;

    @ApiModelProperty(value = "标记", name = "bj", example = "1")
    private String bj;

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }
}
