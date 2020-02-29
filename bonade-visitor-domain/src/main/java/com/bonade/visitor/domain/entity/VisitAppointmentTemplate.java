package com.bonade.visitor.domain.entity;

import org.spin.common.db.entity.AbstractEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 访客预约模板
 * @author lqx
 */
@TableName("vms_visit_appointment_template")
public class VisitAppointmentTemplate extends AbstractEntity {

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 来访区域
     */
    private String region = "来访区域";

    /**
     * 被访人姓名
     */
    private String toName = "被访人姓名";

    /**
     * 被访人手机号
     */
    private String toPhone = "被访人手机号";

    /**
     * 被访人事由
     */
    private String toCause = "被访人事由";

    /**
     * 来访日期
     */
    private String dateTime = "来访日期";

    /**
     * 有否随访人员项
     */
    private String followPersonItem = "有否随访人员";

    /**
     * 有否随访人员(1:有，2:无)
     */
    private boolean followPerson;

    private String followPersonInfoItem = "随访人信息录入";

    /**
     * 随访人信息录入是否必选项
     */
    private boolean followPersonInfoItemMust;

    /**
     * 允许添加随访人数
     */
    private Integer followPersonCount;

    /**
     * 是否需现场录入随访人员图像
     */
    private boolean followPersonImg;

    /**
     * 随访人员现场人像是否必须上传(1:必选，2:可选)
     */
    private Integer followPersonImgUpload;

    /**
     * 随访车牌信息
     */
    private String followCarnoItem = "随访车牌信息";

    /**
     * 随访车牌信息是否必选项
     */
    private boolean followCarno;

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
