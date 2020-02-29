package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 门禁类型
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
public enum AreaType implements MyBatisEnum<Integer> {

    BGQY(1, "办公区域"),
    HYSQY(2, "会议室区域"),
    ZYQY(3, "重要区域"),
    QTQY(4, "其他区域");

    private final int value;
    private final String description;

    AreaType(int value, String description) {
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
