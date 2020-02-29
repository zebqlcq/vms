package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * description 企业信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/9/3.</p>
 */
@ApiModel(description = "企业编辑信息（简单信息）")
public class EnterpriseSimpleEditVo implements Serializable {

    private static final long serialVersionUID = -4812130444997624963L;

    /**
     * 企业ID
     */
    @PreventOverflow
    @ApiModelProperty(value = "ID", required = true)
    @NotNull(message = "主键ID不能为空")
    private Long id;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号", required = true)
    @NotNull(message = "版本号不能为空")
    private Integer version;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称", required = true)
    @NotBlank(message = "企业名称不能为空")
    private String name;

    /**
     * 企业简介
     */
    @ApiModelProperty(value = "企业简介", required = true)
    @NotBlank(message = "企业简介不能为空")
    private String summary;

    /**
     * 企业负责人
     */
    @ApiModelProperty(value = "企业负责人", required = true)
    @NotBlank(message = "企业负责人不能为空")
    private String manager;

    /**
     * 企业负责人号码
     */
    @ApiModelProperty(value = "企业负责人号码", required = true)
    @NotBlank(message = "企业负责人号码不能为空")
    private String managerPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
}
