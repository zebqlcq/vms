package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.dto.VisitRecordDetailDto;
import com.bonade.visitor.domain.dto.VisitRecordDto;
import com.bonade.visitor.domain.dto.VisitRecordForGuardDto;
import com.bonade.visitor.domain.entity.ApprovalDetail;
import com.bonade.visitor.domain.entity.VisitRecord;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface VisitRecordMapper extends BaseMapper<VisitRecord> {

	List<Visitor> visitorCodeList(@Param("enterpriseId") Long enterpriseId,@Param("fistCode") char fistCode);
	
	IPage<VisitRecordForGuardDto> visitRecordForGuard(Page<VisitRecordForGuardDto> page, @Param("vo") VisitRecordForGuardVo vo);

	IPage<VisitRecordForGuardDto> visitRecordForGuardHistory(Page<VisitRecordForGuardDto> page, @Param("vo") VisitRecordForGuardVo vo);

	IPage<VisitRecordDto> approvalVisitRecord(Page<VisitRecordDto> page, @Param("vo") HomeVo vo, @Param("stateList") List<Integer> stateList, @Param("approvalState") Integer approvalState, @Param("type") Integer type);

	IPage<VisitRecordDto> visitRecordHistory(Page<VisitRecordDto> page, @Param("vo") HomeVo vo);

	VisitRecordDetailDto getVisitRecordDetail(@Param("id") Long visitRecordId);

	List<ApprovalDetail> getApprovalDetailList(@Param("visitRecordId") Long visitRecordId, @Param("type") Integer type);

	void loginValidate(@Param("visitorId") Long visitorId, @Param("visitStatus") Integer visitStatus,@Param("registration") Integer registration);

    public ApplyStatisticsVo applyStatistics(@Param("param") Map<String, Object> param);

    public ArriveOnStatisticsVo arriveOnStatistics(@Param("param") Map<String, Object> param);

    public AddUpStatisticsVo addUpStatistics(@Param("param") Map<String, Object> param);

    public AttrStatisticsVo attrStatistics(@Param("param") Map<String, Object> param);

    public VisitCauseStatisticsVo visitCauseStatistics(@Param("param") Map<String, Object> param);

    public List<EmployeeStatisticsVo> employeeStatistics(@Param("param") Map<String, Object> param);

    public List<DeptStatisticsVo> deptStatistics(@Param("param") Map<String, Object> param);

    public List<VisitArchiveStatisticsDetailVo> applyDetailStatistics(@Param("param") Map<String, Object> param);

    public Map<String, Object> deviceStatistics(@Param("param") Map<String, Object> param);
    public Map<String, Object> deviceAreaStatistics(@Param("param") Map<String, Object> param);
    public List<DeviceTypeStatisticVo> deviceTypeStatistics(@Param("param") Map<String, Object> param);

    public  List<VisitRecordDetailVo> selectRecordDetail(@Param("visitorId") Long visitorId);

    IPage<VisitRecordVo> getRecordList(Page<VisitRecord> page, @Param("param") Map<String, Object> param);

    IPage<VisitRecordVo> getRecordAllList(Page<VisitRecord> page, @Param("param") Map<String, Object> param);
}
