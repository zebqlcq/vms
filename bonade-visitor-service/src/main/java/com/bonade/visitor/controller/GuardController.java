package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.vo.GuardInVo;
import com.bonade.visitor.domain.vo.GuardOutVo;
import com.bonade.visitor.service.GuardService;
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

/**
 * @author chenmeng
 * @description 门禁管理
 * @date 2019-12-26 15:08
 */
@RestController
@RequestMapping("v1/guard")
@Api(value = "门禁管理")
public class GuardController {

    @Autowired
    private GuardService guardService;

    @PostApi(value = "/add", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "增加门禁")
    public void add(@Valid @RequestBody GuardInVo vo) {
        guardService.addOrUpdateGuard(vo);
    }

    @PostApi(value = "/edit", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "修改门禁")
    public void edit(@Valid @RequestBody GuardInVo vo) {
        guardService.addOrUpdateGuard(vo);
    }

    @GetApi(value = "/detail/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "查询详情")
    public GuardOutVo detail(@PathVariable Long id) {
        return guardService.getDetail(id);
    }

    @GetApi(value = "/del/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "删除")
    public void del(@PathVariable Long id) {
        guardService.del(id);
    }

    @PostApi(value = "/page", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取分页列表")
    public IPage<GuardOutVo> page(@Valid @RequestBody GuardInVo vo) {
        return guardService.getPage(vo);
    }


}
