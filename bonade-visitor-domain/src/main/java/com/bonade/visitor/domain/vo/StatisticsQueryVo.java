package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ApiModel(value = "StatisticsQueryVo", description = "统计查询对象")
public class StatisticsQueryVo {

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @ApiModelProperty(value = "条件(today:今日,week:本周,month:本月,year:全年)", name = "today", example = "1")
    private String condition;

    @ApiModelProperty(value = "查询时间起", name = "startDate", example = "2019-12-30")
    private LocalDate startDate;

    @ApiModelProperty(value = "查询时间止", name = "startDate", example = "2019-12-30")
    private LocalDate endDate;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
