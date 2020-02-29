package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.enums.AreaType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import java.time.LocalDateTime;

/**
 * @description 区域VO
 * @author chenmeng
 * @date 2019-12-26 9:11
*/
@ApiModel(value = "AreaOutVo", description = "访问入参vo")
public class AreaOutVo<L> implements VoEntityMapper<AreaOutVo, Abnormal> {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "区域名称", name = "name", example = "", required = true)
    private String name;

    @ApiModelProperty(value = "区域描述", name = "describe", example = "", required = true)
    private String areaDescribe;

    @ApiModelProperty(value = "区域位置", name = "position", example = "", required = true)
    private String position;

    @ApiModelProperty(value = "创建人", name = "createUsername", example = "", required = true)
    private String createUsername;

    @ApiModelProperty(value = "创建时间", name = "createTime", example = "", required = true)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "区域类型", name = "areaType", example = "", required = true)
    private AreaType areaType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaDescribe() {
        return areaDescribe;
    }

    public void setAreaDescribe(String areaDescribe) {
        this.areaDescribe = areaDescribe;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }
}
