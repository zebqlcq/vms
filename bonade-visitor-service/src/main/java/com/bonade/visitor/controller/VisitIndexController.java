package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.dto.*;
import com.bonade.visitor.domain.enums.PermissionRange;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.RolePermissionService;
import com.bonade.visitor.service.VisitAppointmentTemplateService;
import com.bonade.visitor.service.VisitIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Operation;
import org.spin.common.util.RemoteClient;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.GetApi;
import org.spin.common.web.annotation.PostApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author zoushaopeng
 * @title: VisitIndexController
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/23 9:05
 */
@RestController
@RequestMapping("v1/visitIndex")
@Api(value = "访客首页接口", tags = "访客首页接口")
public class VisitIndexController {

    @Autowired
    private VisitAppointmentTemplateService visitAppointmentTemplateService;

    @Autowired
    RolePermissionService permissionService;

    private final VisitIndexService visitIndexService;

    public VisitIndexController(VisitIndexService visitIndexService) {
        this.visitIndexService = visitIndexService;
    }

    @PostApi(value = "getVisitIndexRecordApproalPageList", auth = AuthLevel.NONE)
    @ApiOperation(value = "审批列表(待我审批)查询", notes = "审批列表(待我审批)查询")
    public IPage<VisitIndexRecordApproalDto> getVisitIndexRecordApproalPageList(@Validated @RequestBody VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo) {
        return visitIndexService.getVisitIndexRecordApproalPageList(visitIndexRecordApproalPageVo);
    }

    @PostApi(value = "getVisitIndexRecordAlreadyApproalPageList", auth = AuthLevel.NONE)
    @ApiOperation(value = "审批列表(已审批)查询", notes = "审批列表(已审批)查询")
    public IPage<VisitIndexRecordApproalDto> getVisitIndexRecordAlreadyApproalPageList(@Validated @RequestBody VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo) {
        return visitIndexService.getVisitIndexRecordAlreadyApproalPageList(visitIndexRecordApproalPageVo);
    }

    @PostApi(value = "getVisitIndexRecordCopyApproalPageList", auth = AuthLevel.NONE)
    @ApiOperation(value = "审批列表(抄送我的)查询", notes = "审批列表(抄送我的)查询")
    public IPage<VisitIndexRecordCopyApproalDto> getVisitIndexRecordCopyApproalPageList(@Validated @RequestBody VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo) {
        return visitIndexService.getVisitIndexRecordCopyApproalPageList(visitIndexRecordApproalPageVo);
    }

