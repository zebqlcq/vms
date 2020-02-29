package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.entity.GardenArea;
import com.bonade.visitor.domain.entity.GateSentry;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.GardenAreaService;
import com.bonade.visitor.service.GateSentryService;
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
 * @author chenmeng
 * @description 园区区域
 * @date 2020-1-13 9:26
 */
@RestController
@RequestMapping("v1/garden/area")
@Api(value = "园区区域划分")
public class GardenAreaController {

    @Autowired
    private GardenAreaService gardenAreaService;

    @PostApi(value = "/add", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "增加区域")
    public GardenArea area(@Valid @RequestBody GardenAreaInVo vo) {
        return gardenAreaService.addOrUpdateArea(vo);
    }

    @PostApi(value = "/edit", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "修改区域")
    public void edit(@Valid @RequestBody GardenAreaInVo vo) {
        gardenAreaService.addOrUpdateArea(vo);
    }

    @PostApi(value = "/bind", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "注册企业并绑定区域")
    public void bindEnterprise(@Valid @RequestBody GardenAreaInVo vo) {
        gardenAreaService.bindEnterprise(vo);
    }

    @GetApi(value = "/unbind/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "解除企业绑定区域")
    public void bindEnterprise(@PathVariable Long id) {
        gardenAreaService.unbind(id);
    }

    @GetApi(value = "/detail/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "查询详情")
    public GardenAreaOutVo detail(@PathVariable Long id) {
        return gardenAreaService.getDetail(id);
    }

    @PostApi(value = "/page", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取分页列表")
    public IPage<GardenAreaOutVo> page(@Valid @RequestBody GardenAreaInVo vo) {
        return gardenAreaService.getPage(vo);
    }


    @GetApi(value = "/del/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "删除区域")
    public void del(@PathVariable Long id) {
        gardenAreaService.del(id);
    }

    @PostApi(value = "/tree", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "查询园区树")
    public List<GardenAreaOutVo> getAreaList(@Valid @RequestBody GardenAreaInVo vo) {
        return gardenAreaService.getAreaList(vo);
    }

    @PostApi(value = "/enterpriseList", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "查询园区下的企业")
    public GardenAreaOutVo enterpriseList(@Valid @RequestBody GardenAreaInVo vo) {
        return gardenAreaService.getEnterpriseList(vo);
    }


    @GetApi(value = "/list/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取园区下所有可以绑定企业的园区列表 供下拉框使用")
    public List<GardenAreaOutVo> list(@PathVariable Long id) {
        return gardenAreaService.getList(id);
    }

    @GetApi(value = "/detailEnt/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取企业详情")
    public GardenAreaOutVo detailEnt(@PathVariable Long id) {
        return gardenAreaService.getDetailEnt(id);
    }

    @PostApi(value = "/editEnt", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "编辑企业信息")
    public GardenAreaOutVo editEnt(@Valid @RequestBody GardenAreaInVo vo) {
        return gardenAreaService.editEnt(vo);
    }

}
