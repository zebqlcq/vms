package com.bonade.visitor.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.Role;
import com.bonade.visitor.domain.entity.RoleAccessApprovalPermission;
import com.bonade.visitor.domain.entity.RoleVisitPermission;
import com.bonade.visitor.domain.enums.PermissionRange;
import com.bonade.visitor.domain.enums.PermissionType;
import com.bonade.visitor.domain.enums.RelationType;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.mapper.RoleAccessApprovalPermissionMapper;
import com.bonade.visitor.mapper.RoleMapper;
import com.bonade.visitor.mapper.RoleVisitPermissionMapper;
import com.bonade.visitor.service.remote.UaacService;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 角色权限服务
 * @author lqx
 */
@Service
public class RolePermissionService {

    private static final String ERRMSG = "未查询到角色";
    private static final String FACENOPERMISSION = "刷脸签到权限无权配置";
    private static final String QRCODENOPERMISSION = "二维码签到权限无权配置";
    private static final String NUMERICCODENOPERMISSION = "数字码签到权限无权配置";

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleVisitPermissionMapper roleVisitPermissionMapper;

    @Autowired
    RoleAccessApprovalPermissionMapper roleAccessApprovalPermissionMapper;

    @Autowired
    AccessRuleService accessRuleService;

    @Autowired
    UaacService uaacService;

    /**
     * 分配权限
     * 角色id为空时新增角色并分配权限
     * @param rolePermissionVo
     * @return
     */
    @Transactional
    public boolean allocationRolePermission(RolePermissionVo rolePermissionVo){

        //验证权限是否可以分派
        checkPermission(rolePermissionVo);

        Role role = null;
        if(null == rolePermissionVo.getId()){
            role = new Role();
            BeanUtils.copyProperties(rolePermissionVo, role);
            roleMapper.insert(role);
        }else{
            role = roleMapper.selectById(rolePermissionVo.getId());
            if(null == role){
                throw new BizException(ERRMSG);
            }
            BeanUtils.copyProperties(rolePermissionVo, role, "id", "createTime", "createUsername", "valid", "version");
            roleMapper.updateById(role);
        }

        List<AccessApprovalPermissionVo> accessApprovalPermissionList = rolePermissionVo.getAccessApprovalPermissionList();
        Long enterpriseId = rolePermissionVo.getEnterpriseId();
        /*if(3 == rolePermissionVo.getSource()){
            for(AccessApprovalPermissionVo vo : accessApprovalPermissionList){
                if(vo.getPermissionType().equals(PermissionType.DOWNENTERPRISE) && vo.getPermissionRange().equals(PermissionRange.ENTERPRISE)){
                    Long[] enterpriseIds = vo.getRangeIds();
                    //验证权限是否可以分派时验证了enterpriseId不为空
                    enterpriseId = enterpriseIds[0];
                }
            }
        }*/

        AccessTrafficVo trafficVo = new AccessTrafficVo();
        BeanUtils.copyProperties(rolePermissionVo, trafficVo);
        trafficVo.setId(role.getId());

        trafficVo.setEnterpriseId(enterpriseId);
        updateAccessTraffic(trafficVo);

        //处理门禁和审批权限
        updateVisitAccess(role.getId(), enterpriseId, rolePermissionVo.getSource(), accessApprovalPermissionList);

        return true;
    }

