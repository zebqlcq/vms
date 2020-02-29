package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;


public enum AbnormalCase implements MyBatisEnum<Integer> {
	ABNORMAL_CASE(1, "异常");

	private final int value;
    private final String desc;

    AbnormalCase(int value, String desc) {
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
