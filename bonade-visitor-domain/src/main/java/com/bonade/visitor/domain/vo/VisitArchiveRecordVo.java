package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitArchiveRecordVo", description = "访客访问记录档案对象")
public class VisitArchiveRecordVo {

    @ApiModelProperty(value = "访问记录id", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1")
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName", example = "1")
    private String enterpriseName;

    @ApiModelProperty(value = "关联内部人员", name = "internalStaffUserId", example = "1")
    private Long internalStaffUserId;

    @ApiModelProperty(value = "关联内部人员名称", name = "internalStaffUserName", example = "1")
    private String internalStaffUserName;

    @ApiModelProperty(value = "关联内部人员手机号", name = "internalStaffUserTel", example = "1")
    private String internalStaffUserTel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInternalStaffUserId() {
        return internalStaffUserId;
    }

    public void setInternalStaffUserId(Long internalStaffUserId) {
        this.internalStaffUserId = internalStaffUserId;
    }

    public String getInternalStaffUserName() {
        return internalStaffUserName;
    }

    public void setInternalStaffUserName(String internalStaffUserName) {
        this.internalStaffUserName = internalStaffUserName;
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

    public String getInternalStaffUserTel() {
        return internalStaffUserTel;
    }

    public void setInternalStaffUserTel(String internalStaffUserTel) {
        this.internalStaffUserTel = internalStaffUserTel;
    }
}
