package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * description 员工相关机构信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/12/11.</p>
 */
@ApiModel(description = "企业员工相关机构信息")
public class EmpOrganFormVo implements Serializable {

    private static final long serialVersionUID = -654226840564026882L;

    /**
     * 部门ID
     */
    @NotEmpty(message = "员工部门信息不能为空")
    @ApiModelProperty(value = "员工部门信息", required = true)
    private List<Long> departments;

    /**
     * 岗位ID
     */
    @NotEmpty(message = "员工岗位信息不能为空")
    @ApiModelProperty(value = "员工岗位信息", required = true)
    private List<Long> stations;

    /**
     * 自定义组织ID
     */
    @NotEmpty(message = "员工自定义组织不能为空")
    @ApiModelProperty(value = "员工自定义组织", required = true)
    private List<Long> customOrgans;

    public List<Long> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Long> departments) {
        this.departments = departments;
    }

    public List<Long> getStations() {
        return stations;
    }

    public void setStations(List<Long> stations) {
        this.stations = stations;
    }

    public List<Long> getCustomOrgans() {
        return customOrgans;
    }

    public void setCustomOrgans(List<Long> customOrgans) {
        this.customOrgans = customOrgans;
    }
}