    /**
     * 验证权限是否可以被分配
     * @param rolePermissionVo
     */
    public void checkPermission(RolePermissionVo rolePermissionVo){
        List<AccessApprovalPermissionVo> accessApprovalPermissionList = rolePermissionVo.getAccessApprovalPermissionList();
        //详细权限集合
        if(accessApprovalPermissionList.size() > 0){
            //判断权限类型是否为空
            if(accessApprovalPermissionList.stream().anyMatch(it -> null == it.getPermissionType())){
                throw new BizException("权限类型含有空值");
            }
            //系统运营台配置的角色
            if(accessApprovalPermissionList.stream().anyMatch(it -> it.getPermissionType().equals(PermissionType.DOWNENTERPRISE))){
                //一个角色只能为一个企业分配权限
                AccessApprovalPermissionVo enterpriseVo = null;
                int count = 0;
                for(AccessApprovalPermissionVo vo : accessApprovalPermissionList){
                    if(vo.getPermissionType().equals(PermissionType.DOWNENTERPRISE) && vo.getPermissionRange().equals(PermissionRange.ENTERPRISE)){
                        enterpriseVo = vo;
                        count++;
                    }
                }
                if(count > 1){
                    throw new BizException("只能为一个企业分配权限");
                }
                if(null != enterpriseVo){
                    Long[] enterpriseIds = enterpriseVo.getRangeIds();
                    if(enterpriseIds.length <= 0){
                        throw new BizException("企业id为空");
                    }

                    if(enterpriseIds.length > 1){
                        throw new BizException("暂时只支持分配1个企业");
                    }
                    long enterpriseId = enterpriseIds[0];
                    Wrapper<RoleAccessApprovalPermission> accessApprovalPermissionWrapper = QueryBuilder.<RoleAccessApprovalPermission>lambdaQuery()
                        .eq(RoleAccessApprovalPermission::getPermissionType, PermissionType.DOWNENTERPRISE)
                        .eq(RoleAccessApprovalPermission::getPermissionRange, PermissionRange.ENTERPRISE)
                        .eq(RoleAccessApprovalPermission::getSource, 3)
                        .eq(RoleAccessApprovalPermission::getRangeId, enterpriseId);
                    List<RoleAccessApprovalPermission> accessApprovalPermissions = roleAccessApprovalPermissionMapper.selectList(accessApprovalPermissionWrapper);
                    if(null == rolePermissionVo.getId()){
                        if(accessApprovalPermissions.size() > 0){
                            throw new BizException("该企业已经分配过权限了");
                        }
                    }else{
                        Wrapper<RoleAccessApprovalPermission> accessApprovalPermissionWrapper2 = QueryBuilder.<RoleAccessApprovalPermission>lambdaQuery()
                            .eq(RoleAccessApprovalPermission::getPermissionType, PermissionType.DOWNENTERPRISE)
                            .eq(RoleAccessApprovalPermission::getPermissionRange, PermissionRange.ENTERPRISE)
                            .eq(RoleAccessApprovalPermission::getSource, 3)
                            .eq(RoleAccessApprovalPermission::getRoleId, rolePermissionVo.getId());
                        List<RoleAccessApprovalPermission> accessApprovalPermissions2 = roleAccessApprovalPermissionMapper.selectList(accessApprovalPermissionWrapper);
                        if(accessApprovalPermissions2.size() > 0){
                            RoleAccessApprovalPermission permission = accessApprovalPermissions2.get(0);
                            if(permission.getRangeId() != enterpriseId && accessApprovalPermissions.size() > 0){
                                throw new BizException("该企业已经分配过权限了");
                            }
                        }
                    }
                }

                //验证基础访问能力是否符合
                AccessRuleVo accessRuleVo = accessRuleService.getAccessRule4System(rolePermissionVo.getEnterpriseId());
                throwException(accessRuleVo, rolePermissionVo);

            }else{//企业控制台配置的角色
                List<Role> roleList = roleMapper.selectRoleByEnterprise(rolePermissionVo.getEnterpriseId());
                if(roleList.size() <= 0){
                    throw new BizException("权限没有下放到该企业");
                }else{
                    Role role = roleList.get(0);

                    //基础权限
                    Wrapper<RoleVisitPermission> visitWrapper = QueryBuilder.<RoleVisitPermission>lambdaQuery()
                        .eq(RoleVisitPermission::getRoleId, role.getId());
                    List<RoleVisitPermission> visitList = roleVisitPermissionMapper.selectList(visitWrapper);
                    if(visitList.size() <= 0){
                        throw new BizException("基础访问能力权限没有下放到该企业");
                    }else{
                        RoleVisitPermission defaultPermission = visitList.get(0);
                        if(!defaultPermission.isOnce() && rolePermissionVo.isOnce()){
                            throw new BizException("曾经来访登记权限无权配置");
                        }
                        if(!defaultPermission.isLogout() && rolePermissionVo.isLogout()){
                            throw new BizException("来访登出权限无权配置");
                        }

                        AccessRuleVo accessRuleVo = accessRuleService.getAccessRule(rolePermissionVo.getEnterpriseId());
                        if(null == accessRuleVo){
                            accessRuleVo = new AccessRuleVo();
                            BeanUtils.copyProperties(defaultPermission, accessRuleVo);
                        }
                        throwException(accessRuleVo, rolePermissionVo);
                    }

                    //其它权限
                    Wrapper<RoleAccessApprovalPermission> accessApprovalPermissionWrapper = QueryBuilder.<RoleAccessApprovalPermission>lambdaQuery()
                        .eq(RoleAccessApprovalPermission::getRoleId, role.getId());
                    List<RoleAccessApprovalPermission> accessApprovalPermissions = roleAccessApprovalPermissionMapper.selectList(accessApprovalPermissionWrapper);

                    checkAccessPermission(accessApprovalPermissions, accessApprovalPermissionList);
                }

            }
        }
    }

