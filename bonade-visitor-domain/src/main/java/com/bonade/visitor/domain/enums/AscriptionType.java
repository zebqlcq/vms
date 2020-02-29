package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 门禁类型
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
public enum AscriptionType implements MyBatisEnum<Integer> {

    MJSB(1, "门禁设备");

    private final int value;
    private final String description;

    AscriptionType(int value, String description) {
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
