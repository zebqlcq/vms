package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "VisitArchiveStatisticsVo", description = "访客档案统计对象")
public class VisitArchiveStatisticsVo {

    @ApiModelProperty(value = "累计来访人次", name = "accumulativeAllCount", example = "1")
    private Integer accumulativeAllCount;

    @ApiModelProperty(value = "访问人次", name = "count", example = "1", notes = "按照所选条件统计访问人次")
    private Integer count;

    @ApiModelProperty(value = "环比", name = "chainRatio", example = "1")
    private BigDecimal chainRatio;

    @ApiModelProperty(value = "访客档案统计细节", name = "detailList", example = "1")
    private List<VisitArchiveStatisticsDetailVo> detailList;

    public Integer getAccumulativeAllCount() {
        return accumulativeAllCount;
    }

    public void setAccumulativeAllCount(Integer accumulativeAllCount) {
        this.accumulativeAllCount = accumulativeAllCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getChainRatio() {
        return chainRatio;
    }

    public void setChainRatio(BigDecimal chainRatio) {
        this.chainRatio = chainRatio;
    }

    public List<VisitArchiveStatisticsDetailVo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<VisitArchiveStatisticsDetailVo> detailList) {
        this.detailList = detailList;
    }
}
