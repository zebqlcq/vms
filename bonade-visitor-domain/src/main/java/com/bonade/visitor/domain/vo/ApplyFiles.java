package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName:  ApplyFiles   
 * @Description:表单 
 * @author: lcq 
 * @date:   2019年12月20日 下午1:54:35   
 * @version 1.0
 */
public class ApplyFiles {


    @ApiModelProperty(value = "类型（text textarea number radio checkbox select date）", name = "fieldType", dataType = "String", example = "text")
    private String fieldType;

    @ApiModelProperty(value = "字段名", name = "fieldText", dataType = "String", example = "1")
    private String fieldText;

    @ApiModelProperty(value = "内容", name = "fieldValue", dataType = "String", example = "1")
    private String fieldValue;

    @ApiModelProperty(value = "内容长度", name = "fieldLength", dataType = "String", example = "1")
    private String fieldLength;

    @ApiModelProperty(value = "描述", name = "fieldDesc", dataType = "String", example = "1")
    private String fieldDesc;

    @ApiModelProperty(value = "控件排序", name = "fieldSort", dataType = "int", example = "1")
    private Integer fieldSort;

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldText() {
        return fieldText;
    }

    public void setFieldText(String fieldText) {
        this.fieldText = fieldText;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(String fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public Integer getFieldSort() {
        return fieldSort;
    }

    public void setFieldSort(Integer fieldSort) {
        this.fieldSort = fieldSort;
    }
}
