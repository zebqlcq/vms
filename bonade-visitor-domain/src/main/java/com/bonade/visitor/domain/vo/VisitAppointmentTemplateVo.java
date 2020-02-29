package com.bonade.visitor.domain.vo;

import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitAppointmentTemplateVo", description = "访客预约模板对象")
public class VisitAppointmentTemplateVo {

    @ApiModelProperty(value = "访客预约模板ID", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @ApiModelProperty(value = "来访区域", name = "region", example = "来访区域")
    private String region = "来访区域";

    @ApiModelProperty(value = "被访人姓名", name = "toName", example = "被访人姓名")
    private String toName = "被访人姓名";

    @ApiModelProperty(value = "被访人手机号", name = "toPhone", example = "被访人手机号")
    private String toPhone = "被访人手机号";

    @ApiModelProperty(value = "被访人事由", name = "toCause", example = "被访人事由")
    private String toCause = "被访人事由";

    @ApiModelProperty(value = "来访日期", name = "dateTime", example = "来访日期")
    private String dateTime = "来访日期";

    @ApiModelProperty(value = "有否随访人员", name = "followPersonItem", example = "有否随访人员")
    private String followPersonItem = "有否随访人员";

    @ApiModelProperty(value = "有否随访人员", name = "followPerson")
    private boolean followPerson;

    @ApiModelProperty(value = "随访人信息录入", name = "followPersonInfoItem", example = "随访人信息录入")
    private String followPersonInfoItem = "随访人信息录入";

    @ApiModelProperty(value = "随访人信息录入是否必选项", name = "followPersonInfoItemMust", example = "true")
    private boolean followPersonInfoItemMust;

    @ApiModelProperty(value = "允许添加随访人数", name = "followPersonCount", example = "1")
    private Integer followPersonCount;

    @ApiModelProperty(value = "是否需现场录入随访人员图像", name = "followPersonImg", example = "true")
    private boolean followPersonImg;

    @ApiModelProperty(value = "随访人员现场人像是否必须上传(1:必选，2:可选)", name = "followPersonImgUpload", example = "1")
    private Integer followPersonImgUpload;

    @ApiModelProperty(value = "随访车牌信息", name = "followCarnoItem", example = "随访车牌信息")
    private String followCarnoItem = "随访车牌信息";

    @ApiModelProperty(value = "随访车牌信息是否必选项", name = "followCarno", example = "true")
    private boolean followCarno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public String getToCause() {
        return toCause;
    }

    public void setToCause(String toCause) {
        this.toCause = toCause;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFollowPersonItem() {
        return followPersonItem;
    }

    public void setFollowPersonItem(String followPersonItem) {
        this.followPersonItem = followPersonItem;
    }

    public boolean getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(boolean followPerson) {
        this.followPerson = followPerson;
    }

    public String getFollowPersonInfoItem() {
        return followPersonInfoItem;
    }

    public void setFollowPersonInfoItem(String followPersonInfoItem) {
        this.followPersonInfoItem = followPersonInfoItem;
    }

    public boolean isFollowPersonInfoItemMust() {
        return followPersonInfoItemMust;
    }

    public void setFollowPersonInfoItemMust(boolean followPersonInfoItemMust) {
        this.followPersonInfoItemMust = followPersonInfoItemMust;
    }

    public Integer getFollowPersonCount() {
        return followPersonCount;
    }

    public void setFollowPersonCount(Integer followPersonCount) {
        this.followPersonCount = followPersonCount;
    }

    public boolean isFollowPersonImg() {
        return followPersonImg;
    }

    public void setFollowPersonImg(boolean followPersonImg) {
        this.followPersonImg = followPersonImg;
    }

    public Integer getFollowPersonImgUpload() {
        return followPersonImgUpload;
    }

    public void setFollowPersonImgUpload(Integer followPersonImgUpload) {
        this.followPersonImgUpload = followPersonImgUpload;
    }

    public String getFollowCarnoItem() {
        return followCarnoItem;
    }

    public void setFollowCarnoItem(String followCarnoItem) {
        this.followCarnoItem = followCarnoItem;
    }

    public boolean isFollowCarno() {
        return followCarno;
    }

    public void setFollowCarno(boolean followCarno) {
        this.followCarno = followCarno;
    }
}
