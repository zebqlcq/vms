package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * @description 访问事由
 * @author chenmeng
 * @date 2019-12-5 10:36
*/
public enum VisitCause implements MyBatisEnum<Integer> {
    YWQT(1, "业务洽谈"),
    SWBL(2, "事务办理"),
    QT(10, "其他");

    private final int value;
    private final String desc;

    VisitCause(int value, String desc) {
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