    @GetApi(value = "getApproalRecordDetail/{id}", auth = AuthLevel.NONE)
    @ApiOperation(value = "发起审批页面查询", notes = "发起审批页面查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "访客记录id", example = "1", dataType = "long")
    })
    public ApproalRecordDetailDto getApproalRecordDetail(@PathVariable Long id) {
        return visitIndexService.getApproalRecordDetail(id);
    }

    @PostApi(value = "getVisitorPageList", auth = AuthLevel.NONE)
    @ApiOperation(value = "访客概况列表查询(系统运营台)", notes = "访客概况列表查询(系统运营台)")
    public IPage<VisitorDto> getVisitorPageList(@Validated @RequestBody VisitorPageVo visitorPageVo) {
        return visitIndexService.getVisitorPageList(visitorPageVo);
    }

    @PostApi(value = "getVisitorEnterprisePageList", auth = AuthLevel.NONE)
    @ApiOperation(value = "访客概况列表查询(企业控制台)", notes = "访客概况列表查询(企业控制台)")
    public IPage<VisitorEnterpriseDto> getVisitorEnterprisePageList(@Validated @RequestBody VisitorEnterprisePageVo visitorEnterprisePageVo) {
        return visitIndexService.getVisitorEnterprisePageList(visitorEnterprisePageVo);
    }

    @GetApi(value = "getVisitorDetail/{visitorId}", auth = AuthLevel.NONE)
    @ApiOperation(value = "查询访客信息详情", notes = "查询访客信息详情")
    public VisitorDetailDto getVisitorDetail(@PathVariable Long visitorId) {
        return visitIndexService.getVisitorDetail(visitorId);
    }

    @GetApi(value = "verifyVisitorDetail/{id}", auth = AuthLevel.NONE)
    @ApiOperation(value = "核实访客信息详情", notes = "核实访客信息详情")
    public VerifyVisitorDetailDto verifyVisitorDetail(@PathVariable Long id) {
        return visitIndexService.verifyVisitorDetail(id);
    }

    @PostApi(value = "verifyVisitorStatus", auth = AuthLevel.NONE)
    @ApiOperation(value = "核实访客访问状态", notes = "核实访客访问状态")
    public void verifyVisitorStatus(@Validated @RequestBody VerifyVisitorStatusVo verifyVisitorStatusVo) {
        visitIndexService.verifyVisitorStatus(verifyVisitorStatusVo);
    }

    @PostApi(value = "getInvitationRecordPageList", auth = AuthLevel.NONE)
    @ApiOperation(value = "邀约记录(企业控制台)", notes = "邀约记录(企业控制台)")
    public IPage<InvitationRecordDto> getInvitationRecordPageList(@Validated @RequestBody InvitationRecordPageVo invitationRecordPageVo) {
        return visitIndexService.getInvitationRecordPageList(invitationRecordPageVo);
    }

    @GetApi(value = "getInvitationRecordDetail/{id}", auth = AuthLevel.NONE)
    @ApiOperation(value = "查询进度（邀约记录）", notes = "查询进度（邀约记录）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "访客记录id", example = "1", dataType = "long")
    })
    public InvitationRecordDetailDto getInvitationRecordDetail(@PathVariable Long id) {
        return visitIndexService.getInvitationRecordDetail(id);
    }

    @PostApi(value = "getVisitorValidPageList", auth = AuthLevel.NONE)
    @ApiOperation(value = "访客现场身份验证列表(企业控制台)-当日", notes = "访客现场身份验证列表(企业控制台)-当日")
    public IPage<VisitorValidDto> getVisitorValidPageList(@Validated @RequestBody VisitorValidPageVo visitorValidPageVo) {
        return visitIndexService.getVisitorValidPageList(visitorValidPageVo);
    }

    @GetApi(value = "getVisitorValidDetail/{id}", auth = AuthLevel.NONE)
    @ApiOperation(value = "发起身份验证详情", notes = "发起身份验证详情")
    public VisitorValidDetailDto getVisitorValidDetail(@PathVariable Long id) {
        return visitIndexService.getVisitorValidDetail(id);
    }

    @PostApi(value = "confirmInitiate", auth = AuthLevel.NONE)
    @ApiOperation(value = "发起身份验证", notes = "发起身份验证")
    public void confirmInitiate(@Validated @RequestBody ConfirmInitiateVo confirmInitiateVo) {
        visitIndexService.confirmInitiate(confirmInitiateVo);
    }

    @PostApi(value = "confirmInternalAlarm", auth = AuthLevel.NONE)
    @ApiOperation(value = "发起内部警报", notes = "发起内部警报")
    public void confirmInternalAlarm(@Validated @RequestBody ConfirmInternalAlarmVo confirmInternalAlarmVo) {
        visitIndexService.confirmInternalAlarm(confirmInternalAlarmVo);
    }

    @PostApi(value = "visitInfo", authors = "陈萌", auth = AuthLevel.NONE)
    @ApiOperation(value = "受邀详情，访问码，二维码", notes = "访客概况列表查询(企业控制台)")
    public IPage<VisitRecordVo> visitInfo(@RequestBody VisitInVo vo) {
        return visitIndexService.getVisitInfo(vo);
    }

    @PostApi(value = "addInfo", authors = "陈萌", auth = AuthLevel.NONE)
    @ApiOperation(value = "保存维护访客信息", notes = "访客概况列表查询(企业控制台)")
    public void addInfo(@RequestBody VisitInVo vo) {
        visitIndexService.addInfo(vo);
    }

    @GetApi(value = "getInfo/{tel}", authors = "陈萌", auth = AuthLevel.NONE)
    @ApiOperation(value = "获取访客信息", notes = "访客概况列表查询(企业控制台)")
    public VisitOutVo getInfo(@PathVariable String tel) {
        return visitIndexService.getInfo(tel);
    }

    @GetApi(value = "getInfoById/{id}", authors = "陈萌", auth = AuthLevel.NONE)
    @ApiOperation(value = "通过id获取访客信息", notes = "访客概况列表查询(企业控制台)")
    public VisitOutVo getInfo(@PathVariable Long id) {
        return visitIndexService.getInfoById(id);
    }


    @GetApi(value = "getAppointmentConfig/{id}", auth = AuthLevel.NONE)
    @ApiOperation(value = "获取预约配置", notes = "获取预约配置")
    public Map<String, Object> getAppointmentConfig(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        VisitAppointmentTemplateVo vo = visitAppointmentTemplateService.queryVisitAppointmentTemplateById(id);
        List<Access4VisitorOutVo> voList = permissionService.selectAccess4Visitor(id, 1);
        Optional<Access4VisitorOutVo> optional = voList.stream().filter(a -> a.getPermissionRange().equals(PermissionRange.DATETIME)).findFirst();
        Access4VisitorOutVo access4VisitorOutVo = new Access4VisitorOutVo();
        for (Access4VisitorOutVo v : voList) {
            if (v.getPermissionRange().equals(PermissionRange.DATETIME)) {
                access4VisitorOutVo = v;
                break;
            }
        }
        map.put("VisitAppointmentTemplateVo", vo);
        map.put("access4VisitorOutVo", access4VisitorOutVo);
        return map;
    }


//    @PostApi(value = "visitRecord",authors = "陈萌",auth = AuthLevel.NONE)
//    @ApiOperation(value = "维护访问记录", notes = "维护访问记录")
//    public void visitRecord(@RequestBody VisitInVo vo){
//        visitIndexService.addInfo(vo);
//    }

}
