package com.bonade.visitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonade.visitor.domain.entity.VisitRecordBehaviorTrace;

@Mapper
public interface VisitRecordBehaviorTraceMapper extends BaseMapper<VisitRecordBehaviorTrace> {
	
	@Select("SELECT  \n" + 
			"				DISTINCT\n" + 
			"				IFNULL(DATE_FORMAT(a.create_time,'%Y-%m-%d %H:%i:%s'),'--') AS createTime,  \n" + 
			"				a.visit_record_id,  \n" + 
			"				IFNULL(DATE_FORMAT(a.operation_time,'%Y-%m-%d %H:%i:%s'),'--') AS operationTime,  \n" + 
			"				a.visit_status AS visitStatus,  \n" + 
			"				\"\" AS visitStatusName,  \n" + 
			"				a.pass_status AS passStatus,\n" + 
			"				CASE \n" + 
			"						WHEN a.pass_status = 1 then '通过'\n" + 
			"						WHEN a.pass_status = 2 then '拒绝'\n" + 
			"				END AS passStatusName,\n" + 
			"				a.opinion AS opinion,\n" + 
			"				a.user_name AS userName\n" + 
			"			FROM  \n" + 
			"				vms_visit_record_behavior_trace a \n" + 
			"			WHERE  \n" + 
			"				a.valid = 1\n" + 
			"			AND a.visit_record_id = #{visitRecordId}")
	List<VisitRecordBehaviorTrace> selectListByVisitRecordId(@Param("visitRecordId") Long visitRecordId);
}
