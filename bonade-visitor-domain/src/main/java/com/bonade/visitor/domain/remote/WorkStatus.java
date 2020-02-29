package com.bonade.visitor.domain.remote;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 在职状态
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
public enum WorkStatus implements MyBatisEnum<Integer> {

    ON_JOB(1, "在职"),
    QUIT(2, "离职");

    private final int value;
    private final String description;

    WorkStatus(int value, String description) {
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
