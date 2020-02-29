package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

@ApiModel(value = "DeptStatisticsOutVo", description = "部门统计对象")
public class DeptStatisticsOutVo {

    @ApiModelProperty(value = "部门", name = "userDept", example = "1")
    private String userDept;

    @ApiModelProperty(value = "人次", name = "rc", example = "1")
    private Integer rc;

    @ApiModelProperty(value = "详细统计", name = "deptDetailList")
    private List<DeptStatisticsOutDetailVo> deptDetailList;

    public String getUserDept() {
        return userDept;
    }

    public void setUserDept(String userDept) {
        this.userDept = userDept;
    }

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public List<DeptStatisticsOutDetailVo> getDeptDetailList() {
        return deptDetailList;
    }

    public void setDeptDetailList(List<DeptStatisticsOutDetailVo> deptDetailList) {
        this.deptDetailList = deptDetailList;
    }
}
