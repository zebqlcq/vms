package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * @description 访客来源  TODO 有何用？
 * @author chenmeng
 * @date 2019-12-5 10:35
*/
public enum VisitorSource implements MyBatisEnum<Integer> {
    INNER(1, "内部创建");

    private final int value;
    private final String desc;

    VisitorSource(int value, String desc) {
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
