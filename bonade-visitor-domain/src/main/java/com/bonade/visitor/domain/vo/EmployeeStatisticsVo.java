package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EmployeeStatisticsVo", description = "公司被访次数最多员工统计对象")
public class EmployeeStatisticsVo {

    @ApiModelProperty(value = "员工姓名", name = "userName", example = "1")
    private String userName;

    @ApiModelProperty(value = "员工部门", name = "userDept", example = "1")
    private String userDept;

    @ApiModelProperty(value = "被访问人次", name = "rc", example = "1")
    private Integer rc;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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
}
