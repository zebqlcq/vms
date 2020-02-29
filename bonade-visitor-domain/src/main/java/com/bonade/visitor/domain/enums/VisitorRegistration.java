package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * @description 访客等级形式 TODO 有何用
 * @author chenmeng
 * @date 2019-12-5 10:35
*/
public enum VisitorRegistration implements MyBatisEnum<Integer> {
    INNER(1, "内部邀约"),
	OUTSIDE(2, "访客预约");

    private final int value;
    private final String desc;

    VisitorRegistration(int value, String desc) {
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
