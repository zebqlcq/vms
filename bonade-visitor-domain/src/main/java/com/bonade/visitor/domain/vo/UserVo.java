package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;

/**
 * 
 * @ClassName: UserVo
 * @Description:消息接收人vo
 * @author: lcq
 * @date: 2020年1月11日 下午4:02:48
 * @version 1.0
 */
@ApiModel(value = "UserVo", description = "消息接收人vo")
public class UserVo {

	/**
	 * 接收人 用户id
	 */
	private Long userId;
	/**
	 * 接收人手机号
	 */
	private String receiverTel;
	/**
	 * 接收人企业id
	 */
	private Long enterpriseId;
	/**
	 * 接收人企业名称
	 */
	private String enterpriseName;
	/**
	 * 危险影响
	 */
	private String influence;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getReceiverTel() {
		return receiverTel;
	}

	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
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

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}
}
