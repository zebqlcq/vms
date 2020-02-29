package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.VisitCause;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitInviteTemplateVo", description = "邀约模板对象")
public class VisitInviteTemplateVo {

    @ApiModelProperty(value = "邀约模板ID", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @NotNull(message = "模板名称不能为空")
    @ApiModelProperty(value = "模板名称", name = "tempName", example = "1", required = true)
    private String tempName;

    @NotNull(message = "邀约事由不能为空")
    @ApiModelProperty(value = "邀约事由", name = "theme", example = "1", required = true)
    private VisitCause theme;

    @NotNull(message = "邀约内容不能为空")
    @ApiModelProperty(value = "邀约内容", name = "content", example = "1", required = true)
    private String content;

    @ApiModelProperty(value = "公司地址", name = "address", example = "1")
    private String address;

    @ApiModelProperty(value = "公司地址地图信息", name = "addressMap", example = "1")
    private String addressMap;

    @ApiModelProperty(value = "交通及停车信息", name = "traffic", example = "1")
    private String traffic;

    @ApiModelProperty(value = "公司介绍", name = "companyIntroduce", example = "1")
    private String companyIntroduce;

    @ApiModelProperty(value = "您的手机号", name = "phoneItem", example = "您的手机号")
    private String phoneItem = "您的手机号";

    @ApiModelProperty(value = "您的手机号项是否需要登记", name = "phone", example = "true")
    private boolean phone;

    @ApiModelProperty(value = "是否默认模板", name = "defaultTemp", example = "true")
    private boolean defaultTemp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
