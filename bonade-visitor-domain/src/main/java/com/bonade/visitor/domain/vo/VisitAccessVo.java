package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(value = "VisitAccessVo", description = "访客准入权限对象")
public class VisitAccessVo {

    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID", name = "enterpriseId", example = "1", required = true)
    @PreventOverflow
    private Long enterpriseId;

    @NotNull(message = "来源不能为空")
    @ApiModelProperty(value = "来源（1、角色权限管理，2、访问信息配置，3、客户权限配置）", name = "source", example = "1", required = true)
    private Integer source;

    @NotNull(message = "属性不能为空")
    @ApiModelProperty(value = "属性（1、一般访客，2、贵宾访客，3、黑名单）", name = "attribute", example = "1", required = true)
    private Integer attribute;

    @ApiModelProperty(value = "进出口门禁和停车场通行权限权限")
    private List<AccessApprovalPermissionVo> accessApprovalPermissionList;

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

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

    public List<AccessApprovalPermissionVo> getAccessApprovalPermissionList() {
        return accessApprovalPermissionList;
    }

    public void setAccessApprovalPermissionList(List<AccessApprovalPermissionVo> accessApprovalPermissionList) {
        this.accessApprovalPermissionList = accessApprovalPermissionList;
    }
}
