package com.bonade.visitor.controller;

import javax.validation.Valid;

import com.bonade.visitor.domain.vo.*;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.DeleteApi;
import org.spin.common.web.annotation.GetApi;
import org.spin.common.web.annotation.PostApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.entity.VisitInviteTemplate;
import com.bonade.visitor.service.VisitAppointmentTemplateService;
import com.bonade.visitor.service.VisitInviteTemplateService;
import com.bonade.visitor.service.VisitRegisterTemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("v1/visitTemplate")
@Api(value = "访客模板及配置接口", tags = "访客模板及配置接口")
public class VisitTemplateController {

    @Autowired
    VisitRegisterTemplateService visitRegisterTemplateService;

    @Autowired
    VisitAppointmentTemplateService visitAppointmentTemplateService;

    @Autowired
    VisitInviteTemplateService visitInviteTemplateService;

    @PostApi(value = "/registerTemp", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "新增或更新来访登记模板")
    public boolean addOrEditVisitRegisterTemplate(@Valid @RequestBody VisitRegisterTemplateVo visitRegisterTemplateVo){
        return visitRegisterTemplateService.addOrEditVisitRegisterTemplate(visitRegisterTemplateVo);
    }

    @GetApi(value = "/registerTemp/{enterpriseId}/{type}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "根据企业id查询来访登记模板")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "type", value = "类型（1、一般访客模板，2、贵宾访客模板）", example = "1", dataType = "int")
    })
    public VisitRegisterTemplateVo queryVisitRegisterTemplateById(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("type") Integer type){
        return visitRegisterTemplateService.queryVisitRegisterTemplateById(enterpriseId, type);
    }

    @PostApi(value = "/appointmentTemp", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "新增或更新访客预约模板")
    public boolean addOrEditVisitAppointmentTemplate(@Valid @RequestBody VisitAppointmentTemplateVo visitAppointmentTemplateVo){
        return visitAppointmentTemplateService.addOrEditVisitAppointmentTemplate(visitAppointmentTemplateVo);
    }

    @GetApi(value = "/appointmentTemp/{enterpriseId}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "根据企业id查询访客预约模板")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long")
    })
    public VisitAppointmentTemplateVo queryVisitAppointmentTemplateById(@PathVariable("enterpriseId") Long enterpriseId){
        return visitAppointmentTemplateService.queryVisitAppointmentTemplateById(enterpriseId);
    }

    @PostApi(value = "/inviteTemp", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "新增或更新邀约模板")
    public VisitInviteTemplateVo addOrEditVisitInviteTemplate(@Valid @RequestBody VisitInviteTemplateVo visitInviteTemplateVo){
        return visitInviteTemplateService.addOrEditVisitInviteTemplate(visitInviteTemplateVo);
    }

    @PostApi(value = "/inviteTemp/query", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "查询邀约模板", notes = "visitor,company,empid不为空时，返回替换过的邀约内容的模板")
    public VisitInviteTemplateVo queryVisitInviteTemplateById(@Valid @RequestBody InviteTempQueryVo inviteTempQueryVo){
        return visitInviteTemplateService.queryVisitInviteTemplateById(inviteTempQueryVo);
    }

    @PostApi(value = "/inviteTemp/page", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "邀约模板列表")
    public IPage<VisitInviteTemplate> VisitInviteTemplatePage(@RequestBody VisitInviteTemplatePageVo pageVo){
        return visitInviteTemplateService.VisitInviteTemplatePage(pageVo);
    }

    @DeleteApi(value = "/inviteTemp/delete/{id}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "根据id删除邀约模板")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "模板id", example = "1", dataType = "long")
    })
    public boolean deleteVisitInviteTemplate(@PathVariable("id") Long id){
        return visitInviteTemplateService.deleteVisitInviteTemplate(id);
    }

    @GetApi(value = "/inviteTemp/list/{enterpriseId}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "根据企业id查询邀约模板")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long")
    })
    public List<VisitInviteTemplateVo> selectVisitInviteTemplate(@PathVariable("enterpriseId") Long enterpriseId){
        return visitInviteTemplateService.selectVisitInviteTemplate(enterpriseId);
    }
}
