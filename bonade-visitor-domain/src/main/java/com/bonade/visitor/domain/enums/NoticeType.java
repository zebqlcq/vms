package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * @description 访问事由
 * @author chenmeng
 * @date 2019-12-5 10:36
*/
public enum NoticeType implements MyBatisEnum<Integer> {
    SPJGTZ(1, "访客通知-审批结果通知"),
    YQWQCTZ(2, "访客通知-逾期未签出"),
    YYXXTZ(3, "被访通知-邀约信息通知"),
    YYSPTZ(51, "企业通知配置-预约审批通知"),
    JBTXZZ(52, "企业通知配置-警报提醒通知");

    private final int value;
    private final String desc;

    NoticeType(int value, String desc) {
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