    public void checkAccessPermission(List<RoleAccessApprovalPermission> accessApprovalPermissions, List<AccessApprovalPermissionVo> accessApprovalPermissionList){
        if(accessApprovalPermissions.size() <= 0){
            throw new BizException("进出口门禁权限或停车场通行权限没有下放到该企业");
        }else{

            //进出口门禁权限指定区域(下放到企业的)
            Set<Long> s1 = new HashSet<>();
            //停车场通行权限指定区域(下放到企业的)
            Set<Long> s3 = new HashSet<>();
            //进出口门禁权限开放时段(下放到企业的)
            List<RoleAccessApprovalPermission> list1 = new ArrayList<>();
            //进停车场通行权限开放时段(下放到企业的)
            List<RoleAccessApprovalPermission> list2 = new ArrayList<>();
            for(RoleAccessApprovalPermission it : accessApprovalPermissions){
                if(it.getSource() == 3 && PermissionType.CHECKINOUTDOOR.equals(it.getPermissionType()) && PermissionRange.REGION.equals(it.getPermissionRange())){
                    s1.add(it.getRangeId());
                }
                if(it.getSource() == 3 && PermissionType.CHECKINOUTDOOR.equals(it.getPermissionType()) && PermissionRange.DATETIME.equals(it.getPermissionRange())){
                    list1.add(it);
                }
                if(it.getSource() == 3 && PermissionType.PARKINGLOT.equals(it.getPermissionType()) && PermissionRange.REGION.equals(it.getPermissionRange())){
                    s3.add(it.getRangeId());
                }
                if(it.getSource() == 3 && PermissionType.PARKINGLOT.equals(it.getPermissionType()) && PermissionRange.DATETIME.equals(it.getPermissionRange())){
                    list1.add(it);
                }
            }

            //进出口门禁权限指定区域(企业操作的)
            Set<Long> s2 = new HashSet<>();
            //停车场通行权限指定区域(企业操作的)
            Set<Long> s4 = new HashSet<>();
            //进出口门禁权限开放时段(企业操作的)
            List<AccessApprovalPermissionVo> list3 = new ArrayList<>();
            //进停车场通行权限开放时段(企业操作的)
            List<AccessApprovalPermissionVo> list4 = new ArrayList<>();
            for (AccessApprovalPermissionVo it : accessApprovalPermissionList){
                if(PermissionType.CHECKINOUTDOOR.equals(it.getPermissionType()) && PermissionRange.REGION.equals(it.getPermissionRange())){
                    s2.addAll(Arrays.asList(it.getRangeIds()));
                }
                if(PermissionType.CHECKINOUTDOOR.equals(it.getPermissionType()) && PermissionRange.DATETIME.equals(it.getPermissionRange())){
                    list3.add(it);
                }
                if(PermissionType.PARKINGLOT.equals(it.getPermissionType()) && PermissionRange.REGION.equals(it.getPermissionRange())){
                    s4.addAll(Arrays.asList(it.getRangeIds()));
                }
                if(PermissionType.PARKINGLOT.equals(it.getPermissionType()) && PermissionRange.DATETIME.equals(it.getPermissionRange())){
                    list4.add(it);
                }
            }

            //进出口门禁权限指定区域不是全部
            if(!accessApprovalPermissions.stream()
                .anyMatch(it -> it.getSource() == 3 && PermissionType.CHECKINOUTDOOR.equals(it.getPermissionType()) && PermissionRange.REGION.equals(it.getPermissionRange()) && it.isWhole()))
            {
                if(s1.size() > 0 && s2.size() > 0 && !s1.containsAll(s2)){
                    throw new BizException("进出口门禁指定区域包含未授权区域");
                }
            }
            //进出口门禁权限开放时段不是全部
            if(!accessApprovalPermissions.stream()
                .anyMatch(it -> it.getSource() == 3 && PermissionType.CHECKINOUTDOOR.equals(it.getPermissionType()) && PermissionRange.DATETIME.equals(it.getPermissionRange()) && it.isWhole()))
            {
                if(list1.size() > 0 && list3.size() > 0){
                    RoleAccessApprovalPermission p1 = list1.get(0);
                    AccessApprovalPermissionVo v1 = list3.get(0);
                    if((p1.getOpenTimeStart().isBefore(p1.getOpenTimeEnd())
                        && v1.getOpenTimeStart().isBefore(v1.getOpenTimeEnd()))
                        && (v1.getOpenTimeStart().isBefore(p1.getOpenTimeStart())
                        || v1.getOpenTimeEnd().isAfter(p1.getOpenTimeEnd()))){
                        throw new BizException("进出口门禁权限开放时段不在授权时间段");
                    }
                }
            }

            //进停车场通行权限指定区域不是全部
            if(!accessApprovalPermissions.stream()
                .anyMatch(it -> it.getSource() == 3 && PermissionType.PARKINGLOT.equals(it.getPermissionType()) && PermissionRange.REGION.equals(it.getPermissionRange()) && it.isWhole()))
            {
                if(s3.size() > 0 && s4.size() > 0 && !s3.containsAll(s4)){
                    throw new BizException("停车场通行指定区域包含未授权区域");
                }
            }

            //进停车场通行权限开放时段不是全部
            if(!accessApprovalPermissions.stream()
                .anyMatch(it -> it.getSource() == 3 && PermissionType.PARKINGLOT.equals(it.getPermissionType()) && PermissionRange.DATETIME.equals(it.getPermissionRange()) && it.isWhole()))
            {
                if(list2.size() > 0 && list4.size() > 0){
                    RoleAccessApprovalPermission p1 = list2.get(0);
                    AccessApprovalPermissionVo v1 = list4.get(0);
                    if((p1.getOpenTimeStart().isBefore(p1.getOpenTimeEnd())
                        && v1.getOpenTimeStart().isBefore(v1.getOpenTimeEnd()))
                        && (v1.getOpenTimeStart().isBefore(p1.getOpenTimeStart())
                        || v1.getOpenTimeEnd().isAfter(p1.getOpenTimeEnd()))){
                        throw new BizException("进停车场通行权限开放时段不在授权时间段");
                    }
                }

            }

        }
    }

