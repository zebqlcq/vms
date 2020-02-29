package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.AbnormalService;
import io.swagger.annotations.Api;
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
import java.time.LocalDate;
import java.util.List;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-26 9:04
 */
@Controller
@RequestMapping("v1/abnormal/")
@Api(value = "异常通行管理", tags = "异常通行管理")
public class AbnormalController {

    @Autowired
    private AbnormalService abnormalService;

    @GetApi(value = "/area/count/{enterpriseId}/{timeInterval}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "区域通行统计")
    @ResponseBody
    public AreaStatisticsOutVo area(@PathVariable Long enterpriseId,@PathVariable String timeInterval) {
        AreaInVo vo = new AreaInVo();
        vo.setTimeInterval(timeInterval);
        vo.setEnterpriseId(enterpriseId);
        return abnormalService.getAreaNumber(vo);
    }

    @PostApi(value = "/page", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "异常通行列表")
    @ResponseBody
    public IPage<AbnormalOutVo> page(@Valid @RequestBody AbnormalInVo vo) {
        return abnormalService.getAbnormalPage(vo);
    }

    @PostApi(value = "/recordPage", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "访客记录列表")
    @ResponseBody
    public IPage<AbnormalRecordOutVo> recordPage(@Valid @RequestBody AbnormalInVo vo) {
        return abnormalService.getRecordPage(vo);
    }

    @GetApi(value = "/detail/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "详情")
    @ResponseBody
    public AbnormalOutVo detail(@PathVariable Long id) {
        return abnormalService.getDetail(id);
    }

    @GetApi(value = "/visitInfo/{tel}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "详情")
    @ResponseBody
    public VisitOutVo detail(@PathVariable String tel) {
        return abnormalService.getVisitorInfo(tel);
    }

    @PostApi(value = "/add", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "增加或修改异常通行")
    @ResponseBody
    public void add(@Valid @RequestBody AbnormalInVo vo) {
        abnormalService.saveOrUpdate(vo);
    }

    @PostApi(auth = AuthLevel.NONE, authors = "陈萌", value = "exportBlacklist")
    @ApiOperation(value = "导出黑名单")
    public ModelExcelView exportBlacklist(@RequestBody AbnormalInVo vo){
        vo.setCurrent(1L);
        vo.setSize(5000L);
        List<AbnormalOutVo> voList = abnormalService.getAbnormalPage(vo).getRecords();
        ExcelGrid grid = ExcelGrid.ofFileName("黑名单导出").appendSheet("sheet1",
            s -> {
                s.appendColumn("访客姓名", "name");
                s.appendColumn("公司名称", "companyName");
                s.appendColumn("岗位", "userStation");
                s.appendColumn("手机号码", "tel");
                s.appendColumn("身份证", "cartNo");
                s.appendColumn("访客属性", "visitorAttributeDesc");
            });

        return new ModelExcelView(new ExcelModel(grid, voList));
    }

}
