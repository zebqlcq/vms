package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ApiModel(value = "VisitArchivePageVo", description = "访客档案列表查询对象")
public class VisitArchivePageVo {

    @NotNull(message = "企业id不能为空")
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "1" ,required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    @ApiModelProperty(value = "访客姓名", name = "name")
    private String name;

    @ApiModelProperty(value = "来访状态", name = "visitStatus")
    private String visitStatus;

    @ApiModelProperty(value = "签入时间起", name = "checkInTimeStart")
    private LocalDateTime checkInTimeStart;

    @ApiModelProperty(value = "签入时间止", name = "checkInTimeEnd")
    private LocalDateTime checkInTimeEnd;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus;
    }

    public LocalDateTime getCheckInTimeStart() {
        return checkInTimeStart;
    }

    public void setCheckInTimeStart(LocalDateTime checkInTimeStart) {
        this.checkInTimeStart = checkInTimeStart;
    }

    public LocalDateTime getCheckInTimeEnd() {
        return checkInTimeEnd;
    }

    public void setCheckInTimeEnd(LocalDateTime checkInTimeEnd) {
        this.checkInTimeEnd = checkInTimeEnd;
    }
}
