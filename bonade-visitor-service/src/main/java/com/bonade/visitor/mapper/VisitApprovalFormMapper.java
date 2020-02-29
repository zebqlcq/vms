package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonade.visitor.domain.entity.ApprovalForm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VisitApprovalFormMapper extends BaseMapper<ApprovalForm> {
	
	List<ApprovalForm> getApprovalForm(@Param("approvalId") Long approvalId);

}
