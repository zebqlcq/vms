package com.bonade.visitor.service;

/**
 * description
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2020/1/14.</p>
 */
public interface AuthService {

    /**
     * 发送短信验证码
     *
     * @param phone 手机号
     */
    void sendVerifyCode(String phone);
}
