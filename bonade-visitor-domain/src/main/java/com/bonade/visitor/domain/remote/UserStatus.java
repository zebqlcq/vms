package com.bonade.visitor.domain.remote;

import org.spin.common.db.entity.MyBatisEnum;

/**
 * description 用户状态 中台相关
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/8/23.</p>
 */
public enum UserStatus implements MyBatisEnum<Integer> {

    /**
     * 启用
     */
    ENABLE(1),

    /**
     * 禁用本地系统访问
     */
    DISABLE(2),

    /**
     * 禁用所有系统
     */
    DISABLEALL(3);

    private final int value;

    UserStatus(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