    public void throwException(AccessRuleVo accessRuleVo, RolePermissionVo rolePermissionVo){
        if(!accessRuleVo.isFace() && rolePermissionVo.isFace()){
            throw new BizException(FACENOPERMISSION);
        }
        if(!accessRuleVo.isQrCode() && rolePermissionVo.isQrCode()){
            throw new BizException(QRCODENOPERMISSION);
        }
        if(!accessRuleVo.isNumericCode() && rolePermissionVo.isNumericCode()){
            throw new BizException(NUMERICCODENOPERMISSION);
        }
    }

    /**
     * 通行到访配置
     * @param trafficVo
     * @return
     */
    public boolean updateAccessTraffic(AccessTrafficVo trafficVo){
        if(2 == trafficVo.getSource()){
            AccessRuleVo accessRuleVo = new AccessRuleVo();
            BeanUtils.copyProperties(trafficVo, accessRuleVo);
            accessRuleVo.setSource(2);
            //检查通行规则
            accessRuleService.checkAccessRule(accessRuleVo);
        }

        Wrapper<RoleVisitPermission> visitWrapper = QueryBuilder.<RoleVisitPermission>lambdaQuery()
            .eq(RoleVisitPermission::getSource, trafficVo.getSource())
            .eq(RoleVisitPermission::getEnterpriseId, trafficVo.getEnterpriseId());
        List<RoleVisitPermission> visitList = roleVisitPermissionMapper.selectList(visitWrapper);
        RoleVisitPermission visitPermission = null;
        if(visitList.size() > 0){
            visitPermission = visitList.get(0);
            BeanUtils.copyProperties(trafficVo, visitPermission, "id", "createTime", "createUsername", "valid", "version");
            visitPermission.setSource(trafficVo.getSource());
            visitPermission.setRoleId(trafficVo.getId());
            visitPermission.setEnterpriseId(trafficVo.getEnterpriseId());
            roleVisitPermissionMapper.updateById(visitPermission);
        }else{
            visitPermission = new RoleVisitPermission();
            BeanUtils.copyProperties(trafficVo, visitPermission);
            visitPermission.setSource(trafficVo.getSource());
            visitPermission.setRoleId(trafficVo.getId());
            visitPermission.setEnterpriseId(trafficVo.getEnterpriseId());
            roleVisitPermissionMapper.insert(visitPermission);
        }

        return true;
    }

