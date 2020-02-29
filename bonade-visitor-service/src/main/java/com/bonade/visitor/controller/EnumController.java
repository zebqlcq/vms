package com.bonade.visitor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.spin.common.db.entity.MyBatisEnum;
import org.spin.common.throwable.BizException;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.GetApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("v1/enum")
@Api(value = "查询枚举", tags = "查询枚举")
public class EnumController {

    @GetApi(value = "/{className}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "查询枚举")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "className", value = "类名", example = "com.bonade.visitor.domain.enums.VisitCause", dataType = "String")
    })
    public Map enumMap(@PathVariable("className") String className){

        try {
            Class className1;
            if(className.contains("."))
                className1 = Class.forName(className);
            else
                className1 = Class.forName("com.bonade.visitor.domain.enums."+className);
            return MyBatisEnum.toMap(className1);
        } catch (ClassNotFoundException e) {
            throw new BizException("类名不正确");
        }
    }
}
