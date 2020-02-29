package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class DeptStatisticsVo {

    private String userDept;

    private Integer rc;

    private LocalDate rq;

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

    public LocalDate getRq() {
        return rq;
    }

    public void setRq(LocalDate rq) {
        this.rq = rq;
    }
}
