package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.vo.AbnormalInVo;
import com.bonade.visitor.domain.vo.AbnormalOutVo;
import com.bonade.visitor.domain.vo.AbnormalRecordOutVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AbnormalMapper extends BaseMapper<Abnormal> {

    IPage<AbnormalOutVo> getPage(Page<Abnormal> page, @Param("vo") AbnormalInVo vo);

    IPage<AbnormalRecordOutVo> getRecordPage(Page<Abnormal> page, @Param("vo") AbnormalInVo vo);

}
