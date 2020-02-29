package com.bonade.visitor.domain.entity;

import java.time.LocalDateTime;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @ClassName:  ScheduleList   
 * @Description:日程清单
 * @author: lcq 
 * @date:   2019年12月27日 下午2:38:00   
 * @version 1.0
 */
@TableName("vms_schedule_list")
public class ScheduleList extends AbstractEntity {

	private static final long serialVersionUID = 132927329383680242L;

	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 手机号
	 */
	private String userTel;
	
	/**
	 * 标题
	 */
	private String scheduleTitle;
	
	/**
	 * 内容
	 */
	private String scheduleContent;
	
	/**
	 * 提醒日期
	 */
	private LocalDateTime reminderDate;
	
	/**
	 * 提醒日期
	 */
	private Integer checked;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public LocalDateTime getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(LocalDateTime reminderDate) {
		this.reminderDate = reminderDate;
	}
	
	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "ScheduleList [userId=" + userId + ", scheduleTitle=" + scheduleTitle + ", scheduleContent="
				+ scheduleContent + ", reminderDate=" + reminderDate + ", checked=" + checked + "]";
	}
}
