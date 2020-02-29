package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * 企业类型
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2019/8/21</p>
 *
 * @author xuweinan
 * @version 1.0
 */
public enum EnterpriseType implements MyBatisEnum<Integer> {

    /**
     * 客户企业
     */
    CUSTOMER(1, "客户企业"),

    /**
     * 运营企业
     */
    OPERATION(2, "运营企业"),

    /**
     * 合作企业
     */
    COOPERATION(3, "合作企业"),

    /**
     * 管理员企业
     */
    ADMIN(4, "管理员企业"),

    /**
     * 客户运营企业
     */
    CUSTOMEROPERATION(5, "客户运营企业");

    private final int value;
    private final String description;

    EnterpriseType(int value, String description) {
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
