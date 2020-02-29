package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(value = "RolePermissionVo", description = "角色权限对象")
public class RolePermissionVo {

    @ApiModelProperty(value = "角色ID", name = "id", example = "1")
    @PreventOverflow
    private Long id;

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @NotNull(message = "来源不能为空")
    @ApiModelProperty(value = "来源（1、角色权限管理，2、访问信息配置，3、客户权限配置）", name = "source", example = "1", required = true)
    private Integer source;

    @NotNull(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称", name = "name", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "角色描述", name = "desc", example = "1")
    private String description;

    @ApiModelProperty(value = "曾经来访登记", name = "once", example = "true")
    private boolean once;

    @ApiModelProperty(value = "来访登出", name = "logout", example = "true")
    private boolean logout;

    @ApiModelProperty(value = "刷脸签到", name = "face", example = "true")
    private boolean face;

    @ApiModelProperty(value = "二维码签到", name = "qrCode", example = "true")
    private boolean qrCode;

    @ApiModelProperty(value = "数字码签到", example = "true")
    private boolean numericCode;

    @ApiModelProperty(value = "门禁和审批权限")
    private List<AccessApprovalPermissionVo> accessApprovalPermissionList;

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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnce() {
        return once;
    }

    public void setOnce(boolean once) {
        this.once = once;
    }

    public boolean isLogout() {
        return logout;
    }

    public void setLogout(boolean logout) {
        this.logout = logout;
    }

    public boolean isFace() {
        return face;
    }

    public void setFace(boolean face) {
        this.face = face;
    }

    public boolean isQrCode() {
        return qrCode;
    }

    public void setQrCode(boolean qrCode) {
        this.qrCode = qrCode;
    }

    public boolean isNumericCode() {
        return numericCode;
    }

    public void setNumericCode(boolean numericCode) {
        this.numericCode = numericCode;
    }

    public List<AccessApprovalPermissionVo> getAccessApprovalPermissionList() {
        return accessApprovalPermissionList;
    }

    public void setAccessApprovalPermissionList(List<AccessApprovalPermissionVo> accessApprovalPermissionList) {
        this.accessApprovalPermissionList = accessApprovalPermissionList;
    }
}