    /**
     * 获取通行到访配置
     * @param enterpriseId
     * @return
     */
    public AccessTrafficVo getAccessTraffic(Long enterpriseId){
        AccessTrafficVo vo = new AccessTrafficVo();
        Wrapper<RoleVisitPermission> visitWrapper = QueryBuilder.<RoleVisitPermission>lambdaQuery()
            .eq(RoleVisitPermission::getSource, 2)
            .eq(RoleVisitPermission::getEnterpriseId, enterpriseId);
        List<RoleVisitPermission> visitList = roleVisitPermissionMapper.selectList(visitWrapper);
        if(visitList.size() > 0){
            BeanUtils.copyProperties(visitList.get(0), vo);
        }else{
            AccessTrafficVo accessTrafficVo = getAccessRole(enterpriseId);
            if(null != accessTrafficVo){
                vo.setQrCode(accessTrafficVo.isQrCode());
                vo.setNumericCode(accessTrafficVo.isNumericCode());
                vo.setFace(accessTrafficVo.isFace());
            }
        }
        return vo;
    }

    /**
     *  访客准入权限
     * @param visitAccessVo
     * @return
     */
    public boolean updateVisitAccess(VisitAccessVo visitAccessVo){
        Wrapper<RoleAccessApprovalPermission> accessApprovalPermissionWrapper = QueryBuilder.<RoleAccessApprovalPermission>lambdaQuery()
            .eq(RoleAccessApprovalPermission::getSource, 3)
            .eq(RoleAccessApprovalPermission::getPermissionType, PermissionType.DOWNENTERPRISE)
            .eq(RoleAccessApprovalPermission::getPermissionRange, PermissionRange.ENTERPRISE)
            .eq(RoleAccessApprovalPermission::getRangeId, visitAccessVo.getEnterpriseId());
        List<RoleAccessApprovalPermission> accessApprovalPermissions = roleAccessApprovalPermissionMapper.selectList(accessApprovalPermissionWrapper);
        //检查进出口门禁和停车场通行权限
        checkAccessPermission(accessApprovalPermissions, visitAccessVo.getAccessApprovalPermissionList());

        List<AccessApprovalPermissionVo> accessApprovalPermissionList = visitAccessVo.getAccessApprovalPermissionList();
        accessApprovalPermissionList.forEach(it -> it.setAttribute(visitAccessVo.getAttribute()));
        updateVisitAccess(null, visitAccessVo.getEnterpriseId(), visitAccessVo.getSource(), accessApprovalPermissionList);

        return true;
    }

