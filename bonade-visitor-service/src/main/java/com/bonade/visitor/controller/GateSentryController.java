package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.vo.GardenAreaInVo;
import com.bonade.visitor.domain.vo.GardenAreaOutVo;
import com.bonade.visitor.domain.vo.GateSentryInVo;
import com.bonade.visitor.domain.vo.GateSentryOutVo;
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
import java.util.Map;

/**
 * @author chenmeng
 * @description 园区区域
 * @date 2020-1-13 9:26
 */
@RestController
@RequestMapping("v1/gateSentry")
@Api(value = "门岗")
public class GateSentryController {

    @Autowired
    private GateSentryService gateSentryService;

    @PostApi(value = "/add", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "增加现场门岗")
    public void add(@Valid @RequestBody GateSentryInVo vo) {
        gateSentryService.addOrUpdate(vo);
    }

    @PostApi(value = "/edit", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "修改区域")
    public void edit(@Valid @RequestBody GateSentryInVo vo) {
        gateSentryService.addOrUpdate(vo);
    }

    @GetApi(value = "/detail/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "查询详情")
    public GateSentryOutVo detail(@PathVariable Long id) {
        return gateSentryService.getDetail(id);
    }

    @GetApi(value = "/detailByUserId/{userId}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "查询详情")
    public GateSentryOutVo detailByUserId(@PathVariable Long userId) {
        return gateSentryService.getDetailByUserId(userId);
    }

    @PostApi(value = "/page", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "获取分页列表")
    public IPage<GateSentryOutVo> page(@Valid @RequestBody GateSentryInVo vo) {
        return gateSentryService.getPage(vo);
    }

    @GetApi(value = "/del/{id}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "删除门岗")
    public void del(@PathVariable Long id) {
        gateSentryService.del(id);
    }

    @GetApi(value = "/statistics/{enterpriseId}", auth = AuthLevel.NONE, authors = "陈萌")
    @ApiOperation(value = "统计门岗")
    public Map statistics(@PathVariable Long enterpriseId){
        return gateSentryService.statistics(enterpriseId);
    }
}
