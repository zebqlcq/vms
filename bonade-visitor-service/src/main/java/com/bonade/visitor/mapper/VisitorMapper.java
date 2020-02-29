package com.bonade.visitor.mapper;

import com.bonade.visitor.domain.vo.*;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.Visitor;

import java.util.List;
import java.util.Map;

/**
 * @author chenmeng
 * @description
 * @date 2019-12-5 13:41
 */
public interface VisitorMapper extends BaseMapper<Visitor> {

    IPage<BlacklistOutVo> getVisitPage(Page<Visitor> page, @Param("vo")BlacklistInVo vo);

    IPage<BlacklistOutVo> getVisitorPage(Page<Visitor> page, @Param("vo")BlacklistInVo vo);

    Page<VisitArchivePageOutVo> selectVisitorArchivePage(Page<VisitArchivePageOutVo> page, @Param("enterpriseIdList") List<Long> enterpriseIdList, @Param("vo") VisitArchivePageVo pageVo);

    List<VisitArchivePageOutVo> selectVisitorArchiveList(@Param("vo") VisitArchiveQueryVo queryVo);

    List<VisitArchiveStatisticsDetailVo> visitArchiveStatistics(@Param("vo")Map<String, Object> param);
}
