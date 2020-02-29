package com.bonade.visitor.service;

import com.bonade.visitor.domain.enums.GuardType;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.mapper.VisitRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.spin.common.throwable.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 访客数据统计
 * @author lqx
 */
@Service
public class VisitStatisticsService {

    @Autowired
    VisitRecordMapper visitRecordMapper;

    @Autowired
    VisitArchiveService visitArchiveService;

    /**
     * 统计访客预约申请人次或邀约访客发起人次
     * @param enterpriseId
     * @param condition
     * @return
     */
    public ApplyStatisticsVo applyStatistics(Long enterpriseId, String condition, Integer registration){
        if(1 == registration || 2 == registration){
            Map<String, Object> param = visitArchiveService.cinvertCondition(condition);
            param.put("enterpriseId", enterpriseId);
            param.put("registration", registration);
            ApplyStatisticsVo vo = visitRecordMapper.applyStatistics(param);
            if(1 == registration){
                BigDecimal rc = new BigDecimal(vo.getRc());
                BigDecimal preRc = new BigDecimal(vo.getPreRc());
                BigDecimal difference = rc.subtract(preRc);
                BigDecimal factor = new BigDecimal(100);
                if(0 == vo.getRc()){
                    vo.setHb(0);
                }else if(0 == vo.getPreRc()){
                    vo.setHb(rc.multiply(factor).intValue());
                }else{
                    vo.setHb(difference.divide(preRc, 2, BigDecimal.ROUND_HALF_UP).multiply(factor).intValue());
                }
            }else if(2 == registration){
                vo.setHb(vo.getRc() - vo.getPreRc());
            }
            List<VisitArchiveStatisticsDetailVo> applyDetailStatistics = visitRecordMapper.applyDetailStatistics(param);
            if(applyDetailStatistics.size() > 0){
                vo.setApplyDetailStatistics(visitArchiveService.replenishData(applyDetailStatistics, condition));
            }
            return vo;
        }else{
            throw new BizException("未知访问类型");
        }
    }

    /**
     * 访客到访人次统计
     * @param enterpriseId
     * @param condition
     * @return
     */
    public ArriveOnStatisticsVo arriveOnStatistics(Long enterpriseId, String condition){
        Map<String, Object> param = visitArchiveService.cinvertCondition(condition);
        param.put("enterpriseId", enterpriseId);
        return visitRecordMapper.arriveOnStatistics(param);
    }

    /**
     * 访问累计概况统计
     * @param enterpriseId
     * @param condition
     * @return
     */
    public AddUpStatisticsVo addUpStatistics(Long enterpriseId, String condition){
        Map<String, Object> param = visitArchiveService.cinvertCondition(condition);
        param.put("enterpriseId", enterpriseId);
        return visitRecordMapper.addUpStatistics(param);
    }

    /**
     * 访客角色占比统计
     * @param enterpriseId
     * @param condition
     * @return
     */
    public AttrStatisticsVo attrStatistics(Long enterpriseId, String condition){
        Map<String, Object> param = visitArchiveService.cinvertCondition(condition);
        param.put("enterpriseId", enterpriseId);
        return visitRecordMapper.attrStatistics(param);
    }

    /**
     * 来访事由占比统计
     * @param enterpriseId
     * @param condition
     * @return
     */
    public VisitCauseStatisticsVo visitCauseStatistics(Long enterpriseId, String condition){
        Map<String, Object> param = visitArchiveService.cinvertCondition(condition);
        param.put("enterpriseId", enterpriseId);
        return visitRecordMapper.visitCauseStatistics(param);
    }

    /**
     * 公司被访次数最多员工
     * @param statisticsQueryVo
     * @return
     */
    public List<EmployeeStatisticsVo> employeeStatistics(StatisticsQueryVo statisticsQueryVo){
        return visitRecordMapper.employeeStatistics(getCondition(statisticsQueryVo));
    }

