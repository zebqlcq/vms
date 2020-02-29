package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

@ApiModel(value = "VisitArchivePageOutVo", description = "访客档案列表对象")
public class VisitArchivePageOutVo {
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @ApiModelProperty(value = "名称", name = "name", example = "1")
    private String name;

    @ApiModelProperty(value = "访客属性", name = "visitorAttribute", example = "1")
    private VisitorAttribute visitorAttribute;

    @ApiModelProperty(value = "访客属性描述", name = "visitorAttributeName", example = "1")
    private String visitorAttributeName;

    @ApiModelProperty(value = "当属企业", name = "companyName", example = "1")
    private String companyName;

    @ApiModelProperty(value = "当属岗位", name = "userStation", example = "1")
    private String userStation;

    @ApiModelProperty(value = "手机号码", name = "tel", example = "1")
    private String tel;

    @ApiModelProperty(value = "身份证号码", name = "cartNo", example = "1")
    private String cartNo;

    @ApiModelProperty(value = "人脸图像", name = "faceImg", example = "1")
    private String faceImg;

    @ApiModelProperty(value = "是否异常", name = "abnormalMsg", example = "1")
    private String abnormalMsg;

    @ApiModelProperty(value = "实际到访状态", name = "visitStatus", example = "1")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "实际到访状态描述", name = "visitStatusDesc", example = "1")
    private String visitStatusDesc;

    @ApiModelProperty(value = "车牌号", name = "carNum", example = "1")
    private String carNum;

    @ApiModelProperty(value = "第一次签入时间", name = "firstCheckInTime", example = "1")
    private LocalDateTime firstCheckInTime;

    @ApiModelProperty(value = "签出时间", name = "operationTime", example = "1")
    private LocalDateTime operationTime;

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

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
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

    public String getVisitorAttributeName() {
        return visitorAttributeName;
    }

    public void setVisitorAttributeName(String visitorAttributeName) {
        this.visitorAttributeName = visitorAttributeName;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getAbnormalMsg() {
        return abnormalMsg;
    }

    public void setAbnormalMsg(String abnormalMsg) {
        this.abnormalMsg = abnormalMsg;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public LocalDateTime getFirstCheckInTime() {
        return firstCheckInTime;
    }

    public void setFirstCheckInTime(LocalDateTime firstCheckInTime) {
        this.firstCheckInTime = firstCheckInTime;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public String getVisitStatusDesc() {
        return visitStatusDesc;
    }

    public void setVisitStatusDesc(String visitStatusDesc) {
        this.visitStatusDesc = visitStatusDesc;
    }
}
