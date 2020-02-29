package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * @description 访客属性 ？ TODO
 * @author chenmeng
 * @date 2019-12-5 10:36
*/
public enum VisitorStatus implements MyBatisEnum<Integer> {
    PERMANENT(1, "常驻访客"),
    UNKNOWN(2, "不明访客"),
    TEMPORARY(3, "临时访客");

    private final int value;
    private final String desc;

    VisitorStatus(int value, String desc) {
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
