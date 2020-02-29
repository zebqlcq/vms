package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 部门类型
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
public enum RelationType implements MyBatisEnum<Integer> {

    DEPARTMENT(1, "部门"),
    STATION(2, "岗位"),
    CUSTOM_ORGAN(3, "自定义组织");

    private final int value;
    private final String description;

    RelationType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
