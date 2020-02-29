package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-26 15:21
 */
@ApiModel(value = "AreaStatisticsDetailOutVo", description = "出参vo")
public class AreaStatisticsDetailOutVo {

    @ApiModelProperty(value = "日期时间", name = "dateTime", example = "", required = true)
    private String dateTime;

    @ApiModelProperty(value = "区域名称和总数列表", name = "dataVo", example = "", required = true)
    private List<AreaStatisticsDetailInfoOutVo> dataVo;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<AreaStatisticsDetailInfoOutVo> getDataVo() {
        return dataVo;
    }

    public void setDataVo(List<AreaStatisticsDetailInfoOutVo> dataVo) {
        this.dataVo = dataVo;
    }
}
