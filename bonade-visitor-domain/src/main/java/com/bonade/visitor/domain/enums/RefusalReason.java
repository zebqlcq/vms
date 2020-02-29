package com.bonade.visitor.domain.enums;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * 
 * @ClassName:  RefusalReason   
 * @Description:
 * @author: lcq 
 * @date:   2019年12月23日 上午11:10:36   
 * @version 1.0
 */
public enum RefusalReason implements MyBatisEnum<Integer> {
	INFO_ABNORMAL(1,"信息异常"),
	DELAY(2,"事务延迟"),
	DANGEROUS(3,"危险关系人"),
	OTHER(4,"其他");
    private final int value;
    private final String desc;

    RefusalReason(int value, String desc) {
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
