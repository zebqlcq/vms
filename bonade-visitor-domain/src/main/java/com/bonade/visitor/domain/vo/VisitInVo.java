package com.bonade.visitor.domain.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.bonade.visitor.domain.enums.*;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-5 13:50
 */
@ApiModel(value = "VisitInVo", description = "访问入参vo")
public class VisitInVo {


    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    @ApiModelProperty(value = "来访时间 开始", name = "beginDate", example = "")
    private LocalDate beginDate;

    @ApiModelProperty(hidden = true)
    private LocalDateTime beignDateTime;

    @ApiModelProperty(value = "来访时间 结束", name = "endDate", example = "")
    private LocalDate endDate;

    @ApiModelProperty(hidden = true)
    private LocalDateTime endDateTime;

    @ApiModelProperty(value = "访客属性", name = "status", example = "")
    private VisitorStatus status;

    @ApiModelProperty(value = "来访状态", name = "visitStatus", example = "")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "关键字", name = "keyWord", example = "")
    private String keyWord;

    @NotNull(message = "访客姓名不能为空",groups = {Add.class,Update.class})
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName", example = "")
    private String enterpriseName;

    @ApiModelProperty(value = "访客公司名称", name = "companyName", example = "")
    private String companyName;

    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "")
    private Long enterpriseId;

    @ApiModelProperty(value = "职位", name = "userStation", example = "")
    private String userStation;

    @NotNull(message = "身份证号码不能为空",groups = {Add.class,Update.class})
    @ApiModelProperty(value = "身份证号码", name = "cartNo", example = "")
    private String cartNo;

    @NotNull(message = "手机号码不能为空",groups = {Add.class,Update.class})
    @ApiModelProperty(value = "手机号码", name = "tel", example = "")
    private String tel;

    @ApiModelProperty(value = "车牌号", name = "carNo", example = "")
    private String carNo;

    @PreventOverflow
    @ApiModelProperty(value = "访客id", name = "visitorId", example = "")
    private Long visitorId;

    @NotNull(message = "人脸照片",groups = {Add.class,Update.class})
    @ApiModelProperty(value = "人脸照片", name = "faceImg", example = "")
    private String faceImg;

    @NotNull(message = "身份证照片(正面）",groups = {Add.class,Update.class})
    @ApiModelProperty(value = "身份证照片(正面）", name = "cartNoPositive", example = "")
    private String cartNoPositive;

    @NotNull(message = "身份证照片（背面）",groups = {Add.class,Update.class})
    @ApiModelProperty(value = "身份证照片（背面）", name = "cartNoNegative", example = "")
    private String cartNoNegative;

    @ApiModelProperty(value = "异常原因", name = "abnormalMsg", example = "")
    private AbnormalCase abnormalCase;

    @ApiModelProperty(value = "异常图片", name = "abnormalImg", example = "")
    private String abnormalImg;

    @ApiModelProperty(value = "异常区域位置", name = "blackArea", example = "")
    private Long blackArea;

    @ApiModelProperty(value = "解除黑名单原因", name = "abnormalImg", example = "")
    private UnBlacklistCause unBlacklistCause;


    @ApiModelProperty(value = "是否黑名单访客 1黑名单 0不是黑名单", name = "blacklist", example = "")
    private Integer blacklist;

    @ApiModelProperty(value = "黑名单监控捕图", name = "blacklist", example = "")
    private List<String> imgList;

    @ApiModelProperty(value = "是否历史记录 1历史 0首页", name = "isAll", example = "")
    private Integer isAll;

    @ApiModelProperty(value = "是否认证 0未认证 1已认证", name = "auth", example = "")
    private Integer auth;

    @ApiModelProperty(value = "手机号码-0或1-时间戳", name = "auth", example = "")
    private String authStr;

    @ApiModelProperty(value = "签发机关", name = "signing", example = "")
    private String signing;

    @ApiModelProperty(value = "企业名片", name = "cardImg", example = "")
    private String cardImg;

    @ApiModelProperty(value = "访客属性", name = "cardImg", example = "")
    private VisitorAttribute visitorAttribute;


    public interface Add {
    }

    public interface Update {
    }

    public interface Search {
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

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getBeignDateTime() {
        return beignDateTime;
    }

    public void setBeignDateTime(LocalDateTime beignDateTime) {
        this.beignDateTime = beignDateTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public VisitorStatus getStatus() {
        return status;
    }

    public void setStatus(VisitorStatus status) {
        this.status = status;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getCartNoPositive() {
        return cartNoPositive;
    }

    public void setCartNoPositive(String cartNoPositive) {
        this.cartNoPositive = cartNoPositive;
    }

    public Integer getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Integer blacklist) {
        this.blacklist = blacklist;
    }

    public AbnormalCase getAbnormalCase() {
        return abnormalCase;
    }

    public void setAbnormalCase(AbnormalCase abnormalCase) {
        this.abnormalCase = abnormalCase;
    }

    public String getAbnormalImg() {
        return abnormalImg;
    }

    public void setAbnormalImg(String abnormalImg) {
        this.abnormalImg = abnormalImg;
    }

    public UnBlacklistCause getUnBlacklistCause() {
        return unBlacklistCause;
    }

    public void setUnBlacklistCause(UnBlacklistCause unBlacklistCause) {
        this.unBlacklistCause = unBlacklistCause;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCartNoNegative() {
        return cartNoNegative;
    }

    public void setCartNoNegative(String cartNoNegative) {
        this.cartNoNegative = cartNoNegative;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getIsAll() {
        return isAll;
    }

    public void setIsAll(Integer isAll) {
        this.isAll = isAll;
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

    public String getAuthStr() {
        return authStr;
    }

    public void setAuthStr(String authStr) {
        this.authStr = authStr;
    }

    public Long getBlackArea() {
        return blackArea;
    }

    public void setBlackArea(Long blackArea) {
        this.blackArea = blackArea;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }
}
