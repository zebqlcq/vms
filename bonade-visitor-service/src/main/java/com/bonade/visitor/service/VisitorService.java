package com.bonade.visitor.service;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.entity.AbnormalImg;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import com.bonade.visitor.domain.remote.EnterpriseViewVo;
import com.bonade.visitor.domain.vo.BlacklistInVo;
import com.bonade.visitor.domain.vo.BlacklistOutVo;
import com.bonade.visitor.mapper.AbnormalImgMapper;
import com.bonade.visitor.mapper.AbnormalMapper;
import com.bonade.visitor.service.remote.UaacService;
import org.omg.CORBA.Current;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.Assert;
import org.spin.core.collection.Pair;
import org.spin.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.vo.VisitInVo;
import com.bonade.visitor.domain.vo.VisitOutVo;
import com.bonade.visitor.mapper.VisitorMapper;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-5 13:40
 */
@Service
public class VisitorService extends ServiceImpl<VisitorMapper, Visitor> {

    @Autowired
    private AbnormalImgMapper abnormalImgMapper;

    @Autowired
    private AbnormalMapper abnormalMapper;

    @Autowired
    private UaacService uaacService;


    public IPage<BlacklistOutVo> getVisitPage(BlacklistInVo vo) {
        Page<Visitor> page = new Page<>(vo.getCurrent(), vo.getSize());
        return baseMapper.getVisitorPage(page, vo);
    }

    public Visitor saveOrUpdateVisitor(VisitInVo vo) {
        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
        if (sessionEnterprise.c2.longValue() == 0L)
            throw new BizException("查不到企业信息，请切换企业登录");
        Long enterpriseId = sessionEnterprise.c2.longValue();
//        Long enterpriseId = 1197054336006676482L;
        if (vo.getVisitorId() == null) {
            LambdaQueryWrapper<Visitor> lqw = QueryBuilder.<Visitor>lambdaQuery()
                .eq(Visitor::getTel, vo.getTel()).eq(Visitor::getEnterpriseId, enterpriseId);
            List<Visitor> list = baseMapper.selectList(lqw);
            if (list.size() > 0) {
                Visitor visitor = list.get(0);
                vo.setVisitorId(visitor.getId());
                BeanUtils.copyTo(vo, visitor);
                visitor.setEnterpriseId(enterpriseId);
                visitor.setId(vo.getVisitorId());
                if (vo.getVisitorAttribute() != null && vo.getVisitorAttribute().equals(VisitorAttribute.BLACK)) {
                    visitor.setVisitorAttribute(VisitorAttribute.BLACK);
                    visitor.setBlacklistTime(LocalDateTime.now());
                    visitor.setBlacklistOperation(CurrentUser.getCurrent().getName());
                    visitor.setBlacklistOperationId(CurrentUser.getCurrent().getId());
                }
                visitor.setId(vo.getVisitorId());
                baseMapper.updateById(visitor);
                LambdaQueryWrapper<AbnormalImg> imgQuery = QueryBuilder.<AbnormalImg>lambdaQuery()
                    .eq(AbnormalImg::getAbnormalId, vo.getVisitorId());
                abnormalImgMapper.delete(imgQuery);
                if (vo.getImgList() != null) {
                    for (String s : vo.getImgList()) {
                        AbnormalImg abnormalImg = new AbnormalImg();
                        abnormalImg.setAbnormalId(visitor.getId());
                        abnormalImg.setImgType(3);
                        abnormalImg.setImgUrl(s);
                        abnormalImgMapper.insert(abnormalImg);
                    }
                }
                return visitor;
            } else {
                Visitor visitor = new Visitor();
                BeanUtils.copyTo(vo, visitor);
                visitor.setEnterpriseId(enterpriseId);
                if (vo.getVisitorAttribute() != null && vo.getVisitorAttribute().equals(VisitorAttribute.BLACK)) {
                    visitor.setVisitorAttribute(VisitorAttribute.BLACK);
                    visitor.setBlacklistTime(LocalDateTime.now());
                    visitor.setBlacklistOperation(CurrentUser.getCurrent().getName());
                    visitor.setBlacklistOperationId(CurrentUser.getCurrent().getId());
                }
                baseMapper.insert(visitor);
                if (vo.getImgList() != null) {
                    for (String s : vo.getImgList()) {
                        AbnormalImg abnormalImg = new AbnormalImg();
                        abnormalImg.setAbnormalId(visitor.getId());
                        abnormalImg.setImgType(3);
                        abnormalImg.setImgUrl(s);
                        abnormalImgMapper.insert(abnormalImg);
                    }
                }
                return visitor;
            }
        } else {
            Visitor visitor = baseMapper.selectById(vo.getVisitorId());
            if (visitor == null)
                throw new BizException("查不到访客");
            BeanUtils.copyTo(vo, visitor);
            visitor.setId(vo.getVisitorId());
            if (vo.getVisitorAttribute() != null && vo.getVisitorAttribute().equals(VisitorAttribute.BLACK)) {
                visitor.setVisitorAttribute(VisitorAttribute.BLACK);
                visitor.setBlacklistTime(LocalDateTime.now());
                visitor.setBlacklistOperation(CurrentUser.getCurrent().getName());
                visitor.setBlacklistOperationId(CurrentUser.getCurrent().getId());
            }
            visitor.setId(vo.getVisitorId());
            baseMapper.updateById(visitor);
            LambdaQueryWrapper<AbnormalImg> imgQuery = QueryBuilder.<AbnormalImg>lambdaQuery()
                .eq(AbnormalImg::getAbnormalId, vo.getVisitorId());
            abnormalImgMapper.delete(imgQuery);
            if (vo.getImgList() != null) {
                for (String s : vo.getImgList()) {
                    AbnormalImg abnormalImg = new AbnormalImg();
                    abnormalImg.setAbnormalId(visitor.getId());
                    abnormalImg.setImgType(3);
                    abnormalImg.setImgUrl(s);
                    abnormalImgMapper.insert(abnormalImg);
                }
            }
            return visitor;
        }
    }

