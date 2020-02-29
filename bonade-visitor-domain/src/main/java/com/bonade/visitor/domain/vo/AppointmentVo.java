package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.VisitCause;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author chenmeng
 * @description 预约VO
 * @date 2020-1-20 9:58
 */
@ApiModel(value = "appointmentVo", description = "访问入参vo")
public class AppointmentVo {

    @NotNull(message = "企业id不能为空")
    @ApiModelProperty(value = "拜访企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @NotBlank(message = "企业名称不能为空")
    @ApiModelProperty(value = "拜访企业名称", name = "enterpriseName", example = "", required = true)
    private String enterpriseName;

    @ApiModelProperty(value = "受访人userId", name = "internalStaffUserId", example = "", required = false)
    private Long internalStaffUserId;

    @ApiModelProperty(value = "受访人员姓名", name = "internalStaffUserName", example = "", required = false)
    private String internalStaffUserName;

    @ApiModelProperty(value = "受访人员手机号", name = "internalStaffUserTel", example = "", required = false)
    private String internalStaffUserTel;

    @NotBlank(message = "访客电话号码不能为空")
    @ApiModelProperty(value = "访客电话号码", name = "visitTel", example = "", required = true)
    private String visitTel;

    @NotBlank(message = "访客姓名不能为空")
    @ApiModelProperty(value = "访客姓名", name = "visitName", example = "", required = true)
    private String visitName;

    @NotNull(message = "访问事由不能为空")
    @ApiModelProperty(value = "访问事由 YWQT(1, \"业务洽谈\"),SWBL(2, \"事务办理\"),QT(10, \"其他\");", name = "visitCause", example = "", required = true)
    private VisitCause visitCause;

    @NotBlank(message = "邀访/预访开始时间不能为空")
    @ApiModelProperty(value = "邀访/预访开始时间", name = "appointmentStartTime", example = "", required = true)
    private String appointmentStartTime;

    @NotBlank(message = "邀访/预访结束时间不能为空")
    @ApiModelProperty(value = "邀访/预访结束时间", name = "appointmentEndTime", example = "", required = true)
    private String appointmentEndTime;

    @ApiModelProperty(value = "随访人数，默认0，最大30", name = "followNum", example = "")
    private Integer followNum = 0;

    @ApiModelProperty(value = "随访人员集合", name = "followUserList", example = "")
    private List<VisitFollowUserVo> followUserList;

    @ApiModelProperty(value = "车牌号", name = "carNum", example = "")
    private String carNum;


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

    public String getInternalStaffUserTel() {
        return internalStaffUserTel;
    }

    public void setInternalStaffUserTel(String internalStaffUserTel) {
        this.internalStaffUserTel = internalStaffUserTel;
    }

    public String getVisitTel() {
        return visitTel;
    }

    public void setVisitTel(String visitTel) {
        this.visitTel = visitTel;
    }

    public VisitCause getVisitCause() {
        return visitCause;
    }

    public void setVisitCause(VisitCause visitCause) {
        this.visitCause = visitCause;
    }

    public String getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(String appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public String getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(String appointmentEndTime) {
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

    public List<VisitFollowUserVo> getFollowUserList() {
        return followUserList;
    }

    public void setFollowUserList(List<VisitFollowUserVo> followUserList) {
        this.followUserList = followUserList;
    }

    public String getVisitName() {
        return visitName;
    }

    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }
}
