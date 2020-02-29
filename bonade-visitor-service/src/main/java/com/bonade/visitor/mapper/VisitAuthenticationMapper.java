package com.bonade.visitor.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonade.visitor.domain.entity.VisitAuthentication;

@Mapper
public interface VisitAuthenticationMapper extends BaseMapper<VisitAuthentication> {
	
}
