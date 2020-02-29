package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.AscriptionType;
import com.bonade.visitor.domain.enums.GuardStatus;
import com.bonade.visitor.domain.enums.GuardType;
import org.spin.common.db.entity.AbstractEntity;

/**
 * @description 门禁表
 * @author chenmeng
 * @date 2019-12-31 8:48
*/
@TableName("vms_guard")
public class Guard extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 门禁
     */
    private String name;

    /**
     * 设备SN
     */
    private String sn;

    /**
     * 关联区域id
     */
    private Long areaId;

    /**
     * 关联运维人员
     */
    private String userName;

    /**
     * 关联运维人员Id
     */
    private Long userId;

    /**
     * 运行状态
     */
    private GuardStatus status;

    /**
     * 门禁类型
     */
    private GuardType guardType;

    /**
     * 归属类别
     */
    private AscriptionType ascriptionType;

    /**
     * 区域类型 1园区区域 2企业区域
     */
    private Integer areaType;

    /**
     * 准入规则id
     */
    private Long roleId;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public GuardStatus getStatus() {
        return status;
    }

    public void setStatus(GuardStatus status) {
        this.status = status;
    }

    public GuardType getGuardType() {
        return guardType;
    }

    public void setGuardType(GuardType guardType) {
        this.guardType = guardType;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public AscriptionType getAscriptionType() {
        return ascriptionType;
    }

    public void setAscriptionType(AscriptionType ascriptionType) {
        this.ascriptionType = ascriptionType;
    }
}
