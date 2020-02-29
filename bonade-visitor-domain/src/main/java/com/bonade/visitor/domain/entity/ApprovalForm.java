package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.spin.common.db.entity.AbstractEntity;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * 
 * @ClassName:  ApprovalForm   
 * @Description:
 * @author: lcq 
 * @date:   2019年12月10日 下午3:29:06   
 * @version 1.0
 */
@TableName("vms_approval_form")
public class ApprovalForm extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 审批id
     */
    @PreventOverflow
    private Long approvalId;

    /**
     * 控件类型 text textarea number radio checkbox select date datesection explain money upload
     */
    private String fieldType;

    /**
     * 控件名称
     */
    private String fieldText;

    /**
     * 控件内容
     */
    private String fieldValue;

    /**
     * 控件内容长度
     */
    private Integer fieldLength;

    /**
     * 控件描述
     */
    private String fieldDesc;

    /**
     * 控件排序
     */
    private Integer fieldSort;

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

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

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
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
