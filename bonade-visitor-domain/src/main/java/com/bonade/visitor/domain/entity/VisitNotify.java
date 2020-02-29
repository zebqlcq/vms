package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @ClassName:  VisitNotify   
 * @Description:收件箱通知实体 仅用保存备份，实际运用使用message项目
 * @author: lcq 
 * @date:   2019年12月26日 下午2:24:32   
 * @version 1.0
 */
@TableName("vms_visit_notify")
public class VisitNotify extends AbstractEntity {


	private static final long serialVersionUID = -1248979577380968788L;

	/**
	 * 访客记录id
	 */
	private Long visitRecordId;
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 访客id
	 */
	private Long visitorId;
	
	/**
	 * 通知类型：1紧急事件 2来访事件
	 */
	private Integer notifyType;
	
	/**
	 * 标题
	 */
	private String notifyTitle;
	
	/**
	 * 内容
	 */
	private String notifyContent;
	
	/**
	 * 消息文案
	 */
	private String newsCopy;

	
	public String getNewsCopy() {
		return newsCopy;
	}

	public void setNewsCopy(String newsCopy) {
		this.newsCopy = newsCopy;
	}

	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}

	public Integer getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(Integer notifyType) {
		this.notifyType = notifyType;
	}

	public String getNotifyTitle() {
		return notifyTitle;
	}

	public void setNotifyTitle(String notifyTitle) {
		this.notifyTitle = notifyTitle;
	}

	public String getNotifyContent() {
		return notifyContent;
	}

	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}
	
}
