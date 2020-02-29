package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.dto.*;
import com.bonade.visitor.domain.entity.VisitInviteTemplate;
import com.bonade.visitor.domain.entity.VisitRecord;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.VisitRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.PostApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName: VisitRecordController
 * @Description:访客记录
 * @author: lcq
 * @date: 2019年12月9日 下午2:27:23
 * @version 1.0
 */
@RestController
@RequestMapping("v1/visit/record")
@Api(value = "访客记录", tags = "访客记录相关接口")
public class VisitRecordController {

	@Autowired
	private VisitRecordService visitRecordService;

	@PostApi(value = "/getInvitationInit", auth = AuthLevel.NONE)
	@ApiOperation(value = "邀约初始化", notes = "邀约初始化页面")
	public VisitInvitationInitDto getInvitationInit(@Validated @RequestBody EnterpriseIdVo vo) {
		return visitRecordService.getInvitationInit(vo.getEnterpriseId());
	}

	@PostApi(value = "/getInvitationInitOnclick", auth = AuthLevel.NONE)
	@ApiOperation(value = "邀约获取时间、属性事件", notes = "邀约获取时间、属性事件")
	public VisitRecord getInvitationInitOnclick(@Validated @RequestBody InvitationInitOnclickVo vo) {
		return visitRecordService.getInvitationInitOnclick(vo.getEnterpriseId(),vo.getName(),vo.getTel());
	}

	@PostApi(value = "/invitationTemplate", auth = AuthLevel.NONE)
	@ApiOperation(value = "企业邀约模板", notes = "获取企业邀约模板")
	public List<VisitInviteTemplate> invitationTemplate(@Validated @RequestBody EnterpriseIdVo vo) {
		return visitRecordService.invitationTemplate(vo.getEnterpriseId());
	}

	@PostApi(value = "/meetingRoom", auth = AuthLevel.NONE)
	@ApiOperation(value = "企业接待会议室", notes = "获取企业接待会议室")
	public List<?> meetingRoom(@Validated @RequestBody EnterpriseIdVo vo) {
		return visitRecordService.meetingRoom(vo.getEnterpriseId());
	}

	@PostApi(value = "/visitorList", auth = AuthLevel.NONE)
	@ApiOperation(value = "获取企业访客", notes = "获取企业访客")
	public List<Visitor> visitorList(@Validated @RequestBody VisitorListVo vo) {
		return visitRecordService.visitorList(vo);
	}
	
	@PostApi(value = "/visitorCodeList", auth = AuthLevel.NONE)
	@ApiOperation(value = "首字母获取企业访客", notes = "获取企业访客")
	public Map<Object, Object> visitorCodeList(@Validated @RequestBody VisitorListVo vo) {
		return visitRecordService.visitorCodeList(vo);
	}

	@PostApi(value = "invitation", auth = AuthLevel.NONE)
	@ApiOperation(value = "发起邀约")
	@ResponseBody
	public void visitPage(@Validated @RequestBody InvitationVo vo) {
		visitRecordService.invitation(vo);
	}

	@PostApi(value = "visitRecordForGuard", auth = AuthLevel.NONE)
	@ApiOperation(value = "安防人员角色主页-来访记录列表", notes = "安防人员角色主页-来访记录列表")
	public IPage<VisitRecordForGuardDto> visitRecordForGuard(@Validated @RequestBody VisitRecordForGuardVo vo) {
		return visitRecordService.visitRecordForGuard(vo);
	}

	@PostApi(value = "visitRecordForGuardHistory", auth = AuthLevel.NONE)
	@ApiOperation(value = "安防人员历史列表", notes = "安防人员历史列表")
	public IPage<VisitRecordForGuardDto> visitRecordForGuardHistory(@Validated @RequestBody VisitRecordForGuardVo vo) {
		return visitRecordService.visitRecordForGuardHistory(vo);
	}

	@PostApi(value = "/employeeHomePage", auth = AuthLevel.NONE)
	@ApiOperation(value = "员工主页", notes = "员工主页(待审批列表)")
	public EmployeeHomePageDto employeeHomePage(@Validated @RequestBody HomeVo vo) {
		return visitRecordService.employeeHomePage(vo, 0, 0);
	}

