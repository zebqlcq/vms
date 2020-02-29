package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 文本类型
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2020/2/12.</p>
 */
public enum ContentType implements MyBatisEnum<Integer> {

    /**
     * 文本
     */
    TEXT(1, "文本"),

    /**
     * 富文本
     */
    RICH_TEXT(2, "富文本"),

    /**
     * JSON
     */
    JSON(3, "json");

    private final int value;

    private final String desc;

    ContentType(int value, String desc) {
        this.desc = desc;
        this.value = value;
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
