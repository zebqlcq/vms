package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;


public enum ApprovalState implements MyBatisEnum<Integer> {
	STATE_0(0, "待审批"),
	STATE_1(1,"通过"),
	STATE_2(2, "拒绝"),
	STATE_3(3, "待阅览"),
	STATE_4(4, "已阅览"),
	STATE_REVOKE(-1, "已撤销");

	private final int value;
    private final String desc;

    ApprovalState(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

	@Override
	public Integer getValue() {
		 return value;
	}
	
	public String getDescription() {
        return desc;
    }
}
