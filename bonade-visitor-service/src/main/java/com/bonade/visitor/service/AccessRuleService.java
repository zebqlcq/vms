package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.AccessRule;
import com.bonade.visitor.domain.entity.Role;
import com.bonade.visitor.domain.entity.RoleVisitPermission;
import com.bonade.visitor.domain.vo.AccessRuleVo;
import com.bonade.visitor.mapper.AccessRuleMapper;
import com.bonade.visitor.mapper.RoleMapper;
import com.bonade.visitor.mapper.RoleVisitPermissionMapper;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 准入规则服务
 * @author lqx
 */
@Service
public class AccessRuleService extends ServiceImpl<AccessRuleMapper, AccessRule> {

    @Autowired
    RoleVisitPermissionMapper roleVisitPermissionMapper;

    /**
     * 获取准入规则
     * @param enterpriseId
     * @param source
     * @return
     */
    public AccessRuleVo getAccessRule(Long enterpriseId, Integer source, boolean other){
        if(1 == source){
            if(!other){
                return getSysAccessRule(enterpriseId);
            }else{
                return getAccessRule4System(enterpriseId);
            }
        }else if(2 == source){
            return getAccessRule4Enterprise(enterpriseId, other);
        }else{
            throw new BizException("未知来源");
        }
    }

    /**
     * 系统运营台获取准入规则
     * @param enterpriseId
     * @return
     */
    public AccessRuleVo getAccessRule4System(Long enterpriseId){
        AccessRuleVo vo = new AccessRuleVo();
        Wrapper<AccessRule> wrapper = QueryBuilder.<AccessRule>lambdaQuery()
            .eq(AccessRule::getSource, 1)
            .in(AccessRule::getEnterpriseId, Arrays.asList(-1, enterpriseId));
        List<AccessRule> accessRuleList = baseMapper.selectList(wrapper);
        if(accessRuleList.size() < 1){
            throw new BizException("系统未配置默认准入规则");
        }else{
            List<AccessRule> defaultList = accessRuleList.stream().filter(it -> -1 == it.getEnterpriseId()).collect(Collectors.toList());
            List<AccessRule> otherList = accessRuleList.stream().filter(it -> -1 != it.getEnterpriseId()).collect(Collectors.toList());
            if(otherList.size() > 0){
                BeanUtils.copyProperties(otherList.get(0), vo);
            }else{
                BeanUtils.copyProperties(defaultList.get(0), vo);
                vo.setId(null);
                vo.setEnterpriseId(null);
            }
        }
        return vo;
    }

    /**
     * 企业控制台获取准入规则
     * @param enterpriseId
     * @return
     */
    public AccessRuleVo getAccessRule4Enterprise(Long enterpriseId, boolean other){
        AccessRuleVo vo = new AccessRuleVo();
        Wrapper<AccessRule> wrapper = QueryBuilder.<AccessRule>lambdaQuery()
            .eq(AccessRule::getSource, 2)
            .eq(AccessRule::getEnterpriseId, enterpriseId);
        List<AccessRule> accessRuleList = baseMapper.selectList(wrapper);
        if(accessRuleList.size() > 0){
            BeanUtils.copyProperties(accessRuleList.get(0), vo);
        }else{
            if(other){
                List<AccessRuleVo> list = roleVisitPermissionMapper.selectAccessRoleByEnterprise(enterpriseId);
                if(list.size() > 0){
                    vo = list.get(0);
                }else{
                    vo = null;
                }
            }else{
                vo.setName(null);
            }
        }
        return vo;
    }

    public AccessRuleVo getAccessRule(Long enterpriseId){
        AccessRuleVo vo = null;
        Wrapper<AccessRule> wrapper = QueryBuilder.<AccessRule>lambdaQuery()
            .eq(AccessRule::getSource, 2)
            .eq(AccessRule::getEnterpriseId, enterpriseId);
        List<AccessRule> accessRuleList = baseMapper.selectList(wrapper);
        if (accessRuleList.size() > 0){
            vo = new AccessRuleVo();
            BeanUtils.copyProperties(accessRuleList.get(0), vo);
        }
        return vo;
    }

    public AccessRuleVo getSysAccessRule(Long enterpriseId){
        AccessRuleVo vo = null;
        Wrapper<AccessRule> wrapper = QueryBuilder.<AccessRule>lambdaQuery()
            .eq(AccessRule::getSource, 1)
            .eq(AccessRule::getEnterpriseId, enterpriseId);
        List<AccessRule> accessRuleList = baseMapper.selectList(wrapper);
        if (accessRuleList.size() > 0){
            vo = new AccessRuleVo();
            BeanUtils.copyProperties(accessRuleList.get(0), vo);
        }
        return vo;
    }

    public boolean updateAccessRule(AccessRuleVo accessRuleVo){

        if(null == accessRuleVo.getEnterpriseId()){
            throw new BizException("企业为空");
        }

        //检查通行规则
        checkAccessRule(accessRuleVo);


        AccessRule accessRule = new AccessRule();
        if(null == accessRuleVo.getId()){
            BeanUtils.copyProperties(accessRuleVo, accessRule);
            baseMapper.insert(accessRule);
        }else{
            accessRule = baseMapper.selectById(accessRuleVo.getId());
            if (null == accessRule){
                throw new BizException("未查询到该企业配置准入规则");
            }
            BeanUtils.copyProperties(accessRuleVo, accessRule, "id", "createTime", "createUsername", "valid", "version");
            baseMapper.updateById(accessRule);
        }
        return true;
    }

    /**
     * 检查通行规则
     * @param accessRuleVo
     */
    public void checkAccessRule(AccessRuleVo accessRuleVo){
        if(2 == accessRuleVo.getSource()){
            List<AccessRuleVo> list = roleVisitPermissionMapper.selectAccessRoleByEnterprise(accessRuleVo.getEnterpriseId());
            if(list.size() <= 0){
                throw new BizException("基础访问能力权限没有下放到该企业");
            }
            AccessRuleVo accessRule = list.get(0);
            if(!accessRule.isFace() && accessRuleVo.isFace()){
                throw new BizException("刷脸签到权限无权配置");
            }
            if(!accessRule.isQrCode() && accessRuleVo.isQrCode()){
                throw new BizException("二维码签到权限无权配置");
            }
            if(!accessRule.isNumericCode() && accessRuleVo.isNumericCode()){
                throw new BizException("数字码签到权限无权配置");
            }
        }
    }
}
