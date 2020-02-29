package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.VisitRecord;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.enums.VisitorSource;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.mapper.VisitRecordMapper;
import com.bonade.visitor.mapper.VisitorMapper;
import com.bonade.visitor.service.remote.UaacService;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 访客档案服务
 * @author lqx
 */
@Service
public class VisitArchiveService extends ServiceImpl<VisitorMapper, Visitor> {

    private static final String ERRMSG = "未查询到访客档案记录";

    final static Map<Integer, String> weekMap = new HashMap<>();
    {
        weekMap.put(1, "周一");
        weekMap.put(2, "周二");
        weekMap.put(3, "周三");
        weekMap.put(4, "周四");
        weekMap.put(5, "周五");
        weekMap.put(6, "周六");
        weekMap.put(7, "周日");
    }

    @Autowired
    VisitRecordMapper visitRecordMapper;

    @Autowired
    UaacService uaacService;

    public Page<VisitArchivePageOutVo> selectVisitorArchivePage(VisitArchivePageVo pageVo){
        Page<VisitArchivePageOutVo> page = new Page<>(pageVo.getCurrent(), pageVo.getSize());

        Long enterpriseId = pageVo.getEnterpriseId();
        if(null == enterpriseId){
            throw new BizException("企业id为空");
        }

        //查询所有下级企业
        EnterpriseTreeVo tree = uaacService.groupList(enterpriseId);
        List<Long> enterpriseIdList = new ArrayList<>();
        if(null == tree){
            enterpriseIdList.add(enterpriseId);
        }else{
            do {
                enterpriseIdList.add(tree.getId());
            }while (null != tree.getChild() && tree.getChild().size() > 0);
        }

        page = baseMapper.selectVisitorArchivePage(page, enterpriseIdList, pageVo);
        page.getRecords().forEach(vo -> {
            if(null != vo.getVisitorAttribute()){
                vo.setVisitorAttributeName(vo.getVisitorAttribute().getDescription());
            }

            if(null != vo.getVisitStatus()){
                vo.setVisitStatusDesc(vo.getVisitStatus().getDescription());
            }
        });

        return page;
    }

