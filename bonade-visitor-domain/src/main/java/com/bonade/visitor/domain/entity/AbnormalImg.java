package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.AbnormalCase;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import org.spin.common.db.entity.AbstractEntity;

/**
 * description 异常访问记录表
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/4.</p>
 */
@TableName("vms_abnormal_img")
public class AbnormalImg extends AbstractEntity {


    private static final long serialVersionUID = -8684614685695520356L;
    /**
     * 异常记录关联id
     */
    private Long abnormalId;

    /**
     * 异常图片地址
     */
    private String imgUrl;

    /**
     * 异常类型 1异常凭证捕图 2预约申请异常信息图像
     */
    private Integer imgType;

    public Long getAbnormalId() {
        return abnormalId;
    }

    public void setAbnormalId(Long abnormalId) {
        this.abnormalId = abnormalId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }
}
