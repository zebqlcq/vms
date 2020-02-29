package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * @description 访问事由
 * @author chenmeng
 * @date 2019-12-5 10:36
*/
public enum UnBlacklistCause implements MyBatisEnum<Integer> {
    NORISK(1, "已解除相关风险"),
    OTHER(2, "其他原因");

    private final int value;
    private final String desc;

    UnBlacklistCause(int value, String desc) {
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
