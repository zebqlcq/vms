package com.bonade.visitor.domain.remote;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/8/21.</p>
 */
public enum CertificateType implements MyBatisEnum<Integer> {
    /**
     * 身份证
     */
    IDCARD(0, "身份证"),

    /**
     * 军官证
     */
    OFFICIAL(1, "军官证"),
    /**
     * 护照
     */
    PASSPORT(2, "护照"),
    /**
     * 港澳通行证
     */
    HMPASS(3, "港澳通行证");

    private final int value;
    private final String description;

    CertificateType(int value, String description) {
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
