package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.AbnormalCase;
import com.bonade.visitor.domain.enums.EnumUtil;

/**
 * @author zoushaopeng
 * @title: AbnormalDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/25 14:09
 */
public class AbnormalDto {

    /**
     * ID
     */
    private Long id;

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 异常原因
     */
    private AbnormalCase abnormalCase;

    /**
     * 异常原因(名字)
     */
    private String abnormalCaseName;

    /**
     * 异常位置
     */
    private Long abnormalAreaId;

    /**
     * 异常位置(名字)
     */
    private String abnormalAreaName;

    /**
     * 异常区域类型 1园区异常通行 2企业异常通行
     */
    private Integer abnormalType;

    /**
     * 访客id
     */
    private Long visitorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAbnormalCaseName() {
        return abnormalCaseName;
    }

    public void setAbnormalCaseName(String abnormalCaseName) {
        this.abnormalCaseName = abnormalCase != null ? EnumUtil.getByValue(abnormalCase.getValue(), AbnormalCase.class, "") : null;
    }

    public Long getAbnormalAreaId() {
        return abnormalAreaId;
    }

    public void setAbnormalAreaId(Long abnormalAreaId) {
        this.abnormalAreaId = abnormalAreaId;
    }

    public String getAbnormalAreaName() {
        return abnormalAreaName;
    }

    public void setAbnormalAreaName(String abnormalAreaName) {
        this.abnormalAreaName = abnormalAreaName;
    }

    public Integer getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(Integer abnormalType) {
        this.abnormalType = abnormalType;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }
}
