package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.enums.AscriptionType;
import com.bonade.visitor.domain.enums.GuardStatus;
import com.bonade.visitor.domain.enums.GuardType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @description 区域VO
 * @author chenmeng
 * @date 2019-12-26 9:11
*/
@ApiModel(value = "GuardInVo", description = "访问入参vo")
public class GuardOutVo implements VoEntityMapper<GuardOutVo, Abnormal> {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "门禁名称", name = "name", example = "", required = true)
    private String name;

    @ApiModelProperty(value = "设备sn", name = "sn", example = "", required = true)
    private String sn;

    @PreventOverflow
    @ApiModelProperty(value = "区域id", name = "areaId", example = "", required = true)
    private Long areaId;

    @ApiModelProperty(value = "区域名称", name = "areaName", example = "", required = true)
    private String areaName;

    @ApiModelProperty(value = "关联运维人员", name = "userName", example = "", required = true)
    private String userName;

    @PreventOverflow
    @ApiModelProperty(value = "关联运维人员id", name = "userId", example = "", required = true)
    private Long userId;

    @ApiModelProperty(value = "运行状态", name = "status", example = "", required = true)
    private GuardStatus status;

    @ApiModelProperty(value = "运行状态描述", name = "statusDesc", example = "", required = true)
    private String statusDesc;

    @ApiModelProperty(value = "门禁类型", name = "current")
    private GuardType guardType;

    @ApiModelProperty(value = "归属类别", name = "ascriptionType")
    private AscriptionType ascriptionType;

    @ApiModelProperty(value = "归属类别名称", name = "ascriptionTypeName")
    private String ascriptionTypeName;

    @ApiModelProperty(value = "门禁类型名称", name = "guardTypeName")
    private String guardTypeName;

    @PreventOverflow
    @ApiModelProperty(value = "准入规则id",name = "roleId")
    private Long roleId;

    @ApiModelProperty(value = "准入规则名称",name = "roleName")
    private String roleName;

    @ApiModelProperty(value = "准入规则详情",name = "accessRuleVo")
    private AccessRuleVo accessRuleVo;

    @ApiModelProperty(value = "区域类型 1园区区域 2企业区域", name = "areaType")
    private Integer areaType;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public GuardStatus getStatus() {
        return status;
    }

    public void setStatus(GuardStatus status) {
        this.status = status;
        if(status!=null)
            this.statusDesc=status.getDescription();
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public GuardType getGuardType() {
        return guardType;
    }

    public void setGuardType(GuardType guardType) {
        this.guardType = guardType;
    }

    public AccessRuleVo getAccessRuleVo() {
        return accessRuleVo;
    }

    public void setAccessRuleVo(AccessRuleVo accessRuleVo) {
        this.accessRuleVo = accessRuleVo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public String getGuardTypeName() {
        return guardTypeName;
    }

    public void setGuardTypeName(String guardTypeName) {
        this.guardTypeName = guardTypeName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public AscriptionType getAscriptionType() {
        return ascriptionType;
    }

    public void setAscriptionType(AscriptionType ascriptionType) {
        this.ascriptionType = ascriptionType;
    }

    public String getAscriptionTypeName() {
        return ascriptionTypeName;
    }

    public void setAscriptionTypeName(String ascriptionTypeName) {
        this.ascriptionTypeName = ascriptionTypeName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
