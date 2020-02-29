package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * description 企业信息
 *
 */
@ApiModel(description = "企业信息")
public class EnterpriseTreeVo implements Serializable {

    private static final long serialVersionUID = -7361784236716331613L;
    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID")
    private Long id;

    /**
     * 上级企业ID
     */
    @ApiModelProperty(value = "父级企业ID")
    private Long parentId;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String name;

    /**
     * 下级企业信息
     */
    @ApiModelProperty(value = "下级企业")
    private List<EnterpriseTreeVo> child;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EnterpriseTreeVo> getChild() {
        return child;
    }

    public void setChild(List<EnterpriseTreeVo> child) {
        this.child = child;
    }
}
