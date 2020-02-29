package com.bonade.visitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonade.visitor.domain.entity.ScheduleList;

/**
 * 
 * @ClassName:  ScheduleListMapper   
 * @Description:
 * @author: lcq 
 * @date:   2019年12月27日 下午2:46:37   
 * @version 1.0
 */
public interface ScheduleListMapper extends BaseMapper<ScheduleList> {
	List<ScheduleList> scheduleListReminder(@Param("reminderTime") String reminderTime);
}