    /**
     * 查询访客准入权限
     * @param enterpriseId
     * @param attribute
     * @return
     */
    public List<AccessApprovalPermissionVo> selectVisitAccessPermission(Long enterpriseId, Integer attribute){
        Wrapper<RoleAccessApprovalPermission> wrapper = QueryBuilder.<RoleAccessApprovalPermission>lambdaQuery()
            .eq(RoleAccessApprovalPermission::getEnterpriseId, enterpriseId)
            .eq(RoleAccessApprovalPermission::getSource, 2)
            .eq(RoleAccessApprovalPermission::getAttribute, attribute);
        return accessApprovalPermissionList(roleAccessApprovalPermissionMapper.selectList(wrapper));

    }

    public void updateVisitAccess(Long roleId, Long enterpriseId, Integer source, List<AccessApprovalPermissionVo> accessApprovalPermissionList){

        roleAccessApprovalPermissionMapper.deletePermission(enterpriseId, source);

        List<RoleAccessApprovalPermission> permissionList = new ArrayList<>();

        for (AccessApprovalPermissionVo vo : accessApprovalPermissionList){
            RoleAccessApprovalPermission permission = new RoleAccessApprovalPermission();
            BeanUtils.copyProperties(vo, permission);
            permission.setEnterpriseId(enterpriseId);
            permission.setSource(source);
            permission.setCreateTime(LocalDateTime.now());
            if(null != roleId){
                permission.setRoleId(roleId);
            }

            Long[] rangeIds = vo.getRangeIds();
            if(null != rangeIds && rangeIds.length > 0){
                permission.setWhole(false);
                for(int i=0; i<rangeIds.length; i++){
                    RoleAccessApprovalPermission permissionTar = new RoleAccessApprovalPermission();
                    BeanUtils.copyProperties(permission, permissionTar);
                    permissionTar.setRangeId(rangeIds[i]);
                    permissionList.add(permissionTar);
                }
            }else if(null != vo.getOpenTimeStart() && null != vo.getOpenTimeEnd()){

                permission.setWhole(false);
                permissionList.add(permission);
            }else{
                permission.setWhole(true);
                permissionList.add(permission);
            }
        }
        if(permissionList.size() > 0){
            roleAccessApprovalPermissionMapper.batchPermission(permissionList);
        }
    }


    public IPage<Role> rolePage(RolePageVo pageVo){
        IPage<Role> page = new Page<>(pageVo.getCurrent(), pageVo.getSize());
        Wrapper<Role> roleWrapper = QueryBuilder.<Role>lambdaQuery()
            .eq(Role::getEnterpriseId, pageVo.getEnterpriseId())
            .eq(Role::getSource, pageVo.getSource())
            .orderByDesc(Role::getCreateTime);
        return roleMapper.selectPage(page, roleWrapper);
    }

