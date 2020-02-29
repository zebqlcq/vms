package com.bonade.visitor.domain.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.bonade.visitor.domain.enums.*;
import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * description 访客信息表
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
@TableName("vms_visitor")
public class Visitor extends AbstractEntity {

    private static final long serialVersionUID = -7608053631307066822L;

    /**
     * 名称
     */
    private String name;

    /**
     * 访客类型
     */
    private VisitorType visitorType;

    /**
     * 访客属性
     */
    private VisitorAttribute visitorAttribute;

    @TableField(exist = false)
    private String visitorAttributeName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 部门名称
     */
    private String depName;

    /**
     * 职位
     */
    private String userStation;

    /**
     * 手机号码
     */
    private String tel;

    /**
     * 身份证号码
     */
    private String cartNo;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 证件信息图像（正面）
     */
    private String cardNoPositive;

    /**
     * 证件信息图像（反面）
     */
    private String cardNoNegative;

    /**
     * 身份证上传时间
     */
    private LocalDateTime cardUploadTime;

    /**
     * 人脸图像
     */
    private String faceImg;

    /**
     * 人脸图像上传时间
     */
    private LocalDateTime faceImgUploadTime;

    /**
     *
     */
    private VisitorStatus status;

    /**
     * 企业ID
     */
    private Long enterpriseId;

//    /**
//     * 是否黑名单访客 1黑名单 0不是黑名单
//     */
//    private Integer blacklist = 0;

    /**
     * 加入黑名单时间
     */
    private LocalDateTime blacklistTime;

    /**
     * 解除黑名单原因
     */
    private UnBlacklistCause unBlacklistCause;


    /**
     * 异常区域位置
     */
    private Long blackArea;

    /**
     * 黑名单操作人
     */
    private String blacklistOperation;

    /**
     * 黑名单操作人id
     */
    private Long blacklistOperationId;

    /**
     * 是否认证 0未认证 1已认证
     */
    private Integer auth;

    /**
     * 签发机关
     */
    private String signing;

    /**
     * 企业名片
     */
    private String cardImg;

    /**
     * 异常原因
     */
    private AbnormalCase abnormalCase;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VisitorType getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(VisitorType visitorType) {
        this.visitorType = visitorType;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public String getVisitorAttributeName() {
        return visitorAttributeName;
    }

    public void setVisitorAttributeName(String visitorAttributeName) {
        this.visitorAttributeName = visitorAttributeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCardNoPositive() {
		return cardNoPositive;
	}

	public void setCardNoPositive(String cardNoPositive) {
		this.cardNoPositive = cardNoPositive;
	}

	public String getCardNoNegative() {
		return cardNoNegative;
	}

	public void setCardNoNegative(String cardNoNegative) {
		this.cardNoNegative = cardNoNegative;
	}

	public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public VisitorStatus getStatus() {
        return status;
    }

    public void setStatus(VisitorStatus status) {
        this.status = status;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public LocalDateTime getBlacklistTime() {
        return blacklistTime;
    }

    public void setBlacklistTime(LocalDateTime blacklistTime) {
        this.blacklistTime = blacklistTime;
    }


    public LocalDateTime getCardUploadTime() {
        return cardUploadTime;
    }

    public void setCardUploadTime(LocalDateTime cardUploadTime) {
        this.cardUploadTime = cardUploadTime;
    }

    public LocalDateTime getFaceImgUploadTime() {
        return faceImgUploadTime;
    }

    public void setFaceImgUploadTime(LocalDateTime faceImgUploadTime) {
        this.faceImgUploadTime = faceImgUploadTime;
    }

    public UnBlacklistCause getUnBlacklistCause() {
        return unBlacklistCause;
    }

    public void setUnBlacklistCause(UnBlacklistCause unBlacklistCause) {
        this.unBlacklistCause = unBlacklistCause;
    }

	public String getBlacklistOperation() {
		return blacklistOperation;
	}

	public void setBlacklistOperation(String blacklistOperation) {
		this.blacklistOperation = blacklistOperation;
	}

	public Long getBlacklistOperationId() {
		return blacklistOperationId;
	}

	public void setBlacklistOperationId(Long blacklistOperationId) {
		this.blacklistOperationId = blacklistOperationId;
	}

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public String getSigning() {
        return signing;
    }

    public void setSigning(String signing) {
        this.signing = signing;
    }

    public String getCardImg() {
        return cardImg;
    }

    public void setCardImg(String cardImg) {
        this.cardImg = cardImg;
    }

    public Long getBlackArea() {
        return blackArea;
    }

    public void setBlackArea(Long blackArea) {
        this.blackArea = blackArea;
    }

    public AbnormalCase getAbnormalCase() {
        return abnormalCase;
    }

    public void setAbnormalCase(AbnormalCase abnormalCase) {
        this.abnormalCase = abnormalCase;
    }
}
