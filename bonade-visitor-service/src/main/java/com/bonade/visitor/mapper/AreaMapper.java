package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.Area;
import com.bonade.visitor.domain.vo.AreaInVo;
import com.bonade.visitor.domain.vo.AreaOutVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreaMapper extends BaseMapper<Area> {

    IPage<AreaOutVo> getPage(Page<Area> page, @Param("vo") AreaInVo vo);

    List<AreaOutVo> getList(@Param("vo") AreaInVo vo);

}
