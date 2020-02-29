package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;


public enum GuardStatus implements MyBatisEnum<Integer> {
	RUNNING(1, "运行中"),
    MAINTAIN(2, "维护中"),
    INVALID(3, "失效");

	private final int value;
    private final String desc;

    GuardStatus(int value, String desc) {
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
