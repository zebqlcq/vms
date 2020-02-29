package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.vo.AreaInVo;
import com.bonade.visitor.domain.vo.AreaOutVo;
import com.bonade.visitor.service.AreaService;
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

/**
 * @author chenmeng
 * @description 区域
 * @date 2019-12-26 15:08
 */
@RestController
@RequestMapping("v1/area")
@Api(value = "企业区域")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostApi(value = "/add", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "增加区域")
    public void area(@Valid @RequestBody AreaInVo vo) {
        areaService.addOrUpdateArea(vo);
    }

    @PostApi(value = "/edit", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "修改区域")
    public void edit(@Valid @RequestBody AreaInVo vo) {
        areaService.addOrUpdateArea(vo);
    }

    @GetApi(value = "/detail/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "查询详情")
    public AreaOutVo detail(@PathVariable Long id) {
        return areaService.getDetail(id);
    }

    @GetApi(value = "/del/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "删除接口")
    public void del(@PathVariable Long id) {
        areaService.del(id);
    }

    @PostApi(value = "/page", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取分页列表")
    public IPage<AreaOutVo> page(@Valid @RequestBody AreaInVo vo) {
        return areaService.getPage(vo);
    }

    @PostApi(value = "/list", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取不分页列表")
    public List<AreaOutVo> list(@Valid @RequestBody AreaInVo vo) {
        return areaService.getList(vo);
    }

}
