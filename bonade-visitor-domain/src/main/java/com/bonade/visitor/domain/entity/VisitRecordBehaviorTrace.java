package com.bonade.visitor.domain.entity;

import java.time.LocalDateTime;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.EventStatus;
import com.bonade.visitor.domain.enums.VisitStatus;

/**
 * 
 * @ClassName: VisitRecordBehaviorTrace
 * @Description:行为跟踪（来访记录扩展信息）
 * @author: lcq
 * @date: 2019年12月10日 下午4:15:25
 * @version 1.0
 */
@TableName("vms_visit_record_behavior_trace")
public class VisitRecordBehaviorTrace extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 邀约模板id
	 */
	private Long visitRecordId;

	/**
	 * 状态/类型
	 */
	private VisitStatus visitStatus;

	@TableField(exist = false)
	private String visitStatusName;
	/**
	 * 事件时间
	 */
	private LocalDateTime operationTime;
	
	/**
	 * 审批/通行 状态 （1通过  2拒绝）
	 */
	private Integer passStatus;
	@TableField(exist = false)
	private String passStatusName;
	
	/**
     * 审批意见
     */
    private String opinion;
    
    /**
     * 用户id
     */
    private Long userId;
    
    /**
     * 用户姓名
     */
    private String userName;
    
	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
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

	public String getVisitStatusName() {
		return visitStatusName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setVisitStatusName(String visitStatusName) {
		this.visitStatusName = visitStatus != null ? EnumUtil.getByValue(visitStatus.getValue(), EventStatus.class, "") : null;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassStatusName() {
		return passStatusName;
	}

	public void setPassStatusName(String passStatusName) {
		this.passStatusName = passStatusName;
	}
	
}
