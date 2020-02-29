package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bonade.visitor.domain.dto.*;
import com.bonade.visitor.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zoushaopeng
 * @title: VisitIndexMapper
 * @projectName bonade-vms
 * @description:
 * @date 2019/12/23 9:51
 */
@Mapper
public interface VisitIndexMapper {

    IPage<VisitIndexRecordApproalDto> getVisitIndexRecordApproalPageList(IPage<VisitIndexRecordApproalDto> page, @Param("visitIndexRecordApproalPageVo") VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo, @Param("stateList") List<Integer> stateList, @Param("type") Integer type);

    IPage<VisitIndexRecordCopyApproalDto> getVisitIndexRecordCopyApproalPageList(IPage<VisitIndexRecordCopyApproalDto> page, @Param("visitIndexRecordApproalPageVo") VisitIndexRecordApproalPageVo visitIndexRecordApproalPageVo, @Param("type") Integer type);

    ApproalRecordDetailDto getApproalRecordDetail(@Param("id") Long id);

    IPage<VisitorDto> getVisitorPageList(IPage<VisitorDto> page, @Param("visitorPageVo") VisitorPageVo visitorPageVo);

    IPage<VisitorEnterpriseDto> getVisitorEnterprisePageList(IPage<VisitorEnterpriseDto> page, @Param("visitorEnterprisePageVo") VisitorEnterprisePageVo visitorEnterprisePageVo);

    IPage<InvitationRecordDto> getInvitationRecordPageList(IPage<InvitationRecordDto> page, @Param("invitationRecordPageVo") InvitationRecordPageVo invitationRecordPageVo);

    InvitationRecordDetailDto getInvitationRecordDetail(@Param("id") Long id);

    IPage<VisitorValidDto> getVisitorValidPageList(IPage<VisitorValidDto> page, @Param("visitorValidPageVo") VisitorValidPageVo visitorValidPageVo);

    VisitorValidDetailDto getVisitorValidDetail(@Param("id") Long id);

    List<VisitIndexRecordDto> getVisitIndexRecordList(@Param("visitorId") Long visitorId);

    VerifyVisitorDetailDto verifyVisitorDetail(@Param("id") Long id);

    List<VerifyVisitorApprovalDetailDto> getVerifyVisitorApprovalDetailList(@Param("id") Long id);

    List<VerifyVisitorBehaviorTraceDetailDto> getVerifyVisitorBehaviorTraceDetailList(@Param("visitRecordId") Long visitRecordId);

    AbnormalDto getAbnormalByVisitorId(@Param("enterpriseId") Long enterpriseId, @Param("visitorId") Long visitorId);
}
