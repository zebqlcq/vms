package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.AbnormalCase;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *
 * @ClassName: InvitationVo
 * @Description:发起邀约 VO
 * @author: lcq
 * @date: 2019年12月9日 下午3:11:08
 * @version 1.0
 */
@ApiModel(value = "AbnormalInVo", description = "访问入参vo")
public class AbnormalInVo {

    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @ApiModelProperty(value = "访客id", name = "visitId", example = "", required = true)
    private Long visitId;

    @ApiModelProperty(value = "企业id",name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "园区id",name = "gardenId", example = "", required = true)
    private Long gardenId;

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

	@ApiModelProperty(value = "异常区域id", name = "abnormalAreaId", example = "", required = true)
	private Long abnormalAreaId;

	@ApiModelProperty(value = "异常区域类型 1园区异常通行 2企业异常通行", name = "abnormalType", example = "", required = true)
	private Long abnormalType;

    @ApiModelProperty(value = "异常图片列表", name = "abnormalImgVoList", example = "", required = true)
	List<AbnormalImgVo> abnormalImgVoList;

    @ApiModelProperty(value = "异常凭证捕图列表", name = "imgBtList", example = "", required = true)
    List<String> imgBtList;

    @ApiModelProperty(value = "预约申请异常信息图像", name = "imgYyList", example = "", required = true)
    List<String> imgYyList;

    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    @ApiModelProperty(value = "通行记录id", name = "recordId", example = "1")
    private Long recordId;


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
    }

    public Long getAbnormalAreaId() {
        return abnormalAreaId;
    }

    public void setAbnormalAreaId(Long abnormalAreaId) {
        this.abnormalAreaId = abnormalAreaId;
    }

    public List<AbnormalImgVo> getAbnormalImgVoList() {
        return abnormalImgVoList;
    }

    public void setAbnormalImgVoList(List<AbnormalImgVo> abnormalImgVoList) {
        this.abnormalImgVoList = abnormalImgVoList;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
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

    public Long getGardenId() {
        return gardenId;
    }

    public void setGardenId(Long gardenId) {
        this.gardenId = gardenId;
    }
}
