package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.entity.AbnormalImg;
import com.bonade.visitor.domain.entity.Area;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.mapper.*;
import com.bonade.visitor.util.DateUtil;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.Assert;
import org.spin.core.collection.Pair;
import org.spin.core.util.BeanUtils;
import org.spin.core.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class AbnormalService extends ServiceImpl<AbnormalMapper, Abnormal> {

    @Autowired
    private AbnormalImgMapper abnormalImgMapper;

    @Autowired
    private VisitRecordMapper visitRecordMapper;

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private AreaMapper areaMapper;

    public AreaStatisticsOutVo getAreaNumber(AreaInVo vo) {
        AreaStatisticsOutVo outVo = new AreaStatisticsOutVo();
        if (vo.getTimeInterval().equals("today")) {
            vo.setStartTime(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
        } else if (vo.getTimeInterval().equals("week")) {
            vo.setStartTime(LocalDateTime.of(LocalDate.now().with(DayOfWeek.MONDAY), LocalTime.MIN));
        } else if (vo.getTimeInterval().equals("month")) {
            vo.setStartTime(LocalDateTime.of(LocalDate.now().withDayOfMonth(1), LocalTime.MIN));
        } else {
            throw new BizException("统计参数异常");
        }
        LambdaQueryWrapper<Abnormal> query = QueryBuilder.<Abnormal>lambdaQuery()
            .eq(Abnormal::getEnterpriseId, vo.getEnterpriseId());
        outVo.setAllCount(baseMapper.selectCount(query));
        query.gt(Abnormal::getCreateTime, vo.getStartTime());
        outVo.setWeekCount(baseMapper.selectCount(query));
        LambdaQueryWrapper<Area> areaQuery = QueryBuilder.<Area>lambdaQuery()
            .eq(Area::getEnterpriseId, vo.getEnterpriseId());
        List<Area> areaList = areaMapper.selectList(areaQuery);
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        if (vo.getTimeInterval().equals("today")) {
            for (LocalDateTime d = vo.getStartTime(); d.isBefore(LocalDateTime.now().plusHours(1)); d = d.plusHours(1)) {
                Map<String, Integer> areaCountMap = new LinkedHashMap<>();
                for (Area a : areaList) {
                    areaCountMap.put(a.getName(), 0);
                }
                map.put(DateUtils.formatDateForSecond(d), areaCountMap);
            }
            for (Area a : areaList) {
                LambdaQueryWrapper<Abnormal> abnormalQuery = QueryBuilder.<Abnormal>lambdaQuery()
                    .eq(Abnormal::getAbnormalAreaId, a.getId())
                    .gt(true, Abnormal::getCreateTime, vo.getStartTime());
                List<Abnormal> abnormalList = baseMapper.selectList(abnormalQuery);
                for (Abnormal abnormal : abnormalList) {
                    map.get(DateUtils.formatDateForSecond(abnormal.getCreateTime().withMinute(0).withSecond(0)))
                        .put(a.getName(), map.get(DateUtils.formatDateForSecond(abnormal.getCreateTime().withMinute(0).withSecond(0))).get(a.getName()) + 1);
                }
            }
        } else {
            for (LocalDateTime d = vo.getStartTime(); d.isBefore(LocalDateTime.now().plusDays(1)); d = d.plusDays(1)) {
                Map<String, Integer> areaCountMap = new LinkedHashMap<>();
                for (Area a : areaList) {
                    areaCountMap.put(a.getName(), 0);
                }
                map.put(DateUtils.formatDateForDay(d), areaCountMap);
            }
            for (Area a : areaList) {
                LambdaQueryWrapper<Abnormal> abnormalQuery = QueryBuilder.<Abnormal>lambdaQuery()
                    .eq(Abnormal::getAbnormalAreaId, a.getId())
                    .gt(true, Abnormal::getCreateTime, vo.getStartTime());
                List<Abnormal> abnormalList = baseMapper.selectList(abnormalQuery);
                for (Abnormal abnormal : abnormalList) {
                    map.get(DateUtils.formatDateForDay(abnormal.getCreateTime())).put(a.getName(), map.get(DateUtils.formatDateForDay(abnormal.getCreateTime())).get(a.getName()) + 1);
                }
            }
        }
        List<AreaStatisticsDetailOutVo> outVoList = new ArrayList<>();
        for (String key : map.keySet()) {
            AreaStatisticsDetailOutVo areaStatisticsDetailOutVo = new AreaStatisticsDetailOutVo();
            areaStatisticsDetailOutVo.setDateTime(key);
            areaStatisticsDetailOutVo.setDataVo(new ArrayList<>());
            for (String k : map.get(key).keySet()) {
                AreaStatisticsDetailInfoOutVo areaStatisticsDetailInfoOutVo = new AreaStatisticsDetailInfoOutVo();
                areaStatisticsDetailInfoOutVo.setAreaName(k);
                areaStatisticsDetailInfoOutVo.setCount(map.get(key).get(k));
                areaStatisticsDetailOutVo.getDataVo().add(areaStatisticsDetailInfoOutVo);
            }
            outVoList.add(areaStatisticsDetailOutVo);
        }
        outVo.setAreaStatisticsDetailOutVoList(outVoList);
        return outVo;
    }

    public IPage<AbnormalOutVo> getAbnormalPage(AbnormalInVo vo) {
//        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
//        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
//        if (sessionEnterprise.c2.longValue() == 0L)
//            throw new BizException("查不到企业信息，请切换企业登录");
//        Long enterpriseId = sessionEnterprise.c2.longValue();
        Long enterpriseId = vo.getEnterpriseId();
        vo.setEnterpriseId(enterpriseId);
        Page<Abnormal> page = new Page<>(vo.getCurrent(), vo.getSize());
        IPage<AbnormalOutVo> outVoIPage = baseMapper.getPage(page, vo);
        for (AbnormalOutVo v : outVoIPage.getRecords()) {
            if (v.getVisitorAttribute() != null) {
                v.setVisitorAttributeDesc(v.getVisitorAttribute().getDescription());
            }
        }
        return outVoIPage;
    }

    public IPage<AbnormalRecordOutVo> getRecordPage(AbnormalInVo vo) {
        Page<Abnormal> page = new Page<>(vo.getCurrent(), vo.getSize());
        IPage<AbnormalRecordOutVo> outVoIPage = baseMapper.getRecordPage(page, vo);
        return outVoIPage;
    }

    public VisitOutVo getVisitorInfo(String tel) {
        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
        if (sessionEnterprise.c2.longValue() == 0L)
            throw new BizException("查不到企业信息，请切换企业登录");
        Long enterpriseId = sessionEnterprise.c2.longValue();
        LambdaQueryWrapper<Visitor> visitQuery = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getEnterpriseId, enterpriseId)
            .eq(Visitor::getTel, tel);
        List<Visitor> visitorList = visitorMapper.selectList(visitQuery);
        if (visitorList.size() > 0) {
            VisitOutVo outVo = new VisitOutVo();
            BeanUtils.copyTo(visitorList.get(0),outVo);
            return outVo;
        } else {
            return null;
        }
    }

    public AbnormalOutVo getDetail(Long id) {
        AbnormalOutVo abnormalOutVo = new AbnormalOutVo();
        Abnormal abnormal = baseMapper.selectById(id);
        Visitor visitor = visitorMapper.selectById(abnormal.getVisitorId());
        BeanUtils.copyTo(visitor, abnormalOutVo);
        BeanUtils.copyTo(abnormal, abnormalOutVo);
        if (abnormal == null)
            throw new BizException("查询不到异常通行记录");
        if (abnormalOutVo.getAbnormalAreaId() != null) {
            abnormalOutVo.setAbnormalAreaName(areaMapper.selectById(abnormalOutVo.getAbnormalAreaId()).getName());
        }
        LambdaQueryWrapper<AbnormalImg> imgQuery = QueryBuilder.<AbnormalImg>lambdaQuery()
            .eq(AbnormalImg::getAbnormalId, abnormal.getId());
        List<AbnormalImg> imgList = abnormalImgMapper.selectList(imgQuery);
        List<AbnormalImgVo> imgVoList = imgList.stream()
            .map(e -> new AbnormalImgVo().fromEntity(e))
            .collect(Collectors.toList());
        abnormalOutVo.setAbnormalImgVoList(imgVoList);
        abnormalOutVo.setImgBtList(new ArrayList<>());
        abnormalOutVo.setImgYyList(new ArrayList<>());
        for (AbnormalImgVo v : imgVoList) {
            if (v.getImgType() == 1) {
                abnormalOutVo.getImgBtList().add(v.getImgUrl());
            } else if (v.getImgType() == 2) {
                abnormalOutVo.getImgYyList().add(v.getImgUrl());
            }
        }
        return abnormalOutVo;
    }

    @Transactional
    public void saveOrUpdate(AbnormalInVo vo) {

        //图片前期处理
        if (vo.getAbnormalImgVoList() == null || vo.getAbnormalImgVoList().size() == 0) {
            vo.setAbnormalImgVoList(new ArrayList<>());
            if (vo.getImgBtList() != null) {
                for (String s : vo.getImgBtList()) {
                    AbnormalImgVo v = new AbnormalImgVo();
                    v.setImgType(1);
                    v.setImgUrl(s);
                    vo.getAbnormalImgVoList().add(v);
                }
            }
            if (vo.getImgYyList() != null) {
                for (String s : vo.getImgYyList()) {
                    AbnormalImgVo v = new AbnormalImgVo();
                    v.setImgType(2);
                    v.setImgUrl(s);
                    vo.getAbnormalImgVoList().add(v);
                }
            }
        }

        //关联访客处理
        Visitor visitor = new Visitor();
        if (vo.getVisitId() != null) {
            visitor = visitorMapper.selectById(vo.getVisitId());
            if (visitor.getTel().equals(vo.getTel())) {
                if (vo.getName() != null && !vo.getName().equals(""))
                    visitor.setName(vo.getName());
                if (vo.getCompanyName() != null && !vo.getCompanyName().equals(""))
                    visitor.setCompanyName(vo.getCompanyName());
                if (vo.getUserStation() != null && !vo.getUserStation().equals(""))
                    visitor.setUserStation(vo.getUserStation());
                if (vo.getCartNo() != null && !vo.getCartNo().equals(""))
                    visitor.setCartNo(vo.getCartNo());
                if (vo.getCartNo() != null && !vo.getCartNo().equals(""))
                    visitor.setCartNo(vo.getCartNo());
                if (vo.getCarNo() != null && !vo.getCarNo().equals(""))
                    visitor.setCarNo(vo.getCarNo());
                if (vo.getVisitorAttribute() != null)
                    visitor.setVisitorAttribute(vo.getVisitorAttribute());
                if (vo.getEnterpriseId() != null)
                    visitor.setEnterpriseId(vo.getEnterpriseId());
                visitorMapper.updateById(visitor);
            } else {
                vo.setVisitId(null);
            }
        }
        if (vo.getVisitId() == null && vo.getTel() != null && !vo.getTel().equals("")) {
            LambdaQueryWrapper<Visitor> visitQuery = QueryBuilder.<Visitor>lambdaQuery()
                .eq(Visitor::getEnterpriseId, vo.getEnterpriseId())
                .eq(Visitor::getTel, vo.getTel());
            List<Visitor> visitorList = visitorMapper.selectList(visitQuery);
            if (visitorList.size() > 0) {
                visitor = visitorList.get(0);
                if (vo.getName() != null && !vo.getName().equals(""))
                    visitor.setName(vo.getName());
                if (vo.getCompanyName() != null && !vo.getCompanyName().equals(""))
                    visitor.setCompanyName(vo.getCompanyName());
                if (vo.getUserStation() != null && !vo.getUserStation().equals(""))
                    visitor.setUserStation(vo.getUserStation());
                if (vo.getCartNo() != null && !vo.getCartNo().equals(""))
                    visitor.setCartNo(vo.getCartNo());
                if (vo.getCarNo() != null && !vo.getCarNo().equals(""))
                    visitor.setCarNo(vo.getCarNo());
                if (vo.getVisitorAttribute() != null)
                    visitor.setVisitorAttribute(vo.getVisitorAttribute());
                if (vo.getEnterpriseId() != null)
                    visitor.setEnterpriseId(vo.getEnterpriseId());
                visitorMapper.updateById(visitor);
            } else {
                visitor.setTel(vo.getTel());
                if (vo.getName() != null && !vo.getName().equals(""))
                    visitor.setName(vo.getName());
                if (vo.getCompanyName() != null && !vo.getCompanyName().equals(""))
                    visitor.setCompanyName(vo.getCompanyName());
                if (vo.getUserStation() != null && !vo.getUserStation().equals(""))
                    visitor.setUserStation(vo.getUserStation());
                if (vo.getCartNo() != null && !vo.getCartNo().equals(""))
                    visitor.setCartNo(vo.getCartNo());
                if (vo.getCarNo() != null && !vo.getCarNo().equals(""))
                    visitor.setCarNo(vo.getCarNo());
                if (vo.getVisitorAttribute() != null)
                    visitor.setVisitorAttribute(vo.getVisitorAttribute());
                if (vo.getEnterpriseId() != null)
                    visitor.setEnterpriseId(vo.getEnterpriseId());
                visitorMapper.insert(visitor);
            }
        }


        Abnormal abnormal = new Abnormal();
        if (vo.getId() == null) {
            BeanUtils.copyTo(vo, abnormal);
            if (visitor.getId() != null)
                abnormal.setVisitorId(visitor.getId());
            baseMapper.insert(abnormal);
        } else {
            abnormal = baseMapper.selectById(vo.getId());
            if (abnormal == null)
                throw new BizException("查询不到异常通行记录");
            BeanUtils.copyTo(vo, abnormal);
            if (visitor.getId() != null)
                abnormal.setVisitorId(visitor.getId());
            baseMapper.updateById(abnormal);
        }

        if (vo.getAbnormalImgVoList() != null && vo.getAbnormalImgVoList().size() != 0) {
            LambdaQueryWrapper<AbnormalImg> imgQuery = QueryBuilder.<AbnormalImg>lambdaQuery()
                .eq(AbnormalImg::getAbnormalId, abnormal.getId());
            abnormalImgMapper.delete(imgQuery);
            for (AbnormalImgVo imgVo : vo.getAbnormalImgVoList()) {
                AbnormalImg img = new AbnormalImg();
                BeanUtils.copyTo(imgVo, img);
                img.setAbnormalId(abnormal.getId());
                abnormalImgMapper.insert(img);
            }
        }
    }
}
