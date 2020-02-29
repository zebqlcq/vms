package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.spin.common.db.entity.AbstractEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: VisitFollowUser
 * @Description:随访人员信息
 * @author: lcq
 * @date: 2019年12月21日 上午8:53:54
 * @version 1.0
 */
@ApiModel(value = "VisitFollowUserVo", description = "入参vo")
public class VisitFollowUserVo extends AbstractEntity {

	private static final long serialVersionUID = 5706945698682123845L;

//	@NotNull(message = "访客记录id不能为空")
//    @ApiModelProperty(value = "访客记录id", name = "visitRecordId", example = "" ,required = true)
//	private Long visitRecordId;

	@NotBlank(message = "随访人姓名不能为空")
    @ApiModelProperty(value = "随访人姓名", name = "userName", example = "" ,required = true)
	private String userName;

	@NotBlank(message = "随访人身份证不能为空")
	@ApiModelProperty(value = "随访人身份证", name = "userIdentityCard", example = "" ,required = true)
	private String userIdentityCard;

    @ApiModelProperty(value = "随访人电话", name = "userTel", example = "")
	private String userTel;

    @ApiModelProperty(value = "用户头像", name = "faceImg", example = "")
    private String faceImg;

//	public Long getVisitRecordId() {
//		return visitRecordId;
//	}
//
//	public void setVisitRecordId(Long visitRecordId) {
//		this.visitRecordId = visitRecordId;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIdentityCard() {
		return userIdentityCard;
	}

	public void setUserIdentityCard(String userIdentityCard) {
		this.userIdentityCard = userIdentityCard;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }
}
