package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.NoticeType;
import com.bonade.visitor.domain.enums.RelationType;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author chenmeng
 * @description 消息通知访客或用户保存
 * @date 2019-12-10 13:41
 */
public class MessageNoticeUserInVo {

    @ApiModelProperty(value = "消息模板id", name = "messageId", example = "", required = true)
    private Long messageId;

    @ApiModelProperty(value = "访客id列表", name = "visitorId", example = "")
    private List<Long> visitorIdList;

    @ApiModelProperty(value = "需要删除访客id列表", name = "delVisitorIdList", example = "")
    private List<Long> delVisitorIdList;

    @ApiModelProperty(value = "内部用户id列表", name = "userId", example = "")
    private List<Long> userIdList;

    @ApiModelProperty(value = "需要删除内部用户id列表", name = "delUserIdList", example = "")
    private List<Long> delUserIdList;

    @ApiModelProperty(value = "访客类型列表", name = "visitorAttributeList", example = "")
    private List<VisitorAttribute> visitorAttributeList;

    @ApiModelProperty(value = "是否全选 1是 0否", name = "isAll", example = "")
    private Integer isAll;

    @ApiModelProperty(value = "是否自动同步 1是 0否", name = "autoSync", example = "")
    private Integer autoSync;

    @ApiModelProperty(value = "员工类型 1部门 2岗位 3自定义组织", name = "staffType", example = "")
    private RelationType staffType;

    @ApiModelProperty(value = "员工类型关联id", name = "typeId", example = "")
    private Long typeId;

    @ApiModelProperty(value = "删除全部访客 1全部删除", name = "delAllVisit", example = "")
    private Integer delAllVisit;

    @ApiModelProperty(value = "删除全部用户 1全部删除", name = "delAllUser", example = "")
    private Integer delAllUser;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public List<Long> getVisitorIdList() {
        return visitorIdList;
    }

    public void setVisitorIdList(List<Long> visitorIdList) {
        this.visitorIdList = visitorIdList;
    }

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

    public List<VisitorAttribute> getVisitorAttributeList() {
        return visitorAttributeList;
    }

    public void setVisitorAttributeList(List<VisitorAttribute> visitorAttributeList) {
        this.visitorAttributeList = visitorAttributeList;
    }

    public Integer getIsAll() {
        return isAll;
    }

    public void setIsAll(Integer isAll) {
        this.isAll = isAll;
    }

    public Integer getAutoSync() {
        return autoSync;
    }

    public void setAutoSync(Integer autoSync) {
        this.autoSync = autoSync;
    }

    public RelationType getStaffType() {
        return staffType;
    }

    public void setStaffType(RelationType staffType) {
        this.staffType = staffType;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public List<Long> getDelVisitorIdList() {
        return delVisitorIdList;
    }

    public void setDelVisitorIdList(List<Long> delVisitorIdList) {
        this.delVisitorIdList = delVisitorIdList;
    }

    public List<Long> getDelUserIdList() {
        return delUserIdList;
    }

    public void setDelUserIdList(List<Long> delUserIdList) {
        this.delUserIdList = delUserIdList;
    }

    public Integer getDelAllVisit() {
        return delAllVisit;
    }

    public void setDelAllVisit(Integer delAllVisit) {
        this.delAllVisit = delAllVisit;
    }

    public Integer getDelAllUser() {
        return delAllUser;
    }

    public void setDelAllUser(Integer delAllUser) {
        this.delAllUser = delAllUser;
    }
}
