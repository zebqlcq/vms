package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * 企业审核状态
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2019/8/21</p>
 *
 * @author xuweinan
 * @version 1.0
 */
public enum EnterpriseAuditStatus implements MyBatisEnum<Integer> {
    NOT_AUDIT(0, "待审核"),
    SUCCESS(1, "审核成功"),
    FAIL(-1, "审核失败");

    private final String description;
    private final int value;

    EnterpriseAuditStatus(int value, String description) {
        this.description = description;
        this.value = value;
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
