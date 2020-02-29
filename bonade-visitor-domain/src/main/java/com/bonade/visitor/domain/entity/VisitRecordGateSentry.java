package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author zoushaopeng
 * @title: VisitRecordGateSentry
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/18 9:54
 */
@TableName("vms_visit_record_gate_sentry")
public class VisitRecordGateSentry extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 访客记录ID
     */
    private Long recordId;

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 管辖区域ID
     */
    private Long areaId;

    /**
     * 安防人员ID
     */
    private Long gateSentryId;

    /**
     * 安防人员[用户]ID
     */
    private Long gateSentryUserId;

    /**
     * 发起人ID
     */
    private Long originatorId;

    /**
     * 发起人名称
     */
    private String originatorName;
    
    @TableField(exist = false)
    private String tel;

    /**
     * 发起人企业ID
     */
    private Long originatorEnterpriseId;

    /**
     * 发起人企业名称
     */
    private String originatorEnterpriseName;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getGateSentryId() {
        return gateSentryId;
    }

    public void setGateSentryId(Long gateSentryId) {
        this.gateSentryId = gateSentryId;
    }

    public Long getGateSentryUserId() {
        return gateSentryUserId;
    }

    public void setGateSentryUserId(Long gateSentryUserId) {
        this.gateSentryUserId = gateSentryUserId;
    }

    public Long getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(Long originatorId) {
        this.originatorId = originatorId;
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public void setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
    }

    public Long getOriginatorEnterpriseId() {
        return originatorEnterpriseId;
    }

    public void setOriginatorEnterpriseId(Long originatorEnterpriseId) {
        this.originatorEnterpriseId = originatorEnterpriseId;
    }

    public String getOriginatorEnterpriseName() {
        return originatorEnterpriseName;
    }

    public void setOriginatorEnterpriseName(String originatorEnterpriseName) {
        this.originatorEnterpriseName = originatorEnterpriseName;
    }

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
    
}
