package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zoushaopeng
 * @title: VisitorEnterprisePageVo
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/23 15:01
 */
public class VisitorEnterprisePageVo {

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

    @PreventOverflow
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @NotNull(message = "企业ID为空")
    private Long enterpriseId;

    @ApiModelProperty(value = "关键字", name = "keyword", example = "zx")
    @Size(min = 0, max = 50, message = "关键字输入长度不合法")
    private String keyword;

    @ApiModelProperty(value = "年份", name = "year", example = "2019")
    private Integer yearSelected;

    @ApiModelProperty(value = "来访时间（选定日期-->预约时间）", name = "year", example = "2019-08-01")
    @Size(min = 0, max = 10, message = "选定日期输入长度不合法")
    private String dateSelected;

    @ApiModelProperty(value = "来访状态", name = "visitStatus", example = "")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "访客属性", name = "visitorAttribute", example = "")
    private VisitorAttribute visitorAttribute;

//    @ApiModelProperty(value = "预约时间", name = "appointmentStartTime", example = "2019-08-01 00:00:00")
//    private String appointmentStartTime;

    @ApiModelProperty(value = "辅助字段1[不传]", name = "dateSpareBegin", example = "2019-08-01")
    private String dateSpareBegin;

    @ApiModelProperty(value = "辅助字段2[不传]", name = "dateSpareEnd", example = "2019-08-01")
    private String dateSpareEnd;

//    @ApiModelProperty(value = "辅助字段3[不传]", name = "appointmentSpareBegin", example = "2019-08-01")
//    private String appointmentSpareBegin;
//
//    @ApiModelProperty(value = "辅助字段4[不传]", name = "appointmentSpareEnd", example = "2019-08-01")
//    private String appointmentSpareEnd;

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

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
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

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
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
