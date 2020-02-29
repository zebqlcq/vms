package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.NoticeType;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import java.util.List;

/**
 * @author chenmeng
 * @description 消息通知访客或用户查询VO
 * @date 2019-12-10 13:41
 */
public class MessageNoticeUserSerachVo {

    @PreventOverflow
    @ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
    private Long enterpriseId;

    /**
     * 通知类型
     */
    @ApiModelProperty(value = "通知类型", name = "noticeType", example = "", required = true)
    private NoticeType noticeType;

    @ApiModelProperty(value = "访客id", name = "visitorId", example = "")
    private Long visitorId;

    @ApiModelProperty(value = "内部用户id列表", name = "userId", example = "")
    private Long userId;

    @PreventOverflow
    @ApiModelProperty(value = "消息模板id", name = "messageId", example = "")
    private Long messageId;

    @ApiModelProperty(value = "访客类型", name = "userId", example = "")
    private VisitorAttribute visitorAttribute;

    @ApiModelProperty(value = "搜索关键字", name = "keyWord", example = "")
    private String keyWord;

    @ApiModelProperty(value = "员工类型 1部门 2岗位 3自定义组织", name = "staffType", example = "")
    private Integer staffType;

    @ApiModelProperty(value = "标记，1查询指定访客 2查询指定用户", name = "staffType", example = "")
    private Integer flag;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
