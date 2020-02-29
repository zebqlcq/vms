package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "DeptStatisticsOutDetailVo", description = "部门详细统计对象")
public class DeptStatisticsOutDetailVo {

    public DeptStatisticsOutDetailVo() {
    }

    public DeptStatisticsOutDetailVo(Integer rc, LocalDate rq) {
        this.rc = rc;
        this.rq = rq;
    }

    @ApiModelProperty(value = "人次", name = "rc", example = "1")
    private Integer rc;

    @ApiModelProperty(value = "日期", name = "rq", example = "1")
    private LocalDate rq;

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public LocalDate getRq() {
        return rq;
    }

    public void setRq(LocalDate rq) {
        this.rq = rq;
    }
}
