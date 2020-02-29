package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-24 17:08
 */
public class NoticeVisitorVo implements VoEntityMapper<NoticeVisitorVo, Visitor> {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    @ApiModelProperty(value = "姓名", name = "name", example = "")
    private String name;

    @ApiModelProperty(value = "访客属性", name = "visitorAttribute", example = "")
    private VisitorAttribute visitorAttribute;

    @ApiModelProperty(value = "是否选择 0未选择 1已选择", name = "choose", example = "")
    private Integer choose;

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

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public Integer getChoose() {
        return choose;
    }

    public void setChoose(Integer choose) {
        this.choose = choose;
    }
}
