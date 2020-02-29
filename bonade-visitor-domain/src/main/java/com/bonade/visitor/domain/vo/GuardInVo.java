package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.enums.AscriptionType;
import com.bonade.visitor.domain.enums.GuardStatus;
import com.bonade.visitor.domain.enums.GuardType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * @description 区域VO
 * @author chenmeng
 * @date 2019-12-26 9:11
*/
@ApiModel(value = "GuardInVo", description = "访问入参vo")
public class GuardInVo implements VoEntityMapper<GuardInVo, Abnormal> {

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

    @ApiModelProperty(value = "关联运维人员", name = "userName", example = "", required = true)
    private String userName;

    @PreventOverflow
    @ApiModelProperty(value = "关联运维人员id", name = "userId", example = "", required = true)
    private Long userId;

    @ApiModelProperty(value = "运行状态", name = "status", example = "", required = true)
    private GuardStatus status;

    @ApiModelProperty(value = "每页显示条数，不传默认10", name = "size", example = "10")
    private Long size = 10L;

    @ApiModelProperty(value = "当前页数，不传默认1", name = "current", example = "1")
    private Long current = 1L;

    @ApiModelProperty(value = "门禁类型", name = "guardType")
    private GuardType guardType;

    @ApiModelProperty(value = "归属类别", name = "ascriptionType")
    private AscriptionType ascriptionType;

    @PreventOverflow
    @ApiModelProperty(value = "准入规则", name = "ruleId")
    private Long roleId;


    @ApiModelProperty(value = "区域类型 1园区区域 2企业区域", name = "areaType")
    private Integer areaType;

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

    public GuardType getGuardType() {
        return guardType;
    }

    public void setGuardType(GuardType guardType) {
        this.guardType = guardType;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public AscriptionType getAscriptionType() {
        return ascriptionType;
    }

    public void setAscriptionType(AscriptionType ascriptionType) {
        this.ascriptionType = ascriptionType;
    }

}
