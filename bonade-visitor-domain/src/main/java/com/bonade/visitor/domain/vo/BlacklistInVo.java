package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.AbnormalCase;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * @author chenmeng
 * @description 黑名单输入接口
 * @date 2019-12-27 14:10
 */
public class BlacklistInVo {

    @PreventOverflow
    @ApiModelProperty(value = "访客id", name = "visitorId", example = "")
    private Long visitorId;

    @ApiModelProperty(value = "异常原因", name = "abnormalCase", example = "")
    private AbnormalCase abnormalCase;

    @ApiModelProperty(value = "异常原因描述", name = "abnormalCaseDesc", example = "")
    private String abnormalCaseDesc;

    @PreventOverflow
    @ApiModelProperty(value = "异常记录id", name = "abnormalId", example = "")
    private Long abnormalId;

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @ApiModelProperty(hidden = true)
    private VisitorAttribute visitorAttribute;

    @ApiModelProperty(value = "搜索关键词", name = "name", example = "", required = true)
    private String name;


    @ApiModelProperty(value = "公司名称", name = "companyName", example = "", required = true)
    private String companyName;

    @ApiModelProperty(value = "担任岗位", name = "userStation", example = "", required = true)
    private String userStation;

    @ApiModelProperty(value = "手机号码", name = "tel", example = "", required = true)
    private String tel;

    @ApiModelProperty(value = "身份证号码", name = "cartNo", example = "", required = true)
    private String cartNo;

    @ApiModelProperty(value = "车牌号", name = "carNo", example = "", required = true)
    private String carNo;

    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public AbnormalCase getAbnormalCase() {
        return abnormalCase;
    }

    public void setAbnormalCase(AbnormalCase abnormalCase) {
        this.abnormalCase = abnormalCase;
    }

    public Long getAbnormalId() {
        return abnormalId;
    }

    public void setAbnormalId(Long abnormalId) {
        this.abnormalId = abnormalId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getAbnormalCaseDesc() {
        if(this.abnormalCase!=null)
            return abnormalCase.getDescription();
        else
            return null;
    }
}
