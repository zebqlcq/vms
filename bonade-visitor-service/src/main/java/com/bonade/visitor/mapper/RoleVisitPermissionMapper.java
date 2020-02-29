package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonade.visitor.domain.entity.RoleVisitPermission;
import com.bonade.visitor.domain.vo.AccessRuleVo;
import com.bonade.visitor.domain.vo.AccessTrafficOutVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleVisitPermissionMapper extends BaseMapper<RoleVisitPermission> {
    public List<AccessRuleVo> selectAccessRoleByEnterprise(Long enterpriseId);

    public AccessTrafficOutVo queryAccessByUser(@Param("param")Map<String, Object> param);
}
