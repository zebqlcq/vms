package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.entity.Guard;
import com.bonade.visitor.domain.vo.AbnormalInVo;
import com.bonade.visitor.domain.vo.AbnormalOutVo;
import com.bonade.visitor.domain.vo.GuardInVo;
import com.bonade.visitor.domain.vo.GuardOutVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface GuardMapper extends BaseMapper<Guard> {

    IPage<GuardOutVo> getPage(Page<Guard> page, @Param("vo") GuardInVo vo);

    IPage<GuardOutVo> getGardenGuardPage(Page<Guard> page, @Param("vo") GuardInVo vo);

}
