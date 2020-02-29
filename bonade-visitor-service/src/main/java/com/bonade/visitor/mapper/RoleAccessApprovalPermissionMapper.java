package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonade.visitor.domain.entity.RoleAccessApprovalPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleAccessApprovalPermissionMapper extends BaseMapper<RoleAccessApprovalPermission> {

    public int deletePermission(@Param("enterpriseId") Long enterpriseId, @Param("source") Integer source);

    public int batchPermission(@Param("permissionList") List<RoleAccessApprovalPermission> permissionList);

    List<Long> selectRoleByUser(@Param("param") Map<String, Object> param);
}
