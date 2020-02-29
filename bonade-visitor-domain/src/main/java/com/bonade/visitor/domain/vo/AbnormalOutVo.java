package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.entity.AbnormalImg;
import com.bonade.visitor.domain.enums.AbnormalCase;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @ClassName: InvitationVo
 * @Description:发起邀约 VO
 * @author: lcq
 * @date: 2019年12月9日 下午3:11:08
 * @version 1.0
 */
@ApiModel(value = "AbnormalOutVo", description = "访问入参vo")
public class AbnormalOutVo implements VoEntityMapper<AbnormalOutVo, Abnormal> {

    @PreventOverflow
    @ApiModelProperty(value = "访客id", name = "visitorId", example = "")
    private Long visitorId;

    @PreventOverflow
    @ApiModelProperty(value = "异常记录id", name = "abnormalId", example = "")
    private Long abnormalId;

    @ApiModelProperty(value = "访客姓名", name = "name", example = "", required = true)
    private String name;

	@ApiModelProperty(value = "公司名称", name = "companyName", example = "", required = true)
	private String companyName;

	@ApiModelProperty(value = "担任岗位", name = "userStation", example = "", required = true)
	private String userStation;

	@ApiModelProperty(value = "手机号码", name = "tel", example = "", required = true)
	private String tel;

	@ApiModelProperty(value = "身份证号码", name = "cartNo", example = "", required = true)
	private String cartNo;

    @ApiModelProperty(value = "车牌号", name = "carNo", example = "", required = true)
    private String carNo;

    @ApiModelProperty(value = "异常原因", name = "abnormalCase", example = "", required = true)
	private AbnormalCase abnormalCase;

	@ApiModelProperty(value = "访客属性", name = "visitorAttribute", example = "", required = true)
	private VisitorAttribute visitorAttribute;

	@ApiModelProperty(value = "异常位置名称", name = "abnormalAreaName", example = "", required = true)
	private String abnormalAreaName;

    @ApiModelProperty(value = "异常区域类型 1园区异常通行 2企业异常通行", name = "abnormalType", example = "", required = true)
    private Long abnormalType;

    @PreventOverflow
    @ApiModelProperty(value = "异常区域id", name = "abnormalAreaId", example = "", required = true)
	private Long abnormalAreaId;

    @ApiModelProperty(value = "异常图片", name = "abnormalImgVoList", example = "", required = true)
	List<AbnormalImgVo> abnormalImgVoList;

    @ApiModelProperty(value = "访客属性中文描述", name = "visitorAttributeDesc", example = "", required = true)
    private String visitorAttributeDesc;

    @ApiModelProperty(value = "异常凭证捕图列表", name = "imgBtList", example = "", required = true)
    List<String> imgBtList;

    @ApiModelProperty(value = "预约申请异常信息图像", name = "imgYyList", example = "", required = true)
    List<String> imgYyList;

    @PreventOverflow
    @ApiModelProperty(value = "通行记录id", name = "recordId", example = "")
    private Long recordId;

    @ApiModelProperty(value = "签入时间", name = "inTime", example = "1")
    private LocalDateTime inTime;

    @ApiModelProperty(value = "签出时间", name = "outTime", example = "1")
    private LocalDateTime outTime;

    @ApiModelProperty(value = "访客头像", name = "faceImg", example = "")
    private String faceImg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public AbnormalCase getAbnormalCase() {
        return abnormalCase;
    }

    public void setAbnormalCase(AbnormalCase abnormalCase) {
        this.abnormalCase = abnormalCase;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
        if(visitorAttribute!=null)
            visitorAttributeDesc=visitorAttribute.getDescription();
    }

    public String getAbnormalAreaName() {
        return abnormalAreaName;
    }

    public void setAbnormalAreaName(String abnormalAreaName) {
        this.abnormalAreaName = abnormalAreaName;
    }

    public List<AbnormalImgVo> getAbnormalImgVoList() {
        return abnormalImgVoList;
    }

    public void setAbnormalImgVoList(List<AbnormalImgVo> abnormalImgVoList) {
        this.abnormalImgVoList = abnormalImgVoList;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getAbnormalId() {
        return abnormalId;
    }

    public void setAbnormalId(Long abnormalId) {
        this.abnormalId = abnormalId;
    }

    public String getVisitorAttributeDesc() {
        return visitorAttributeDesc;
    }

    public void setVisitorAttributeDesc(String visitorAttributeDesc) {
        this.visitorAttributeDesc = visitorAttributeDesc;
    }

    public List<String> getImgBtList() {
        return imgBtList;
    }

    public void setImgBtList(List<String> imgBtList) {
        this.imgBtList = imgBtList;
    }

    public List<String> getImgYyList() {
        return imgYyList;
    }

    public void setImgYyList(List<String> imgYyList) {
        this.imgYyList = imgYyList;
    }

    public Long getAbnormalAreaId() {
        return abnormalAreaId;
    }

    public void setAbnormalAreaId(Long abnormalAreaId) {
        this.abnormalAreaId = abnormalAreaId;
    }

    public Long getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(Long abnormalType) {
        this.abnormalType = abnormalType;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }
}
