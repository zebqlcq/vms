package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.VisitAppointmentTemplate;
import com.bonade.visitor.domain.vo.VisitAppointmentTemplateVo;
import com.bonade.visitor.mapper.VisitAppointmentTemplateMapper;

import java.util.List;

/**
 * 访客预约模板
 * @author lqx
 */
@Service
public class VisitAppointmentTemplateService extends ServiceImpl<VisitAppointmentTemplateMapper, VisitAppointmentTemplate> {

    @Transactional
    public boolean addOrEditVisitAppointmentTemplate(VisitAppointmentTemplateVo visitAppointmentTemplateVo){
        if(null == visitAppointmentTemplateVo.getId()){
            VisitAppointmentTemplate v = new VisitAppointmentTemplate();
            BeanUtils.copyProperties(visitAppointmentTemplateVo, v);
            return baseMapper.insert(v) == 1;
        }else{
            VisitAppointmentTemplate v = baseMapper.selectById(visitAppointmentTemplateVo.getId());
            if(null == v){
                throw new BizException("未查询到模板");
            }
            BeanUtils.copyProperties(visitAppointmentTemplateVo, v, "id", "createTime", "createUsername", "valid", "version");
            return baseMapper.updateById(v) == 1;
        }
    }

    public VisitAppointmentTemplateVo queryVisitAppointmentTemplateById(Long enterpriseId){
        Wrapper<VisitAppointmentTemplate> wrapper = QueryBuilder.<VisitAppointmentTemplate>lambdaQuery()
            .eq(VisitAppointmentTemplate::getEnterpriseId, enterpriseId)
            .orderByDesc(VisitAppointmentTemplate::getCreateTime);
        List<VisitAppointmentTemplate> list = baseMapper.selectList(wrapper);
        VisitAppointmentTemplate v = new VisitAppointmentTemplate();
        if (list.size() > 0){
            v = list.get(0);
        }
        VisitAppointmentTemplateVo vo = new VisitAppointmentTemplateVo();
        BeanUtils.copyProperties(v, vo);
        return vo;
    }
}
