package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Abnormal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @description 区域VO
 * @author chenmeng
 * @date 2019-12-26 9:11
*/
@ApiModel(value = "AreaStatisticsOutVo", description = "访问入参vo")
public class AreaStatisticsOutVo {


    @ApiModelProperty(value = "本周异常访问", name = "weekCount", example = "", required = true)
    private Integer weekCount;

	@ApiModelProperty(value = "累计异常访问", name = "allCount", example = "", required = true)
	private Integer allCount;

    @ApiModelProperty(value = "区域统计数据", name = "areaStatisticsDetailOutVos", example = "", required = true)
    private List<AreaStatisticsDetailOutVo> areaStatisticsDetailOutVoList;


    public Integer getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public List<AreaStatisticsDetailOutVo> getAreaStatisticsDetailOutVoList() {
        return areaStatisticsDetailOutVoList;
    }

    public void setAreaStatisticsDetailOutVoList(List<AreaStatisticsDetailOutVo> areaStatisticsDetailOutVoList) {
        this.areaStatisticsDetailOutVoList = areaStatisticsDetailOutVoList;
    }
}