    public Page<Visitor> visitorArchivePage4Enterprise(VisitArchivePageVo pageVo) {
        Page<Visitor> page = new Page<>(pageVo.getCurrent(), pageVo.getSize());

        Long enterpriseId = pageVo.getEnterpriseId();
        if (null == enterpriseId) {
            throw new BizException("企业id为空");
        }
        Wrapper<Visitor> wrapper = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getEnterpriseId, pageVo.getEnterpriseId())
            .eq(StringUtils.hasText(pageVo.getName()),Visitor::getName, pageVo.getName())
            .orderByDesc(Visitor::getCreateTime);
        page = baseMapper.selectPage(page, wrapper);
        page.getRecords().forEach(vo -> {
            if(null != vo.getVisitorAttribute()){
                vo.setVisitorAttributeName(vo.getVisitorAttribute().name());
            }
        });
        return page;
    }

    @Transactional
    public boolean addOrEditVisitArchive(VisitArchiveVo visitArchiveVo){
        if(null == visitArchiveVo.getId()){
            //校验重复数据
            if(null != visitArchiveVo.getEnterpriseId() && null != visitArchiveVo.getName() && null != visitArchiveVo.getTel()){
                Wrapper<Visitor> wrapper = QueryBuilder.<Visitor>lambdaQuery()
                    .eq(Visitor::getEnterpriseId, visitArchiveVo.getEnterpriseId())
                    .eq(Visitor::getName, visitArchiveVo.getName())
                    .eq(Visitor::getTel, visitArchiveVo.getTel());
                Integer count = baseMapper.selectCount(wrapper);
                if(count > 0){
                    throw new BizException("库中已存在该访客信息");
                }
            }else{
                throw new BizException("缺少必要参数");
            }

            Visitor visitor = new Visitor();
            BeanUtils.copyProperties(visitArchiveVo, visitor);
            baseMapper.insert(visitor);
            //处理访问记录
            /*if(null != visitArchiveVo.getVisitArchiveRecord()){
                VisitArchiveRecordVo recordVo = visitArchiveVo.getVisitArchiveRecord();
                recordVo.setId(null);
                addOrEditVisitRecord(visitor.getId(), recordVo);
            }*/
        }else{
            Visitor visitor = baseMapper.selectById(visitArchiveVo.getId());
            if(null == visitor){
                throw new BizException(ERRMSG);
            }
            BeanUtils.copyProperties(visitArchiveVo, visitor, "id", "createTime", "createUsername", "valid", "version");
            baseMapper.updateById(visitor);
            //处理访问记录
            /*if(null != visitArchiveVo.getVisitArchiveRecord()){
                VisitArchiveRecordVo recordVo = visitArchiveVo.getVisitArchiveRecord();
                addOrEditVisitRecord(visitor.getId(), recordVo);
            }*/
        }
        return true;
    }

    public void addOrEditVisitRecord(Long visitId, VisitArchiveRecordVo recordVo){
        if(null == recordVo.getId()){
            VisitRecord record = new VisitRecord();
            record.setEnterpriseId(recordVo.getEnterpriseId());
            record.setEnterpriseName(recordVo.getEnterpriseName());
            record.setVisitorId(visitId);
            record.setInternalStaffUserId(recordVo.getInternalStaffUserId());
            record.setInternalStaffUserName(recordVo.getInternalStaffUserName());
            record.setInternalStaffUserTel(recordVo.getInternalStaffUserTel());
//            record.setSource(VisitorSource.INNER.getValue());
            visitRecordMapper.insert(record);
        }else{
            VisitRecord record = visitRecordMapper.selectById(recordVo.getId());
            record.setEnterpriseId(recordVo.getEnterpriseId());
            record.setEnterpriseName(recordVo.getEnterpriseName());
            record.setInternalStaffUserId(recordVo.getInternalStaffUserId());
            record.setInternalStaffUserName(recordVo.getInternalStaffUserName());
            record.setInternalStaffUserTel(recordVo.getInternalStaffUserTel());
            visitRecordMapper.updateById(record);
        }
    }

    public VisitArchiveDetailVo queryVisitArchiveDetail(Long id){
        Visitor visitor = baseMapper.selectById(id);
        if(null == visitor){
            throw new BizException(ERRMSG);
        }
        VisitArchiveDetailVo detail = new VisitArchiveDetailVo();
        BeanUtils.copyProperties(visitor, detail);

        if(null != detail.getVisitorAttribute()){
            detail.setVisitorAttributeName(detail.getVisitorAttribute().name());
        }

        List<VisitRecordDetailVo> recordVoList = new ArrayList<>();

        List<VisitRecordDetailVo> recordList = visitRecordMapper.selectRecordDetail(visitor.getId());
        if(recordList.size() > 0){
            recordList.forEach(record -> {
                VisitRecordDetailVo vo = new VisitRecordDetailVo();
                BeanUtils.copyProperties(record, vo);

                if(null != vo.getRegistration()){
                    vo.setRegistrationDesc(vo.getRegistration().name());
                }

                if(null != vo.getVisitCause()){
                    vo.setVisitCauseDesc(vo.getVisitCause().name());
                }

                if(null != vo.getVisitStatus()){
                    vo.setVisitStatusDesc(vo.getVisitStatus().name());
                }

                if(null != vo.getState()){
                    vo.setStateDesc(vo.getState().name());
                }
                recordVoList.add(vo);
            });
        }

        detail.setVisitRecordList(recordVoList);

        return detail;
    }

    /**
     * 根据条件统计访客档案
     * today 今日
     * week 本周
     * month 本月
     * year 全年
     * @param condition
     * @return
     */
    public VisitArchiveStatisticsVo queryVisitArchiveStatistics(Long enterpriseId, String condition){
        VisitArchiveStatisticsVo statisticsVo = new VisitArchiveStatisticsVo();

        Wrapper<VisitRecord> recordWrapper = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getEnterpriseId, enterpriseId)
            .in(VisitRecord::getVisitStatus, 3, 6);
        Integer accumulativeAllCount = visitRecordMapper.selectCount(recordWrapper);
        statisticsVo.setAccumulativeAllCount(accumulativeAllCount);

        Map<String, Object> param = cinvertCondition(condition);
        param.put("enterpriseId", enterpriseId);
        List<VisitArchiveStatisticsDetailVo> detailVoList = baseMapper.visitArchiveStatistics(param);

        //当前条件统计
        List<VisitArchiveStatisticsDetailVo> thisDetailList = new ArrayList<>();
        //当前条件减1统计
        List<VisitArchiveStatisticsDetailVo> preDetailList = new ArrayList<>();

        detailVoList.forEach(detail -> {
            if("t".equals(detail.getBj())){
                thisDetailList.add(detail);
            }else if("o".equals(detail.getBj())){
                preDetailList.add(detail);
            }
        });

        //当前条件的详细统计
        statisticsVo.setDetailList(replenishData(thisDetailList, condition));

        Integer thisCount = 0;
        Integer preCount = 0;

        for(VisitArchiveStatisticsDetailVo detail : thisDetailList){
            thisCount += detail.getRc();
        }
        for(VisitArchiveStatisticsDetailVo detail : preDetailList){
            preCount += detail.getRc();
        }

        //访问人次
        statisticsVo.setCount(thisCount);
        //环比
        BigDecimal thisCountBig = new BigDecimal(thisCount);
        BigDecimal preCountBig = new BigDecimal(preCount);
        BigDecimal difference = thisCountBig.subtract(preCountBig);
        BigDecimal factor = new BigDecimal(100);
        if(thisCount == 0){
            statisticsVo.setChainRatio(preCountBig.multiply(new BigDecimal(-100)).setScale(0));
        }else if(preCount == 0){
            statisticsVo.setChainRatio(thisCountBig.multiply(new BigDecimal(100)).setScale(0));
        }else{
            statisticsVo.setChainRatio(difference.divide(preCountBig, 2, BigDecimal.ROUND_HALF_UP).multiply(factor).setScale(0));
        }

        return statisticsVo;
    }

    public List<VisitArchiveStatisticsDetailVo> replenishData(List<VisitArchiveStatisticsDetailVo> detailList, String condition){
        List<VisitArchiveStatisticsDetailVo> list = new ArrayList<>();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        Map<String, VisitArchiveStatisticsDetailVo> map = new HashMap<>();
        if("today".equals(condition)){
            map = detailList.stream().collect(Collectors.toMap(vo -> vo.getRq().substring(vo.getRq().indexOf(" ") + 1), vo -> vo));
        }else{
            map = detailList.stream().collect(Collectors.toMap(vo -> vo.getRq(), vo -> vo));
        }
        switch (condition){
            case "today":
                List<String> hour = new ArrayList<>();
                for(int i=1; i<=24; i++){
                    String hourStr = i + "";
                    if(i < 10){
                        hourStr = "0" + hourStr;
                    }
                    hour.add(hourStr);
                }
                for(String h : hour) {
                    if (map.containsKey(h)) {
                        VisitArchiveStatisticsDetailVo vo = map.get(h);
                        vo.setBj(null);
                        vo.setRq(h);
                        list.add(vo);
                    } else {
                        list.add(new VisitArchiveStatisticsDetailVo(0, h));
                    }
                }
                break;
            case "week" :

                DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MM/dd");
                int weekDay = today.getDayOfWeek().getValue();
                for(int j=1; j<=7; j++){
                    LocalDate date = today.plusDays(j - weekDay);
                    String key = date.format(f);
                    if(map.containsKey(key)){
                        VisitArchiveStatisticsDetailVo vo = map.get(key);
                        vo.setBj(null);
                        vo.setRq(LocalDate.parse(vo.getRq(), f).format(f2) + " " + weekMap.get(j));
                        list.add(vo);
                    }else{
                        list.add(new VisitArchiveStatisticsDetailVo(0, date.format(f2) + " " + weekMap.get(j)));
                    }
                }
                break;
            case "month" :
                int monthDay = today.getDayOfMonth();
                LocalDate nextMonth = today.plusMonths(1);
                int monthDays = nextMonth.plusDays(-nextMonth.getDayOfMonth()).getDayOfMonth();
                for(int m=1; m<=monthDays; m++){
                    LocalDate date = today.plusDays(m-monthDay);
                    String key = date.format(f);
                    if(map.containsKey(key)){
                        VisitArchiveStatisticsDetailVo vo = map.get(key);
                        vo.setBj(null);
                        list.add(vo);
                    }else{
                        list.add(new VisitArchiveStatisticsDetailVo(0, key));
                    }
                }
                break;
        }
        return list;
    }

    public Map<String, Object> cinvertCondition(String condition){
        Map<String, Object> param = new HashMap<>();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        switch (condition){
            case "today":
                param.put("startTime", today);
                param.put("endTime", today);
                param.put("preStartTime", today.plusDays(-1));
                param.put("preEndTime", today.plusDays(-1));
                param.put("dataPattern", "%Y-%m-%d %H");
                break;
            case "week" :
                int dayOfWeek = today.getDayOfWeek().getValue();
                LocalDate firstDayOfWeek = today.plusDays(-(dayOfWeek - 1));
                LocalDate preFirstDayOfWeek = today.plusDays(-(dayOfWeek - 1 + 7));
                LocalDate preLastDayOfWeek = today.plusDays(-dayOfWeek);
                param.put("startTime", firstDayOfWeek);
                param.put("endTime", today);
                param.put("preStartTime", preFirstDayOfWeek);
                param.put("preEndTime", preLastDayOfWeek);
                param.put("dataPattern", "%Y-%m-%d");
                break;
            case "month" :
                int dayOfMonth = today.getDayOfMonth();
                int month = today.getMonthValue();
                int year = today.getYear();
                LocalDate preMonthDay = today.plusMonths(-1);
                int preMonth = preMonthDay.getMonth().getValue();
                int preYear = preMonthDay.getYear();

                LocalDate firstDayOfMonth = LocalDate.parse(year + "-" + (month < 10 ? ("0" + month) : month) + "-01", f);
                LocalDate preFirstDayOfMonth = LocalDate.parse(preYear + "-" + (preMonth < 10 ? ("0" + preMonth) : preMonth) + "-01", f);
                LocalDate preLastDayOfMonth = today.plusDays(-dayOfMonth);
                param.put("startTime", firstDayOfMonth);
                param.put("endTime", today);
                param.put("preStartTime", preFirstDayOfMonth);
                param.put("preEndTime", preLastDayOfMonth);
                param.put("dataPattern", "%Y-%m-%d");
                break;
            case "year" :
                int nowYear = today.getYear();
                param.put("startTime", LocalDate.parse(nowYear + "-01-01", f));
                param.put("endTime", LocalDate.parse(nowYear + "-12-31", f));
                break;
            default:
                throw new BizException("未知条件");
        }
        return param;
    }

    /**
     * 查询访客档案，最多5000条
     * @param queryVo
     * @return
     */
    public List<VisitArchivePageOutVo> selectVisitorArchiveList(VisitArchiveQueryVo queryVo){
        List<VisitArchivePageOutVo> list = baseMapper.selectVisitorArchiveList(queryVo);
        list.forEach(vo -> {
            if(null != vo.getVisitorAttribute()){
                vo.setVisitorAttributeName(vo.getVisitorAttribute().name());
            }
        });return list;
    }
}
