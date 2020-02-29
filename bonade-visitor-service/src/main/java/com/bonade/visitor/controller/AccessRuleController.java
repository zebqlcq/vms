package com.bonade.visitor.controller;

import com.bonade.visitor.domain.vo.AccessRuleVo;
import com.bonade.visitor.service.AccessRuleService;
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

@RestController
@RequestMapping("v1/accessRule")
@Api(value = "准入规则管理", tags = "准入规则管理")
public class AccessRuleController {

    @Autowired
    AccessRuleService accessRuleService;

    @GetApi(value = "/{enterpriseId}/{source}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "获取准入规则", notes = "企业控制台中如果用户没有保存准入规则，就返回系统运营台下发的准入规则")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "source", value = "来源（1、系统运营台，2、企业控制台）", example = "1", dataType = "int")
    })
    public AccessRuleVo getAccessRule(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("source") Integer source){
        return accessRuleService.getAccessRule(enterpriseId, source, true);
    }

    @GetApi(value = "/only/{enterpriseId}/{source}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "获取企业设置准入规则", notes = "只包含准入规则")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "source", value = "来源（1、系统运营台，2、企业控制台）", example = "1", dataType = "int")
    })
    public AccessRuleVo getAccessRuleOnly(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("source") Integer source){
        return accessRuleService.getAccessRule(enterpriseId, source, false);
    }

    @PostApi(value = "/update", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "修改准入规则")
    public boolean updateAccessRule(@Valid @RequestBody AccessRuleVo accessRuleVo){
        return accessRuleService.updateAccessRule(accessRuleVo);
    }

}
