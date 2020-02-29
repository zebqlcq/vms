package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.AbnormalCase;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author chenmeng
 * @description 黑名单输入接口
 * @date 2019-12-27 14:10
 */
public class BlacklistOutVo {

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

    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    @ApiModelProperty(value = "加入黑名单时间", name = "blacklistTime", example = "")
    private LocalDateTime blacklistTime;

    @ApiModelProperty(value = "手机号码", name = "tel", example = "")
    private String tel;

    @ApiModelProperty(value = "身份证", name = "cartNo", example = "")
    private String cartNo;

    @ApiModelProperty(value = "黑名单操作人", name = "blacklistOeration", example = "")
    private String blacklistOperation;

    @ApiModelProperty(value = "监控捕图", name = "abnormalImg", example = "")
    private String abnormalImg;

    @ApiModelProperty(value = "登记时间", name = "createTime", example = "")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "登记人", name = "createUsername", example = "")
    private String createUsername;

    public String getAbnormalCaseDesc() {
        return abnormalCaseDesc;
    }

    public void setAbnormalCaseDesc(String abnormalCaseDesc) {
        this.abnormalCaseDesc = abnormalCaseDesc;
    }

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
        if(abnormalCase!=null)
            abnormalCaseDesc = abnormalCase.getDescription();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBlacklistTime() {
        return blacklistTime;
    }

    public void setBlacklistTime(LocalDateTime blacklistTime) {
        this.blacklistTime = blacklistTime;
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

    public String getBlacklistOperation() {
        return blacklistOperation;
    }

    public void setBlacklistOperation(String blacklistOperation) {
        this.blacklistOperation = blacklistOperation;
    }

    public String getAbnormalImg() {
        return abnormalImg;
    }

    public void setAbnormalImg(String abnormalImg) {
        this.abnormalImg = abnormalImg;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }
}
