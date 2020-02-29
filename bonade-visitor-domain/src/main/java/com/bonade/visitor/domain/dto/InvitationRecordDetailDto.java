package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zoushaopeng
 * @title: InvitationRecordDetailDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/21 11:22
 */
public class InvitationRecordDetailDto {

    /**
     * ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", name = "tel", example = "")
    private String tel;

    /**
     * 访问事由[1-业务洽谈,2-事务办理,10-其他]
     */
    @ApiModelProperty(value = "访问事由[1-业务洽谈,2-事务办理,10-其他]", name = "visitCause", dataType = "VisitCause")
    private VisitCause visitCause;

    /**
     * 访问事由名称
     */
    @ApiModelProperty(value = "访问事由名称", name = "visitCauseName", example = "")
    private String visitCauseName;

    /**
     * 邀约详情
     */
    @ApiModelProperty(value = "邀约详情", name = "invitationExplain", example = "")
    private String invitationExplain;

    /**
     * 访客预约/邀约时间-->来访时间
     */
    @ApiModelProperty(value = "访客预约/邀约时间(开始)-->来访时间", name = "appointmentStartTime", example = "")
    private LocalDateTime appointmentStartTime;

    /**
     * 访客预约/邀约时间
     */
    @ApiModelProperty(value = "访客预约/邀约时间(结束)", name = "appointmentEndTime", example = "")
    private LocalDateTime appointmentEndTime;

    /**
     * 随访人数
     */
    @ApiModelProperty(value = "随访人数", name = "followNum", example = "")
    private Integer followNum;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号", name = "carNum", example = "")
    private String carNum;

    /**
     * 访客属性:1普通访客 2贵宾访客 3黑名单访客
     */
    @ApiModelProperty(value = "访客属性:1普通访客 2贵宾访客 3黑名单访客", name = "visitorAttribute", example = "")
    private VisitorAttribute visitorAttribute;

    /**
     * 访客属性名称
     */
    @ApiModelProperty(value = "访客属性名称", name = "visitorAttributeName", example = "")
    private String visitorAttributeName;

    /**
     * 状态/类型
     */
    @ApiModelProperty(value = "状态/类型[1-待审核, 2-待验证, 3-待拜访,4-待来访,5-已拒绝,6-已拒绝,7-已入场, 8-已完成, 9-访问超时, 10-访问异常,11-通过,12-请求验证,0-撤销邀约,-1 - 撤销预约]", name = "visitStatus", example = "")
    private VisitStatus visitStatus;

    /**
     * 状态名称
     */
    @ApiModelProperty(value = "状态名称", name = "visitStatusName", dataType = "String")
    private String visitStatusName;

    @ApiModelProperty(value = "事件详情", name = "verifyVisitorBehaviorTraceDetailList", example = "")
    private List<VerifyVisitorBehaviorTraceDetailDto> verifyVisitorBehaviorTraceDetailList;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public VisitCause getVisitCause() {
        return visitCause;
    }

    public void setVisitCause(VisitCause visitCause) {
        this.visitCause = visitCause;
    }

    public String getVisitCauseName() {
        return visitCauseName;
    }

    public void setVisitCauseName(String visitCauseName) {
        this.visitCauseName = visitCause != null ? EnumUtil.getByValue(visitCause.getValue(), VisitCause.class, "") : null;
    }

    public String getInvitationExplain() {
        return invitationExplain;
    }

    public void setInvitationExplain(String invitationExplain) {
        this.invitationExplain = invitationExplain;
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public LocalDateTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public String getVisitorAttributeName() {
        return visitorAttributeName;
    }

    public void setVisitorAttributeName(String visitorAttributeName) {
        this.visitorAttributeName = visitorAttribute != null ? EnumUtil.getByValue(visitorAttribute.getValue(), VisitorAttribute.class, "") : null;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public String getVisitStatusName() {
        return visitStatusName;
    }

    public void setVisitStatusName(String visitStatusName) {
        this.visitStatusName = visitStatus != null ? EnumUtil.getByValue(visitStatus.getValue(), VisitStatus.class, "") : null;
    }

    public List<VerifyVisitorBehaviorTraceDetailDto> getVerifyVisitorBehaviorTraceDetailList() {
        return verifyVisitorBehaviorTraceDetailList;
    }

    public void setVerifyVisitorBehaviorTraceDetailList(List<VerifyVisitorBehaviorTraceDetailDto> verifyVisitorBehaviorTraceDetailList) {
        this.verifyVisitorBehaviorTraceDetailList = verifyVisitorBehaviorTraceDetailList;
    }
}
