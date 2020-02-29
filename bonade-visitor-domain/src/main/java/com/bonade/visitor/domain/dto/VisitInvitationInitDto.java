package com.bonade.visitor.domain.dto;

import java.util.List;

import com.bonade.visitor.domain.entity.VisitInviteTemplate;
import com.bonade.visitor.domain.entity.Visitor;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName:  VisitInvitationInitDto   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: lcq 
 * @date:   2019年12月25日 下午3:26:51   
 * @version 1.0
 */
public class VisitInvitationInitDto {

	@ApiModelProperty(value = "邀约模板", name = "inviteTemplates", example = "")
	private List<VisitInviteTemplate> inviteTemplates;
	
	@ApiModelProperty(value = "接待会议室", name = "meetingRooms", example = "")
	private List<?> meetingRooms;
	
	@ApiModelProperty(value = "企业访客", name = "visitors", example = "")
	private List<Visitor> visitors;

	public List<VisitInviteTemplate> getInviteTemplates() {
		return inviteTemplates;
	}

	public void setInviteTemplates(List<VisitInviteTemplate> inviteTemplates) {
		this.inviteTemplates = inviteTemplates;
	}

	public List<?> getMeetingRooms() {
		return meetingRooms;
	}

	public void setMeetingRooms(List<?> meetingRooms) {
		this.meetingRooms = meetingRooms;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}
	
}
