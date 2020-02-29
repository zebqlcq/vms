package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.VisitFollowUser;
import com.bonade.visitor.domain.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.web.annotation.PostApi;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ApiModel(value = "VisitRecordVo", description = "访客档案对象")
public class VisitRecordVo {

    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2019-12-09 17:11:11")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建用户", name = "createUsername", example = "1")
    private String createUsername;

    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1")
    @PreventOverflow
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName", example = "1")
    private String enterpriseName;

    @ApiModelProperty(value = "访客id", name = "visitorId", example = "1")
    @PreventOverflow
    private Long visitorId;

    @ApiModelProperty(value = "关联内部人员", name = "internalStaffUserId", example = "1")
    @PreventOverflow
    private Long internalStaffUserId;

    @ApiModelProperty(value = "关联内部人员名称", name = "internalStaffUserName", example = "1")
    private String internalStaffUserName;

    @ApiModelProperty(value = "关联内部人员手机号", name = "internalStaffUserTel", example = "1")
    private String internalStaffUserTel;

    @ApiModelProperty(value = "关联内部人员职位", name = "internalStaffUserStation", example = "1")
    private String internalStaffUserStation;

    @ApiModelProperty(value = "权限 0未激活 1激活", name = "permission", example = "1")
    private Integer permission;

    @ApiModelProperty(value = "登记形式", name = "registration", example = "1")
    private VisitorRegistration registration;

    @ApiModelProperty(value = "访客来源", name = "source", example = "1")
    private VisitorSource source;

    @ApiModelProperty(value = "邀访/预访开始时间", name = "appointmentSartTime", example = "2019-12-09 17:11:11")
    private LocalDateTime appointmentSartTime;

    @ApiModelProperty(value = "邀访/预访开始时间", name = "appointmentEndTime", example = "2019-12-09 17:11:11")
    private LocalDateTime appointmentEndTime;

    @ApiModelProperty(value = "生效日期", name = "effectiveDate", example = "2019-12-09 17:11:11")
    private LocalDateTime effectiveDate;

    @ApiModelProperty(value = "失效日期", name = "expirationDate", example = "2019-12-09 17:11:11")
    private LocalDateTime expirationDate;

    @ApiModelProperty(value = "访问事由", name = "visitCause", example = "1")
    private VisitCause visitCause;

    @ApiModelProperty(value = "实际到访状态", name = "visitStatus", example = "1")
    private VisitStatus visitStatus;

    @ApiModelProperty(value = "实际到访状态中文名称", name = "visitStatusName", example = "1")
    private String visitStatusName;


    @ApiModelProperty(value = "到访时间", name = "visitingTime", example = "2019-12-09 17:11:11")
    private Date visitingTime;

    @ApiModelProperty(value = "车牌号", name = "carNum", example = "1")
    private String carNum;

    @ApiModelProperty(value = "随访人数", name = "followNum", example = "1")
    private Integer followNum;

    @ApiModelProperty(value = "访客属性", name = "visitorStatus", example = "1")
    private VisitorStatus visitorStatus;

    @ApiModelProperty(value = "访问地址", name = "address", example = "1")
    private String address;

    @ApiModelProperty(value = "随访人员信息", name = "followUserList", example = "1")
    private List<VisitFollowUser> followUserList;

    @ApiModelProperty(value = "二维码", name = "qrCode", example = "1")
    private String qrCode;

    @ApiModelProperty(value = "访客码", name = "visitorCode", example = "1")
    private String visitorCode;

    @ApiModelProperty(value = "邀约详情", name = "invitationExplain", example = "1")
    private String invitationExplain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getInternalStaffUserId() {
        return internalStaffUserId;
    }

    public void setInternalStaffUserId(Long internalStaffUserId) {
        this.internalStaffUserId = internalStaffUserId;
    }

    public String getInternalStaffUserName() {
        return internalStaffUserName;
    }

    public void setInternalStaffUserName(String internalStaffUserName) {
        this.internalStaffUserName = internalStaffUserName;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public VisitorRegistration getRegistration() {
        return registration;
    }

    public void setRegistration(VisitorRegistration registration) {
        this.registration = registration;
    }

    public VisitorSource getSource() {
        return source;
    }

    public void setSource(VisitorSource source) {
        this.source = source;
    }

    public LocalDateTime getAppointmentSartTime() {
        return appointmentSartTime;
    }

    public void setAppointmentSartTime(LocalDateTime appointmentSartTime) {
        this.appointmentSartTime = appointmentSartTime;
    }

    public LocalDateTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public VisitCause getVisitCause() {
        return visitCause;
    }

    public void setVisitCause(VisitCause visitCause) {
        this.visitCause = visitCause;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public Date getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(Date visitingTime) {
        this.visitingTime = visitingTime;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public VisitorStatus getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(VisitorStatus visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    public String getInternalStaffUserTel() {
        return internalStaffUserTel;
    }

    public void setInternalStaffUserTel(String internalStaffUserTel) {
        this.internalStaffUserTel = internalStaffUserTel;
    }

    public String getInternalStaffUserStation() {
        return internalStaffUserStation;
    }

    public void setInternalStaffUserStation(String internalStaffUserStation) {
        this.internalStaffUserStation = internalStaffUserStation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<VisitFollowUser> getFollowUserList() {
        return followUserList;
    }

    public void setFollowUserList(List<VisitFollowUser> followUserList) {
        this.followUserList = followUserList;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getVisitorCode() {
        return visitorCode;
    }

    public void setVisitorCode(String visitorCode) {
        this.visitorCode = visitorCode;
    }

    public String getInvitationExplain() {
        return invitationExplain;
    }

    public void setInvitationExplain(String invitationExplain) {
        this.invitationExplain = invitationExplain;
    }

    public String getVisitStatusName() {
        return visitStatusName;
    }

    public void setVisitStatusName(String visitStatusName) {
        this.visitStatusName = visitStatusName;
    }
}
