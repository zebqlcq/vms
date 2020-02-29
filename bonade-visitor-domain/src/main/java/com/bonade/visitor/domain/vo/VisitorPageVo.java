package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zoushaopeng
 * @title: VisitorPageVo
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/23 9:16
 */
public class VisitorPageVo {

    /**
     * 当前页:默认1
     */
    @PreventOverflow
    @ApiModelProperty(value = "当前页", name = "current", example = "1", required = true)
    @NotNull(message = "页面值不能为空")
    @Min(value = 1, message = "最小值不能小于1")
    private Long current;

    /**
     * 页面大小
     */
    @PreventOverflow
    @ApiModelProperty(value = "页面大小", name = "size", example = "10", required = true)
    @NotNull(message = "页面大小值不能为空")
    @Min(value = 1, message = "最小值不能小于1")
    private Long size;

    @ApiModelProperty(value = "关键字", name = "keyword", example = "zx")
    @Size(min = 0, max = 50, message = "关键字输入长度不合法")
    private String keyword;

    @ApiModelProperty(value = "年份", name = "year", example = "2019")
    private Integer yearSelected;

    @ApiModelProperty(value = "选定日期", name = "year", example = "2019-08-01")
    @Size(min = 0, max = 10, message = "选定日期输入长度不合法")
    private String dateSelected;

    @ApiModelProperty(value = "辅助字段1[不传]", name = "dateSpareBegin", example = "2019-08-01")
    private String dateSpareBegin;

    @ApiModelProperty(value = "辅助字段2[不传]", name = "dateSpareEnd", example = "2019-08-01")
    private String dateSpareEnd;

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getYearSelected() {
        return yearSelected;
    }

    public void setYearSelected(Integer yearSelected) {
        this.yearSelected = yearSelected;
    }

    public String getDateSelected() {
        return dateSelected;
    }

    public void setDateSelected(String dateSelected) {
        this.dateSelected = dateSelected;
    }

    public String getDateSpareBegin() {
        return dateSpareBegin;
    }

    public void setDateSpareBegin(String dateSpareBegin) {
        this.dateSpareBegin = dateSpareBegin;
    }

    public String getDateSpareEnd() {
        return dateSpareEnd;
    }

    public void setDateSpareEnd(String dateSpareEnd) {
        this.dateSpareEnd = dateSpareEnd;
    }
}
