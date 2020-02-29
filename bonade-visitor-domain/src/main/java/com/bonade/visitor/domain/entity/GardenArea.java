package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.GardenAreaType;
import org.spin.common.db.entity.AbstractEntity;

/**
 * @description 园区区域
 * @author chenmeng
 * @date 2020-1-13 9:13
*/
@TableName("vms_garden_area")
public class GardenArea extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域位置
     */
    private String areaLocation;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 企业负责人姓名
     */
    private String userName;

    /**
     * 企业负责人id
     */
    private Long userId;

    /**
     * 企业负责人手机号码
     */
    private String tel;

    /**
     * 园区区域类型
     */
    private GardenAreaType gardenAreaType;

    /**
     * 用于记录所有父级id
     */
    private String idPath;

    /**
     * 树的层级
     */
    private Integer level;

    /**
     * 区域负责人姓名
     */
    private String areaUserName;

    /**
     * 区域负责人手机号码
     */
    private String areaTel;

    /**
     * 区域负责人id
     */
    private Long areaUserId;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public GardenAreaType getGardenAreaType() {
        return gardenAreaType;
    }

    public void setGardenAreaType(GardenAreaType gardenAreaType) {
        this.gardenAreaType = gardenAreaType;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getAreaLocation() {
        return areaLocation;
    }

    public void setAreaLocation(String areaLocation) {
        this.areaLocation = areaLocation;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAreaUserName() {
        return areaUserName;
    }

    public void setAreaUserName(String areaUserName) {
        this.areaUserName = areaUserName;
    }

    public String getAreaTel() {
        return areaTel;
    }

    public void setAreaTel(String areaTel) {
        this.areaTel = areaTel;
    }

    public Long getAreaUserId() {
        return areaUserId;
    }

    public void setAreaUserId(Long areaUserId) {
        this.areaUserId = areaUserId;
    }
}
