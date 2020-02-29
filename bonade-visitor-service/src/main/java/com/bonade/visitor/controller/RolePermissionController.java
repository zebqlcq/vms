package com.bonade.visitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.entity.Role;
import com.bonade.visitor.domain.entity.RoleAccessApprovalPermission;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.service.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.spin.common.web.AuthLevel;
import org.spin.common.web.annotation.GetApi;
import org.spin.common.web.annotation.PostApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/permission")
@Api(value = "角色权限管理", tags = "角色权限管理")
public class RolePermissionController {

    @Autowired
    RolePermissionService permissionService;

    @PostApi(value = "/allocation", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "分配权限", notes = "角色id为空时新增角色并分配权限；如果门禁和审批权限项缺少，则相应权限就会被删除")
    private boolean allocationRolePermission(@Valid @RequestBody RolePermissionVo rolePermissionVo){
        return permissionService.allocationRolePermission(rolePermissionVo);
    }

    @PostApi(value = "/accessTraffic", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "修改通行到访配置")
    public boolean updateAccessTraffic(@Valid @RequestBody AccessTrafficVo trafficVo){
        return permissionService.updateAccessTraffic(trafficVo);
    }

    @GetApi(value = "/accessTraffic/{enterpriseId}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "根据企业id查询通行到访配置")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long")
    })
    public AccessTrafficVo getAccessTraffic(@PathVariable("enterpriseId") Long enterpriseId){
        return permissionService.getAccessTraffic(enterpriseId);
    }

    @PostApi(value = "/visitAccess", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "修改访客准入权限")
    public boolean updateVisitAccess(@RequestBody VisitAccessVo visitAccessVo){
        return permissionService.updateVisitAccess(visitAccessVo);
    }

    @GetApi(value = "/visitAccess/{enterpriseId}/{attribute}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "查询访客准入权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "attribute", value = "属性（1、一般访客，2、贵宾访客，3、黑名单）", example = "1", dataType = "long")
    })
    public List<AccessApprovalPermissionVo> selectVisitAccessPermission(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("attribute") Integer attribute){
        return permissionService.selectVisitAccessPermission(enterpriseId, attribute);
    }

    @PostApi(value = "/page", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "角色列表")
    public IPage<Role> rolePage(@Valid @RequestBody RolePageVo pageVo){
        return permissionService.rolePage(pageVo);
    }

    @GetApi(value = "/{id}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "根据id查询角色权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "角色id", example = "1", dataType = "long")
    })
    public RolePermissionVo queryRolePermission(@PathVariable("id") Long id){
        return permissionService.queryRolePermission(id);
    }

    @GetApi(value = "/role/{enterpriseId}/{source}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "查询角色")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "source", value = "来源（1、角色权限管理，2、访问信息配置，3、客户权限配置）", example = "1", dataType = "int")
    })
    public List<RoleVo> selectRole(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("source") Integer source){
        return permissionService.selectRole(enterpriseId, source);
    }

    @GetApi(value = "/accessVisitor/{enterpriseId}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "获取基础访问能力配置(外来访客)", notes = "所传企业id为所访问企业id")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long")
    })
    public AccessTrafficOutVo queryAccessTraffic4Visitor(@PathVariable("enterpriseId") Long enterpriseId){
        AccessTrafficOutVo vo = new AccessTrafficOutVo();
        AccessTrafficVo a = permissionService.getAccessTraffic(enterpriseId);
        if(null == a){
            vo = null;
        }else{
            BeanUtils.copyProperties(a, vo);
        }
        return vo;
    }

    @GetApi(value = "/permissionUser/{userId}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "获取企业员工权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "企业id", example = "1", dataType = "long")
    })
    public RolePermissionVo queryPermission4Employee(@PathVariable("userId") Long userId){

        return permissionService.queryPermission4Employee(userId);
    }

    @GetApi(value = "/accessVisitor/{enterpriseId}/{attribute}", auth = AuthLevel.NONE, authors = "李钦显")
    @ApiOperation(value = "获取进出口门禁权限配置（外来访客）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "enterpriseId", value = "企业id", example = "1", dataType = "long"),
        @ApiImplicitParam(name = "attribute", value = "属性（1、一般访客，2、贵宾访客，3、黑名单）", example = "1", dataType = "long")
    })
    public List<Access4VisitorOutVo> selectAccess4Visitor(@PathVariable("enterpriseId") Long enterpriseId, @PathVariable("attribute") Integer attribute){
        return permissionService.selectAccess4Visitor(enterpriseId, attribute);
    }
}
