package com.bonade.visitor.controller;

import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.VisitStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

@RestController
@RequestMapping("/v1/statistics")
@Api(value = "访客数据统计", tags = "访客数据统计")
public class VisitStatisticsController {

    @Autowired
    VisitStatisticsService visitStatisticsService;

    @GetApi(value = "/apply/{enterpriseId}/{condition}/{registration}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "申请统计", notes = "适用于统计访客预约申请人次和邀约访客发起人次")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "condition", value = "条件(today:今日,week:本周,month:本月,year:全年)", example = "week", dataType = "string"),
        @ApiImplicitParam(name = "registration", value = "访问类型（1、邀约访客发起人次，2、访客预约申请人次）", example = "1", dataType = "long")
    })
    public ApplyStatisticsVo applyStatistics(
        @PathVariable("enterpriseId") Long enterpriseId,
        @PathVariable("condition") String condition,
        @PathVariable("registration") Integer registration){
        return visitStatisticsService.applyStatistics(enterpriseId, condition, registration);
    }

    @GetApi(value = "/arrive/{enterpriseId}/{condition}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "访客到访人次统计", notes = "统计访客到访人次")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "condition", value = "条件(today:今日,week:本周,month:本月,year:全年)", example = "week", dataType = "string")
    })
    public ArriveOnStatisticsVo arriveOnStatistics(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("condition") String condition){
        return visitStatisticsService.arriveOnStatistics(enterpriseId, condition);
    }

    @GetApi(value = "/addUp/{enterpriseId}/{condition}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "访问累计概况统计", notes = "访问累计概况统计")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "condition", value = "条件(today:今日,week:本周,month:本月,year:全年)", example = "week", dataType = "string")
    })
    public AddUpStatisticsVo addUpStatistics(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("condition") String condition){
        return visitStatisticsService.addUpStatistics(enterpriseId, condition);
    }

    @GetApi(value = "/attr/{enterpriseId}/{condition}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "访客角色占比统计", notes = "访客角色占比统计")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "condition", value = "条件(today:今日,week:本周,month:本月,year:全年)", example = "week", dataType = "string")
    })
    public AttrStatisticsVo attrStatistics(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("condition") String condition){
        return visitStatisticsService.attrStatistics(enterpriseId, condition);
    }

    @GetApi(value = "/cause/{enterpriseId}/{condition}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "来访事由占比统计", notes = "来访事由占比统计")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "condition", value = "条件(today:今日,week:本周,month:本月,year:全年)", example = "week", dataType = "string")
    })
    public VisitCauseStatisticsVo visitCauseStatistics(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("condition") String condition){
        return visitStatisticsService.visitCauseStatistics(enterpriseId, condition);
    }

    @PostApi(value = "/enterprise/employee", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "公司被访次数最多员工统计", notes = "公司被访次数最多员工统计")
    public List<EmployeeStatisticsVo> employeeStatistics(@Valid @RequestBody StatisticsQueryVo statisticsQueryVo){
        return visitStatisticsService.employeeStatistics(statisticsQueryVo);
    }

    @PostApi(value = "/enterprise/dept", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "公司被访次数最多部门统计", notes = "公司被访次数最多部门统计")
    public List<DeptStatisticsOutVo> deptStatistics(@Valid @RequestBody StatisticsQueryVo statisticsQueryVo){
        return visitStatisticsService.deptStatistics(statisticsQueryVo);
    }

    @GetApi(value = "/device/{enterpriseId}/{condition}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "企业硬件设备统计", notes = "企业硬件设备统计")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "condition", value = "条件(today:今日,week:本周,month:本月,year:全年)", example = "week", dataType = "string")
    })
    public DeviceStatisticVo deviceStatistic(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("condition") String condition){
        return visitStatisticsService.deviceStatistic(enterpriseId, condition);
    }
}
