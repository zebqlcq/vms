package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.VisitArchiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.GetApi;
import org.spin.common.web.annotation.PostApi;
import org.spin.common.web.view.ModelExcelView;
import org.spin.core.util.excel.ExcelGrid;
import org.spin.core.util.excel.ExcelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("v1/visitArchive")
@Api(value = "访客档案接口", tags = "访客档案接口")
public class VisitArchiveController {

    @Autowired
    VisitArchiveService visitArchiveService;

    @PostApi(value = "/page", auth = AuthLevel.NONE, authors = "李钦显")
    @ResponseBody
    @ApiOperation(value = "访客档案列表", notes = "系统运营台访客信息查询")
    public IPage<VisitArchivePageOutVo> selectVisitorArchivePage(@Valid @RequestBody VisitArchivePageVo pageVo){
        return visitArchiveService.selectVisitorArchivePage(pageVo);
    }

    @PostApi(value = "/page4Enterprise", auth = AuthLevel.NONE, authors = "李钦显")
    @ResponseBody
    @ApiOperation(value = "企业访客档案列表", notes = "企业控制台和企业业务工作站访客档案管理")
    public IPage<Visitor> visitorArchivePage4Enterprise(@Valid @RequestBody VisitArchivePageVo pageVo){
        return visitArchiveService.visitorArchivePage4Enterprise(pageVo);
    }

    @PostApi(auth = AuthLevel.NONE, authors = "李钦显")
    @ResponseBody
    @ApiOperation(value = "新增或更新访客档案")
    public boolean addOrEditVisitArchive(@Valid @RequestBody VisitArchiveVo visitArchiveVo){
        return visitArchiveService.addOrEditVisitArchive(visitArchiveVo);
    }

    @GetApi(value = "/{id}", auth = AuthLevel.NONE, authors = "李钦显")
    @ResponseBody
    @ApiOperation(value = "根据id查询访客档案")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "访客档案id", example = "1", dataType = "long")
    })
    public VisitArchiveDetailVo queryVisitArchiveDetail(@PathVariable("id") Long id){
        return visitArchiveService.queryVisitArchiveDetail(id);
    }

    @GetApi(value = "/{enterpriseId}/{condition}", auth = AuthLevel.NONE, authors = "李钦显")
    @ResponseBody
    @ApiOperation(value = "访客档案统计")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "condition", value = "条件(today:今日,week:本周,month:本月,year:全年)", example = "week", dataType = "string")
    })
    public VisitArchiveStatisticsVo queryVisitArchiveStatistics(
        @PathVariable("enterpriseId") Long enterpriseId,
        @PathVariable("condition") String condition){
        return visitArchiveService.queryVisitArchiveStatistics(enterpriseId, condition);
    }

    @PostApi(value = "/export", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "访客档案导出")
    public ModelExcelView export(@Valid @RequestBody VisitArchiveQueryVo queryVo){
        List<VisitArchivePageOutVo> list = visitArchiveService.selectVisitorArchiveList(queryVo);
        String fileName = "访客档案";
        ExcelGrid excelGrid = ExcelGrid.ofFileName(fileName).appendSheet("访客档案", s ->
           s.appendColumn("名称", "name")
           .appendColumn("访客属性", "visitorAttribute")
           .appendColumn("当属企业", "companyName")
           .appendColumn("当属岗位", "userStation")
           .appendColumn("手机号码", "tel")
           .appendColumn("身份证号码", "cartNo")
        );
        return new ModelExcelView(new ExcelModel(excelGrid, list));
    }
}