    public RolePermissionVo queryRolePermission(Long id){
        RolePermissionVo vo = new RolePermissionVo();
        Role role = roleMapper.selectById(id);
        if(null == role){
            throw new BizException(ERRMSG);
        }
        BeanUtils.copyProperties(role, vo);

        Wrapper<RoleVisitPermission> visitPermissionWrapper = QueryBuilder.<RoleVisitPermission>lambdaQuery()
            .eq(RoleVisitPermission::getRoleId, role.getId());
        List<RoleVisitPermission> visitPermissionList = roleVisitPermissionMapper.selectList(visitPermissionWrapper);
        if(visitPermissionList.size() > 0){
            RoleVisitPermission visitPermission = visitPermissionList.get(0);
            BeanUtils.copyProperties(visitPermission, vo, "id", "createTime", "createUsername", "valid", "version");
        }


        Wrapper<RoleAccessApprovalPermission> permissionWrapper = QueryBuilder.<RoleAccessApprovalPermission>lambdaQuery()
            .eq(RoleAccessApprovalPermission::getRoleId, role.getId());
        List<RoleAccessApprovalPermission> permissionList = roleAccessApprovalPermissionMapper.selectList(permissionWrapper);


        vo.setAccessApprovalPermissionList(accessApprovalPermissionList(permissionList));
        return vo;
    }

    public List<AccessApprovalPermissionVo> accessApprovalPermissionList(List<RoleAccessApprovalPermission> permissionList){

        List<AccessApprovalPermissionVo> accessApprovalPermissionList = new ArrayList<>();
        Map<String, List<RoleAccessApprovalPermission>> map = permissionList.stream().collect(Collectors.groupingBy(it -> it.getPermissionType() + ":" + it.getPermissionRange()));

        for(String key : map.keySet()){
            List<RoleAccessApprovalPermission> permissions = map.get(key);
            if(permissions.size() > 0){
                RoleAccessApprovalPermission permission = permissions.get(0);
                AccessApprovalPermissionVo permissionVo = new AccessApprovalPermissionVo();
                BeanUtils.copyProperties(permission, permissionVo);

                if(null != permission.getRangeId()){
                    List<Long> rangeIdList = permissions.stream().map(RoleAccessApprovalPermission::getRangeId).collect(Collectors.toList());
                    Long[] rangeIds = new Long[rangeIdList.size()];
                    rangeIdList.toArray(rangeIds);
                    permissionVo.setRangeIds(rangeIds);
                }

                permissionVo.setWholeValue(permissionVo.isWhole() ? 1 : 0);

                accessApprovalPermissionList.add(permissionVo);
            }
        }
        return accessApprovalPermissionList;
    }

    public List<RoleVo> selectRole(Long enterpriseId, Integer source){
        List<RoleVo> roleVoList = new ArrayList<>();
        Wrapper<Role> roleWrapper = QueryBuilder.<Role>lambdaQuery()
            .eq(Role::getEnterpriseId, enterpriseId)
            .eq(Role::getSource, source);
        List<Role> roleList = roleMapper.selectList(roleWrapper);
        roleList.forEach(role -> {
            RoleVo vo = new RoleVo();
            BeanUtils.copyProperties(role, vo);
            roleVoList.add(vo);
        });
        return roleVoList;
    }

    public RolePermissionVo queryPermission4Employee(Long userId){
        RolePermissionVo permissionVo = new RolePermissionVo();
        EmployeeQueryVo query = new EmployeeQueryVo();
        query.setUserId(userId);
        List<EmployeeOrganViewVo> orgVoList = uaacService.listUserOrgan(query);

        Long enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;

        Map<String, Object> param = new HashMap<>();
        param.put("enterpriseId", enterpriseId);
        param.put("userId", userId);
        List<Long> departmentList = new ArrayList<>();
        List<Long> stationList = new ArrayList<>();
        List<Long> customOrgList = new ArrayList<>();
        orgVoList.forEach(it -> {
            if(it.getRelationType().equals(RelationType.DEPARTMENT)){
                departmentList.add(it.getRelationId());
            }else if(it.getRelationType().equals(RelationType.STATION)){
                departmentList.add(it.getRelationId());
            }else if(it.getRelationType().equals(RelationType.CUSTOM_ORGAN)){
                departmentList.add(it.getRelationId());
            }
        });
        if(departmentList.size() > 0){
            param.put("departmentList", departmentList);
        }
        if(stationList.size() > 0){
            param.put("stationList", stationList);
        }
        if(customOrgList.size() > 0){
            param.put("customOrgList", customOrgList);
        }

        List<Long> roleList = roleAccessApprovalPermissionMapper.selectRoleByUser(param);
        if(roleList.size() > 0){
            Long roleId = roleList.get(0);
            permissionVo = queryRolePermission(roleId);
            AccessTrafficVo accessTrafficVo = getAccessRole(enterpriseId);
            if(null != accessTrafficVo){
                permissionVo.setQrCode(accessTrafficVo.isQrCode());
                permissionVo.setNumericCode(accessTrafficVo.isNumericCode());
                permissionVo.setFace(accessTrafficVo.isFace());
            }
        }else{
            permissionVo = null;
        }

        return permissionVo;
    }

