package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 访客系统内部角色
 * @author lqx
 */
@TableName("vms_role")
public class Role extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 来源（1、角色权限管理(内部员工)，2、访问信息配置（外来访客），3、客户权限配置（系统管理员））
     */
    private Integer source;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
