package com.bonade.visitor.controller;

import com.bonade.visitor.domain.vo.BlacklistInVo;
import com.bonade.visitor.domain.vo.BlacklistOutVo;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.GetApi;
import org.spin.common.web.annotation.PostApi;
import org.spin.common.web.view.ModelExcelView;
import org.spin.core.util.excel.ExcelGrid;
import org.spin.core.util.excel.ExcelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.vo.VisitInVo;
import com.bonade.visitor.domain.vo.VisitOutVo;
import com.bonade.visitor.service.VisitorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-5 11:23
 */

@Controller
@RequestMapping("v1/visit/blacklist")
@Api(value = "访客黑名单访问接口", tags = "访客黑名单访问接口")
public class VisitBlacklistController {

    @Autowired
    private VisitorService visitService;

    @PostApi(auth = AuthLevel.NONE, authors = "陈萌", value = "visitPage")
    @ApiOperation(value = "查询黑名单列表")
    @ResponseBody
    public IPage<BlacklistOutVo> visitPage(@Validated(VisitInVo.Search.class) @RequestBody BlacklistInVo vo){
        return visitService.getVisitPage(vo);
    }

    @GetApi(auth = AuthLevel.NONE,authors = "陈萌",value = "detail/{id}")
    @ApiOperation(value = "查询访客详情")
    @ResponseBody
    public VisitOutVo detail(@PathVariable Long id){
        return visitService.getDetail(id);
    }

    @PostApi(auth = AuthLevel.NONE, authors = "陈萌", value = "addVisitor")
    @ApiOperation(value = "新增访客信息")
    @ResponseBody
    public Visitor addVisitor(@RequestBody VisitInVo vo){
        return visitService.saveOrUpdateVisitor(vo);
    }

    @PostApi(auth = AuthLevel.NONE, authors = "陈萌", value = "updateVisitor")
    @ApiOperation(value = "修改访客信息")
    @ResponseBody
    public Visitor updateVisitor(@Validated(VisitInVo.Update.class) @RequestBody VisitInVo vo){
        return visitService.saveOrUpdateVisitor(vo);
    }

    @PostApi(auth = AuthLevel.NONE, authors = "陈萌", value = "addToBlacklist")
    @ApiOperation(value = "添加到黑名单")
    @ResponseBody
    public Visitor addToBlacklist(@RequestBody BlacklistInVo vo){
        return visitService.addToBlacklist(vo);
    }

    @PostApi(auth = AuthLevel.NONE, authors = "陈萌", value = "removeToBlacklist")
    @ApiOperation(value = "移除黑名单")
    @ResponseBody
    public Visitor removeToBlacklist(@RequestBody VisitInVo vo){
        return visitService.removeToBlacklist(vo);
    }

    @PostApi(auth = AuthLevel.NONE, authors = "陈萌", value = "exportBlacklist")
    @ApiOperation(value = "导出黑名单")
    public ModelExcelView exportBlacklist(@RequestBody BlacklistInVo vo){
        vo.setCurrent(1L);
        vo.setSize(5000L);
        List<BlacklistOutVo> voList = visitService.getVisitPage(vo).getRecords();
        ExcelGrid grid = ExcelGrid.ofFileName("黑名单导出").appendSheet("sheet1",
            s -> {
                s.appendColumn("访客姓名", "name");
                s.appendColumn("监控捕图", "abnormalImg");
                s.appendColumn("登记时间", "blacklistTime");
                s.appendColumn("异常原因", "abnormalCase");
                s.appendColumn("手机号码", "tel");
                s.appendColumn("身份证", "cartNo");
                s.appendColumn("登记时间", "blacklistTime");
                s.appendColumn("登记人", "blacklistOeration");
            });

        return new ModelExcelView(new ExcelModel(grid, voList));
    }




}
