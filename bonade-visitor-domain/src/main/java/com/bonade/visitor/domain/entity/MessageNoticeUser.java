package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.NoticeType;
import com.bonade.visitor.domain.enums.RelationType;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import org.spin.common.db.entity.AbstractEntity;

/**
 * @author chenmeng
 * @description 消息通知
 * @date 2019-12-10 13:41
 */
@TableName("vms_message_notice_user")
public class MessageNoticeUser extends AbstractEntity {

    /**
     * 模板id
     */
    private Long messageId;

    /**
     * 消息类型
     */
    private NoticeType noticeType;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 访客id
     */
    private Long visitorId;

    /**
     * 访客类型
     */
    private VisitorAttribute visitorAttribute;

    /**
     * 员工类型
     */
    private RelationType staffType;

    /**
     * 员工类型关联id
     */
    private Long typeId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public VisitorAttribute getVisitorAttribute() {
        return visitorAttribute;
    }

    public void setVisitorAttribute(VisitorAttribute visitorAttribute) {
        this.visitorAttribute = visitorAttribute;
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

}
