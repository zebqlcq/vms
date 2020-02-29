package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.*;
import org.spin.common.db.entity.AbstractEntity;

import java.time.LocalDateTime;

/**
 * description 异常访问记录表
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
@TableName("vms_abnormal")
public class Abnormal extends AbstractEntity {


    private static final long serialVersionUID = -2351125867019728706L;
    /**
     * 企业ID
     */
    private Long enterpriseId;


    /**
     * 异常原因
     */
    private AbnormalCase abnormalCase;

    /**
     * 异常位置
     */
    private Long abnormalAreaId;

    /**
     * 异常区域类型 1园区异常通行 2企业异常通行
     */
    private Integer abnormalType;

    /**
     * 访客id
     */
    private Long visitorId;

    /**
     * 访问记录id
     */
    private Long recordId;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public AbnormalCase getAbnormalCase() {
        return abnormalCase;
    }

    public void setAbnormalCase(AbnormalCase abnormalCase) {
        this.abnormalCase = abnormalCase;
    }


    public Long getAbnormalAreaId() {
        return abnormalAreaId;
    }

    public void setAbnormalAreaId(Long abnormalAreaId) {
        this.abnormalAreaId = abnormalAreaId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Integer getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(Integer abnormalType) {
        this.abnormalType = abnormalType;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
}
