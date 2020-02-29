package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.enums.NoticeType;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chenmeng
 * @description 消息通知
 * @date 2019-12-10 13:41
 */
public class MessageNoticeTemplateOutVo {

    @ApiModelProperty(value = "id", name = "id", example = "", required = true)
    private Long id;

    @ApiModelProperty(value = "模板名称", name = "name", example = "", required = true)
    private String name;

    /**
     * 通知类型
     */
    @ApiModelProperty(value = "通知类型", name = "noticeType", example = "", required = true)
    private NoticeType noticeType;

    /**
     * 模板编码
     */
    @ApiModelProperty(value = "模板编码", name = "code", example = "", required = true)
    private String code;

    /**
     * 启用状态 0关闭 1启用
     */
    @ApiModelProperty(value = "启用状态 0关闭 1启用", name = "stauts", example = "", required = true)
    private Integer stauts;

    /**
     * 跳转方式 0不支持 1支持
     */
    @ApiModelProperty(value = "跳转方式 0不支持 1支持", name = "jumpModes", example = "", required = true)
    private Integer jumpModes;

    /**
     * 网页url
     */
    @ApiModelProperty(value = "网页url", name = "webUrl", example = "", required = true)
    private String webUrl;


    /**
     * 通知标题
     */
    @ApiModelProperty(value = "通知标题", name = "title", example = "", required = true)
    private String title;

    /**
     * 通知内容
     */
    @ApiModelProperty(value = "通知内容", name = "content", example = "", required = true)
    private String content;

    /**
     * 是否全员 1全员 2指定用户
     */
    @ApiModelProperty(value = "是否全员 1全员 2指定用户", name = "all", example = "", required = true)
    private Integer allUser;

    /**
     * 全选 0未选择 1已选择
     */
    @ApiModelProperty(value = "全选 0未选择 1已选择", name = "allChoose", example = "1")
    private Integer allChoose;

    /**
     * 微信公共号 0未选择 1已选择
     */
    @ApiModelProperty(value = "微信公共号 0未选择 1已选择", name = "wechat", example = "1")
    private Integer wechat;

    /**
     * 手机短信 0未选择 1已选择
     */
    @ApiModelProperty(value = "手机短信 0未选择 1已选择", name = "shortMessage", example = "1")
    private Integer shortMessage;

    /**
     * 小程序站内信 0未选择 1已选择
     */
    @ApiModelProperty(value = "小程序站内信 0未选择 1已选择", name = "emaill", example = "1")
    private Integer emaill;

    /**
     * 伯纳德IM 0未选择 1已选择
     */
    @ApiModelProperty(value = "伯纳德IM 0未选择 1已选择", name = "bndIm", example = "1")
    private Integer bndIm;

    /**
     * 一般访客自动同步 1已选择
     */
    @ApiModelProperty(value = "一般访客自动同步 1已选择", name = "plainSync", example = "1")
    private Integer plainSync;

    /**
     * 贵宾访客自动同步 1已选择
     */
    @ApiModelProperty(value = "贵宾访客自动同步 1已选择", name = "vipSync", example = "1")
    private Integer vipSync;

    /**
     * 黑名单访客自动同步 1已选择
     */
    @ApiModelProperty(value = "黑名单访客自动同步 1已选择", name = "blackSync", example = "1")
    private Integer blackSync;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
