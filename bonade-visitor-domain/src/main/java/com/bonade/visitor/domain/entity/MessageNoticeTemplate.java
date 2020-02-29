package com.bonade.visitor.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bonade.visitor.domain.enums.NoticeType;
import org.spin.common.db.entity.AbstractEntity;

/**
 * @author chenmeng
 * @description 消息通知
 * @date 2019-12-10 13:41
 */
@TableName("vms_message_notice_template")
public class MessageNoticeTemplate extends AbstractEntity {

    /**
     * 模板名称
     */
    private String name;

    /**
     * 通知类型
     */
    private NoticeType noticeType;

    /**
     * 模板编码
     */
    private String code;

    /**
     * 启用状态 0关闭 1启用
     */
    private Integer status;

    /**
     * 跳转方式 0不支持 1支持
     */
    private Integer jumpModes;

    /**
     * 网页url
     */
    private String webUrl;

    /**
     * 通知标题
     */
    private String title;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 企业id
     */
    private Long enterpriseId;

    /**
     * 是否全员 1全员 2指定用户
     */
    private Integer allUser;


    /**
     * 全选 0未选择 1已选择
     */
    private Integer allChoose;

    /**
     * 微信公共号 0未选择 1已选择
     */
    private Integer wechat;

    /**
     * 手机短信 0未选择 1已选择
     */
    private Integer shortMessage;

    /**
     * 小程序站内信 0未选择 1已选择
     */
    private Integer emaill;

    /**
     * 伯纳德IM 0未选择 1已选择
     */
    private Integer bndIm;

    /**
     * 一般访客自动同步
     */
    private Integer plainSync;

    /**
     * 贵宾访客自动同步
     */
    private Integer vipSync;

    /**
     * 黑名单访客自动同步
     */
    private Integer blackSync;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getJumpModes() {
        return jumpModes;
    }

    public void setJumpModes(Integer jumpModes) {
        this.jumpModes = jumpModes;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getAllUser() {
        return allUser;
    }

    public void setAllUser(Integer allUser) {
        this.allUser = allUser;
    }

    public Integer getAllChoose() {
        return allChoose;
    }

    public void setAllChoose(Integer allChoose) {
        this.allChoose = allChoose;
    }

    public Integer getWechat() {
        return wechat;
    }

    public void setWechat(Integer wechat) {
        this.wechat = wechat;
    }

    public Integer getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(Integer shortMessage) {
        this.shortMessage = shortMessage;
    }

    public Integer getEmaill() {
        return emaill;
    }

    public void setEmaill(Integer emaill) {
        this.emaill = emaill;
    }

    public Integer getBndIm() {
        return bndIm;
    }

    public void setBndIm(Integer bndIm) {
        this.bndIm = bndIm;
    }

    public Integer getPlainSync() {
        return plainSync;
    }

    public void setPlainSync(Integer plainSync) {
        this.plainSync = plainSync;
    }

    public Integer getVipSync() {
        return vipSync;
    }

    public void setVipSync(Integer vipSync) {
        this.vipSync = vipSync;
    }

    public Integer getBlackSync() {
        return blackSync;
    }

    public void setBlackSync(Integer blackSync) {
        this.blackSync = blackSync;
    }
}
