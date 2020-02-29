package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.GardenArea;
import com.bonade.visitor.domain.vo.AreaInVo;
import com.bonade.visitor.domain.vo.GardenAreaInVo;
import com.bonade.visitor.domain.vo.GardenAreaOutVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface GardenAreaMapper extends BaseMapper<GardenArea> {

    IPage<GardenAreaOutVo> getPage(Page<GardenArea> page, @Param("vo") GardenAreaInVo vo);

    List<GardenAreaOutVo> getList(@Param("id") Long id);

    void delEnt(@Param("map") Map<String,Object> map);

}
