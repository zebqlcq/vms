package com.bonade.visitor.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.job.core.enums.JobStatus;
import org.spin.job.core.handler.annotation.JobHandler;
import org.spin.job.core.log.JobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.dto.UserViewDto;
import com.bonade.visitor.domain.entity.ScheduleList;
import com.bonade.visitor.domain.vo.ScheduleListVo;
import com.bonade.visitor.domain.vo.ScheduleVo;
import com.bonade.visitor.mapper.ScheduleListMapper;
import com.bonade.visitor.service.remote.UaacService;
import com.bonade.visitor.service.sms.SmsConstants;
import com.bonade.visitor.util.DateUtil;

@Service
public class ScheduleListService extends ServiceImpl<ScheduleListMapper, ScheduleList> {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleListService.class);

	@Autowired
	private ScheduleListMapper scheduleListMapper;

//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
//	
//	@Autowired
//	private VisitNotifyMapper visitNotifyMapper ;
	
	@Autowired
	private VisitRecordService visitRecordService;
	
	@Autowired
	private UaacService uaacService;
	
//	static String key = "xqc_visit_"+ ":scheduleList";
//	static String lockKey ="xqc_visit_" + "lock" + "_" + ":scheduleList";
	/**
	 * 
	 * @Title: scheduleList   
	 * @Description:日程清单列表
	 * @param: @param userId
	 * @param: @return      
	 * @return: List<ScheduleList>      
	 * @throws   
	 * @author: lcq
	 * @date:   2019年12月27日 下午3:48:57
	 * @version 1.0
	 */
	public List<ScheduleList> scheduleList(ScheduleListVo vo) {
		LambdaQueryWrapper<ScheduleList> wrapper = QueryBuilder.<ScheduleList>lambdaQuery()
				.eq(ScheduleList::getUserId, vo.getUserId());
				
		if(!ObjectUtils.isEmpty(vo.getReminderDate())) {
			wrapper.between(ScheduleList::getReminderDate, vo.getReminderDate() + " 00:00:00", vo.getReminderDate() + " 23:59:59");
		}else {
			wrapper.between(ScheduleList::getReminderDate, DateUtil.format(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd) + " 00:00:00", DateUtil.format(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd) + " 23:59:59");
		}
		wrapper.orderByDesc(ScheduleList::getReminderDate);
		List<ScheduleList> scheduleList = scheduleListMapper.selectList(wrapper);
		for (int i = 0; i < scheduleList.size(); i++) {
			ScheduleList schedule = scheduleList.get(i);
			try {
				schedule.setScheduleContent(new String(Base64.decodeBase64(schedule.getScheduleContent()),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return scheduleList;
	}
	
	/**
	 * 
	 * @Title: scheduleDetail   
	 * @Description: 日程详情
	 * @param: @param id
	 * @param: @return      
	 * @return: ScheduleList      
	 * @throws   
	 * @author: lcq
	 * @date:   2019年12月27日 下午5:43:00
	 * @version 1.0
	 */
	public ScheduleList scheduleDetail(Long id) {
		ScheduleList schedule = scheduleListMapper.selectById(id);
		try {
			schedule.setScheduleContent(new String(Base64.decodeBase64(schedule.getScheduleContent()),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return schedule;
	}
	
	/**
	 * 
	 * @Title: addSchedule   
	 * @Description: 添加日程
	 * @param: @param vo      
	 * @return: void      
	 * @throws   
	 * @author: lcq
	 * @date:   2019年12月27日 下午3:49:15
	 * @version 1.0
	 */
	@Transactional
	public void addSchedule(ScheduleVo vo) {
		try {
			
			UserViewDto dto = uaacService.getUserDetail(vo.getUserId());
			if(ObjectUtils.isEmpty(dto)) {
				throw new BizException("UserId=" + vo.getUserId() + "不存在");
			}
			if(ObjectUtils.isEmpty(dto.getPhone())) {
				throw new BizException("用户手机号不存在，无法添加");
			}
			ScheduleList schedule = new ScheduleList();
			schedule.setUserId(vo.getUserId());
			schedule.setScheduleTitle(vo.getScheduleTitle());
			schedule.setScheduleContent(new String(Base64.encodeBase64(vo.getScheduleContent().getBytes("UTF-8"))));
			schedule.setReminderDate(DateUtil.date2LocalDateTime(DateUtil.string2Date(vo.getReminderDate(), "yyyy-MM-dd HH:mm")));
			schedule.setUserTel(dto.getPhone());
			scheduleListMapper.insert(schedule);
			
			
//			Object str = stringRedisTemplate.opsForHash().get(key, lockKey);
//
//			if (!ObjectUtils.isEmpty(str)) {
//				String schedules = JSON.parseObject(str.toString(), String.class);
//				List<ScheduleList> scheduleList = JSONObject.parseArray(schedules, ScheduleList.class);
//				scheduleList.add(schedule);
//				stringRedisTemplate.opsForHash().put(key, lockKey, JSONObject.toJSONString(scheduleList));
//			} else {
//				List<ScheduleList> scheduleList = new ArrayList<>();
//				scheduleList.add(schedule);
//				stringRedisTemplate.opsForHash().put(key, lockKey, JSONObject.toJSONString(scheduleList));
//			}
//            stringRedisTemplate.expire(key, 24, TimeUnit.DAYS);
            
		} catch (Exception e) {
			logger.error("添加日程失败：", e.toString());
			throw new BizException("添加失败");
		}
	}
	
	/**
	 * 
	 * @Title: addSchedule   
	 * @Description: 删除日程
	 * @param: @param vo      
	 * @return: void      
	 * @throws   
	 * @author: lcq
	 * @date:   2019年12月27日 下午3:51:12
	 * @version 1.0
	 */
	public void delSchedule(Long id) {
		try {
			scheduleListMapper.deleteById(id);
		} catch (Exception e) {
			logger.error("删除日程失败：", e.toString());
			throw new BizException("删除失败");
		}
	}
	
	/**
	 * 
	 * @Title: checkedSchedule   
	 * @Description: 选中日程
	 * @param: @param id
	 * @param: @param checked      
	 * @return: void      
	 * @throws   
	 * @author: lcq
	 * @date:   2020年1月10日 下午4:44:06
	 * @version 1.0
	 */
	public void checkedSchedule(Long id,Integer checked) {
		Wrapper<ScheduleList> wrapper = QueryBuilder.<ScheduleList>lambdaQuery()
				.eq(ScheduleList::getId,id);
		ScheduleList schedule = null;
		try {
			schedule = scheduleListMapper.selectOne(wrapper);
		} catch (Exception e) {
			logger.error("checkedSchedule失败：",e.toString());
			throw new BizException("日程数据异常！");
		}
		if(ObjectUtils.isEmpty(schedule)) {
			throw new BizException("【id=\" + id + \"】日程不存在") ;
		}
		try {
			schedule.setChecked(checked);
			scheduleListMapper.updateById(schedule);
		} catch (Exception e) {
			logger.error("更新失败：", e.toString());
			throw new BizException("更新失败");
		}
	}
	
	/**
	 * 
	 * @Title: remind   
	 * @Description: 日程提醒
	 * @param:       
	 * @return: void      
	 * @throws   
	 * @author: lcq
	 * @date:   2019年12月30日 下午1:23:10
	 * @version 1.0
	 */
	@Transactional
	@JobHandler
	public void scheduleRemind() {
		String reminderTime = DateUtil.format(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM);
		List<ScheduleList> scheduleList = scheduleListMapper.scheduleListReminder(reminderTime);
		if(!ObjectUtils.isEmpty(scheduleList)) {
			for (int i = 0; i < scheduleList.size(); i++) {
				ScheduleList schedule = scheduleList.get(i);
				//TODO 站内信
				try {
					visitRecordService.sendNotify(null, SmsConstants.RCTX, null, null, null, schedule, null, null, null,null);
				} catch (Exception e) {
					logger.error("scheduleRemind报错:",e.toString());
					JobLogger.log(null, e.toString(), JobStatus.FAIL);
				}
				
			}
		}
//		try {
//			Object strRedis = stringRedisTemplate.opsForHash().get(key, lockKey);
//			String scheduleListStr  = JSON.parseObject(strRedis.toString(), String.class);
//			List<ScheduleList> scheduleList = JSONObject.parseArray(scheduleListStr, ScheduleList.class);
//			if(!ObjectUtils.isEmpty(scheduleList)) {
//				for (int i = 0; i < scheduleList.size(); i++) {
//					ScheduleList schedule = scheduleList.get(i);
//					String newDate = DateUtil.format(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM);
//					String localDate = DateUtil.format(DateUtil.localDateTime2Date(schedule.getReminderDate()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM);
//					if(newDate.equals(localDate)) {
//						//TODO 发通知
//						VisitNotify visitNotify = new VisitNotify();
//						visitNotify.setUserId(schedule.getUserId());
//						visitNotify.setNotifyTitle(schedule.getScheduleTitle());
//						visitNotify.setNotifyContent(schedule.getScheduleContent());
//						visitNotify.setNotifyType(3);
//						visitNotifyMapper.insert(visitNotify);
//						
//						scheduleList.remove(i);
//					}
//				}
//				stringRedisTemplate.opsForHash().put(key, lockKey, JSONObject.toJSONString(scheduleList));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
