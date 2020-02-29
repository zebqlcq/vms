package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.enums.AreaType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @description 区域VO
 * @author chenmeng
 * @date 2019-12-26 9:11
*/
@ApiModel(value = "AreaInVo", description = "访问入参vo")
public class AreaInVo implements VoEntityMapper<AreaInVo, Abnormal> {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "区域名称", name = "name", example = "", required = true)
    private String name;

    @ApiModelProperty(value = "区域描述", name = "describe", example = "", required = true)
    private String areaDescribe;

    @ApiModelProperty(value = "区域位置", name = "position", example = "", required = true)
    private String position;

    @ApiModelProperty(value = "统计开始日期", name = "date", example = "", required = true)
    private LocalDate startDate;

    @ApiModelProperty(hidden = true)
    private LocalDateTime startTime;

    @ApiModelProperty(value = "区域类型", name = "areaType", example = "", required = true)
    private AreaType areaType;

    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    @ApiModelProperty(value = "统计时段 今天 today 本周 week 本月 month", name = "timeInterval", example = "1")
    private String timeInterval;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaDescribe() {
        return areaDescribe;
    }

    public void setAreaDescribe(String areaDescribe) {
        this.areaDescribe = areaDescribe;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }
}
