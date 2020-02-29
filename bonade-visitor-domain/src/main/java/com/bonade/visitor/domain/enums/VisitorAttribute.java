package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * 访客属性
 */
public enum VisitorAttribute implements MyBatisEnum<Integer> {
	PLAIN(1, "普通访客"),
    VIP(2, "贵宾访客"),
    BLACK(3, "黑名单访客");

    private final int value;
    private final String desc;

    VisitorAttribute(int value, String desc) {
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
