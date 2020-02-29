package com.bonade.visitor.domain.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.enums.*;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author chenmeng
 * @description
 * @date 2019-12-5 13:50
 */

@ApiModel(value = "VisitOutVo", description = "访问出参vo")
public class VisitOutVo {
    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "访客id", name = "visitorId", example = "")
    private Long visitorId;


    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    @ApiModelProperty(value = "公司名称", name = "companyName", example = "")
    private String companyName;

    @ApiModelProperty(value = "访客预约时间", name = "appointmentTime", example = "")
    private LocalDateTime appointmentTime;

    @ApiModelProperty(value = "访客属性", name = "status", example = "")
    private VisitorStatus status;

    @ApiModelProperty(value = "预约事由", name = "cause", example = "")
    private VisitCause cause;

    @ApiModelProperty(value = "来访状态", name = "visitStatus", example = "")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "身份证", name = "cartNo", example = "")
    private String cartNo;

    @ApiModelProperty(value = "是否黑名单访客 1黑名单 0不是黑名单", name = "blacklist", example = "")
    private Integer blacklist;

    @ApiModelProperty(value = "加入黑名单时间", name = "blacklistTime", example = "")
    private LocalDateTime blacklistTime;

    @ApiModelProperty(value = "异常原因", name = "abnormalMsg", example = "")
    private String abnormalMsg;

    @ApiModelProperty(value = "异常图片", name = "abnormalImg", example = "")
    private String abnormalImg;

    @PreventOverflow
    @ApiModelProperty(value = "异常区域位置", name = "blackArea", example = "")
    private Long blackArea;

    @ApiModelProperty(value = "手机号码", name = "tel", example = "")
    private String tel;

    @ApiModelProperty(value = "黑名单操作人", name = "blacklistOeration", example = "")
    private String blacklistOeration;

    @ApiModelProperty(value = "黑名单操作人id", name = "blacklistOerationId", example = "")
    private String blacklistOerationId;

    @ApiModelProperty(value = "消息通知模板id", name = "messageId", example = "")
    private Long messageId;

    @ApiModelProperty(value = "黑名单监控捕图", name = "imgList", example = "")
    private List<String> imgList;

    @ApiModelProperty(value = "是否认证 1身份验证 2人脸识别 3认证通过", name = "auth", example = "")
    private Integer auth;

    @ApiModelProperty(value = "签发机关", name = "signing", example = "")
    private String signing;

    @ApiModelProperty(value = "企业名片", name = "cardImg", example = "")
    private String cardImg;

    @ApiModelProperty(value = "职位", name = "userStation", example = "")
    private String userStation;

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "")
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName", example = "")
    private String enterpriseName;

    @ApiModelProperty(value = "车牌号", name = "carNo", example = "")
    private String carNo;

    @ApiModelProperty(value = "异常原因", name = "abnormalCase", example = "")
    private AbnormalCase abnormalCase;

    @ApiModelProperty(value = "访客属性", name = "visitorAttribute", example = "")
    private VisitorAttribute visitorAttribute;

    @ApiModelProperty(value = "来访记录", name = "recordPage", example = "")
    private IPage<AbnormalRecordOutVo> recordPage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public VisitorStatus getStatus() {
        return status;
    }

    public void setStatus(VisitorStatus status) {
        this.status = status;
    }

    public VisitCause getCause() {
        return cause;
    }

    public void setCause(VisitCause cause) {
        this.cause = cause;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public Integer getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Integer blacklist) {
        this.blacklist = blacklist;
    }

    public String getAbnormalMsg() {
        return abnormalMsg;
    }

    public void setAbnormalMsg(String abnormalMsg) {
        this.abnormalMsg = abnormalMsg;
    }

    public String getAbnormalImg() {
        return abnormalImg;
    }

    public void setAbnormalImg(String abnormalImg) {
        this.abnormalImg = abnormalImg;
    }

    public LocalDateTime getBlacklistTime() {
        return blacklistTime;
    }

    public void setBlacklistTime(LocalDateTime blacklistTime) {
        this.blacklistTime = blacklistTime;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBlacklistOeration() {
        return blacklistOeration;
    }

    public void setBlacklistOeration(String blacklistOeration) {
        this.blacklistOeration = blacklistOeration;
    }

    public String getBlacklistOerationId() {
        return blacklistOerationId;
    }

    public void setBlacklistOerationId(String blacklistOerationId) {
        this.blacklistOerationId = blacklistOerationId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public String getSigning() {
        return signing;
    }

    public void setSigning(String signing) {
        this.signing = signing;
    }

    public String getCardImg() {
        return cardImg;
    }

    public void setCardImg(String cardImg) {
        this.cardImg = cardImg;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }

    public Long getBlackArea() {
        return blackArea;
    }

    public void setBlackArea(Long blackArea) {
        this.blackArea = blackArea;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public AbnormalCase getAbnormalCase() {
        return abnormalCase;
    }

    public void setAbnormalCase(AbnormalCase abnormalCase) {
        this.abnormalCase = abnormalCase;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public IPage<AbnormalRecordOutVo> getRecordPage() {
        return recordPage;
    }

    public void setRecordPage(IPage<AbnormalRecordOutVo> recordPage) {
        this.recordPage = recordPage;
    }
}
