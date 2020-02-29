package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "UserQueryVo", description = "用户")
public class UserQueryVo implements Serializable {

    private static final long serialVersionUID = 7613528884679353782L;

    @PreventOverflow
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;

    @ApiModelProperty(value = "用户姓名", name = "realName")
    private String realName;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName")
    private String enterpriseName;

    @NotBlank(message = "用户手机号码不能为空")
    @ApiModelProperty(value = "手机号码", name = "phone")
    private String phone;

    @PreventOverflow
    @ApiModelProperty(value = "默认绑定员工", name = "defaultEmployee")
    private Long defaultEmployee;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getDefaultEmployee() {
        return defaultEmployee;
    }

    public void setDefaultEmployee(Long defaultEmployee) {
        this.defaultEmployee = defaultEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
