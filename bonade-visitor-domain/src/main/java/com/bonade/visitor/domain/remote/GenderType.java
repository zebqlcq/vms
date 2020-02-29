package com.bonade.visitor.domain.remote;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 性别
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/8/22.</p>
 */
public enum GenderType implements MyBatisEnum<Integer> {
    /**
     * 男
     */
    MALE(1),

    /**
     * 女
     */
    FEMALE(2),

    /**
     * 未知
     */
    UNKNOWN(0);

    private final int value;

    GenderType(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
