package com.bonade.visitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EnumVo", description = "枚举对象")
public class EnumVo {

    public EnumVo() {
    }

    public EnumVo(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @ApiModelProperty(value = "枚举值", name = "value", example = "1")
    private Integer value;

    @ApiModelProperty(value = "枚举描述", name = "desc")
    private String desc;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