    public AccessTrafficVo getAccessRole(Long enterpriseId){
        AccessTrafficVo vo = new AccessTrafficVo();
        List<AccessRuleVo> list = roleVisitPermissionMapper.selectAccessRoleByEnterprise(enterpriseId);
        if(list.size() > 0){
            AccessRuleVo accessRuleVo = accessRuleService.getAccessRule(enterpriseId);
            if(null != accessRuleVo){
                BeanUtils.copyProperties(accessRuleVo, vo);
            }else{
                BeanUtils.copyProperties(list.get(0), vo);
            }
        }else{
            vo = null;
        }
        return vo;
    }

    /**
     *  获取外来访客进出口门禁权限配置
     * @param enterpriseId 企业id
     * @param attribute 属性（1、一般访客，2、贵宾访客，3、黑名单）
     * @return
     */
    public List<Access4VisitorOutVo> selectAccess4Visitor(Long enterpriseId, Integer attribute){
        Wrapper<RoleAccessApprovalPermission> wrapper = QueryBuilder.<RoleAccessApprovalPermission>lambdaQuery()
            .eq(RoleAccessApprovalPermission::getEnterpriseId, enterpriseId)
            .eq(RoleAccessApprovalPermission::getSource, 2)
            .eq(RoleAccessApprovalPermission::getPermissionType, 1)
            .eq(RoleAccessApprovalPermission::getAttribute, attribute);
        List<RoleAccessApprovalPermission> list = roleAccessApprovalPermissionMapper.selectList(wrapper);
        List<Access4VisitorOutVo> outList = new ArrayList<>();
        if(list.size() > 0){
            //指定区域
            if(list.stream().anyMatch(it -> PermissionRange.REGION.equals(it.getPermissionRange()))){
                Access4VisitorOutVo vo = new Access4VisitorOutVo();
                vo.setPermissionRange(PermissionRange.REGION);
                if(list.stream().anyMatch(it -> PermissionRange.REGION.equals(it.getPermissionRange()) && it.isWhole())){
                    vo.setWhole(true);
                }else{
                    String ids = list.stream()
                        .filter(it -> PermissionRange.REGION.equals(it.getPermissionRange()))
                        .map(it -> String.valueOf(it.getRangeId())).collect(Collectors.joining(","));
                    vo.setRangeIds(ids);
                    vo.setWhole(false);
                }
                outList.add(vo);
            }

            //开放时间段
            if(list.stream().anyMatch(it -> PermissionRange.DATETIME.equals(it.getPermissionRange()))){
                Access4VisitorOutVo vo = new Access4VisitorOutVo();
                vo.setPermissionRange(PermissionRange.DATETIME);
                RoleAccessApprovalPermission permission = list.stream().filter(it -> PermissionRange.DATETIME.equals(it.getPermissionRange())).findFirst().get();
                if(permission.isWhole()){
                    vo.setWhole(true);
                }else{
                    vo.setOpenTimeStart(permission.getOpenTimeStart());
                    vo.setOpenTimeEnd(permission.getOpenTimeEnd());
                    vo.setWhole(false);
                }
                outList.add(vo);
            }
        }
        return outList;
    }

}
