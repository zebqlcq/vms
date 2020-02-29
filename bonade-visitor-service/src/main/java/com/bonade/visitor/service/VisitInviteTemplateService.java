package com.bonade.visitor.service;



import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.vo.InviteTempQueryVo;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.util.EnumUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.VisitInviteTemplate;
import com.bonade.visitor.domain.vo.VisitInviteTemplatePageVo;
import com.bonade.visitor.domain.vo.VisitInviteTemplateVo;
import com.bonade.visitor.mapper.VisitInviteTemplateMapper;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 邀约模板服务
 * @author lqx
 */
@Service
public class VisitInviteTemplateService extends ServiceImpl<VisitInviteTemplateMapper, VisitInviteTemplate> {

    @Transactional
    public VisitInviteTemplateVo addOrEditVisitInviteTemplate(VisitInviteTemplateVo visitInviteTemplateVo){
        VisitInviteTemplateVo vo = new VisitInviteTemplateVo();
        if(null == visitInviteTemplateVo.getId()){
            VisitInviteTemplate v = new VisitInviteTemplate();
            BeanUtils.copyProperties(visitInviteTemplateVo, v);
            baseMapper.insert(v);
            BeanUtils.copyProperties(v, vo);
        }else{
            VisitInviteTemplate v = baseMapper.selectById(visitInviteTemplateVo.getId());
            if(null == v){
                throw new BizException("未查询到模板");
            }
            BeanUtils.copyProperties(visitInviteTemplateVo, v, "id", "createTime", "createUsername", "valid", "version");
            baseMapper.updateById(v);
            BeanUtils.copyProperties(v, vo);
        }
        return vo;
    }

    public VisitInviteTemplateVo queryVisitInviteTemplateById(InviteTempQueryVo inviteTempQueryVo){
        Long id = inviteTempQueryVo.getId();
        if(null == id){
            throw new BizException("邀约模板ID不能为空");
        }
        VisitInviteTemplate v = baseMapper.selectById(id);
        if(null == v){
            throw new BizException("未查询到模板");
        }
        VisitInviteTemplateVo vo = new VisitInviteTemplateVo();
        BeanUtils.copyProperties(v, vo);

        String content = vo.getContent();
        if(content.contains("{visitor}") && StringUtils.hasText(inviteTempQueryVo.getVisitor())){
            content = content.replace("{visitor}", inviteTempQueryVo.getVisitor());
        }

        if(content.contains("{company}") && StringUtils.hasText(inviteTempQueryVo.getCompany())){
            content = content.replace("{company}", inviteTempQueryVo.getCompany());
        }

        if(content.contains("{empid}") && StringUtils.hasText(inviteTempQueryVo.getEmpid())){
            content = content.replace("{empid}", inviteTempQueryVo.getEmpid());
        }
        vo.setContent(content);

        return vo;
    }

    public IPage<VisitInviteTemplate> VisitInviteTemplatePage(VisitInviteTemplatePageVo pageVo){
        IPage<VisitInviteTemplate> page = new Page<>(pageVo.getCurrent(), pageVo.getSize());
        Wrapper<VisitInviteTemplate> wrapper = QueryBuilder.<VisitInviteTemplate>lambdaQuery().orderByDesc(VisitInviteTemplate::getCreateTime);
        return baseMapper.selectPage(page, wrapper);
    }

    public boolean deleteVisitInviteTemplate(Long id){
        return baseMapper.deleteById(id) == 1;
    }

    public List<VisitInviteTemplateVo> selectVisitInviteTemplate(Long enterpriseId){
        Wrapper<VisitInviteTemplate> wrapper = QueryBuilder.<VisitInviteTemplate>lambdaQuery()
            .eq(VisitInviteTemplate::getEnterpriseId, enterpriseId).eq(VisitInviteTemplate::getValid, 1)
            .orderByAsc(VisitInviteTemplate::getCreateTime);
        List<VisitInviteTemplate> list = baseMapper.selectList(wrapper);

        List<VisitInviteTemplateVo> voList = new ArrayList<>();
        Optional<VisitInviteTemplate> defaultTemp = list.stream().filter(it -> it.isDefaultTemp()).findFirst();
        if(defaultTemp.isPresent()){
            VisitInviteTemplateVo vo = new VisitInviteTemplateVo();
            BeanUtils.copyProperties(defaultTemp.get(), vo);
            voList.add(vo);
            list.forEach(it -> {
                if(!it.isDefaultTemp()){
                    VisitInviteTemplateVo vo1 = new VisitInviteTemplateVo();
                    BeanUtils.copyProperties(it, vo1);
                    voList.add(vo1);
                }
            });
        }else{
            list.forEach(it -> {
                if(!it.isDefaultTemp()){
                    VisitInviteTemplateVo vo1 = new VisitInviteTemplateVo();
                    BeanUtils.copyProperties(it, vo1);
                    voList.add(vo1);
                }
            });
        }
        return voList;
    }
}
