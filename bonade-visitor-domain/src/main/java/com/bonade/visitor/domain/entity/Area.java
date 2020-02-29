package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.AreaType;
import org.spin.common.db.entity.AbstractEntity;

/**
 * description 异常访问记录表
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
@TableName("vms_area")
public class Area extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 描述
     */
    private String areaDescribe;

    /**
     * 位置
     */
    private String position;

    /**
     * 区域类型
     */
    private AreaType areaType;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
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

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }
}
