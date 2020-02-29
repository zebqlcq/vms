package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.GardenArea;
import com.bonade.visitor.domain.entity.GateSentry;
import com.bonade.visitor.domain.vo.GateSentryInVo;
import com.bonade.visitor.domain.vo.GateSentryOutVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface GateSentryMapper extends BaseMapper<GateSentry> {

    IPage<GateSentryOutVo> getPage(Page<GateSentry> page, @Param("vo") GateSentryInVo vo);

}
