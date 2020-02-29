package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.entity.MessageNoticeTemplate;
import com.bonade.visitor.domain.entity.MessageNoticeUser;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.MessageNoticeTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.GetApi;
import org.spin.common.web.annotation.PostApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @description 消息通知配置
 * @author chenmeng
 * @date 2019-12-19 9:20
*/
@RestController
@RequestMapping("v1/notice/template")
@Api(value = "消息通知配置", tags = "消息通知配置")
public class MessageNoticeTemplateController {

    @Autowired
    private MessageNoticeTemplateService messageNoticeTemplateService;

//    @Autowired
//    MessageNoticeTemplateTestService messageNoticeTemplateTestService;

    @PostApi(value = "/save", auth = AuthLevel.AUTHENCATE, authors = "陈萌")
    @ApiOperation(value = "保存或修改消息通知模板")
    public MessageNoticeTemplateOutVo save(@Valid @RequestBody MessageNoticeTemplateInVo vo){
        return messageNoticeTemplateService.saveOrUpdate(vo);
    }

//    @PostApi(value = "/test/save", auth = AuthLevel.NONE, authors = "陈萌")
//    @ApiOperation(value = "保存或修改消息通知模板")
//    public MessageNoticeTemplateOutVo saveTest(@Valid @RequestBody MessageNoticeTemplateInVo vo){
//        return messageNoticeTemplateTestService.saveOrUpdate(vo);
//    }

    @PostApi(value = "/saveVisit", auth = AuthLevel.AUTHENCATE, authors = "陈萌")
    @ApiOperation(value = "保存访客或者用户")
    public void saveVisit(@Valid @RequestBody MessageNoticeUserInVo vo){
        messageNoticeTemplateService.saveUserOrVisitList(vo);
    }

//    @PostApi(value = "/test/saveVisit", auth = AuthLevel.NONE, authors = "陈萌")
//    @ApiOperation(value = "保存访客或者用户-测试")
//    public void saveVisitTest(@Valid @RequestBody MessageNoticeUserInVo vo){
//        messageNoticeTemplateService.saveUserOrVisitList(vo);
//    }

    @GetApi(value = "/detail/{id}",auth = AuthLevel.AUTHENCATE,authors = "陈萌")
    @ApiOperation(value = "获取模板信息")
    public MessageNoticeTemplateOutVo detail(@PathVariable Long id){
        return messageNoticeTemplateService.getById(id);
    }

    @PostApi(value = "/detail/vo", auth = AuthLevel.AUTHENCATE, authors = "陈萌")
    @ApiOperation(value = "通过用户，企业和模板类型获取模板")
    public MessageNoticeTemplate detailByVo(@Valid @RequestBody MessageNoticeUserSerachVo vo){
        return messageNoticeTemplateService.getByVo(vo);
    }

    @PostApi(value = "/detail/test/vo", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "测试使用，通过用户，企业和模板类型获取模板")
    public MessageNoticeTemplate detailByVoTest(@Valid @RequestBody MessageNoticeUserSerachVo vo){
        return messageNoticeTemplateService.getByVo(vo);
    }

    @GetApi(value = "/del/{id}",auth = AuthLevel.AUTHENCATE,authors = "陈萌")
    @ApiOperation(value = "删除模板信息")
    public void del(@PathVariable Long id){
        messageNoticeTemplateService.del(id);
    }

    @PostApi(value = "/page", auth = AuthLevel.AUTHENCATE, authors = "陈萌")
    @ApiOperation(value = "获取模板信息列表分页")
    public IPage<MessageNoticeTemplateOutVo> page(@Valid @RequestBody MessageNoticeTemplateInVo vo){
        return messageNoticeTemplateService.getPage(vo);
    }

    @PostApi(value = "/visitList", auth = AuthLevel.AUTHENCATE, authors = "陈萌")
    @ApiOperation(value = "获取根据企业和模板获取访客")
    public Map<VisitorAttribute, List<NoticeVisitorVo>> visitList(@Valid @RequestBody MessageNoticeUserSerachVo vo){
        return messageNoticeTemplateService.getMessageNoticeVisitorList(vo);
    }

    @PostApi(value = "/test/visitList", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取根据企业和模板获取访客-测试")
    public Map<VisitorAttribute, List<NoticeVisitorVo>> visitListTest(@Valid @RequestBody MessageNoticeUserSerachVo vo){
        return messageNoticeTemplateService.getMessageNoticeVisitorList(vo);
    }

    @PostApi(value = "/userList", auth = AuthLevel.AUTHENCATE, authors = "陈萌")
    @ApiOperation(value = "获取根据企业和模板获取内部用户")
    public List<MessageNoticeUser> userList(@Valid @RequestBody MessageNoticeUserSerachVo vo){
        return messageNoticeTemplateService.getMessageNoticeUserList(vo);
    }

    @PostApi(value = "/noticeUserList", auth = AuthLevel.AUTHENCATE, authors = "陈萌")
    @ApiOperation(value = "查询指定访客或指定内部用户")
    public List<MessageNoticeUser> noticeUserList(@Valid @RequestBody MessageNoticeUserSerachVo vo){
        return messageNoticeTemplateService.getMessageNoticeList(vo);
    }

//    @PostApi(value = "/test/userList", auth = AuthLevel.NONE, authors = "陈萌")
//    @ApiOperation(value = "获取根据企业和模板获取内部用户-测试")
//    public List<NoticeVisitorVo> userListTest(@Valid @RequestBody MessageNoticeUserSerachVo vo){
//        return messageNoticeTemplateService.getMessageNoticeUserList(vo);
//    }

}
