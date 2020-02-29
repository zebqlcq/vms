package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.VisitRegisterTemplate;
import com.bonade.visitor.domain.vo.VisitRegisterTemplateVo;
import com.bonade.visitor.mapper.VisitRegisterTemplateMapper;

import java.util.List;

/**
 * 来访登记模板服务
 */
@Service
public class VisitRegisterTemplateService extends ServiceImpl<VisitRegisterTemplateMapper, VisitRegisterTemplate> {

    @Transactional
    public boolean addOrEditVisitRegisterTemplate(VisitRegisterTemplateVo visitRegisterTemplateVo){
        if(null == visitRegisterTemplateVo.getId()){
            VisitRegisterTemplate v = new VisitRegisterTemplate();
            BeanUtils.copyProperties(visitRegisterTemplateVo, v);
            return baseMapper.insert(v) == 1;
        }else{
            VisitRegisterTemplate v = baseMapper.selectById(visitRegisterTemplateVo.getId());
            if(null == v){
                throw new BizException("未查询到模板");
            }
            BeanUtils.copyProperties(visitRegisterTemplateVo, v, "id", "createTime", "createUsername", "valid", "version");
            return baseMapper.updateById(v) == 1;
        }
    }

    public VisitRegisterTemplateVo queryVisitRegisterTemplateById(Long enterpriseId, Integer type){
        Wrapper<VisitRegisterTemplate> wrapper = QueryBuilder.<VisitRegisterTemplate>lambdaQuery()
            .eq(VisitRegisterTemplate::getEnterpriseId, enterpriseId)
            .eq(VisitRegisterTemplate::getTemplateType, type)
            .orderByDesc(VisitRegisterTemplate::getCreateTime);
        List<VisitRegisterTemplate> list = baseMapper.selectList(wrapper);
        VisitRegisterTemplate v = new VisitRegisterTemplate();
        if (list.size() > 0){
            v = list.get(0);
        }
        VisitRegisterTemplateVo vo = new VisitRegisterTemplateVo();
        BeanUtils.copyProperties(v, vo);
        return vo;
    }
}
