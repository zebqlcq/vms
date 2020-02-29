package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * 来访登记模板类型
 */
public enum VisitRegisterTemplateType implements MyBatisEnum<Integer> {

    EMPLOYEE(1, "一般访客模板"),
    VISITOR(2, "贵宾访客模板");

    private final int value;
    private final String desc;

    VisitRegisterTemplateType(int value, String desc) {
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
