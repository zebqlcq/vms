package com.bonade.visitor.domain.entity;

import java.time.LocalDateTime;

import org.spin.common.db.entity.AbstractEntity;
import org.spin.core.gson.annotation.PreventOverflow;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.VisitCause;

/**
 * 
 * @ClassName:  ApprovalDetail   
 * @Description:审批详情(审批人&抄送人) 实体
 * @author: lcq 
 * @date:   2019年12月9日 下午2:42:38   
 * @version 1.0
 */
@TableName("vms_approval_detail")
public class ApprovalDetail extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 审批id
     */
    @PreventOverflow
    private Long approvalId;

    /**
     * 用户id
     */
    @PreventOverflow
    private Long userId;
    
    /**
     * 用户姓名
     */
    private String userName;
    
    /**
     * 用户电话
     */
    private String userTel;

    /**
     * 用户所属企业id
     */
    @PreventOverflow
    private Long organizationId;

    /**
     * 审批人顺序（越小越靠前）
     */
    @PreventOverflow
    private Integer sort;

    /**
     * 类型 0审批人 1抄送人
     */
    private Integer type;

    /**
     * 审批状态 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） 3待阅览（抄送人）4 已阅览（抄送人）
     */
    private ApprovalState state;
    
    /**
     * 审批状态 0待审批（审批人） 1通过（审批人） 2拒绝（审批人） 3待阅览（抄送人）4 已阅览（抄送人）
     */
    private String stateName;

    /**
     * 审批意见
     */
    private String approvalOpinion;

    /**
     * 审批时间
     */
    private LocalDateTime approvalTime;

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public ApprovalState getState() {
		return state;
	}

	public void setState(ApprovalState state) {
		this.state = state;
	}

	public String getApprovalOpinion() {
		return approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	public LocalDateTime getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(LocalDateTime approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = state != null ? EnumUtil.getByValue(state.getValue(), ApprovalState.class, "") : null;
	}
	
}
