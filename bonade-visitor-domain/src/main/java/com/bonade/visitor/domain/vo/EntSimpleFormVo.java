package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * description 企业信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/9/3.</p>
 */
@ApiModel(description = "企业注册信息")
public class EntSimpleFormVo implements  Serializable {

    private static final long serialVersionUID = 8757484225335549869L;

    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    @NotBlank(message = "企业名称不能为空")
    private String name;


    /**
     * 企业简介
     */
    @ApiModelProperty(value = "企业简介")
    @NotBlank(message = "企业简介不能为空")
    private String summary;

    /**
     * 企业负责人
     */
    @ApiModelProperty(value = "企业负责人")
    @NotBlank(message = "企业负责人不能为空")
    private String manager;

    /**
     * 企业负责人联系电话
     */
    @ApiModelProperty(value = "企业负责人联系电话")
    @NotBlank(message = "企业负责人联系电话不能为空")
    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号码格式不正确")
    private String managerPhone;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号", required = true)
    @NotNull(message = "版本号不能为空")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
