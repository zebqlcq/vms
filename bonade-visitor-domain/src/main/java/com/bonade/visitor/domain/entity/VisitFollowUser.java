package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @ClassName: VisitFollowUser
 * @Description:随访人员信息
 * @author: lcq
 * @date: 2019年12月21日 上午8:53:54
 * @version 1.0
 */
@TableName("vms_follow_user")
public class VisitFollowUser extends AbstractEntity {

	private static final long serialVersionUID = 6687020879370817162L;

	/**
	 * 访客记录id
	 */
	private Long visitRecordId;
	/**
	 * 随访人姓名
	 */
	private String userName;
	/**
	 * 随访人电话
	 */
	private String userTel;

	/**
	 * 随访人身份证
	 */
	private String userIdentityCard;

    /**
     * 用户头像
     */
	private String faceImg;

	public Long getVisitRecordId() {
		return visitRecordId;
	}

	public void setVisitRecordId(Long visitRecordId) {
		this.visitRecordId = visitRecordId;
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

	public String getUserIdentityCard() {
		return userIdentityCard;
	}

	public void setUserIdentityCard(String userIdentityCard) {
		this.userIdentityCard = userIdentityCard;
	}

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }
}