    /**
     * 公司被访次数最多部门
     * @param statisticsQueryVo
     * @return
     */
    public List<DeptStatisticsOutVo> deptStatistics(StatisticsQueryVo statisticsQueryVo){
        if(null == statisticsQueryVo.getStartDate() || null == statisticsQueryVo.getEndDate()){
            throw new BizException("时间段条件不能为空");
        }
        LocalDate start = statisticsQueryVo.getStartDate();
        LocalDate end = statisticsQueryVo.getEndDate();
        List<DeptStatisticsOutVo> outVoList = new ArrayList<>();
        List<DeptStatisticsVo> voList = visitRecordMapper.deptStatistics(getCondition(statisticsQueryVo));
        Map<String, List<DeptStatisticsVo>> map = voList.stream().collect(Collectors.groupingBy(DeptStatisticsVo::getUserDept));
        for(String key : map.keySet()){
            DeptStatisticsOutVo vo = new DeptStatisticsOutVo();
            vo.setUserDept(key);

            List<DeptStatisticsOutDetailVo> detailList = new ArrayList<>();
            List<DeptStatisticsVo> list = map.get(key);
            Integer count = 0;
            for(DeptStatisticsVo detail : list){
                LocalDate startDate = start;
                while (!startDate.isEqual(end.plusDays(1))){
                    if(detail.getRq().isEqual(startDate)){
                        detailList.add(new DeptStatisticsOutDetailVo(detail.getRc(), detail.getRq()));
                        count += detail.getRc();
                    }else{
                        detailList.add(new DeptStatisticsOutDetailVo(0, startDate));
                    }
                    startDate = startDate.plusDays(1);
                }
            }

            vo.setRc(count);
            vo.setDeptDetailList(detailList);
            outVoList.add(vo);
        }
        return outVoList;
    }

    public Map<String, Object> getCondition(StatisticsQueryVo statisticsQueryVo){
        Map<String, Object> param = new HashMap<>();
        if(StringUtils.hasText(statisticsQueryVo.getCondition())){
            param = visitArchiveService.cinvertCondition(statisticsQueryVo.getCondition());
        }else{
            param.put("startTime", statisticsQueryVo.getStartDate());
            param.put("endTime", statisticsQueryVo.getEndDate());
        }
        param.put("enterpriseId", statisticsQueryVo.getEnterpriseId());
        return param;
    }

    /**
     * 企业硬件设备统计
     * @param enterpriseId
     * @param condition
     * @return
     */
    public DeviceStatisticVo deviceStatistic(Long enterpriseId, String condition){
        Map<String, Object> param = visitArchiveService.cinvertCondition(condition);
        param.put("enterpriseId", enterpriseId);
        DeviceStatisticVo vo = new DeviceStatisticVo();
        Map<String, Object> deviceStatistics = visitRecordMapper.deviceStatistics(param);
        if(null != deviceStatistics && !deviceStatistics.isEmpty()){
            vo.setNewDevice(ObjectUtils.isEmpty(deviceStatistics.get("newDevice")) ? 0 : Integer.valueOf(deviceStatistics.get("newDevice").toString()));
            vo.setRuningDevice(ObjectUtils.isEmpty(deviceStatistics.get("runingDevice")) ? 0 : Integer.valueOf(deviceStatistics.get("runingDevice").toString()));
            vo.setDefendDevice(ObjectUtils.isEmpty(deviceStatistics.get("defendDevice")) ? 0 : Integer.valueOf(deviceStatistics.get("defendDevice").toString()));
            vo.setInvalidDevice(ObjectUtils.isEmpty(deviceStatistics.get("invalidDevice")) ? 0 : Integer.valueOf(deviceStatistics.get("invalidDevice").toString()));
        }

        Map<String, Object> deviceAreaStatistics = visitRecordMapper.deviceAreaStatistics(param);
        if(null != deviceAreaStatistics && !deviceAreaStatistics.isEmpty()){
            vo.setAreaName(ObjectUtils.isEmpty(deviceAreaStatistics.get("name")) ? "" : String.valueOf(deviceAreaStatistics.get("name")));
            vo.setAreaDevice(ObjectUtils.isEmpty(deviceAreaStatistics.get("device")) ? 0 : Integer.valueOf(deviceAreaStatistics.get("device").toString()));
        }
        List<DeviceTypeStatisticVo> deviceTypeStatistics = visitRecordMapper.deviceTypeStatistics(param);
        if (deviceTypeStatistics.size() > 0){
            GuardType[] guardTypes = GuardType.values();
            for(GuardType guardType : guardTypes){
                if(!deviceTypeStatistics.stream().anyMatch(it -> it.getGuardType().equals(guardType))){
                    deviceTypeStatistics.add(new DeviceTypeStatisticVo(guardType, guardType.getDescription(), 0));
                }
            }
            deviceTypeStatistics.forEach(it -> {
                if (!StringUtils.hasText(it.getGuardTypeName()))
                    it.setGuardTypeName(it.getGuardType().getDescription());
            });
            vo.setDeviceTypeList(deviceTypeStatistics);
        }
        return vo;
    }
}
