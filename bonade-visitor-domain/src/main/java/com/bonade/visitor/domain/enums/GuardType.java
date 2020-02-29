package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 门禁类型
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
public enum GuardType implements MyBatisEnum<Integer> {

    MJSB(1, "门禁设备"),
    TXZJ(2, "通行闸机"),
    ZNFK(3, "智能访客"),
    ZNCPSB(4, "智能车票识别"),
    JKDP(5, "监控大屏");

    private final int value;
    private final String description;

    GuardType(int value, String description) {
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
