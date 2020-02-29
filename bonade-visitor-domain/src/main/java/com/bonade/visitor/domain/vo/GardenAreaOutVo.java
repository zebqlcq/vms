package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.GardenArea;
import com.bonade.visitor.domain.enums.GardenAreaType;
import com.bonade.visitor.domain.remote.EnterpriseViewVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;
import org.spin.core.gson.annotation.PreventOverflow;

import java.util.List;

/**
 * @description 区域VO
 * @author chenmeng
 * @date 2019-12-26 9:11
*/
@ApiModel(value = "GardenAreaOutVo", description = "园区区域入参vo")
public class GardenAreaOutVo implements VoEntityMapper<GardenAreaOutVo, GardenArea> {

    @PreventOverflow
    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称", name = "enterpriseName", example = "", required = true)
    private String enterpriseName;

    @PreventOverflow
    @ApiModelProperty(value = "父级id", name = "parentId", example = "", required = true)
    private Long parentId;

    @ApiModelProperty(value = "区域名称", name = "name", example = "", required = true)
    private String name;

    @ApiModelProperty(value = "区域位置", name = "areaLocation", example = "", required = true)
    private String areaLocation;

    @ApiModelProperty(value = "负责人姓名", name = "userName", example = "", required = true)
    private String userName;

    @ApiModelProperty(value = "负责人手机号码", name = "tel", example = "", required = true)
    private String tel;

    @ApiModelProperty(value = "创建人", name = "createUsername", example = "", required = true)
    private String createUsername;

    @ApiModelProperty(value = "负责人id", name = "userId", example = "", required = true)
    private Long userId;

    @ApiModelProperty(value = "园区区域类型", name = "gardenAreaType", example = "", required = true)
    private GardenAreaType gardenAreaType;

    @ApiModelProperty(value = "子区域", name = "gardenAreaOutVoList", example = "", required = true)
    private List<GardenAreaOutVo> child;

    @ApiModelProperty(value = "区域负责人姓名", name = "userName", example = "", required = true)
    private String areaUserName;

    @ApiModelProperty(value = "区域负责人手机号码", name = "tel", example = "", required = true)
    private String areaTel;

    @ApiModelProperty(value = "区域负责人id", name = "userId", example = "", required = true)
    private Long areaUserId;

    @ApiModelProperty(value = "企业信息", name = "userId", example = "")
    private EnterpriseViewVo enterpriseViewVo;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public GardenAreaType getGardenAreaType() {
        return gardenAreaType;
    }

    public void setGardenAreaType(GardenAreaType gardenAreaType) {
        this.gardenAreaType = gardenAreaType;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public List<GardenAreaOutVo> getChild() {
        return child;
    }

    public void setChild(List<GardenAreaOutVo> child) {
        this.child = child;
    }

    public String getAreaLocation() {
        return areaLocation;
    }

    public void setAreaLocation(String areaLocation) {
        this.areaLocation = areaLocation;
    }

    public String getAreaUserName() {
        return areaUserName;
    }

    public void setAreaUserName(String areaUserName) {
        this.areaUserName = areaUserName;
    }

    public String getAreaTel() {
        return areaTel;
    }

    public void setAreaTel(String areaTel) {
        this.areaTel = areaTel;
    }

    public Long getAreaUserId() {
        return areaUserId;
    }

    public void setAreaUserId(Long areaUserId) {
        this.areaUserId = areaUserId;
    }

    public EnterpriseViewVo getEnterpriseViewVo() {
        return enterpriseViewVo;
    }

    public void setEnterpriseViewVo(EnterpriseViewVo enterpriseViewVo) {
        this.enterpriseViewVo = enterpriseViewVo;
    }
}
