package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonade.visitor.domain.entity.AbnormalImg;
import com.bonade.visitor.domain.entity.VisitRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AbnormalImgMapper extends BaseMapper<AbnormalImg> {

}
