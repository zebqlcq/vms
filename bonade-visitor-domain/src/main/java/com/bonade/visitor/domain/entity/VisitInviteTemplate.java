package com.bonade.visitor.domain.entity;

import com.bonade.visitor.domain.enums.VisitCause;
import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 邀约模板
 * @author lqx
 */
@TableName("vms_visit_invite_template")
public class VisitInviteTemplate extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 模板名称
     */
    private String tempName;

    /**
     * 邀约事由
     */
    private VisitCause theme;

    /**
     * 邀约内容
     */
    private String content;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 公司地址地图信息
     */
    private String addressMap;

    /**
     * 交通及停车信息
     */
    private String traffic;

    /**
     * 公司介绍
     */
    private String companyIntroduce;

    private String phoneItem = "您的手机号";

    /**
     * 您的手机号项是否需要登记
     */
    private boolean phone;

    /**
     * 是否默认模板
     */
    private boolean defaultTemp;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public VisitCause getTheme() {
        return theme;
    }

    public void setTheme(VisitCause theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(String addressMap) {
        this.addressMap = addressMap;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getCompanyIntroduce() {
        return companyIntroduce;
    }

    public void setCompanyIntroduce(String companyIntroduce) {
        this.companyIntroduce = companyIntroduce;
    }

    public String getPhoneItem() {
        return phoneItem;
    }

    public void setPhoneItem(String phoneItem) {
        this.phoneItem = phoneItem;
    }

    public boolean isPhone() {
        return phone;
    }

    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    public boolean isDefaultTemp() {
        return defaultTemp;
    }

    public void setDefaultTemp(boolean defaultTemp) {
        this.defaultTemp = defaultTemp;
    }
}
