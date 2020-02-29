package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 访客类型
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
public enum VisitorType implements MyBatisEnum<Integer> {
    VISITOR(1, "访客"),
    GUEST(2, "来宾");

    private final int value;
    private final String desc;

    VisitorType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
