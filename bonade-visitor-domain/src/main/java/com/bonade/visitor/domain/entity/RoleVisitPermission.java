package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.spin.common.db.entity.AbstractEntity;

/**
 * 角色来访权限
 * @author lqx
 */
@TableName("vms_role_visit_permission")
public class RoleVisitPermission extends AbstractEntity {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 来源（1、角色权限管理(内部员工)，2、访问信息配置（外来访客），3、客户权限配置（系统管理员））
     */
    private Integer source;

    /**
     * 曾经来访登记
     */
    private boolean once;

    /**
     * 来访登出
     */
    private boolean logout;

    /**
     * 刷脸签到
     */
    private boolean face;

    /**
     * 二维码签到
     */
    private boolean qrCode;

    /**
     * 数字码签到
     */
    private boolean numericCode;

    /**
     * 通行验证码生效期
     */
    private Integer onTime;

    /**
     * 通行验证码失效期
     */
    private Integer offTime;

    public Long getRoleId() {
        return roleId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public boolean isOnce() {
        return once;
    }

    public void setOnce(boolean once) {
        this.once = once;
    }

    public boolean isLogout() {
        return logout;
    }

    public void setLogout(boolean logout) {
        this.logout = logout;
    }

    public boolean isFace() {
        return face;
    }

    public void setFace(boolean face) {
        this.face = face;
    }

    public boolean isQrCode() {
        return qrCode;
    }

    public void setQrCode(boolean qrCode) {
        this.qrCode = qrCode;
    }

    public boolean isNumericCode() {
        return numericCode;
    }

    public void setNumericCode(boolean numericCode) {
        this.numericCode = numericCode;
    }

    public Integer getOnTime() {
        return onTime;
    }

    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    public Integer getOffTime() {
        return offTime;
    }

    public void setOffTime(Integer offTime) {
        this.offTime = offTime;
    }
}
