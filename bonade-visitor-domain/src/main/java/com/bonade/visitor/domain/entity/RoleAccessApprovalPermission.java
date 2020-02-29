package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.PermissionRange;
import com.bonade.visitor.domain.enums.PermissionType;
import org.spin.common.db.entity.AbstractEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 门禁和审批权限
 * @author lqx
 */
@TableName("vms_role_access_approval_permission")
public class RoleAccessApprovalPermission extends AbstractEntity {

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
     * 属性（1、一般访客，2、贵宾访客，3、黑名单）
     */
    private Integer attribute;

    /**
     * 权限类型
     */
    private PermissionType permissionType;

    /**
     * 权限范围
     */
    private PermissionRange permissionRange;

    /**
     * 全部（权限范围）
     */
    private boolean whole;

    /**
     * 指定范围id
     */
    private Long rangeId;

    /**
     * 指定范围名称
     */
    private String rangeName;

    /**
     * 开放时间起
     */
    private LocalTime openTimeStart;

    /**
     * 开放时间止
     */
    private LocalTime openTimeEnd;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    public PermissionRange getPermissionRange() {
        return permissionRange;
    }

    public void setPermissionRange(PermissionRange permissionRange) {
        this.permissionRange = permissionRange;
    }

    public boolean isWhole() {
        return whole;
    }

    public void setWhole(boolean whole) {
        this.whole = whole;
    }

    public Long getRangeId() {
        return rangeId;
    }

    public void setRangeId(Long rangeId) {
        this.rangeId = rangeId;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public LocalTime getOpenTimeStart() {
        return openTimeStart;
    }

    public void setOpenTimeStart(LocalTime openTimeStart) {
        this.openTimeStart = openTimeStart;
    }

    public LocalTime getOpenTimeEnd() {
        return openTimeEnd;
    }

    public void setOpenTimeEnd(LocalTime openTimeEnd) {
        this.openTimeEnd = openTimeEnd;
    }
}
