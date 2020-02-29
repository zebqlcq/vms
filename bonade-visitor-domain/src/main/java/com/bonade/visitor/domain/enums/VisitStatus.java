package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * @description 到访状态
 * @author chenmeng
 * @date 2019-12-5 10:36
*/
public enum VisitStatus implements MyBatisEnum<Integer> {
	CHECKWAIT_1(1, "待审核"), // 预约发起审批后
	CHECKWAIT_2(2, "待验证"), // 邀约发起成功后（无需审批） 即收到邀请
	VISITWAIT_1(3, "待拜访"), // 预约审批通过后
	VISITWAIT_2(4, "待来访"), // 邀约验证后
	APPROVALREFUSE(5, "已拒绝"), // 预约审批被拒绝
	VALIDATEREFUSE(6, "已拒绝"), // 安防验证被拒绝
	ALREADYING(7, "已入场"), 
	FINISHED(8, "已完成"), 
	OVERTIME(9, "访问超时"), 
	ABNORMAL(10, "访问异常"),
	PASS(11, "通过"),//预约审批通过
	REQUESTVALIDA(12, "请求验证"),
	INVITATION_REVOKE(0,"撤销邀约"),
	APPOINTMENT_REVOKE(-1,"撤销预约");

    private final int value;
    private final String desc;

    VisitStatus(int value, String desc) {
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
