package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.enums.AbnormalCase;
import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @ClassName: InvitationVo
 * @Description:发起邀约 VO
 * @author: lcq
 * @date: 2019年12月9日 下午3:11:08
 * @version 1.0
 */
@ApiModel(value = "AbnormalRecordOutVo", description = "访客来访记录信息")
public class AbnormalRecordOutVo {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    @ApiModelProperty(value = "区域名称", name = "areaName", example = "")
    private String areaName;

	@ApiModelProperty(value = "来访性质 1内部邀约,2访客预约", name = "companyName", example = "")
	private Integer registration;

	@ApiModelProperty(value = "关联内部人员姓名", name = "internalStaffUserName", example = "")
	private String internalStaffUserName;

	@ApiModelProperty(value = "访问事由", name = "visitCause", example = "")
	private VisitCause visitCause;

	@ApiModelProperty(value = "预约来访时间", name = "appointmentStartTime", example = "")
	private LocalDateTime appointmentStartTime;

    @ApiModelProperty(value = "签入时间", name = "inTime", example = "")
    private LocalDateTime inTime;

    @ApiModelProperty(value = "迁出时间", name = "outTime", example = "")
    private LocalDateTime outTime;

    @ApiModelProperty(value = "审批状态", name = "state", example = "")
    private ApprovalState state;

    @ApiModelProperty(value = "是否存在访问异常 0 不存在 大于0 存在", name = "abnormalCase", example = "")
	private Integer isAbnormal;

	@ApiModelProperty(value = "审批人", name = "approvalName", example = "")
	private String approvalName;

    @ApiModelProperty(value = "访问事由名称", name = "visitCauseName", example = "")
	private String visitCauseName;

    @ApiModelProperty(value = "审批状态名称", name = "stateName", example = "")
    private String stateName;

    @ApiModelProperty(value = "来访性质名称", name = "registrationName", example = "")
    private String registrationName;

    @ApiModelProperty(value = "是否异常名称", name = "isAbnormalName", example = "")
    private String isAbnormalName;

	public String getVisitCauseName(){
	    if(this.visitCause!=null)
	        return visitCause.getDescription();
	    else
	        return "";
    }

    public String getStateName(){
        if(this.state!=null)
            return state.getDescription();
        else
            return "";
    }

    public String getRegistrationName(){
	    if(this.registration==1)
	        return "内部邀约";
	    else if(this.registration==2)
	        return "自主预约";
	    else
	        return "";
    }

    public String getIsAbnormalName(){
	    if(this.isAbnormal==0)
	        return "无";
	    else
	        return "存在";
    }

    public void setVisitCauseName(String visitCauseName) {
        this.visitCauseName = visitCauseName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public void setIsAbnormalName(String isAbnormalName) {
        this.isAbnormalName = isAbnormalName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public String getInternalStaffUserName() {
        return internalStaffUserName;
    }

    public void setInternalStaffUserName(String internalStaffUserName) {
        this.internalStaffUserName = internalStaffUserName;
    }

    public VisitCause getVisitCause() {
        return visitCause;
    }

    public void setVisitCause(VisitCause visitCause) {
        this.visitCause = visitCause;
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public ApprovalState getState() {
        return state;
    }

    public void setState(ApprovalState state) {
        this.state = state;
    }

    public Integer getIsAbnormal() {
        return isAbnormal;
    }

    public void setIsAbnormal(Integer isAbnormal) {
        this.isAbnormal = isAbnormal;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }
}
