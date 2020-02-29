package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @ClassName:  VisitAuthentication   
 * @Description:visit_authentication
 * @author: lcq 
 * @date:   2019年12月10日 下午4:10:38   
 * @version 1.0
 */
@TableName("vms_visit_authentication")
public class VisitAuthentication extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 来访记录id
	 */
	private Long visitRecordId;

	/**
	 * 门卫/安防人员用户id
	 */
	private Long guardUserId;

	/**
	 * 门卫/安防人员用户姓名
	 */
	private String guardUserName;

	/**
	 * 身份证验证：1正确，2异常
	 */
	private Integer cardCheck;

	/**
	 * 数字码验证：1正确，2异常
	 */
	private Integer codeCheck;

    /**
     * 通行状态：1允许通行，2拒绝通行
     */
    private Integer passStatus;

	/**
	 * 拒绝通行原因：1信息异常，2事务延迟，3危险关系人，4其他
	 */
	private Integer refusalReason;

	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

	public Long getGuardUserId() {
		return guardUserId;
	}

	public void setGuardUserId(Long guardUserId) {
		this.guardUserId = guardUserId;
	}

	public String getGuardUserName() {
		return guardUserName;
	}

	public void setGuardUserName(String guardUserName) {
		this.guardUserName = guardUserName;
	}

	public Integer getCardCheck() {
		return cardCheck;
	}

	public void setCardCheck(Integer cardCheck) {
		this.cardCheck = cardCheck;
	}

	public Integer getCodeCheck() {
		return codeCheck;
	}

	public void setCodeCheck(Integer codeCheck) {
		this.codeCheck = codeCheck;
	}

	public Integer getPassStatus() {
		return passStatus;
	}

	public void setPassStatus(Integer passStatus) {
		this.passStatus = passStatus;
	}

	public Integer getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(Integer refusalReason) {
		this.refusalReason = refusalReason;
	}

	
}
