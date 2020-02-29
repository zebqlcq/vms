package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * 权限范围
 * @author lqx
 */
public enum PermissionRange implements MyBatisEnum<Integer> {
    NUMBER(1, "使用成员"),
    GROUP(2, "成员组"),
    REGION(3, "指定区域"),
    DATETIME(4, "开放时间"),
    DEVICE(5, "选择设备"),
    EXCEPTIONAPPROVAL(6, "异常访客审批"),
    EXCEPTIONSIGN(7, "异常访客标记"),
    FUNCTIONALDEPT(8, "选择职能部门"),
    ENTERPRISE(9, "企业"),
    DEPARTMENT(10, "部门"),
    STATION(11, "岗位"),
    CUSTOM_ORGAN(12, "自定义组织");

    private final int value;
    private final String desc;

    PermissionRange(int value, String desc) {
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
