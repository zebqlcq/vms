package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;


public enum EventStatus implements MyBatisEnum<Integer> {
	CHECKWAIT_1(1, "发起预约申请"), // 预约发起审批后
	CHECKWAIT_2(2, "成功发起邀请"), // 邀约发起成功后（无需审批） 即收到邀请
	VISITWAIT_1(3, "预约审批通过"), // 预约审批通过后
	VISITWAIT_2(4, "用户已验证邀请"), // 邀约验证后
	APPROVALREFUSE(5, "预约审批不通过"), // 预约审批被拒绝
	VALIDATEREFUSE(6, "审批拒绝通行"), // 安防验证拒绝
	ALREADYING(7, "签入"), 
	FINISHED(8, "签出"), 
	OVERTIME(9, "访问超时"), 
	ABNORMAL(10, "访问异常"),
	VALIDATEPASS(11, "审批通行"),//安防验证通过
	REQUESTVALIDA(12, "请求验证"),//请求验证
	INVITATION_REVOKE(0,"撤销邀约"),
	APPOINTMENT_REVOKE(-1,"撤销预约");

    private final int value;
    private final String desc;

    EventStatus(int value, String desc) {
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
