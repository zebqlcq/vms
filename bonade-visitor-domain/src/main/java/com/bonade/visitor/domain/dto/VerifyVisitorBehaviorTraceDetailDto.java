package com.bonade.visitor.domain.dto;

import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.EventStatus;
import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.enums.VisitorAttribute;

import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @author zoushaopeng
 * @title: VerifyVisitorBehaviorTraceDetailDto
 * @projectName bonade-vms
 * @description:
 * @date 2020/2/20 17:26
 */
public class VerifyVisitorBehaviorTraceDetailDto {

    /**
     * 访客记录ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "访客记录ID", name = "visitRecordId", example = "")
    private Long visitRecordId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "")
    private LocalDateTime createTime;

    /**
     * 状态/类型
     */
    @ApiModelProperty(value = "状态/类型[1-发起预约申请, 2-成功发起邀请, 3-预约审批通过,4-用户已验证邀请,5-预约审批不通过,6-审批拒绝通行,7-签入, 8-签出, 9-访问超时, 10-访问异常,11-审批通行,12-请求验证,0-撤销邀约,-1 - 撤销预约]", name = "visitStatus", example = "")
    private VisitStatus visitStatus;
    
    @ApiModelProperty(value = "状态名称", name = "visitStatus", example = "")
    private String visitStatusName;

    /**
     * 事件时间
     */
    @ApiModelProperty(value = "事件时间", name = "operationTime", example = "")
    private LocalDateTime operationTime;

    /**
     * 1同意  2拒绝
     */
    @ApiModelProperty(value = "1同意  2拒绝", name = "passStatus", example = "")
    private Integer passStatus;

    /**
     * 意见
     */
    @ApiModelProperty(value = "意见", name = "opinion", example = "")
    private String opinion;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名", name = "userName", example = "")
    private String userName;

    public Long getVisitRecordId() {
        return visitRecordId;
    }

    public void setVisitRecordId(Long visitRecordId) {
        this.visitRecordId = visitRecordId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(Integer passStatus) {
        this.passStatus = passStatus;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public String getVisitStatusName() {
		return visitStatusName;
	}

	public void setVisitStatusName(String visitStatusName) {
		this.visitStatusName = visitStatus != null ? EnumUtil.getByValue(visitStatus.getValue(), EventStatus.class, "") : null;
	}
    
}
