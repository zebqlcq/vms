package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * 权限类型
 * @author lqx
 */
public enum PermissionType implements MyBatisEnum<Integer> {
    CHECKINOUTDOOR(1, "进出口门禁权限"),
    PARKINGLOT(2, "停车场通行权限"),
    APPROCAL(3, "审批权限"),
    INVITATION(4, "邀约权限"),
    MONITOR(5, "监控权限"),
    EXCEPTIONMANAGE(6, "异常管理权限"),
    VISITORINFO(7, "访客信息查询权限"),
    DOWNENTERPRISE(8, "下放企业权限");

    private final int value;
    private final String desc;

    PermissionType(int value, String desc) {
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
