package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zoushaopeng
 * @title: VerifyVisitorDetailDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/18 15:23
 */
public class VerifyVisitorDetailDto {

    /**
     * id
     */
    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    /**
     * 访客公司名称
     */
    @ApiModelProperty(value = "访客公司名称", name = "companyName", example = "")
    private String companyName;

    /**
     * 拜访企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "拜访企业ID", name = "enterpriseId", example = "")
    private Long enterpriseId;

    /**
     * 拜访企业名称
     */
    @ApiModelProperty(value = "拜访企业名称", name = "enterpriseName", example = "")
    private String enterpriseName;

    /**
     * 访客姓名
     */
    @ApiModelProperty(value = "访客姓名", name = "name", example = "")
    private String name;

    /**
     * 访问事由
     */
    @ApiModelProperty(value = "访问事由", name = "visitCause", dataType = "VisitCause")
    private VisitCause visitCause;

    /**
     * 访问事由名称
     */
    @ApiModelProperty(value = "访问事由名称", name = "visitCauseName", example = "")
    private String visitCauseName;

    /**
     * 访客预约时间
     */
    @ApiModelProperty(value = "访客预约时间(开始)", name = "appointmentStartTime", example = "")
    private LocalDateTime appointmentStartTime;

    /**
     * 访客预约时间
     */
    @ApiModelProperty(value = "访客预约时间(结束)", name = "appointmentEndTime", example = "")
    private LocalDateTime appointmentEndTime;

    /**
     * 事件详情-审批流程详情
     */
//    @ApiModelProperty(value = "事件详情-审批流程详情", name = "VerifyVisitorApprovalDetailList", example = "")
//    private List<VerifyVisitorApprovalDetailDto> verifyVisitorApprovalDetailList;

    @ApiModelProperty(value = "事件详情", name = "verifyVisitorBehaviorTraceDetailList", example = "")
    private List<VerifyVisitorBehaviorTraceDetailDto> verifyVisitorBehaviorTraceDetailList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

//    public List<VerifyVisitorApprovalDetailDto> getVerifyVisitorApprovalDetailList() {
//        return verifyVisitorApprovalDetailList;
//    }
//
//    public void setVerifyVisitorApprovalDetailList(List<VerifyVisitorApprovalDetailDto> verifyVisitorApprovalDetailList) {
//        this.verifyVisitorApprovalDetailList = verifyVisitorApprovalDetailList;
//    }


    public List<VerifyVisitorBehaviorTraceDetailDto> getVerifyVisitorBehaviorTraceDetailList() {
        return verifyVisitorBehaviorTraceDetailList;
    }

    public void setVerifyVisitorBehaviorTraceDetailList(List<VerifyVisitorBehaviorTraceDetailDto> verifyVisitorBehaviorTraceDetailList) {
        this.verifyVisitorBehaviorTraceDetailList = verifyVisitorBehaviorTraceDetailList;
    }
}