	@PostApi(value = "/getVisitRecordDetail", auth = AuthLevel.NONE)
	@ApiOperation(value = "访客记录id对应的具体信息")
	public VisitRecordDetailDto getVisitRecordDetail(@Validated @RequestBody VisitRecordIdVo vo) {
		return visitRecordService.getVisitRecordDetail(vo.getVisitRecordId());
	}

	@PostApi(value = "/loginValidate", auth = AuthLevel.NONE)
	@ApiOperation(value = "宾客登录验证", notes = "宾客登录验证")
	public void loginValidate(@Validated @RequestBody VisitorIdVo vo) {
		visitRecordService.loginValidate(vo.getVisitorId());
	}

	@PostApi(value = "/approval", auth = AuthLevel.NONE)
	@ApiOperation(value = "审批", notes = "员工待审批记录审批")
	public void approval(@Validated @RequestBody ApprovalVo approvalVo) {
		visitRecordService.approval(approvalVo);
	}

	@PostApi(value = "/visitRecordHistory", auth = AuthLevel.NONE)
	@ApiOperation(value = "邀约历史", notes = "员工邀约历史")
	public IPage<VisitRecordDto> visitRecordHistory(@Validated @RequestBody HomeVo vo) {
		return visitRecordService.visitRecordHistory(vo);
	}

	@PostApi(value = "/approvaledByMe", auth = AuthLevel.NONE)
	@ApiOperation(value = "我已审批", notes = "我已审批列表")
	public IPage<VisitRecordDto> approvaledByMe(@Validated @RequestBody HomeVo vo) {
		return visitRecordService.approvaledByMe(vo, null, 0);
	}

	@PostApi(value = "/approvaledCopyMe", auth = AuthLevel.NONE)
	@ApiOperation(value = "抄送我的", notes = "抄送我的列表")
	public IPage<VisitRecordDto> approvaledCopyMe(@Validated @RequestBody HomeVo vo) {
		return visitRecordService.approvaledCopyMe(vo, 1, 1);
	}

	@PostApi(value = "/visitValidate", auth = AuthLevel.NONE)
	@ApiOperation(value = "安防验证", notes = "安防验证")
	public void visitValidate(@Validated @RequestBody VisitValidateVo vo) {
		visitRecordService.visitValidate(vo);
	}

	@PostApi(value = "/visitCancel", auth = AuthLevel.NONE)
	@ApiOperation(value = "撤销邀请", notes = "撤销邀请")
	public void visitCancel(@Validated @RequestBody VisitRecordIdVo vo) {
		visitRecordService.visitCancel(vo.getVisitRecordId());
	}

	@PostApi(value = "/reapply", auth = AuthLevel.NONE)
	@ApiOperation(value = "重新邀约", notes = "重新邀约")
	public void reapply(@Validated @RequestBody VisitRecordIdVo vo) {
		visitRecordService.reapply(vo.getVisitRecordId());
	}

	@PostApi(value = "/visitRemind", auth = AuthLevel.NONE)
	@ApiOperation(value = "拜访提醒", notes = "拜访提醒")
	public void visitRemind() {
		visitRecordService.visitRemind();
	}

	@PostApi(value = "/checkOutRemind", auth = AuthLevel.NONE)
	@ApiOperation(value = "签出提醒", notes = "签出提醒")
	public void checkOutRemind() {
		visitRecordService.checkOutRemind();
	}

	@PostApi(value = "/getEmpConfig", auth = AuthLevel.NONE)
	@ApiOperation(value = "获取员工配置及二维码", notes = "获取员工配置及二维码")
	public RoleConfigDto getEmpConfig(@Validated @RequestBody GetEmpConfigVo vo ) {
		return visitRecordService.getEmpConfig(vo.getUserId());
	}

	@PostApi(value = "/getGuardConfig", auth = AuthLevel.NONE)
	@ApiOperation(value = "获取安防人员配置及二维码", notes = "获取安防人员配置及二维码")
	public RoleConfigDto getGuardConfig(@Validated @RequestBody GetGuardConfigVo vo) {
		return visitRecordService.getGuardConfig(vo.getUserId(), vo.getEnterpriseId());
	}

    @PostApi(value = "/addAppointment", auth = AuthLevel.NONE)
    @ApiOperation(value = "增加预约记录", notes = "增加预约记录")
    public VisitRecord addAppointment(@Validated @RequestBody AppointmentVo vo) {
        return visitRecordService.addAppointment(vo);
    }

}
