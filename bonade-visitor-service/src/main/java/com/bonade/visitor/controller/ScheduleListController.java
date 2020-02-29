package com.bonade.visitor.controller;

import java.util.List;

import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.PostApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonade.visitor.domain.entity.ScheduleList;
import com.bonade.visitor.domain.vo.CheckedScheduleVo;
import com.bonade.visitor.domain.vo.ScheduleIdVo;
import com.bonade.visitor.domain.vo.ScheduleListVo;
import com.bonade.visitor.domain.vo.ScheduleVo;
import com.bonade.visitor.service.ScheduleListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName:  ScheduleListController   
 * @Description:日程清单
 * @author: lcq 
 * @date:   2019年12月27日 下午2:42:19   
 * @version 1.0
 */
@RestController
@RequestMapping("v1/visit/schedule")
@Api(value = "日程清单", tags = "日程清单相关接口")
public class ScheduleListController {
	
	@Autowired
	private ScheduleListService scheduleListService;
	
	
	@PostApi(value = "/scheduleList", auth = AuthLevel.NONE)
	@ApiOperation(value = "日程清单", notes = "日程清单列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "企业id", example = "1", dataType = "Long") })
	public List<ScheduleList> scheduleList(@Validated @RequestBody ScheduleListVo vo) {
		return scheduleListService.scheduleList(vo);
	}
	
	@PostApi(value = "/scheduleDetail", auth = AuthLevel.NONE)
	@ApiOperation(value = "日程清单详情", notes = "日程清单详情")
	public ScheduleList scheduleDetail(@Validated @RequestBody ScheduleIdVo vo) {
		return scheduleListService.scheduleDetail(vo.getScheduleId());
	}
	
	@PostApi(value = "/addSchedule", auth = AuthLevel.NONE)
	@ApiOperation(value = "添加日程", notes = "添加日程")
	public void scheduleList(@Validated @RequestBody ScheduleVo vo) {
		scheduleListService.addSchedule(vo);
	}
	
	@PostApi(value = "/delSchedule", auth = AuthLevel.NONE)
	@ApiOperation(value = "删除日程", notes = "删除日程")
	public void delSchedule(@Validated @RequestBody ScheduleIdVo vo) {
		scheduleListService.delSchedule(vo.getScheduleId());
	}
	
	@PostApi(value = "/checkedSchedule", auth = AuthLevel.NONE)
	@ApiOperation(value = "选中日程", notes = "选中日程")
	public void checkedSchedule(@Validated @RequestBody CheckedScheduleVo vo) {
		scheduleListService.checkedSchedule(vo.getScheduleId(),vo.getChecked());
	}
	
	@PostApi(value = "/scheduleRemind", auth = AuthLevel.NONE)
	@ApiOperation(value = "日程提醒任务", notes = "日程提醒任务")
	public void scheduleRemind() {
		scheduleListService.scheduleRemind();
	}

}