    @Transient
    public Visitor addToBlacklist(BlacklistInVo vo) {
//TODO        CurrentUser.getCurrentNonNull("必须登录后才能操作");
//        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
//        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
//        if (sessionEnterprise.c2.longValue() == 0L)
//            throw new BizException("查不到企业信息，请切换企业登录");
//        Long enterpriseId = sessionEnterprise.c2.longValue();
        Visitor visitor = new Visitor();
        if (vo.getVisitorId() != null) {
            visitor = baseMapper.selectById(vo.getVisitorId());
            if (visitor == null)
                throw new BizException("查不到访客");
            visitor.setVisitorAttribute(VisitorAttribute.BLACK);
            baseMapper.updateById(visitor);
        } else {
            visitor.setName(vo.getName());
            visitor.setCompanyName(vo.getCompanyName());
            visitor.setUserStation(vo.getUserStation());
            visitor.setCartNo(vo.getCartNo());
            visitor.setCarNo(vo.getCarNo());
            visitor.setVisitorAttribute(VisitorAttribute.BLACK);
            baseMapper.insert(visitor);
        }

        visitor.setVisitorAttribute(VisitorAttribute.BLACK);
        visitor.setBlacklistTime(LocalDateTime.now());
//TODO        visitor.setBlacklistOperation(CurrentUser.getCurrent().getName());
//        visitor.setBlacklistOperationId(CurrentUser.getCurrent().getId());
        baseMapper.updateById(visitor);
        if (vo.getAbnormalId() != null) {
            Abnormal abnormal = abnormalMapper.selectById(vo.getAbnormalId());
            abnormal.setAbnormalCase(vo.getAbnormalCase());
            abnormalMapper.updateById(abnormal);
            LambdaQueryWrapper<AbnormalImg> imgQuery = QueryBuilder.<AbnormalImg>lambdaQuery()
                .eq(AbnormalImg::getAbnormalId, abnormal.getId()).eq(AbnormalImg::getImgType, 1);
            List<AbnormalImg> imgList = abnormalImgMapper.selectList(imgQuery);
            for (AbnormalImg a : imgList) {
                AbnormalImg abnormalImg = new AbnormalImg();
                abnormalImg.setImgUrl(a.getImgUrl());
                abnormalImg.setImgType(3);
                abnormalImg.setAbnormalId(visitor.getId());
                abnormalImgMapper.insert(abnormalImg);
            }
        }
        return visitor;
    }

    public Visitor removeToBlacklist(VisitInVo vo) {
        Visitor visitor = baseMapper.selectById(vo.getVisitorId());
        if (visitor == null)
            throw new BizException("查不到访客");
        visitor.setVisitorAttribute(VisitorAttribute.PLAIN);
        visitor.setUnBlacklistCause(vo.getUnBlacklistCause());
//        visitor.setBlacklistTime(LocalDateTime.now());
        baseMapper.updateById(visitor);

        LambdaQueryWrapper<AbnormalImg> imgQuery = QueryBuilder.<AbnormalImg>lambdaQuery()
            .eq(AbnormalImg::getAbnormalId, visitor.getId()).eq(AbnormalImg::getImgType, 3);
        List<AbnormalImg> imgList = abnormalImgMapper.selectList(imgQuery);
        for (AbnormalImg a : imgList) {
            abnormalImgMapper.deleteById(a.getId());
        }

        return visitor;
    }

    public VisitOutVo getDetail(Long id) {
        Visitor visitor = baseMapper.selectById(id);
        if (visitor == null)
            throw new BizException("查不到访客");
        VisitOutVo vo = new VisitOutVo();
        BeanUtils.copyTo(visitor, vo);
        vo.setVisitorId(visitor.getId());
        LambdaQueryWrapper<AbnormalImg> imgQuery = QueryBuilder.<AbnormalImg>lambdaQuery()
            .eq(AbnormalImg::getAbnormalId, vo.getVisitorId()).eq(AbnormalImg::getImgType, 3);
        List<AbnormalImg> imgList = abnormalImgMapper.selectList(imgQuery);
        List<String> imgStrList = new ArrayList<>();
        for (AbnormalImg img : imgList) {
            imgStrList.add(img.getImgUrl());
        }
        vo.setImgList(imgStrList);
        EnterpriseViewVo entVo = uaacService.getEnterpriseDetailById(visitor.getEnterpriseId());
        vo.setEnterpriseName(entVo.getName());
        return vo;
    }
}
