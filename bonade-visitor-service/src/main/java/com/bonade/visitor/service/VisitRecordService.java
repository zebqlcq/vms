package com.bonade.visitor.service;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.ErrorCode;
import org.spin.core.util.ImageUtils;
import org.spin.core.util.StringUtils;
import org.spin.core.util.file.FileType;
import org.spin.core.util.qrcode.QrCodeUtils;
import org.spin.job.core.enums.JobStatus;
import org.spin.job.core.handler.annotation.JobHandler;
import org.spin.job.core.log.JobLogger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.dto.EmpDetailViewDto;
import com.bonade.visitor.domain.dto.EmployeeHomePageDto;
import com.bonade.visitor.domain.dto.FileDto;
import com.bonade.visitor.domain.dto.RoleConfigDto;
import com.bonade.visitor.domain.dto.UserViewDto;
import com.bonade.visitor.domain.dto.VisitInvitationInitDto;
import com.bonade.visitor.domain.dto.VisitRecordDetailDto;
import com.bonade.visitor.domain.dto.VisitRecordDto;
import com.bonade.visitor.domain.dto.VisitRecordForGuardDto;
import com.bonade.visitor.domain.entity.Approval;
import com.bonade.visitor.domain.entity.ApprovalDetail;
import com.bonade.visitor.domain.entity.ApprovalForm;
import com.bonade.visitor.domain.entity.Area;
import com.bonade.visitor.domain.entity.MessageNoticeTemplate;
import com.bonade.visitor.domain.entity.ScheduleList;
import com.bonade.visitor.domain.entity.VisitAuthentication;
import com.bonade.visitor.domain.entity.VisitFollowUser;
import com.bonade.visitor.domain.entity.VisitInviteTemplate;
import com.bonade.visitor.domain.entity.VisitNotify;
import com.bonade.visitor.domain.entity.VisitRecord;
import com.bonade.visitor.domain.entity.VisitRecordBehaviorTrace;
import com.bonade.visitor.domain.entity.VisitRecordGateSentry;
import com.bonade.visitor.domain.entity.Visitor;
import com.bonade.visitor.domain.enums.ApprovalState;
import com.bonade.visitor.domain.enums.AreaType;
import com.bonade.visitor.domain.enums.ContentType;
import com.bonade.visitor.domain.enums.EnumUtil;
import com.bonade.visitor.domain.enums.NoticeType;
import com.bonade.visitor.domain.enums.PermissionRange;
import com.bonade.visitor.domain.enums.RefusalReason;
import com.bonade.visitor.domain.enums.RelationType;
import com.bonade.visitor.domain.enums.VisitCause;
import com.bonade.visitor.domain.enums.VisitStatus;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import com.bonade.visitor.domain.enums.VisitorRegistration;
import com.bonade.visitor.domain.remote.EmpViewVo;
import com.bonade.visitor.domain.remote.EnterpriseViewVo;
import com.bonade.visitor.domain.vo.Access4VisitorOutVo;
import com.bonade.visitor.domain.vo.AccessApprovalPermissionVo;
import com.bonade.visitor.domain.vo.AccessTrafficOutVo;
import com.bonade.visitor.domain.vo.AccessTrafficVo;
import com.bonade.visitor.domain.vo.ApplyFiles;
import com.bonade.visitor.domain.vo.AppointmentVo;
import com.bonade.visitor.domain.vo.ApprovalOperationVo;
import com.bonade.visitor.domain.vo.ApprovalSubmitVo;
import com.bonade.visitor.domain.vo.ApprovalUserVo;
import com.bonade.visitor.domain.vo.ApprovalVo;
import com.bonade.visitor.domain.vo.EmpRelationViewVo;
import com.bonade.visitor.domain.vo.FileFormVo;
import com.bonade.visitor.domain.vo.GateSentryOutVo;
import com.bonade.visitor.domain.vo.HomeVo;
import com.bonade.visitor.domain.vo.InvitationVo;
import com.bonade.visitor.domain.vo.MailFormVo;
import com.bonade.visitor.domain.vo.MailReceiverFormVo;
import com.bonade.visitor.domain.vo.MessageNoticeUserSerachVo;
import com.bonade.visitor.domain.vo.RolePermissionVo;
import com.bonade.visitor.domain.vo.SmsTemplateMessageVo;
import com.bonade.visitor.domain.vo.UserVo;
import com.bonade.visitor.domain.vo.VisitFollowUserVo;
import com.bonade.visitor.domain.vo.VisitRecordForGuardVo;
import com.bonade.visitor.domain.vo.VisitValidateVo;
import com.bonade.visitor.domain.vo.VisitorListVo;
import com.bonade.visitor.mapper.AreaMapper;
import com.bonade.visitor.mapper.ScheduleListMapper;
import com.bonade.visitor.mapper.VisitApprovalDetailMapper;
import com.bonade.visitor.mapper.VisitApprovalFormMapper;
import com.bonade.visitor.mapper.VisitApprovalMapper;
import com.bonade.visitor.mapper.VisitAuthenticationMapper;
import com.bonade.visitor.mapper.VisitFollowUserMapper;
import com.bonade.visitor.mapper.VisitInviteTemplateMapper;
import com.bonade.visitor.mapper.VisitNotifyMapper;
import com.bonade.visitor.mapper.VisitRecordBehaviorTraceMapper;
import com.bonade.visitor.mapper.VisitRecordGateSentryMapper;
import com.bonade.visitor.mapper.VisitRecordMapper;
import com.bonade.visitor.mapper.VisitorMapper;
import com.bonade.visitor.service.remote.AdminService;
import com.bonade.visitor.service.remote.MessageService;
import com.bonade.visitor.service.remote.UaacService;
import com.bonade.visitor.service.sms.SmsConstants;
import com.bonade.visitor.util.DateUtil;
import com.bonade.visitor.util.RuleUtil;

@Service
public class VisitRecordService extends ServiceImpl<VisitRecordMapper, VisitRecord> {

    private static final Logger logger = LoggerFactory.getLogger(VisitRecordService.class);
    @Autowired
    private VisitRecordMapper visitRecordMapper;

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private VisitFollowUserMapper visitFollowUserMapper;

    @Autowired
    private VisitRecordBehaviorTraceMapper visitRecordBehaviorTraceMapper;


    @Autowired
    private VisitApprovalMapper approvalMapper;

    @Autowired
    private VisitApprovalDetailMapper approvalDetailMapper;

    @Autowired
    private UaacService uaacService;

    @Autowired
    private VisitAuthenticationMapper visitAuthenticationMapper;

    @Autowired
    private VisitInviteTemplateMapper visitInviteTemplateMapper;

    @Autowired
    private MessageNoticeTemplateService messageNoticeTemplateService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private VisitNotifyMapper visitNotifyMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RolePermissionService permissionService;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private GateSentryService gateSentryService;

    @Autowired
    private ScheduleListMapper scheduleListMapper;

    @Autowired
    private VisitApprovalFormMapper approvalFormMapper;

    @Autowired
    private VisitRecordGateSentryMapper visitRecordGateSentryMapper;

    /**
     * @throws
     * @Title: getInvitationInit
     * @Description: 邀约初始化页面
     * @param: @param enterpriseId
     * @param: @return
     * @return: VisitInvitationInitDto
     * @author: lcq
     * @date: 2019年12月25日 下午3:32:40
     * @version 1.0
     */
    public VisitInvitationInitDto getInvitationInit(Long enterpriseId) {
    	enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
        VisitInvitationInitDto dto = new VisitInvitationInitDto();
        dto.setInviteTemplates(invitationTemplate(enterpriseId));
        dto.setMeetingRooms(meetingRoom(enterpriseId));
        //TODO 获取访客准入权限，初始化开放时间段
        return dto;
    }

    /**
     * @throws
     * @Title: invitationTemplate
     * @Description: 获取企业邀约模板
     * @param: @param enterpriseId
     * @param: @return
     * @return: List<VisitInviteTemplate>
     * @author: lcq
     * @date: 2019年12月25日 上午9:32:36
     * @version 1.0
     */
    public List<VisitInviteTemplate> invitationTemplate(Long enterpriseId) {
    	enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
        Wrapper<VisitInviteTemplate> wrapper = QueryBuilder.<VisitInviteTemplate>lambdaQuery()
            .eq(VisitInviteTemplate::getEnterpriseId, enterpriseId);
        List<VisitInviteTemplate> visitInviteTemplates = null;
        try {
            visitInviteTemplates = visitInviteTemplateMapper.selectList(wrapper);
        } catch (Exception e) {
            logger.error("邀约模板数据异常===enterpriseId：{};exp：{}", enterpriseId, e.toString());
            throw new BizException("邀约模板数据异常：" + e.getMessage()) ;
        }
        return visitInviteTemplates;
    }

    /**
     * @throws
     * @Title: meetingRoom
     * @Description: 获取企业接待会议室
     * @param: @param enterpriseId
     * @param: @return
     * @return: List<?>
     * @author: lcq
     * @date: 2019年12月25日 上午9:32:51
     * @version 1.0
     */
    public List<Area> meetingRoom(Long enterpriseId) {
        //TODO
    	enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
        Wrapper<Area> wrapper = QueryBuilder.<Area>lambdaQuery()
            .eq(Area::getEnterpriseId, enterpriseId)
            .eq(Area::getAreaType, AreaType.HYSQY);
        List<Area> areas = null;
        try {
            areas = areaMapper.selectList(wrapper);
        } catch (Exception e) {
            logger.error("接待会议室数据异常===enterpriseId：{};exp：{}", enterpriseId, e.toString());
            throw new BizException("接待会议室数据异常："  + e.getMessage());
        }
        return areas;
    }

    /**
     * @throws
     * @Title: visitorList
     * @Description: 获取企业访客
     * @param: @param enterpriseId
     * @param: @return
     * @return: List<Visitor>
     * @author: lcq
     * @date: 2019年12月25日 上午9:33:10
     * @version 1.0
     */
    public List<Visitor> visitorList(VisitorListVo vo) {
    	Long enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
        LambdaQueryWrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
            .ne(Visitor::getVisitorAttribute, VisitorAttribute.BLACK)
            .eq(Visitor::getEnterpriseId, enterpriseId);

        if (!ObjectUtils.isEmpty(vo.getNameOrTel())) {
            visitorWrapper.like(Visitor::getName, vo.getNameOrTel())
                .or().like(Visitor::getTel, vo.getNameOrTel());
        }

        List<Visitor> visitors = null;
        try {
            visitors = visitorMapper.selectList(visitorWrapper);
        } catch (Exception e) {
            logger.error("访客数据异常===enterpriseId：{};exp：{}", enterpriseId, e.toString());
            throw new BizException("访客数据异常：" + e.getMessage());
        }
        return visitors;
    }
    
    public Map<Object, Object> visitorCodeList(VisitorListVo vo) {
    	Long enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
//    	Long enterpriseId = vo.getEnterpriseId();
    	Map<Object, Object> map = new HashMap<>();
    	for (char i = 'A'; i <= 'Z'; i++) {
    		try {
    			List<Visitor> visitors = visitRecordMapper.visitorCodeList(enterpriseId,i);
    			map.put(i, visitors);
        	} catch (Exception e) {
        		logger.error("访客数据异常===enterpriseId：{};exp：{}", enterpriseId, e.toString());
        		throw new BizException("访客数据异常：" + e.getMessage());
        	}
    	}
    	return map;
    }

    /**
     * @throws
     * @Title: getInvitationInitOnclick
     * @Description: 姓名手机号获取访问开发时间、访客属性
     * @param: @param enterpriseId
     * @param: @param name
     * @param: @param tel
     * @param: @return
     * @return: VisitRecord
     * @author: lcq
     * @date: 2020年1月7日 下午3:11:24
     * @version 1.0
     */
    public VisitRecord getInvitationInitOnclick(Long enterpriseId, String name, String tel) {
    	enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
        Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getName, name)
            .eq(Visitor::getTel, tel)
            .eq(Visitor::getEnterpriseId, enterpriseId);
        Visitor visitor = null;
        try {
            visitor = visitorMapper.selectOne(visitorWrapper);
        } catch (Exception e) {
            logger.error("访客数据异常===enterpriseId：{};name：{};tel：{};exp：{}", enterpriseId, name, tel, e.toString());
            throw new BizException("访客数据异常：" + e.getMessage());
        }
        VisitRecord visitRecord = new VisitRecord();
        if (ObjectUtils.isEmpty(visitor)) {
            visitor = new Visitor();
            visitRecord.setVisitorAttribute(VisitorAttribute.VIP.getValue());
            visitRecord.setVisitorAttributeName(VisitorAttribute.VIP.getDescription());
            visitor.setVisitorAttribute(VisitorAttribute.VIP);
        } else {
        	if (Objects.equals(visitor.getVisitorAttribute().getValue(), VisitorAttribute.BLACK.getValue())) {
                throw new BizException("很抱歉通知您，黑名单访客无法发起邀约。如需解除禁用，请联系您的企业管理员！");
            }
            visitRecord.setVisitorAttribute(visitor.getVisitorAttribute().getValue());
            visitRecord.setVisitorAttributeName(visitor.getVisitorAttribute().getDescription());
        }
        visitRecord.setEnterpriseId(enterpriseId);
        getConfig(visitRecord, visitor);
        return visitRecord;
    }
    @Autowired
    private Validator validator;
    /**
     * @throws
     * @Title: invitation
     * @Description: 发起邀约
     * @param: @param vo
     * @return: void
     * @author: lcq
     * @date: 2020年1月6日 下午5:56:54
     * @version 1.0
     */
    @Transactional
    public void invitation(InvitationVo vo) {
    	StringBuilder errorMsg = new StringBuilder();
    	Set<ConstraintViolation<InvitationVo>> validate = null;
    	if(!ObjectUtils.isEmpty(vo.getCarNum())) {
            validate = validator.validate(vo, InvitationVo.CarNum.class);
            validate.forEach(it -> errorMsg.append(it.getMessageTemplate()).append(","));
        }
    	if(!ObjectUtils.isEmpty(vo.getInvitationExplain())) {
    		validate = validator.validate(vo, InvitationVo.InvitationExplain.class);
    		validate.forEach(it -> errorMsg.append(it.getMessageTemplate()).append(","));
    	}
    	if (StringUtils.isNotEmpty(errorMsg)) {
    		throw new BizException(errorMsg.substring(0, errorMsg.length() - 1));
		}
    	UserViewDto dto = uaacService.getUserDetail(vo.getInternalStaffUserId());
    	if(ObjectUtils.isEmpty(dto)) {
    		throw new BizException("获取用户详情信息为空");
    	}
        if (dto.getPhone().equals(vo.getInviteeTelephone())) {
            throw new BizException("邀请人与被邀请人手机号不能相同");
        }
        if (DateUtil.string2Date(vo.getAppointmentStartTime(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM).compareTo(DateUtil.string2Date(vo.getAppointmentEndTime(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM)) > 0) {
            throw new BizException("开始时间不能大于结束时间");
        }
        Long enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
        Long userId = CurrentUser.getCurrent().getId();
        String name = CurrentUser.getCurrent().getName();
        Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getName, vo.getInviteeName())
            .eq(Visitor::getTel, vo.getInviteeTelephone())
            .eq(Visitor::getEnterpriseId, enterpriseId);
        Visitor visitor = null;
        try {
            visitor = visitorMapper.selectOne(visitorWrapper);
        } catch (Exception e) {
            logger.error("访客数据异常===name：{};tel：{};exp：{}", vo.getInviteeName(), vo.getInviteeTelephone(), e.toString());
            throw new BizException("访客数据异常："  + e.getMessage());
        }

        if (null == visitor) {
            visitor = new Visitor();
            visitor.setName(vo.getInviteeName());
            visitor.setTel(vo.getInviteeTelephone());
            visitor.setEnterpriseId(enterpriseId);
            Optional<VisitorAttribute> visitorAttribute = EnumUtil.getEnum(vo.getVisitorAttribute(), VisitorAttribute.class, "访客属性");
            visitor.setVisitorAttribute(visitorAttribute.get());
            visitorMapper.insert(visitor);
        } else {
            if (Objects.equals(visitor.getVisitorAttribute().getValue(), VisitorAttribute.BLACK.getValue())) {
                throw new BizException("很抱歉通知您，被邀请人已被列为黑名单，暂不可发起邀约。如需解除禁用，请联系您的企业管理员！");
            }
        }

//        Long enterpriseId = vo.getEnterpriseId();
//        Long userId = vo.getInternalStaffUserId();
//        String name = dto.getRealName();

        VisitRecord visitRecord = new VisitRecord();
        visitRecord.setEnterpriseId(enterpriseId);
        visitRecord.setEnterpriseName(vo.getEnterpriseName());
        visitRecord.setVisitInviteTemplateId(vo.getVisitInviteTemplateId());
        visitRecord.setVisitorId(visitor.getId());
        visitRecord.setInternalStaffUserId(userId);
        visitRecord.setInternalStaffUserName(name);
        visitRecord.setInternalStaffUserTel(dto.getPhone());
        try {
			EmpDetailViewDto empDto = uaacService.employee();
			logger.info("EmpDetailViewDto： {}", empDto);
			if(!ObjectUtils.isEmpty(empDto)) {
				Map<RelationType, List<EmpRelationViewVo>> relationMap = empDto.getRelationMap();
				logger.info("relationMap： {}", relationMap);
				if(!ObjectUtils.isEmpty(relationMap)) {
					List<EmpRelationViewVo> empVo = relationMap.get(RelationType.DEPARTMENT);
					if(!ObjectUtils.isEmpty(empVo)) {
						EmpRelationViewVo erVo = empVo.get(0);
						visitRecord.setInternalStaffUserDept(erVo.getOrganName());
						visitRecord.setInternalStaffUserStation(erVo.getTitle());
					}
				}
			}
		} catch (Exception e1) {
			logger.error("uaacService.employee： {}" ,e1.getMessage());
			throw new BizException("获取部门、岗位失败：" + e1.getMessage());
		}
        visitRecord.setRegistration(VisitorRegistration.INNER.getValue());
        visitRecord.setAppointmentStartTime(DateUtil.date2LocalDateTime(DateUtil.string2Date(vo.getAppointmentStartTime(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM)));
        visitRecord.setAppointmentEndTime(DateUtil.date2LocalDateTime(DateUtil.string2Date(vo.getAppointmentEndTime(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM)));
        visitRecord.setMeetingRoom(vo.getMeetingRoom());
        visitRecord.setInvitationExplain(vo.getInvitationExplain());
        visitRecord.setVisitCause(vo.getVisitCause());
        visitRecord.setVisitStatus(VisitStatus.CHECKWAIT_2.getValue());
        visitRecord.setCarNum(vo.getCarNum());
        visitRecord.setAddress(vo.getAddress());

        if (vo.getFollowNum() > 30 || vo.getFollowNum() < 0) {
            throw new BizException("随访人数区间0-30");
        }
        visitRecord.setFollowNum(vo.getFollowNum());
        baseMapper.insert(visitRecord);
        //0.获取访客码、二维码等
        getConfig(visitRecord, visitor);

        //1.新增访客记录
        baseMapper.updateById(visitRecord);
        //随访人员信息
        if (!ObjectUtils.isEmpty(vo.getFollowUserList())) {
            for (int i = 0; i < vo.getFollowUserList().size(); i++) {
                VisitFollowUserVo visitFollowUserVo = vo.getFollowUserList().get(i);
                VisitFollowUser followUser = new VisitFollowUser();
                followUser.setVisitRecordId(visitRecord.getId());
                followUser.setUserName(visitFollowUserVo.getUserName());
                followUser.setUserIdentityCard(visitFollowUserVo.getUserIdentityCard());
                followUser.setUserTel(visitFollowUserVo.getUserTel());
                visitFollowUserMapper.insert(followUser);
            }
        }
        //事件记录
        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();
        trace.setVisitRecordId(visitRecord.getId());
        trace.setVisitStatus(VisitStatus.CHECKWAIT_2);
        trace.setOperationTime(visitRecord.getCreateTime());
        trace.setUserId(vo.getInternalStaffUserId());
        trace.setUserName(dto.getRealName());
        visitRecordBehaviorTraceMapper.insert(trace);

        /*
        //邀约无需审批
        String companyName = visitor.getCompanyName()!=null?visitor.getCompanyName():"";
        String jsonStr = "[" +
    			"{" +
    			"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"访客姓名\"," +
        		"        \"fieldValue\":\"" + vo.getInviteeName() + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"被邀请人姓名\"," +
        		"        \"fieldSort\":\"0\"" +
        		"}," +
        		"{" +
    			"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"当属企业\"," +
        		"        \"fieldValue\":\"" + companyName + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"被邀请人企业\"," +
        		"        \"fieldSort\":\"1\"" +
        		"}" +
        		"{" +
    			"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"发起时间\"," +
        		"        \"fieldValue\":\""+ DateUtil.getDateToString(new Date()) + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"邀约发起时间\"," +
        		"        \"fieldSort\":\"2\"" +
        		"}" +
        		"{" +
        		"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"访客手机号\"," +
        		"        \"fieldValue\":\""+ vo.getInviteeTelephone() + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"被邀请人手机号\"," +
        		"        \"fieldSort\":\"3\"" +
        		"}" +
        		"{" +
        		"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"访问对象\"," +
        		"        \"fieldValue\":\""+ vo.getInternalStaffUserName() + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"访问对象\"," +
        		"        \"fieldSort\":\"4\"" +
        		"}" +
        		"{" +
        		"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"访问事由\"," +
        		"        \"fieldValue\":\""+ EnumUtil.getByValue(vo.getVisitCause(), VisitCause.class,"访问事由")+ "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"邀访事由\"," +
        		"        \"fieldSort\":\"5\"" +
        		"}" +
        		"{" +
        		"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"访问时间\"," +
        		"        \"fieldValue\":\""+ vo.getAppointmentStartTime() + "~" + vo.getAppointmentEndTime() + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"邀访事由\"," +
        		"        \"fieldSort\":\"6\"" +
        		"}" +
        		"{" +
        		"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"车牌号\"," +
        		"        \"fieldValue\":\""+ vo.getCarNum() + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"车牌号\"," +
        		"        \"fieldSort\":\"7\"" +
        		"}" +
        		"{" +
        		"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"随访人数\"," +
        		"        \"fieldValue\":\""+ vo.getFollowUserList().size() + "\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"随访人数\"," +
        		"        \"fieldSort\":\"8\"" +
        		"}" +
        		"{" +
        		"        \"fieldType\":\"text\"," +
        		"        \"fieldText\":\"访客属性\"," +
        		"        \"fieldValue\":\"未定义\"," +
        		"        \"fieldLength\":\"\"," +
        		"        \"fieldDesc\":\"访客属性\"," +
        		"        \"fieldSort\":\"9\"" +
        		"}" +
    		 "]";

        List<ApplyFiles> applyFiles = JSON.parseObject(jsonStr,new TypeReference<List<ApplyFiles>>(){});
        //2.调uaac审批接口
        ApprovalSubmitVo approvalSubmitVo = new ApprovalSubmitVo();
        approvalSubmitVo.setUserId(vo.getInternalStaffUserId());
        approvalSubmitVo.setOrganizationId(vo.getEnterpriseId());
        approvalSubmitVo.setRelationCode("模板编码");
        approvalSubmitVo.setApprovalDescribe("邀约审批");
        approvalSubmitVo.setApprovalFlowUserList(vo.getApprovalUserList());
        approvalSubmitVo.setApprovalCopeUserList(vo.getCopyUserList());
        approvalSubmitVo.setApplyFiles(applyFiles);
        String uaacApprovalId = "";
		try {
			uaacApprovalId = uaacService.submitApproval(approvalSubmitVo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("uaacService.submitApproval == " + e.toString());
			throw new BizException("提交uaac审批失败");
		}
//        uaacApprovalId = "121";
        if(ObjectUtils.isEmpty(uaacApprovalId)) {
        	throw new BizException("uaacApprovalId获取失败");
        }
        //3.新增本地审批表
        Approval approval = new Approval();
        approval.setOriginatorId(vo.getInternalStaffUserId());
        approval.setVisitRecordId(visitRecord.getId());
        approval.setState(ApprovalState.STATE_0);
        approval.setApprovalDesc("发起邀约");
        approval.setUaacApprovalId(Long.valueOf(uaacApprovalId));
        approvalMapper.insert(approval);

        //3.新增审批人、抄送人信息
        if(!ObjectUtils.isEmpty(vo.getApprovalUserList())) {
        	for (int i = 0; i < vo.getApprovalUserList().size(); i++) {
        		ApprovalDetail approvalDetail = new ApprovalDetail();
        		approvalDetail.setApprovalId(approval.getId());
        		approvalDetail.setUserId(vo.getApprovalUserList().get(i).getUserId());
        		approvalDetail.setOrganizationId(vo.getApprovalUserList().get(i).getOrganizationId());
        		approvalDetail.setUserName(vo.getApprovalUserList().get(i).getRealName());
        		approvalDetail.setUserTel(vo.getApprovalUserList().get(i).getUserTel());
        		approvalDetail.setSort(i);
        		approvalDetail.setType(0);
        		approvalDetail.setState(0);
        		approvalDetailMapper.insert(approvalDetail);
        	}
        }
        if(!ObjectUtils.isEmpty(vo.getCopyUserList())) {
        	for (int i = 0; i < vo.getCopyUserList().size(); i++) {
        		ApprovalDetail approvalDetail = new ApprovalDetail();
        		approvalDetail.setApprovalId(approval.getId());
        		approvalDetail.setUserId(vo.getCopyUserList().get(i).getUserId());
        		approvalDetail.setOrganizationId(vo.getCopyUserList().get(i).getOrganizationId());
        		approvalDetail.setUserName(vo.getCopyUserList().get(i).getRealName());
        		approvalDetail.setUserTel(vo.getCopyUserList().get(i).getUserTel());
        		approvalDetail.setSort(i);
        		approvalDetail.setType(1);
        		approvalDetail.setState(3);
        		approvalDetailMapper.insert(approvalDetail);
        	}
        }

        List<ApprovalForm> formList = JSON.parseObject(jsonStr,new TypeReference<List<ApprovalForm>>(){});
        //5.新增审批表单
        for (int j = 0; j < formList.size(); j++) {
        	ApprovalForm approvalForm = formList.get(j);
        	approvalForm.setApprovalId(approval.getId());
        	approvalFormMapper.insert(approvalForm);
		}

        */


        //7.发送短信等
        try {
            sendNotify(NoticeType.YYXXTZ, SmsConstants.YQTZ, visitRecord, visitor, null, null, null, null, null, null);
        } catch (Exception e) {
            logger.error("信息推送失败：{}", e.toString());
            throw new BizException("信息推送失败：" + e.getMessage());
        }

    }

    /**
     * @throws
     * @Title: sendNotify
     * @Description: 发送各类消息通知  各参数根据实际业务场景传
     * @param: @param flag
     * @param: @param businessScenario			业务场景
     * @param: @param visitRecord 				访客记录实体
     * @param: @param visitor					访客实体
     * @param: @param visitAuthentication		门卫验证实体
     * @param: @param scheduleList				日程清单实体
     * @param: @param abnormalArea				异常区域
     * @param: @param abnormalReason      		异常原因
     * @param: @param initiator					支援请求方
     * @param: @param user						接收人信息（异常提醒、请求支援）
     * @return: void
     * @author: lcq
     * @date: 2020年1月8日 上午11:18:34
     * @version 1.0
     */
    public void sendNotify(NoticeType noticeType, String businessScenario, VisitRecord visitRecord, Visitor visitor, VisitAuthentication visitAuthentication, ScheduleList scheduleList, String abnormalArea, String abnormalReason, String initiator, UserVo user) {
        MessageNoticeUserSerachVo msgTepleteVo = new MessageNoticeUserSerachVo();

        VisitNotify visitNotify = new VisitNotify();
        if (SmsConstants.YYTG.equals(businessScenario)) {//预约通过
            msgTepleteVo.setEnterpriseId(visitRecord.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setVisitorId(visitor.getId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                logger.error("getByVo报错：{}", e.toString());
                throw new BizException("获取消息配置失败：" + e.getMessage());
            }

            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getBndIm() == 1) {
                    //伯纳德IM
                }
                if (msgTeplete.getWechat() == 1) {
                    //微信公众号
                }
                if (msgTeplete.getEmaill() == 1) {
                    String newsCopy = "预约申请已通过";
                    String notifyTitle = "预约申请";
                    String notifyContent = "你的来访预约申请 <span style=\"color:#4577FF\">" + visitRecord.getInternalStaffUserName() + "</span> 已同意，请知晓！";
                    visitNotify.setVisitorId(visitRecord.getVisitorId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(notifyContent);
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);

                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(notifyContent);
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("预约进度");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setReceiver(visitor.getTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);

                    mailVo.setReceivers(receivers);

                    //TODO
                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("message");
                    mailVo.setContentType(ContentType.TEXT);
                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(visitor.getTel());
                    smsVo.setTemplateCode(SmsConstants.YYTG);
                    Map<String, Object> param = new HashMap<>();
                    param.put("respondents", visitRecord.getInternalStaffUserName());
                    param.put("appName", "访客小程序app名称");
                    smsVo.setParam(param);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.YYBTG.equals(businessScenario)) {//预约不通过
            msgTepleteVo.setEnterpriseId(visitRecord.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setVisitorId(visitor.getId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                throw new BizException("获取消息配置失败：" + e.getMessage());
            }
            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getEmaill() == 1) {

                    String newsCopy = "预约申请被拒绝";
                    String notifyTitle = "预约申请";
                    String notifyContent = "你的来访预约申请已被 <span style=\"color:#4577FF\">" + visitRecord.getInternalStaffUserName() + "</span> 拒绝，请知晓！";
                    visitNotify.setVisitorId(visitRecord.getVisitorId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(notifyContent);
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);

                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(notifyContent);
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("预约进度");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setReceiver(visitor.getTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);
                    mailVo.setReceivers(receivers);

                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("message");
                    mailVo.setContentType(ContentType.TEXT);

                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(visitor.getTel());
                    smsVo.setTemplateCode(SmsConstants.YYBTG);
                    Map<String, Object> param = new HashMap<>();
                    param.put("respondents", visitRecord.getInternalStaffUserName());
                    smsVo.setParam(param);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.BFTX_1.equals(businessScenario)) {//拜访提醒 第一次 全渠道发送

            String newsCopy = "【拜访提醒】您于明日有待拜访计划";
            String notifyTitle = "拜访提醒";
//            StringBuffer notifyContent = new StringBuffer();
//            notifyContent.append("拜访对象：" + visitRecord.getInternalStaffUserName());
//            notifyContent.append("<br/>拜访区域：" + visitRecord.getEnterpriseName());
//            notifyContent.append("<br/>拜访事由：" + visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
//            notifyContent.append("<br/>拜访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//            notifyContent.append("<br/>温馨提示：您可出示电子码或若您已完成实名认证，则可使用人脸识别出入场。");
            Map<String,Object> map = new HashMap<>();
            map.put("拜访对象", visitRecord.getInternalStaffUserName());
            map.put("拜访区域", visitRecord.getEnterpriseName());
            map.put("拜访事由", visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
            map.put("拜访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
            map.put("温馨提示", "您可出示电子码或若您已完成实名认证，则可使用人脸识别出入场。");

            visitNotify.setVisitorId(visitRecord.getVisitorId());
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(JSON.toJSONString(map));
            visitNotify.setVisitRecordId(visitRecord.getId());
            visitNotifyMapper.insert(visitNotify);

            //TODO 站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(JSON.toJSONString(map));
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("消息");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setReceiver(visitor.getTel());
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setReceivers(receivers);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.JSON);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败：{}", e.toString());
                throw new BizException("站内信发送失败：" + e.getMessage());
            }


            //TODO 短信
            SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
            smsVo.setPhone(visitor.getTel());
            smsVo.setTemplateCode(SmsConstants.BFTX_1);
            Map<String, Object> param = new HashMap<>();
            param.put("startTime", visitRecord.getAppointmentStartTime());
            param.put("appName", "访客小程序app名称");
            smsVo.setParam(param);
            try {
                messageService.sendSms(smsVo);
            } catch (Exception e) {
                logger.error("短信发送失败：{}", e.toString());
                throw new BizException("短信发送失败：" + e.getMessage());
            }

        } else if (SmsConstants.BFTX_2.equals(businessScenario)) {//拜访提醒 第二次 全渠道发送
            String newsCopy = "【拜访提醒】您于2小时后有拜访计划";
            String notifyTitle = "拜访提醒";
//            StringBuffer notifyContent = new StringBuffer();
//            notifyContent.append("拜访对象：" + visitRecord.getInternalStaffUserName());
//            notifyContent.append("<br/>拜访区域：" + visitRecord.getEnterpriseName());
//            notifyContent.append("<br/>拜访事由：" + visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
//            notifyContent.append("<br/>拜访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//            notifyContent.append("<br/>温馨提示：您可出示电子码或若您已完成实名认证，则可使用人脸识别出入场。");
            Map<String,Object> map = new HashMap<>();
            map.put("拜访对象", visitRecord.getInternalStaffUserName());
            map.put("拜访区域", visitRecord.getEnterpriseName());
            map.put("拜访事由", visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
            map.put("拜访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
            map.put("温馨提示", "您可出示电子码或若您已完成实名认证，则可使用人脸识别出入场。");

            visitNotify.setVisitorId(visitRecord.getVisitorId());
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(JSON.toJSONString(map));
            visitNotify.setVisitRecordId(visitRecord.getId());
            visitNotifyMapper.insert(visitNotify);

            //TODO 站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(JSON.toJSONString(map));
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("消息");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setReceiver(visitor.getTel());
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setReceivers(receivers);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.JSON);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败：{}", e.toString());
                throw new BizException("站内信发送失败：" + e.getMessage());
            }

            //TODO 短信
            SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
            smsVo.setPhone(visitor.getTel());
            smsVo.setTemplateCode(SmsConstants.BFTX_2);
            Map<String, Object> param = new HashMap<>();
            param.put("respondents", visitRecord.getInternalStaffUserName());
            param.put("appName", "访客小程序app名称");
            smsVo.setParam(param);
            try {
                messageService.sendSms(smsVo);
            } catch (Exception e) {
                logger.error("短信发送失败：{}", e.toString());
                throw new BizException("短信发送失败：" + e.getMessage());
            }

        } else if (SmsConstants.QCTX.equals(businessScenario)) {//签出提醒
            msgTepleteVo.setEnterpriseId(visitRecord.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setVisitorId(visitor.getId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                throw new BizException("获取消息配置失败：" + e.getMessage());
            }
            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getEmaill() == 1) {

                    String newsCopy = "【签出提醒】距约定离场时间还有半小时";
                    String notifyTitle = "签出提醒";
//                    StringBuffer notifyContent = new StringBuffer();
//                    notifyContent.append("拜访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//                    notifyContent.append("<br/>温馨提示：您可出示电子码或若您已完成实名认证，则可使用人脸识别出入场。");
                    Map<String,Object> map = new HashMap<>();
                    map.put("拜访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
                    map.put("温馨提示", "您可出示电子码或若您已完成实名认证，则可使用人脸识别出入场。");
                    visitNotify.setVisitorId(visitRecord.getVisitorId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(JSON.toJSONString(map));
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);

                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(JSON.toJSONString(map));
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("消息");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setReceiver(visitor.getTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);

                    mailVo.setReceivers(receivers);

                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("message");
                    mailVo.setContentType(ContentType.JSON);
                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(visitor.getTel());
                    smsVo.setTemplateCode(SmsConstants.QCTX);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.YQWQC.equals(businessScenario)) {//逾期未签出
            msgTepleteVo.setEnterpriseId(visitRecord.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setVisitorId(visitor.getId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                throw new BizException(e.getMessage());
            }
            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getEmaill() == 1) {

                    String newsCopy = "【签出提醒】请注意您的通行电子码已失效";
                    String notifyTitle = "签出提醒";
//                    StringBuffer notifyContent = new StringBuffer();
//                    notifyContent.append("拜访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//                    notifyContent.append("<br/>温馨提示：由于您未在约定时间内离场，通行电子码已作废，如需离场，请联系您的企业联系人");
                    Map<String,Object> map = new HashMap<>();
                    map.put("拜访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
                    map.put("温馨提示", "由于您未在约定时间内离场，通行电子码已作废，如需离场，请联系您的企业联系人");
                    visitNotify.setVisitorId(visitRecord.getVisitorId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(JSON.toJSONString(map));
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);

                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(JSON.toJSONString(map));
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("消息");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setReceiver(visitor.getTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);

                    mailVo.setReceivers(receivers);

                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("message");
                    mailVo.setContentType(ContentType.JSON);
                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(visitor.getTel());
                    smsVo.setTemplateCode(SmsConstants.YQWQC);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.YQTZ.equals(businessScenario)) {//邀请通知
            msgTepleteVo.setEnterpriseId(visitRecord.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setVisitorId(visitor.getId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                throw new BizException(e.getMessage());
            }
            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getEmaill() == 1) {
                    String newsCopy = "【邀请通知】您收到一封邀请函";
                    String notifyTitle = "邀访提醒";
//                    StringBuffer notifyContent = new StringBuffer();
//                    notifyContent.append("邀请人：" + visitRecord.getInternalStaffUserName());
//                    notifyContent.append("<br/>邀访区域：" + visitRecord.getEnterpriseName());
//                    notifyContent.append("<br/>邀请事由：" + visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
//                    notifyContent.append("<br/>邀访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//                    notifyContent.append("<br/>温馨提示：届时系统将发放通行电子码给您；通过小程序实名制后可以快速刷脸进场哦~");

                    Map<String,Object> map = new HashMap<>();
                    map.put("邀请人", visitRecord.getInternalStaffUserName());
                    map.put("邀访区域", visitRecord.getEnterpriseName());
                    map.put("邀请事由", visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
                    map.put("邀访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
                    map.put("温馨提示", "届时系统将发放通行电子码给您；通过小程序实名制后可以快速刷脸进场哦~");
                    visitNotify.setVisitorId(visitRecord.getVisitorId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(JSON.toJSONString(map));
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);

                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(JSON.toJSONString(map));
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("消息");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setReceiver(visitor.getTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);

                    mailVo.setReceivers(receivers);

                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("message");
                    mailVo.setContentType(ContentType.JSON);
                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(visitor.getTel());
                    smsVo.setTemplateCode(SmsConstants.YQTZ);
                    Map<String, Object> param = new HashMap<>();
                    param.put("enterprise", visitRecord.getEnterpriseName());
                    param.put("inviter", visitRecord.getInternalStaffUserName());
                    param.put("appName", "访客小程序app名称");
                    smsVo.setParam(param);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.YYQX.equals(businessScenario)) {//邀约取消
            msgTepleteVo.setEnterpriseId(visitRecord.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setVisitorId(visitor.getId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                throw new BizException("获取消息配置失败：" + e.getMessage());
            }
            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getEmaill() == 1) {
                    String newsCopy = "【邀请取消通知】您的拜访计划已被取消！";
                    String notifyTitle = "邀访取消提醒";
//                    StringBuffer notifyContent = new StringBuffer();
//                    notifyContent.append("邀请人：" + visitRecord.getInternalStaffUserName());
//                    notifyContent.append("<br/>邀访区域：" + visitRecord.getEnterpriseName());
//                    notifyContent.append("<br/>邀请事由：" + visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
//                    notifyContent.append("<br/>邀访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//                    notifyContent.append("<br/>温馨提示：很抱歉，该拜访计划已被取消，请知悉！");

                    Map<String,Object> map = new HashMap<>();
                    map.put("邀请人", visitRecord.getInternalStaffUserName());
                    map.put("邀访区域", visitRecord.getEnterpriseName());
                    map.put("邀请事由", visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
                    map.put("邀访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
                    map.put("温馨提示", "很抱歉，该拜访计划已被取消，请知悉！");
                    visitNotify.setVisitorId(visitRecord.getVisitorId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(JSON.toJSONString(map));
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);

                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(JSON.toJSONString(map));
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("消息");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setReceiver(visitor.getTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);

                    mailVo.setReceivers(receivers);

                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("message");
                    mailVo.setContentType(ContentType.JSON);
                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(visitor.getTel());
                    smsVo.setTemplateCode(SmsConstants.YYQX);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.YYSQ.equals(businessScenario)) {//预约申请
            msgTepleteVo.setEnterpriseId(visitRecord.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setUserId(visitRecord.getInternalStaffUserId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                throw new BizException("获取消息配置失败：" + e.getMessage());
            }
            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getEmaill() == 1) {
                    String newsCopy = "预约申请";
                    String notifyTitle = "预约申请";
                    String notifyContent = "<span style=\"color:#4577FF\">" + visitor.getName() + "</span> 提交的预约申请，待您审批！";

                    visitNotify.setUserId(visitRecord.getInternalStaffUserId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(notifyContent);
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);

                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(notifyContent);
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("待办");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setEnterpriseId(visitRecord.getEnterpriseId());
                    receiversVo.setReceiver(visitRecord.getInternalStaffUserTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);

                    mailVo.setReceivers(receivers);

                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("message");
                    mailVo.setContentType(ContentType.TEXT);

                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(visitRecord.getInternalStaffUserTel());
                    smsVo.setTemplateCode(SmsConstants.YYSQ);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.LFTX_OUT.equals(businessScenario)) {//来访提醒  未达
            if (visitor.getVisitorAttribute() == VisitorAttribute.VIP) {//仅限宾客来访前提醒
                String newsCopy = "【来访提醒】" + visitor.getName() + " 2小时后将到访";
                String notifyTitle = "来访提醒";
//                StringBuffer notifyContent = new StringBuffer();
//                notifyContent.append("来访对象：" + visitor.getName());
//                notifyContent.append("<br/>来访事由：" + visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
//                notifyContent.append("<br/>来访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//                notifyContent.append("<br/>温馨提示：贵宾即将到访，请做好迎接准备！");

                Map<String,Object> map = new HashMap<>();
                map.put("来访对象", visitor.getName());
                map.put("来访事由", visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
                map.put("来访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
                map.put("温馨提示", "贵宾即将到访，请做好迎接准备！");

                visitNotify.setUserId(visitRecord.getInternalStaffUserId());
                visitNotify.setNewsCopy(newsCopy);
                visitNotify.setNotifyTitle(notifyTitle);
                visitNotify.setNotifyContent(JSON.toJSONString(map));
                visitNotify.setVisitRecordId(visitRecord.getId());
                visitNotifyMapper.insert(visitNotify);

                //TODO 站内信
                MailFormVo mailVo = new MailFormVo();
                mailVo.setTitle(notifyTitle);
                mailVo.setContent(JSON.toJSONString(map));
                mailVo.setScope(SmsConstants.SCOPE);
                mailVo.setType("消息");

                MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                receiversVo.setEnterpriseId(visitRecord.getEnterpriseId());
                receiversVo.setReceiver(visitRecord.getInternalStaffUserTel());
                List<MailReceiverFormVo> receivers = new ArrayList<>();
                receivers.add(receiversVo);

                mailVo.setReceivers(receivers);

                mailVo.setSummary(newsCopy);
                mailVo.setIcon("message");
                mailVo.setContentType(ContentType.JSON);
                try {
                    messageService.sendMail(mailVo);
                } catch (Exception e) {
                    logger.error("站内信发送失败：{}", e.toString());
                    throw new BizException("站内信发送失败：" + e.getMessage());
                }

                //TODO 短信
                SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                smsVo.setPhone(visitRecord.getInternalStaffUserTel());
                smsVo.setTemplateCode(SmsConstants.LFTX_OUT);
                Map<String, Object> param = new HashMap<>();
                param.put("visitor", visitor.getName());
                smsVo.setParam(param);
                try {
                    messageService.sendSms(smsVo);
                } catch (Exception e) {
                    logger.error("短信发送失败：{}", e.toString());
                    throw new BizException("短信发送失败：" + e.getMessage());
                }
            }

        } else if (SmsConstants.LFTX_IN.equals(businessScenario)) {//来访提醒  已达
            if (visitor.getVisitorAttribute() == VisitorAttribute.VIP) {//仅限宾客来访前提醒
                String newsCopy = "【来访提醒】" + visitor.getName() + " 已抵达约定地方";
                String notifyTitle = "来访提醒";
//                StringBuffer notifyContent = new StringBuffer();
//                notifyContent.append("来访对象：" + visitor.getName());
//                notifyContent.append("<br/>来访事由：" + visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
//                notifyContent.append("<br/>来访时间：" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
//                notifyContent.append("<br/>温馨提示：贵宾已抵达约定地点，请速前去迎接！");

                Map<String,Object> map = new HashMap<>();
                map.put("来访对象", visitor.getName());
                map.put("来访事由", visitRecord.getVisitCause() != null ? EnumUtil.getByValue(visitRecord.getVisitCause(), VisitCause.class, "") : null);
                map.put("来访时间", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM) + "-" + DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_HH_MM));
                map.put("温馨提示", "贵宾已抵达约定地点，请速前去迎接！");

                visitNotify.setUserId(visitRecord.getInternalStaffUserId());
                visitNotify.setNewsCopy(newsCopy);
                visitNotify.setNotifyTitle(notifyTitle);
                visitNotify.setNotifyContent(JSON.toJSONString(map));
                visitNotify.setVisitRecordId(visitRecord.getId());
                visitNotifyMapper.insert(visitNotify);

                //TODO 站内信
                MailFormVo mailVo = new MailFormVo();
                mailVo.setTitle(notifyTitle);
                mailVo.setContent(JSON.toJSONString(map));
                mailVo.setScope(SmsConstants.SCOPE);
                mailVo.setType("消息");

                MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                receiversVo.setEnterpriseId(visitRecord.getEnterpriseId());
                receiversVo.setReceiver(visitRecord.getInternalStaffUserTel());
                List<MailReceiverFormVo> receivers = new ArrayList<>();
                receivers.add(receiversVo);

                mailVo.setReceivers(receivers);

                mailVo.setSummary(newsCopy);
                mailVo.setIcon("message");
                mailVo.setContentType(ContentType.JSON);
                try {
                    messageService.sendMail(mailVo);
                } catch (Exception e) {
                    logger.error("站内信发送失败：{}", e.toString());
                    throw new BizException("站内信发送失败：" + e.getMessage());
                }

                //TODO 短信
                SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                smsVo.setPhone(visitRecord.getInternalStaffUserTel());
                smsVo.setTemplateCode(SmsConstants.LFTX_IN);
                Map<String, Object> param = new HashMap<>();
                param.put("visitor", visitor.getName());
                smsVo.setParam(param);
                try {
                    messageService.sendSms(smsVo);
                } catch (Exception e) {
                    logger.error("短信发送失败：{}", e.toString());
                    throw new BizException("短信发送失败：" + e.getMessage());
                }
            }

        } else if (SmsConstants.YZTX_AGREE.equals(businessScenario)) {//验证提醒  允许通行
            String newsCopy = "【身份验证反馈】" + visitor.getName() + " 已被允许通行";
            String notifyTitle = "身份验证反馈";
//            StringBuffer notifyContent = new StringBuffer();
//            notifyContent.append("验证访客：" + visitor.getName());
//            notifyContent.append("<br/>访客属性：" + visitRecord.getVisitorAttribute() != null ? EnumUtil.getByValue(visitRecord.getVisitorAttribute(), VisitorAttribute.class, "") : null);
//            notifyContent.append("<br/>检验保安：" + visitAuthentication.getGuardUserName());
//            notifyContent.append("<br/>检验结果：允许通行");
//            notifyContent.append("<br/>温馨提示：您发起的身份验证已被保安核实身份，请知悉！");

            Map<String,Object> map = new HashMap<>();
            map.put("验证访客", visitor.getName());
            map.put("访客属性", visitRecord.getVisitorAttribute() != null ? EnumUtil.getByValue(visitRecord.getVisitorAttribute(), VisitorAttribute.class, "") : null);
            map.put("检验保安", visitAuthentication.getGuardUserName());
            map.put("检验结果", "允许通行");
            map.put("温馨提示", "您发起的身份验证已被保安核实身份，请知悉！");

            visitNotify.setUserId(visitRecord.getInternalStaffUserId());
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(JSON.toJSONString(map));
            visitNotify.setVisitRecordId(visitRecord.getId());
            visitNotifyMapper.insert(visitNotify);

            //TODO 站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(JSON.toJSONString(map));
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("消息");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setEnterpriseId(visitRecord.getEnterpriseId());
            receiversVo.setReceiver(visitRecord.getInternalStaffUserTel());
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setReceivers(receivers);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.JSON);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败：{}", e.toString());
                throw new BizException("站内信发送失败：" + e.getMessage());
            }

        } else if (SmsConstants.YZTX_REFUSE.equals(businessScenario)) {//验证提醒  拒绝通行
            String newsCopy = "【身份验证反馈】" + visitor.getName() + " 已被拒绝通行";
            String notifyTitle = "身份验证反馈";
//            StringBuffer notifyContent = new StringBuffer();
//            notifyContent.append("验证访客：" + visitor.getName());
//            notifyContent.append("<br/>访客属性：" + visitRecord.getVisitorAttribute() != null ? EnumUtil.getByValue(visitRecord.getVisitorAttribute(), VisitorAttribute.class, "") : null);
//            notifyContent.append("<br/>检验保安：" + visitAuthentication.getGuardUserName());
//            notifyContent.append("<br/>检验结果：拒绝通行");
//            notifyContent.append("<br/>拒绝理由：" + visitAuthentication.getRefusalReason() != null ? EnumUtil.getByValue(visitAuthentication.getRefusalReason(), RefusalReason.class, "") : null);
//            notifyContent.append("<br/>温馨提示：您发起的身份验证已被保安核实身份，请知悉！");

            Map<String,Object> map = new HashMap<>();
            map.put("验证访客", visitor.getName());
            map.put("访客属性", visitRecord.getVisitorAttribute() != null ? EnumUtil.getByValue(visitRecord.getVisitorAttribute(), VisitorAttribute.class, "") : null);
            map.put("检验保安", visitAuthentication.getGuardUserName());
            map.put("检验结果", "拒绝通行");
            map.put("温馨提示", "您发起的身份验证已被保安核实身份，请知悉！");

            visitNotify.setUserId(visitRecord.getInternalStaffUserId());
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(JSON.toJSONString(map));
            visitNotify.setVisitRecordId(visitRecord.getId());
            visitNotifyMapper.insert(visitNotify);

            //TODO 站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(JSON.toJSONString(map));
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("消息");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setEnterpriseId(visitRecord.getEnterpriseId());
            receiversVo.setReceiver(visitRecord.getInternalStaffUserTel());
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setReceivers(receivers);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.JSON);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败：{}", e.toString());
                throw new BizException("站内信发送失败：" + e.getMessage());
            }

        } else if (SmsConstants.RCTX.equals(businessScenario)) {//日程提醒
            String newsCopy = "【日程提醒】您有一个日程计划";
            String notifyTitle = "日程提醒";
//            StringBuffer notifyContent = new StringBuffer();
//            notifyContent.append("提醒时间：" + DateUtil.format(DateUtil.localDateTime2Date(scheduleList.getReminderDate()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM));
//            notifyContent.append("<br/>日程内容：" + scheduleList.getScheduleContent());
//            notifyContent.append("<br/>温馨提示：完成以后可以去日程标记已完成哦~");

            Map<String,Object> map = new HashMap<>();
            map.put("提醒时间", DateUtil.format(DateUtil.localDateTime2Date(scheduleList.getReminderDate()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM));
            map.put("日程内容", scheduleList.getScheduleContent());
            map.put("温馨提示", "完成以后可以去日程标记已完成哦~");

            visitNotify.setUserId(scheduleList.getUserId());
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(JSON.toJSONString(map));
            visitNotifyMapper.insert(visitNotify);

            //TODO 站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(JSON.toJSONString(map));
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("消息");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setReceiver(scheduleList.getUserTel());
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setReceivers(receivers);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.JSON);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败：{}", e.toString());
                throw new BizException("站内信发送失败：" + e.getMessage());
            }

        } else if (SmsConstants.YCTX.equals(businessScenario)) {//异常提醒
            msgTepleteVo.setEnterpriseId(user.getEnterpriseId());
            msgTepleteVo.setNoticeType(noticeType);
            msgTepleteVo.setUserId(user.getUserId());
            MessageNoticeTemplate msgTeplete = null;
            try {
                msgTeplete = messageNoticeTemplateService.getByVo(msgTepleteVo);
            } catch (Exception e) {
                throw new BizException("获取消息配置失败：" + e.getMessage());
            }
            if (!ObjectUtils.isEmpty(msgTeplete)) {
                if (msgTeplete.getEmaill() == 1) {
                    String newsCopy = "【安全警示】请注意" + abnormalArea + "出现异常情况";
                    String notifyTitle = "安全警示";
//                    StringBuffer notifyContent = new StringBuffer();
//                    notifyContent.append("异常访客：" + visitor.getName());
//                    notifyContent.append("<br/>异常区域：" + abnormalArea);
//                    notifyContent.append("<br/>异常原因：" + abnormalReason);
//                    notifyContent.append("<br/>温馨提示：请保护好个人人身安全与财产安全，如遇情况危急，请勿慌乱，有序离场！");

                    Map<String,Object> map = new HashMap<>();
                    map.put("异常访客", visitor.getName());
                    map.put("异常区域", abnormalArea);
                    map.put("异常原因", abnormalReason);
                    map.put("温馨提示", "请保护好个人人身安全与财产安全，如遇情况危急，请勿慌乱，有序离场！");

                    visitNotify.setUserId(visitRecord.getInternalStaffUserId());
                    visitNotify.setNewsCopy(newsCopy);
                    visitNotify.setNotifyTitle(notifyTitle);
                    visitNotify.setNotifyContent(JSON.toJSONString(map));
                    visitNotify.setVisitRecordId(visitRecord.getId());
                    visitNotifyMapper.insert(visitNotify);


                    //TODO 站内信
                    MailFormVo mailVo = new MailFormVo();
                    mailVo.setTitle(notifyTitle);
                    mailVo.setContent(JSON.toJSONString(map));
                    mailVo.setScope(SmsConstants.SCOPE);
                    mailVo.setType("消息");

                    MailReceiverFormVo receiversVo = new MailReceiverFormVo();
                    receiversVo.setEnterpriseId(user.getEnterpriseId());
                    receiversVo.setReceiver(user.getReceiverTel());
                    List<MailReceiverFormVo> receivers = new ArrayList<>();
                    receivers.add(receiversVo);

                    mailVo.setReceivers(receivers);

                    mailVo.setSummary(newsCopy);
                    mailVo.setIcon("warning");
                    mailVo.setContentType(ContentType.JSON);
                    try {
                        messageService.sendMail(mailVo);
                    } catch (Exception e) {
                        logger.error("站内信发送失败：{}", e.toString());
                        throw new BizException("站内信发送失败：" + e.getMessage());
                    }
                }

                if (msgTeplete.getShortMessage() == 1) {
                    //TODO 短信
                    SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
                    smsVo.setPhone(user.getReceiverTel());
                    smsVo.setTemplateCode(SmsConstants.YCTX);
                    Map<String, Object> param = new HashMap<>();
                    param.put("abnormalArea", abnormalArea);
                    try {
                        messageService.sendSms(smsVo);
                    } catch (Exception e) {
                        logger.error("短信发送失败：{}", e.toString());
                        throw new BizException("短信发送失败：" + e.getMessage());
                    }
                }
            }

        } else if (SmsConstants.QQZY.equals(businessScenario)) {//请求支援  全渠道发送
            String newsCopy = "【支援请求】" + initiator + "向您请求支援";
            String notifyTitle = "支援任务";
//            StringBuffer notifyContent = new StringBuffer();
//            notifyContent.append("异常对象：" + visitor.getName());
//            notifyContent.append("<br/>支援请求方：" + initiator);
//            notifyContent.append("<br/>所属企业：" + visitRecord.getEnterpriseName());
//            notifyContent.append("<br/>异常区域：" + abnormalArea);
//            notifyContent.append("<br/>危险影响：" + user.getInfluence());
//            notifyContent.append("<br/>温馨提示：请保护好个人人身安全与财产安全，如遇情况危急，请勿慌乱，有序离场！");

            Map<String,Object> map = new HashMap<>();
            map.put("异常对象", visitor.getName());
            map.put("支援请求方", initiator);
            map.put("所属企业", visitRecord.getEnterpriseName());
            map.put("异常区域", abnormalArea);
            map.put("危险影响", user.getInfluence());
            map.put("温馨提示", "请保护好个人人身安全与财产安全，如遇情况危急，请勿慌乱，有序离场！");

            visitNotify.setUserId(user.getUserId());//TODO  保安/安防人员是否属于员工？
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(JSON.toJSONString(map));
            visitNotifyMapper.insert(visitNotify);

            //TODO 站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(JSON.toJSONString(map));
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("消息");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setEnterpriseId(user.getEnterpriseId());
            receiversVo.setReceiver(user.getReceiverTel());
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setReceivers(receivers);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.JSON);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败：{}", e.toString());
                throw new BizException("站内信发送失败：" + e.getMessage());
            }

            //TODO 短信
            SmsTemplateMessageVo smsVo = new SmsTemplateMessageVo();
            smsVo.setPhone(user.getReceiverTel());
            smsVo.setTemplateCode(SmsConstants.QQZY);
            Map<String, Object> param = new HashMap<>();
            param.put("initiator", initiator);
            param.put("enterprise", user.getEnterpriseName());
            param.put("abnormalArea", abnormalArea);
            try {
                messageService.sendSms(smsVo);
            } catch (Exception e) {
                logger.error("短信发送失败：{}", e.toString());
                throw new BizException("短信发送失败：" + e.getMessage());
            }

        } else if (SmsConstants.SFRZRW.equals(businessScenario)) {//身份验证任务
            String newsCopy = "【身份验证】您有一个身份验证任务";
            String notifyTitle = "身份验证任务";

//            StringBuffer notifyContent = new StringBuffer();
//            notifyContent.append("验证访客：" + visitor.getName());
//            notifyContent.append("<br/>验证请求方：" + visitRecord.getInternalStaffUserName() + "-" + visitRecord.getInternalStaffUserTel());
//            notifyContent.append("<br/>所属企业：" + visitRecord.getEnterpriseName());
//            notifyContent.append("<br/>温馨提示：请对验证对象进行来访信息与身份信息双重检验，如需帮助可致电咨询验证请求方！");

            Map<String,Object> map = new HashMap<>();
            map.put("验证访客", visitor.getName());
            map.put("验证请求方", visitRecord.getInternalStaffUserName() + "-" + visitRecord.getInternalStaffUserTel());
            map.put("所属企业", visitRecord.getEnterpriseName());
            map.put("温馨提示", "请对验证对象进行来访信息与身份信息双重检验，如需帮助可致电咨询验证请求方！");

            visitNotify.setUserId(visitRecord.getInternalStaffUserId());//TODO  保安/安防人员是否属于员工？
            visitNotify.setNewsCopy(newsCopy);
            visitNotify.setNotifyTitle(notifyTitle);
            visitNotify.setNotifyContent(JSON.toJSONString(map));
            visitNotify.setVisitRecordId(visitRecord.getId());
            visitNotifyMapper.insert(visitNotify);

            //TODO 站内信
            MailFormVo mailVo = new MailFormVo();
            mailVo.setTitle(notifyTitle);
            mailVo.setContent(JSON.toJSONString(map));
            mailVo.setScope(SmsConstants.SCOPE);
            mailVo.setType("消息");

            MailReceiverFormVo receiversVo = new MailReceiverFormVo();
            receiversVo.setEnterpriseId(visitRecord.getEnterpriseId());
            receiversVo.setReceiver(visitRecord.getInternalStaffUserTel());
            List<MailReceiverFormVo> receivers = new ArrayList<>();
            receivers.add(receiversVo);

            mailVo.setReceivers(receivers);

            mailVo.setSummary(newsCopy);
            mailVo.setIcon("message");
            mailVo.setContentType(ContentType.JSON);
            try {
                messageService.sendMail(mailVo);
            } catch (Exception e) {
                logger.error("站内信发送失败：{}", e.toString());
                throw new BizException("站内信发送失败：" + e.getMessage());
            }

        }
    }

    /**
     * @throws
     * @Title: getConfig
     * @Description: 访客权限、生产数字码、二维码
     * @param: @param visitRecord
     * @param: @param visitor
     * @param: @return
     * @return: VisitRecord
     * @author: lcq
     * @date: 2020年1月14日 下午3:53:54
     * @version 1.0
     */
    public VisitRecord getConfig(VisitRecord visitRecord, Visitor visitor) {
        try {

            if (!ObjectUtils.isEmpty(visitor)) {
                //TODO 获取访客准入权限，获取进出口门禁指定区域
                List<Access4VisitorOutVo> list = permissionService.selectAccess4Visitor(visitRecord.getEnterpriseId(), visitor.getVisitorAttribute().getValue());
                if (ObjectUtils.isEmpty(list)) {
                	logger.info("EnterpriseId：{}，VisitorAttribute：{}",visitRecord.getEnterpriseId(), visitor.getVisitorAttribute().getValue());
                    throw new BizException("【访客准入权限-进出口门禁权限】未配置");
                } else {
//                	Optional<Access4VisitorOutVo> o = list.stream().filter(it -> PermissionRange.REGION.equals(it.getPermissionRange())).findFirst();
                    Access4VisitorOutVo vo = list.stream().filter(it -> PermissionRange.REGION.equals(it.getPermissionRange())).findFirst().get();
                    if (vo.isWhole()) {
                        //全区域
                    	visitRecord.setAreaIds("0");
                    } else {
                        visitRecord.setAreaIds(vo.getRangeIds());
                    }

                    Access4VisitorOutVo permission = list.stream().filter(it -> PermissionRange.DATETIME.equals(it.getPermissionRange())).findFirst().get();
                    if (permission.isWhole()) {
                        //全天
                        visitRecord.setOpenTimeStart(DateUtil.START_TIME_HM);
                        visitRecord.setOpenTimeEnd(DateUtil.END_TIME_HM);
                    } else {
                        visitRecord.setOpenTimeStart(permission.getOpenTimeStart().toString());
                        visitRecord.setOpenTimeEnd(permission.getOpenTimeEnd().toString());
                    }
                }
                if (!ObjectUtils.isEmpty(visitRecord.getId())) {
                    AccessTrafficVo at = permissionService.getAccessTraffic(visitRecord.getEnterpriseId());
                    if (!ObjectUtils.isEmpty(at)) {
                        AccessTrafficOutVo ato = new AccessTrafficOutVo();
                        BeanUtils.copyProperties(at, ato);

                        if (ato.isNumericCode()) {//数字码
                            String visitorCode = RuleUtil.randomNum();
                            visitRecord.setVisitorCode(visitorCode);
                            logger.info("visitorCode：{}",visitorCode);
                        }

                        if (ato.isQrCode()) {//二维码
//							StringBuffer content = new StringBuffer();
//							content.append("{");
//								content.append("\"result\":{");
//									content.append("\"visitRecordId:\"" + visitRecord.getId() + "\",");
//									content.append("\"areaIds:\"" + visitRecord.getAreaIds() + "\",");
//									content.append("\"appointmentStartTime:\"" + visitRecord.getAppointmentStartTime() + "\",");
//									content.append("\"appointmentEndTime:\"" + visitRecord.getAppointmentEndTime() + "\"");
//							    content.append("}");
//							content.append("}");
                            Map<String, Object> map = new HashMap<>();
                            map.put("visitRecordId", visitRecord.getId());
                            map.put("areaIds", visitRecord.getAreaIds());
                            map.put("appointmentStartTime",DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM));
                            map.put("appointmentEndTime", DateUtil.format(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM));
                            String jsonString = JSON.toJSONString(map);
                            BufferedImage qrcode = QrCodeUtils.encode(jsonString, 430);
                            String base64EncodedQrcode = ImageUtils.encodeWithBase64(qrcode, FileType.Image.PNG);
                            FileFormVo fileFormVo = new FileFormVo();
                            fileFormVo.setBase64(base64EncodedQrcode);
                            fileFormVo.setFileName(visitRecord.getId().toString());
                            try {
                                FileDto dto = adminService.uploadByBase64(fileFormVo);
                                visitRecord.setQrCode(dto.getFilePath());
                                logger.info("QrCode：{}",dto.getFilePath());
                            } catch (Exception e) {
                                logger.error("uploadByBase64报错：{};参数：{}", e.toString(), fileFormVo);
                                throw new BizException("生成二维码失败：" + e.getMessage());
                            }
                        }
                        if(!ato.isNumericCode() && !ato.isQrCode()) {
                        	throw new BizException("无法操作：二维码及数字码未配置，请联系企业管理员！");
                        }
                        if (!ObjectUtils.isEmpty(ato.getOnTime()) && ato.getOnTime() != 0) {

                            visitRecord.setEffectiveDate(DateUtil.manageDate(DateUtil.localDateTime2Date(visitRecord.getAppointmentStartTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM, Calendar.HOUR, -ato.getOnTime()));
                        }
                        if (!ObjectUtils.isEmpty(ato.getOffTime()) && ato.getOffTime() != 0) {
                            visitRecord.setExpirationDate(DateUtil.manageDate(DateUtil.localDateTime2Date(visitRecord.getAppointmentEndTime()), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM, Calendar.HOUR, ato.getOffTime()));
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.error("访客准入权限获取失败：" + e.toString());
            throw new BizException("错误：" + e.getMessage());
        }

        return visitRecord;
    }


    /**
     * @throws
     * @Title: visitRecordForGuard
     * @Description: 安防人员角色主页
     * @param: @param vo
     * @param: @return
     * @return: IPage<VisitRecordForGuardDto>
     * @author: lcq
     * @date: 2019年12月21日 上午10:42:29
     * @version 1.0
     */
    public IPage<VisitRecordForGuardDto> visitRecordForGuard(VisitRecordForGuardVo vo) {
        IPage<VisitRecordForGuardDto> visitRecord = null;
        Page<VisitRecordForGuardDto> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());

        try {
            visitRecord = visitRecordMapper.visitRecordForGuard(page, vo);
        } catch (Exception e) {
            logger.error("报错visitRecordForGuard：{}", e.getMessage());
            throw new BizException(ErrorCode.INTERNAL_ERROR, "查看列表失败：" + e.getMessage());
        }
        return visitRecord;
    }

    public IPage<VisitRecordForGuardDto> visitRecordForGuardHistory(VisitRecordForGuardVo vo) {
        IPage<VisitRecordForGuardDto> visitRecord = null;
        Page<VisitRecordForGuardDto> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());

        try {
            visitRecord = visitRecordMapper.visitRecordForGuardHistory(page, vo);
        } catch (Exception e) {
            logger.error("报错visitRecordForGuardHistory：{}", e.getMessage());
            throw new BizException(ErrorCode.INTERNAL_ERROR, "查看列表失败：" + e.getMessage());
        }
        return visitRecord;
    }

    /**
     * @throws
     * @Title: employeeHomePage
     * @Description: 员工主页
     * @param: @param approvalVo
     * @param: @param userType
     * @param: @return
     * @return: EmployeeHomePageDto
     * @author: lcq
     * @date: 2019年12月21日 上午10:42:19
     * @version 1.0
     */
    public EmployeeHomePageDto employeeHomePage(HomeVo vo, Integer approvalState, Integer type) {
        IPage<VisitRecordDto> visitRecords = null;
        Page<VisitRecordDto> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        try {
            List<Integer> stateList = new ArrayList<>();
            stateList.add(0);
            visitRecords = visitRecordMapper.approvalVisitRecord(page, vo, stateList, approvalState, type);
        } catch (Exception e) {
            logger.error("报错employeeHomePage：{}", e.getMessage());
            throw new BizException(ErrorCode.INTERNAL_ERROR, "查询列表失败：" + e.getMessage());
        }
        EmployeeHomePageDto dto = new EmployeeHomePageDto();
        dto.setPage(visitRecords);

        LambdaQueryWrapper<ScheduleList> wrapper = QueryBuilder.<ScheduleList>lambdaQuery()
            .eq(ScheduleList::getUserId, vo.getUserId());
        wrapper.ge(ScheduleList::getReminderDate, DateUtil.format(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd));
        List<ScheduleList> scheduleList = scheduleListMapper.selectList(wrapper);
        dto.setWaitProces(scheduleList.size());
        return dto;
    }

    /**
     * @throws
     * @Title: getVisitRecordDetail
     * @Description: 访客记录详情
     * @param: @param visitRecordId
     * @param: @return
     * @return: VisitRecordDetailDto
     * @author: lcq
     * @date: 2019年12月21日 上午10:45:28
     * @version 1.0
     */
    public VisitRecordDetailDto getVisitRecordDetail(Long visitRecordId) {
        try {
            //1.访客记录信息
            VisitRecordDetailDto dto = visitRecordMapper.getVisitRecordDetail(visitRecordId);
            if (ObjectUtils.isEmpty(dto)) {
                throw new BizException("id参数有误，访客记录不存在！");
            }
            //必须为审批通过后 抄送人才可查看到审批
            //2.1.审批人
            List<ApprovalDetail> flowsList = visitRecordMapper.getApprovalDetailList(visitRecordId, 0);
            dto.setFlowsList(flowsList);
            //2.2.抄送人
            List<ApprovalDetail> copysList = visitRecordMapper.getApprovalDetailList(visitRecordId, 1);
            dto.setCopysList(copysList);

            //3.随访人员
            Wrapper<VisitFollowUser> wrapper = QueryBuilder.<VisitFollowUser>lambdaQuery()
                .eq(VisitFollowUser::getVisitRecordId, visitRecordId);
            List<VisitFollowUser> followUserList = null;
            try {
                followUserList = visitFollowUserMapper.selectList(wrapper);
            } catch (Exception e) {
                logger.error("获取随访人员报错：{}", e.getMessage());
                throw new BizException("随访人数据异常：" + e.getMessage()) ;
            }
            dto.setFollowUserList(followUserList);

            //4.行为跟踪
            List<VisitRecordBehaviorTrace> recordBehaviorTraceList = null;
            try {
                recordBehaviorTraceList = visitRecordBehaviorTraceMapper.selectListByVisitRecordId(visitRecordId);
            } catch (Exception e) {
                logger.error("获取行为跟踪报错：{}", e.getMessage());
                throw new BizException("行为跟踪数据异常：" + e.getMessage());
            }
            dto.setRecordBehaviorTraceList(recordBehaviorTraceList);

            Wrapper<VisitRecordGateSentry> wrapper2 = QueryBuilder.<VisitRecordGateSentry>lambdaQuery()
                    .eq(VisitRecordGateSentry::getRecordId, visitRecordId);
            List<VisitRecordGateSentry> list = null;
            try {
            	list = visitRecordGateSentryMapper.selectList(wrapper2);
            } catch (Exception e) {
                logger.error("安防人员审批数据报错：{}",e.getMessage());
                throw new BizException("安防人员审批数据异常：" + e.getMessage());
            }
            if(list.size() > 0) {
            	VisitRecordGateSentry gateSentry = list.get(0);
            	UserViewDto userDto = uaacService.getUserDetail(gateSentry.getOriginatorId());
            	gateSentry.setTel(userDto.getPhone());
            	dto.setGateSentry(gateSentry);
            }
            return dto;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(ErrorCode.INTERNAL_ERROR, "查询不到对应的审批详情：" + e.getMessage());
        }
    }

    /**
     * @throws
     * @Title: validate
     * @Description:宾客登录验证
     * @param: @param visitorId
     * @return: void
     * @author: lcq
     * @date: 2019年12月21日 上午10:22:17
     * @version 1.0
     */
    @Transactional
    public void loginValidate(Long visitorId) {
        if (ObjectUtils.isEmpty(visitorId)) {
            throw new BizException("visitorId不能为空！");
        }
        visitRecordMapper.loginValidate(visitorId, 4, 1);//邀约验证

        Wrapper<VisitRecord> visitRecordWrapper = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getVisitorId, visitorId)
            .eq(VisitRecord::getRegistration, 1)
            .eq(VisitRecord::getVisitStatus, 2);
        List<VisitRecord> visitRecords = null;
        try {
            visitRecords = visitRecordMapper.selectList(visitRecordWrapper);
        } catch (Exception e) {
            throw new BizException("审批详情数据异常：" + e.getMessage());
        }
        for (int i = 0; i < visitRecords.size(); i++) {
            VisitRecord visitRecord = visitRecords.get(i);
            visitRecord.setVisitStatus(VisitStatus.VISITWAIT_2.getValue());
            visitRecordMapper.updateById(visitRecord);

            VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();
            trace.setVisitRecordId(visitRecord.getId());
            trace.setVisitStatus(VisitStatus.VISITWAIT_2);//待来访即为用户已验证
            trace.setOperationTime(visitRecord.getUpdateTime());
            visitRecordBehaviorTraceMapper.insert(trace);
        }
    }

    /**
     * @throws
     * @Title: approval
     * @Description: 员工审批
     * @param: @param approvalVo
     * @param: @param state
     * @return: void
     * @author: lcq
     * @date: 2019年12月21日 下午2:16:09
     * @version 1.0
     */
    @Transactional
    public void approval(ApprovalVo approvalVo) {
        Wrapper<ApprovalDetail> detailWrapper = QueryBuilder.<ApprovalDetail>lambdaQuery()
            .eq(ApprovalDetail::getApprovalId, approvalVo.getApprovalId());
        List<ApprovalDetail> details = null;
        try {
            details = approvalDetailMapper.selectList(detailWrapper);
        } catch (Exception e) {
            throw new BizException("审批详情数据异常：" + e.getMessage());
        }
        if (ObjectUtils.isEmpty(details)) {
            throw new BizException("审批详情数据异常：空");
        }

        Wrapper<Approval> approvalWrapper = QueryBuilder.<Approval>lambdaQuery()
            .eq(Approval::getId, approvalVo.getApprovalId());
        Approval approval = null;
        try {
            approval = approvalMapper.selectOne(approvalWrapper);
        } catch (Exception e) {
            throw new BizException("审批数据异常：" + e.getMessage());
        }
        if (ObjectUtils.isEmpty(approval)) {
            throw new BizException("审批数据异常：空");
        }

        Wrapper<VisitRecord> visitRecordWrapper = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getId, approvalVo.getVisitRecordId());
        VisitRecord visitRecord = null;
        try {
            visitRecord = visitRecordMapper.selectOne(visitRecordWrapper);
        } catch (Exception e) {
            throw new BizException("访客记录数据异常：" + e.getMessage());
        }
        if (ObjectUtils.isEmpty(visitRecord)) {
            throw new BizException("访客记录数据异常：空");
        }

        int sort = 0;
        for (int i = 0; i < details.size(); i++) {
            ApprovalDetail detail = details.get(i);
            if (detail.getUserId().equals(approvalVo.getUserId())) {
                sort = i;//获取审批人的位置
                break;
            }
        }
        ApprovalDetail detail = details.get(sort);

        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();

        if (sort == details.size() - 1) {//最后一个
            Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
                .eq(Visitor::getId, visitRecord.getVisitorId());
            Visitor visitor = null;
            try {
                visitor = visitorMapper.selectOne(visitorWrapper);
            } catch (Exception e) {
                throw new BizException("访客数据异常：" + e.getMessage());
            }
            if (ObjectUtils.isEmpty(visitor)) {
                throw new BizException("访客数据异常：访客不存在");
            }
            if (approvalVo.getOperationType() == 1) {//同意
                detail.setState(ApprovalState.STATE_1);
                approval.setState(ApprovalState.STATE_1);
                visitRecord.setVisitStatus(VisitStatus.VISITWAIT_1.getValue());
                trace.setVisitStatus(VisitStatus.PASS);
                trace.setPassStatus(ApprovalState.STATE_1.getValue());
                getConfig(visitRecord, visitor);
                sendNotify(NoticeType.SPJGTZ, SmsConstants.YYTG, visitRecord, visitor, null, null, null, null, null, null);
            } else if (approvalVo.getOperationType() == 2) {//拒绝
                detail.setState(ApprovalState.STATE_2);
                approval.setState(ApprovalState.STATE_2);
                visitRecord.setVisitStatus(VisitStatus.APPROVALREFUSE.getValue());
                trace.setVisitStatus(VisitStatus.APPROVALREFUSE);
                trace.setPassStatus(ApprovalState.STATE_2.getValue());
                getConfig(visitRecord, visitor);
                sendNotify(NoticeType.SPJGTZ, SmsConstants.YYBTG, visitRecord, visitor, null, null, null, null, null, null);

            } else {
                throw new BizException("operationType=" + approvalVo.getOperationType() + "参数值不存在");
            }
        } else {
            if (approvalVo.getOperationType() == 1) {//同意
                detail.setState(ApprovalState.STATE_1);
                trace.setVisitStatus(VisitStatus.PASS);
                trace.setPassStatus(ApprovalState.STATE_1.getValue());
            } else if (approvalVo.getOperationType() == 2) {//拒绝
                detail.setState(ApprovalState.STATE_2);
                approval.setState(ApprovalState.STATE_2);
                visitRecord.setVisitStatus(VisitStatus.APPROVALREFUSE.getValue());
                trace.setVisitStatus(VisitStatus.APPROVALREFUSE);
                trace.setPassStatus(ApprovalState.STATE_2.getValue());
            } else {
                throw new BizException("operationType=" + approvalVo.getOperationType() + "参数值不存在");
            }
        }
//        trace.setApprovalDetailId(detail.getId());
        trace.setVisitRecordId(visitRecord.getId());
        trace.setOperationTime(visitRecord.getUpdateTime());
        trace.setOpinion(approvalVo.getApprovalOpinion());
        trace.setUserId(detail.getUserId());
        UserViewDto dto = uaacService.getUserDetail(detail.getUserId());
        trace.setUserName(dto.getRealName());
        visitRecordBehaviorTraceMapper.insert(trace);

        detail.setApprovalOpinion(approvalVo.getApprovalOpinion());
        //审批人表
        approvalDetailMapper.updateById(detail);
        //审批主表
        approvalMapper.updateById(approval);
        //访客记录表
        visitRecordMapper.updateById(visitRecord);

        //uaac审批接口
        ApprovalOperationVo vo = new ApprovalOperationVo();
        vo.setUaacApprovalId(approval.getUaacApprovalId());
        vo.setUserId(approvalVo.getUserId());
        vo.setOrganizationId(approvalVo.getOrganizationId());
        vo.setOperationType(approvalVo.getOperationType());
        try {
            uaacService.updateApprovalStatus(vo);
        } catch (Exception e) {
            logger.error("approval异常：{}", e.toString());
            throw new BizException("调用uaac审批接口异常：" + e.getMessage());
        }
    }

    /**
     * @throws
     * @Title: visitHistory
     * @Description: 邀约历史
     * @param: @param vo
     * @param: @return
     * @return: IPage<VisitRecordForGuardDto>
     * @author: lcq
     * @date: 2019年12月21日 下午3:55:30
     * @version 1.0
     */
    public IPage<VisitRecordDto> visitRecordHistory(HomeVo vo) {
        IPage<VisitRecordDto> history = null;
        Page<VisitRecordDto> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        try {
            history = visitRecordMapper.visitRecordHistory(page, vo);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, "查询列表失败：" + e.getMessage());
        }
        return history;
    }

    /**
     * @throws
     * @Title: approvaledByMe
     * @Description: 我已审批
     * @param: @param vo
     * @param: @param approvalState
     * @param: @param type
     * @param: @return
     * @return: IPage<VisitRecordDto>
     * @author: lcq
     * @date: 2019年12月21日 下午5:42:04
     * @version 1.0
     */
    public IPage<VisitRecordDto> approvaledByMe(HomeVo vo, Integer approvalState, Integer type) {
        IPage<VisitRecordDto> history = null;
        Page<VisitRecordDto> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        try {
            List<Integer> stateList = new ArrayList<>();
            stateList.add(1);
            stateList.add(2);
            history = visitRecordMapper.approvalVisitRecord(page, vo, stateList, approvalState, type);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, "查询列表失败：" + e.getMessage());
        }
        return history;
    }

    /**
     * @throws
     * @Title: approvaledCopyMe
     * @Description: 抄送我的
     * @param: @param vo
     * @param: @param state
     * @param: @return
     * @return: IPage<VisitRecordDto>
     * @author: lcq
     * @date: 2019年12月23日 上午10:27:03
     * @version 1.0
     */
    public IPage<VisitRecordDto> approvaledCopyMe(HomeVo vo, Integer approvalState, Integer type) {
        IPage<VisitRecordDto> history = null;
        Page<VisitRecordDto> page = new Page<>(vo.getCurrentPage(), vo.getPageSize());
        try {
            history = visitRecordMapper.approvalVisitRecord(page, vo, null, approvalState, type);
        } catch (Exception e) {
            throw new BizException(ErrorCode.INTERNAL_ERROR, "查询列表失败：" + e.getMessage());
        }
        return history;
    }

    /**
     * @throws
     * @Title: visitValidate
     * @Description: 安防验证
     * @param: @param visitorId
     * @return: void
     * @author: lcq
     * @date: 2019年12月23日 上午10:59:36
     * @version 1.0
     */
    @Transactional
    public void visitValidate(VisitValidateVo vo) {
        if (vo.getPassStatus() != 1 && vo.getPassStatus() != 2) {//允许通行
            throw new BizException("passStatus参数值不存在！");
        }

        Wrapper<VisitRecord> visitRecordWrapper = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getId, vo.getVisitRecordId());
        VisitRecord visitRecord = null;
        try {
            visitRecord = visitRecordMapper.selectOne(visitRecordWrapper);
        } catch (Exception e) {
            throw new BizException("访客记录数据异常：" + e.getMessage());
        }
        if (ObjectUtils.isEmpty(visitRecord)) {
            throw new BizException("访客记录数据异常：空");
        }

        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();
        trace.setVisitRecordId(visitRecord.getId());
        if (vo.getPassStatus() == 1) {//允许
            trace.setVisitStatus(VisitStatus.ALREADYING);
            trace.setOperationTime(DateUtil.date2LocalDateTime(new Date()));
            if (ObjectUtils.isEmpty(visitRecord.getFirstCheckInTime())) {
                visitRecord.setFirstCheckInTime(trace.getOperationTime());
            }
            visitRecord.setVisitStatus(VisitStatus.ALREADYING.getValue());
            trace.setPassStatus(ApprovalState.STATE_1.getValue());
        } else if (vo.getPassStatus() == 2) {//拒绝
        	if(ObjectUtils.isEmpty(vo.getRefusalReason())) {
        		throw new BizException("拒绝原因必须选择！");
        	}
            trace.setVisitStatus(VisitStatus.VALIDATEREFUSE);
            trace.setOperationTime(DateUtil.date2LocalDateTime(new Date()));
            visitRecord.setVisitStatus(VisitStatus.VALIDATEREFUSE.getValue());
            trace.setPassStatus(ApprovalState.STATE_1.getValue());
            trace.setOpinion(vo.getRefusalReason() != null ? EnumUtil.getByValue(vo.getRefusalReason(), RefusalReason.class, "") : null);
        }
        trace.setUserId(vo.getGuardUserId());
        UserViewDto dto = uaacService.getUserDetail(vo.getGuardUserId());
        trace.setUserName(dto.getRealName());
        visitRecordBehaviorTraceMapper.insert(trace);

        visitRecordMapper.updateById(visitRecord);

        VisitAuthentication authentication = new VisitAuthentication();
        authentication.setVisitRecordId(visitRecord.getId());
        authentication.setGuardUserId(vo.getGuardUserId());
        authentication.setGuardUserName(vo.getGuardUserName());
        authentication.setPassStatus(vo.getPassStatus());
        authentication.setRefusalReason(vo.getRefusalReason());
        visitAuthenticationMapper.insert(authentication);

        Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getId, visitRecord.getVisitorId());
        Visitor visitor = null;
        try {
            visitor = visitorMapper.selectOne(visitorWrapper);
        } catch (Exception e) {
            throw new BizException("访客数据异常：" + e.getMessage());
        }
        if (ObjectUtils.isEmpty(visitor)) {
            throw new BizException("访客数据异常：空");
        }

        try {
            if (vo.getPassStatus() == 1) {//允许
                sendNotify(null, SmsConstants.YZTX_AGREE, visitRecord, visitor, authentication, null, null, null, null, null);
                //TODO 调接口闸机开门
            } else if (vo.getPassStatus() == 2) {//拒绝
                sendNotify(null, SmsConstants.YZTX_REFUSE, visitRecord, visitor, authentication, null, null, null, null, null);
            }
        } catch (Exception e) {
            logger.error("visitValidate报错：{}", e.toString());
            throw new BizException("操作失败：" + e.getMessage());
        }

    }


    /**
     * @throws
     * @Title: visitValidate
     * @Description: 撤销邀请
     * @param: @param visitRecordId
     * @return: void
     * @author: lcq
     * @date: 2020年1月6日 下午5:32:47
     * @version 1.0
     */
    @Transactional
    public void visitCancel(Long visitRecordId) {
        Wrapper<VisitRecord> visitRecordWrapper = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getId, visitRecordId);
        VisitRecord visitRecord = null;
        try {
            visitRecord = visitRecordMapper.selectOne(visitRecordWrapper);
        } catch (Exception e) {
            throw new BizException("访客记录数据异常！");
        }
        if (ObjectUtils.isEmpty(visitRecord)) {
            throw new BizException("访客记录数据异常：空");
        }
        if (visitRecord.getVisitStatus() != VisitStatus.CHECKWAIT_2.getValue() && visitRecord.getVisitStatus() != VisitStatus.VISITWAIT_2.getValue()) {
            //除待验证、待来访 其余不能撤销
            throw new BizException("当前状态不允许撤销！");
        }
        Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getId, visitRecord.getVisitorId());
        Visitor visitor = null;
        try {
            visitor = visitorMapper.selectOne(visitorWrapper);
        } catch (Exception e) {
            throw new BizException("访客数据异常："  + e.getMessage());
        }
        if (ObjectUtils.isEmpty(visitRecord)) {
            throw new BizException("访客数据异常：空");
        }
        visitRecord.setVisitStatus(VisitStatus.INVITATION_REVOKE.getValue());
//        getConfig(visitRecord, visitor);
        visitRecordMapper.updateById(visitRecord);

        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();
        trace.setVisitRecordId(visitRecord.getId());
        trace.setVisitStatus(VisitStatus.INVITATION_REVOKE);
        trace.setOperationTime(visitRecord.getUpdateTime());
        Long userId = CurrentUser.getCurrent().getId();
        String name = CurrentUser.getCurrent().getName();
        trace.setUserId(userId);
        trace.setUserName(name);
        visitRecordBehaviorTraceMapper.insert(trace);

        try {
            sendNotify(NoticeType.YYXXTZ, SmsConstants.YYQX, visitRecord, visitor, null, null, null, null, null, null);
        } catch (Exception e) {
            throw new BizException("撤销失败：" + e.getMessage());
        }
    }

    /**
     * @throws
     * @Title: reapply
     * @Description: 重新邀请
     * @param: @param visitRecordId
     * @return: void
     * @author: lcq
     * @date: 2020年1月9日 下午2:45:37
     * @version 1.0
     */
    @Transactional
    public void reapply(Long visitRecordId) {
        Wrapper<VisitRecord> visitRecordWrapper = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getId, visitRecordId);
        VisitRecord visitRecord = null;
        try {
            visitRecord = visitRecordMapper.selectOne(visitRecordWrapper);
        } catch (Exception e) {
            throw new BizException("访客记录数据异常："  + e.getMessage());
        }
        if (ObjectUtils.isEmpty(visitRecord)) {
            throw new BizException("访客记录数据异常：空");
        }
        if(VisitStatus.INVITATION_REVOKE.getValue() != visitRecord.getVisitStatus()) {
        	throw new BizException("非撤销状态无法重新邀约！");
        }
        Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getId, visitRecord.getVisitorId());
        Visitor visitor = null;
        try {
            visitor = visitorMapper.selectOne(visitorWrapper);
        } catch (Exception e) {
            throw new BizException("访客数据异常："  + e.getMessage());
        }
        if (ObjectUtils.isEmpty(visitor)) {
            throw new BizException("访客数据异常：空");
        }
        visitRecord.setVisitStatus(VisitStatus.CHECKWAIT_2.getValue());
//        getConfig(visitRecord, visitor);
        visitRecordMapper.updateById(visitRecord);

        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();
        trace.setVisitRecordId(visitRecord.getId());
        trace.setVisitStatus(VisitStatus.CHECKWAIT_2);
        trace.setOperationTime(visitRecord.getUpdateTime());
        Long userId = CurrentUser.getCurrent().getId();
        String name = CurrentUser.getCurrent().getName();
        trace.setUserId(userId);
        trace.setUserName(name);
        visitRecordBehaviorTraceMapper.insert(trace);

        try {
            sendNotify(NoticeType.YYXXTZ, SmsConstants.YQTZ, visitRecord, visitor, null, null, null, null, null, null);
        } catch (Exception e) {
            throw new BizException("重新邀约失败：" + e.getMessage());
        }
    }


    /**
     * @throws
     * @Title: visitRemind
     * @Description: 拜访提醒
     * @param:
     * @return: void
     * @author: lcq
     * @date: 2020年1月9日 下午2:56:43
     * @version 1.0
     */
    @Transactional
    @JobHandler
    public void visitRemind() {
        //于拜访开始时间前24小时
        LocalDateTime remindTime_1 = DateUtil.manageDate(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM, Calendar.HOUR, 24);

        Wrapper<VisitRecord> visitRecordWrapper_1 = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getAppointmentStartTime, DateUtil.getDateToString(DateUtil.localDateTime2Date(remindTime_1)));

        List<VisitRecord> visitRecords_1 = null;
        try {
            visitRecords_1 = visitRecordMapper.selectList(visitRecordWrapper_1);
        } catch (Exception e) {
            throw new BizException("访客记录数据异常！");
        }
        if (!ObjectUtils.isEmpty(visitRecords_1)) {
            for (int i = 0; i < visitRecords_1.size(); i++) {
                VisitRecord record = visitRecords_1.get(i);

                Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
                    .eq(Visitor::getId, record.getVisitorId());
                Visitor visitor = null;
                try {
                    visitor = visitorMapper.selectOne(visitorWrapper);
                } catch (Exception e) {
                    logger.error("访客数据异常：{}", e.toString());
                    continue;
                }
                if (ObjectUtils.isEmpty(visitor)) {
                    logger.info("访客数据异常：空！");
                    continue;
                }
                try {
                    sendNotify(null, SmsConstants.BFTX_1, record, visitor, null, null, null, null, null, null);
                } catch (Exception e) {
                    logger.error("visitRemind_1报错：{}", e.toString());
                    JobLogger.log(null, e.toString(), JobStatus.FAIL);
                    continue;
                }
            }
        }

        //于拜访开始时间前2小时
        LocalDateTime remindTime_2 = DateUtil.manageDate(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM, Calendar.HOUR, 2);
        Wrapper<VisitRecord> visitRecordWrapper_2 = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getAppointmentStartTime, DateUtil.getDateToString(DateUtil.localDateTime2Date(remindTime_2)));
        List<VisitRecord> visitRecords_2 = null;
        try {
            visitRecords_2 = visitRecordMapper.selectList(visitRecordWrapper_2);
        } catch (Exception e) {
            throw new BizException("访客记录数据异常！");
        }
        if (!ObjectUtils.isEmpty(visitRecords_2)) {
            for (int i = 0; i < visitRecords_2.size(); i++) {
                VisitRecord record = visitRecords_2.get(i);

                Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
                    .eq(Visitor::getId, record.getVisitorId());
                Visitor visitor = null;
                try {
                    visitor = visitorMapper.selectOne(visitorWrapper);
                } catch (Exception e) {
                    logger.error("访客数据异常：{}", e.toString());
                    continue;
                }
                if (ObjectUtils.isEmpty(visitor)) {
                    logger.info("访客数据异常：空");
                    continue;
                }
                //拜访提醒	访客
                try {
                    sendNotify(null, SmsConstants.BFTX_2, record, visitor, null, null, null, null, null, null);
                } catch (Exception e) {
                    logger.error("visitRemind_BFTX_2报错：{}", e.toString());
                    JobLogger.log(null, e.toString(), JobStatus.FAIL);
                    continue;
                }

                //来访提醒 	员工
                try {
                    sendNotify(null, SmsConstants.LFTX_OUT, record, visitor, null, null, null, null, null, null);
                } catch (Exception e) {
                    logger.error("visitRemind_LFTX_OUT报错：{}", e.toString());
                    JobLogger.log(null, e.toString(), JobStatus.FAIL);
                    continue;
                }
            }
        }
    }

    /**
     * @throws
     * @Title: checkOutRemind
     * @Description: 签出提醒
     * @param:
     * @return: void
     * @author: lcq
     * @date: 2020年1月9日 下午2:56:43
     * @version 1.0
     */
    @Transactional
    @JobHandler
    public void checkOutRemind() {
        //签出提醒 距离离开时间前30分钟
        LocalDateTime remindTime_1 = DateUtil.manageDate(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM, Calendar.MINUTE, 30);

        Wrapper<VisitRecord> visitRecordWrapper_1 = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getAppointmentEndTime, DateUtil.getDateToString(DateUtil.localDateTime2Date(remindTime_1)));

        List<VisitRecord> visitRecords_1 = null;
        try {
            visitRecords_1 = visitRecordMapper.selectList(visitRecordWrapper_1);
        } catch (Exception e) {
            return;
        }
        if (!ObjectUtils.isEmpty(visitRecords_1)) {
            for (int i = 0; i < visitRecords_1.size(); i++) {
                VisitRecord record = visitRecords_1.get(i);

                Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
                    .eq(Visitor::getId, record.getVisitorId());
                Visitor visitor = null;
                try {
                    visitor = visitorMapper.selectOne(visitorWrapper);
                } catch (Exception e) {
                    logger.error("访客数据异常：{}", e.toString());
                    continue;
                }
                if (ObjectUtils.isEmpty(visitor)) {
                    logger.info("访客数据异常：空");
                    continue;
                }
                try {
                    sendNotify(NoticeType.YQWQCTZ, SmsConstants.QCTX, record, visitor, null, null, null, null, null, null);
                } catch (Exception e) {
                    logger.error("checkOutRemind_1报错：{}", e.toString());
                    JobLogger.log(null, e.toString(), JobStatus.FAIL);
                    continue;
                }
            }
        }

        //预期未签出 离开时间-即时
        Wrapper<VisitRecord> visitRecordWrapper_2 = QueryBuilder.<VisitRecord>lambdaQuery()
            .eq(VisitRecord::getAppointmentEndTime, DateUtil.format(new Date(), DateUtil.DATE_PATTERN_yyyy_MM_dd_HH_MM));
        List<VisitRecord> visitRecords_2 = null;
        try {
            visitRecords_2 = visitRecordMapper.selectList(visitRecordWrapper_2);
        } catch (Exception e) {
            throw new BizException("访客记录数据异常！");
        }
        if (!ObjectUtils.isEmpty(visitRecords_2)) {
            for (int i = 0; i < visitRecords_2.size(); i++) {
                VisitRecord record = visitRecords_2.get(i);

                Wrapper<Visitor> visitorWrapper = QueryBuilder.<Visitor>lambdaQuery()
                    .eq(Visitor::getId, record.getVisitorId());
                Visitor visitor = null;
                try {
                    visitor = visitorMapper.selectOne(visitorWrapper);
                } catch (Exception e) {
                    logger.error("访客数据异常：{}", e.toString());
                    continue;
                }
                if (ObjectUtils.isEmpty(visitor)) {
                    logger.info("访客数据异常：空");
                    continue;
                }
                try {
                    sendNotify(NoticeType.YQWQCTZ, SmsConstants.YQWQC, record, visitor, null, null, null, null, null, null);
                } catch (Exception e) {
                    logger.error("checkOutRemind_2报错：{}", e.toString());
                    JobLogger.log(null, e.toString(), JobStatus.FAIL);
                    continue;
                }
            }
        }
    }

    /**
     * @throws
     * @Title: getConfig
     * @Description: 获取员工权限配置 生成二维码、数字码
     * @param: @param userId
     * @param: @return
     * @return: VisitRecord
     * @author: lcq
     * @date: 2020年1月14日 下午2:02:45
     * @version 1.0
     */
    public RoleConfigDto getEmpConfig(Long userId) {
        userId = CurrentUser.getCurrent().getId();
        RoleConfigDto dto = new RoleConfigDto();
        logger.info("getEmpConfig.userId：{}",userId);
        RolePermissionVo rolePermissionVo = permissionService.queryPermission4Employee(userId);
        if (!ObjectUtils.isEmpty(rolePermissionVo)) {
            List<AccessApprovalPermissionVo> accessApprovalPermissionVo = rolePermissionVo.getAccessApprovalPermissionList();
            if (ObjectUtils.isEmpty(accessApprovalPermissionVo)) {
                throw new BizException("权限未配置！");
            } else {
                AccessApprovalPermissionVo vo = accessApprovalPermissionVo.stream().filter(it -> PermissionRange.REGION.equals(it.getPermissionRange())).findFirst().get();
                if (vo.isWhole()) {
                    //全区域
                	dto.setAreaIds("0");
                } else {
                    //部分区域
                    String ids = StringUtils.join(vo.getRangeIds(), ",");
                    dto.setAreaIds(ids);
                }

                AccessApprovalPermissionVo permissionVo = accessApprovalPermissionVo.stream().filter(it -> PermissionRange.DATETIME.equals(it.getPermissionRange())).findFirst().get();
                if (permissionVo.isWhole()) {
                    //全天
                    dto.setOpenTimeStart(DateUtil.START_TIME_HM);
                    dto.setOpenTimeEnd(DateUtil.END_TIME_HM);
                } else {
                    //指定时间
                    dto.setOpenTimeStart(permissionVo.getOpenTimeStart().toString());
                    dto.setOpenTimeEnd(permissionVo.getOpenTimeEnd().toString());
                }
                logger.info("isNumericCode：{}",rolePermissionVo.isNumericCode());
                logger.info("isQrCode：{}",rolePermissionVo.isQrCode());
                if (rolePermissionVo.isNumericCode()) {
                    String numericCode = RuleUtil.randomNum();
                    dto.setNumericCode(numericCode);
                    logger.info("numericCode：{}",numericCode);
                }
                if (rolePermissionVo.isQrCode()) {
//					StringBuffer content = new StringBuffer();
//					content.append("{");
//						content.append("\"result\":{");
//							content.append("\"userId:\"" + userId + "\",");
//							content.append("\"areaIds:\"" + dto.getAreaIds() + "\",");
//							content.append("\"openTimeStart:\"" + dto.getOpenTimeStart() + "\",");
//							content.append("\"openTimeEnd:\"" + dto.getOpenTimeEnd() + "\"");
//					    content.append("}");
//					content.append("}");

                    Map<String, Object> map = new HashMap<>();
                    map.put("userId", userId);
                    map.put("areaIds", dto.getAreaIds());
                    map.put("openTimeStart", dto.getOpenTimeStart());
                    map.put("openTimeEnd", dto.getOpenTimeEnd());
                    String jsonString = JSON.toJSONString(map);

                    BufferedImage qrcode = QrCodeUtils.encode(jsonString, 430);
                    String base64EncodedQrcode = ImageUtils.encodeWithBase64(qrcode, FileType.Image.PNG);
//					FileFormVo fileFormVo = new FileFormVo();
//					fileFormVo.setBase64(base64EncodedQrcode);
                    dto.setQrCode(base64EncodedQrcode);
                    dto.setUserId(userId);
                    logger.info("base64EncodedQrcode：{}",base64EncodedQrcode);
                }
                if(!rolePermissionVo.isNumericCode() && !rolePermissionVo.isQrCode()) {
                	throw new BizException("二维码及数字码未配置，请联系您的企业管理员！");
                }
            }
        }else {
        	throw new BizException("二维码及数字码未配置获取为空！");
        }
        return dto;
    }

    /**
     * @throws
     * @Title: getGuardConfig
     * @Description: 获取安防人员权限配置 生成二维码、数字码
     * @param: @param roleId
     * @param: @param enterpriseId
     * @param: @return
     * @return: RolePermissionVo
     * @author: lcq
     * @date: 2020年1月14日 下午3:03:35
     * @version 1.0
     */
    public RoleConfigDto getGuardConfig(Long userId, Long enterpriseId) {
    	enterpriseId = CurrentUser.getCurrent().getSessionEnterprise().c2;
        userId = CurrentUser.getCurrent().getId();
        logger.info("getGuardConfig.userId：{}，getGuardConfig.enterpriseId：{}",userId,enterpriseId);
    	UserViewDto userDto = uaacService.getUserDetail(userId);
    	if(ObjectUtils.isEmpty(userDto)) {
    		throw new BizException("用户不存在：userId=" + userId);
    	}
        GateSentryOutVo outVo = gateSentryService.getDetail(userDto.getPhone(), enterpriseId);
        if (ObjectUtils.isEmpty(outVo)) {
            throw new BizException("现场门岗不存在");
        }
        if (ObjectUtils.isEmpty(outVo.getRoleId())) {
            throw new BizException("获取角色失败");
        }
        RoleConfigDto dto = new RoleConfigDto();
        RolePermissionVo rolePermissionVo = permissionService.queryRolePermission(outVo.getRoleId());
        AccessTrafficVo accessTrafficVo = permissionService.getAccessRole(enterpriseId);
        if (null != accessTrafficVo) {
            rolePermissionVo.setQrCode(accessTrafficVo.isQrCode());
            rolePermissionVo.setNumericCode(accessTrafficVo.isNumericCode());
            rolePermissionVo.setFace(accessTrafficVo.isFace());
        }

        if (!ObjectUtils.isEmpty(rolePermissionVo)) {
            List<AccessApprovalPermissionVo> accessApprovalPermissionVo = rolePermissionVo.getAccessApprovalPermissionList();
            if (ObjectUtils.isEmpty(accessApprovalPermissionVo)) {
                throw new BizException("权限未配置！");
            } else {
                AccessApprovalPermissionVo vo = accessApprovalPermissionVo.stream().filter(it -> PermissionRange.REGION.equals(it.getPermissionRange())).findFirst().get();
                if (vo.isWhole()) {
                    //全区域
                	dto.setAreaIds("0");
                } else {
                    //部分区域
                    String ids = StringUtils.join(vo.getRangeIds(), ",");
                    dto.setAreaIds(ids);
                }

                AccessApprovalPermissionVo permissionVo = accessApprovalPermissionVo.stream().filter(it -> PermissionRange.DATETIME.equals(it.getPermissionRange())).findFirst().get();
                if (permissionVo.isWhole()) {
                    //全天
                    dto.setOpenTimeStart(DateUtil.START_TIME_HM);
                    dto.setOpenTimeEnd(DateUtil.END_TIME_HM);
                } else {
                    //指定时间
                    dto.setOpenTimeStart(permissionVo.getOpenTimeStart().toString());
                    dto.setOpenTimeEnd(permissionVo.getOpenTimeEnd().toString());
                }

                logger.info("isNumericCode：{}",rolePermissionVo.isNumericCode());
                logger.info("isQrCode：{}",rolePermissionVo.isQrCode());
                if (rolePermissionVo.isNumericCode()) {
                    String numericCode = RuleUtil.randomNum();
                    dto.setNumericCode(numericCode);
                    logger.info("numericCode：{}",numericCode);
                }
                if (rolePermissionVo.isQrCode()) {
//					StringBuffer content = new StringBuffer();
//					content.append("{");
//						content.append("\"result\":{");
//							content.append("\"userId:\"" + userId + "\",");
//							content.append("\"areaIds:\"" + dto.getAreaIds() + "\",");
//							content.append("\"openTimeStart:\"" + dto.getOpenTimeStart() + "\",");
//							content.append("\"openTimeEnd:\"" + dto.getOpenTimeEnd() + "\",");
//					    content.append("}");
//					content.append("}");

                    Map<String, Object> map = new HashMap<>();
                    map.put("userId", userId);
                    map.put("areaIds", dto.getAreaIds());
                    map.put("openTimeStart", dto.getOpenTimeStart());
                    map.put("openTimeEnd", dto.getOpenTimeEnd());
                    String jsonString = JSON.toJSONString(map);

                    BufferedImage qrcode = QrCodeUtils.encode(jsonString, 430);
                    String base64EncodedQrcode = ImageUtils.encodeWithBase64(qrcode, FileType.Image.PNG);
//					FileFormVo fileFormVo = new FileFormVo();
//					fileFormVo.setBase64(base64EncodedQrcode);
                    dto.setQrCode(base64EncodedQrcode);
                    dto.setUserId(userId);
                    logger.info("base64EncodedQrcode：{}",base64EncodedQrcode);
                }
                if(!rolePermissionVo.isNumericCode() && !rolePermissionVo.isQrCode()) {
                	throw new BizException("二维码及数字码未配置，请联系您的企业管理员！");
                }
            }
        }else {
        	throw new BizException("权限未配置，请联系您的企业管理员！");
        }
        return dto;
    }

    @Transactional
    public VisitRecord addAppointment(AppointmentVo vo) {
        LambdaQueryWrapper<Visitor> query = QueryBuilder.<Visitor>lambdaQuery()
            .eq(Visitor::getTel, vo.getVisitTel()).isNull(Visitor::getEnterpriseId);
        List<Visitor> visitorList = visitorMapper.selectList(query);
        if (visitorList.size() == 0)
            throw new BizException("访客信息不存在");
        EmpViewVo empViewVo = uaacService.getByUser(vo.getEnterpriseId(), vo.getInternalStaffUserTel());
        if (empViewVo == null)
            throw new BizException("查询不到企业员工");
        EnterpriseViewVo entVo = uaacService.getEntDetail(empViewVo.getEnterpriseId());
        if (entVo == null)
            throw new BizException("查询不到企业信息");
        vo.setInternalStaffUserId(empViewVo.getUserId());
        vo.setInternalStaffUserName(empViewVo.getUsername());
        Visitor visitor = visitorList.get(0);
        if(!visitor.getName().equals(vo.getVisitName()))
            throw new BizException("受访人手机号码与系统预留手机号不符，请核对后再提交");
        visitor.setId(null);
        visitor.setEnterpriseId(vo.getEnterpriseId());
        visitorMapper.insert(visitor);
        VisitRecord visitRecord = new VisitRecord();
        BeanUtils.copyProperties(vo, visitRecord);
        visitRecord.setInternalStaffUserStation(empViewVo.getStationName());
        visitRecord.setAddress(entVo.getAddress());
        visitRecord.setRegistration(2);
//        visitRecord.setSource(1);
        visitRecord.setVisitStatus(VisitStatus.CHECKWAIT_1.getValue());
        visitRecord.setVisitorId(visitor.getId());
        baseMapper.insert(visitRecord);

        //随访人员信息
        if (!ObjectUtils.isEmpty(vo.getFollowUserList())) {
            for (int i = 0; i < vo.getFollowUserList().size(); i++) {
                VisitFollowUserVo visitFollowUserVo = vo.getFollowUserList().get(i);
                VisitFollowUser followUser = new VisitFollowUser();
                followUser.setVisitRecordId(visitRecord.getId());
                followUser.setUserName(visitFollowUserVo.getUserName());
                followUser.setUserIdentityCard(visitFollowUserVo.getUserIdentityCard());
                followUser.setUserTel(visitFollowUserVo.getUserTel());
                followUser.setFaceImg(visitFollowUserVo.getFaceImg());
                visitFollowUserMapper.insert(followUser);
            }
        }

        List<ApprovalUserVo> approvalUserList = new ArrayList<>();
        ApprovalUserVo approvalUserVo = new ApprovalUserVo();
        approvalUserVo.setUserId(visitRecord.getInternalStaffUserId());
        approvalUserVo.setRealName(visitRecord.getInternalStaffUserName());
        approvalUserVo.setUserTel(visitRecord.getInternalStaffUserTel());
        approvalUserVo.setOrganizationId(visitRecord.getEnterpriseId());
        approvalUserVo.setType(0);
        approvalUserVo.setSort(0);
        approvalUserList.add(approvalUserVo);

        String companyName = visitor.getCompanyName() != null ? visitor.getCompanyName() : "";
        String jsonStr = "[" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"访客姓名\"," +
            "        \"fieldValue\":\"" + visitor.getName() + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"被邀请人姓名\"," +
            "        \"fieldSort\":\"0\"" +
            "}," +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"访客所属企业\"," +
            "        \"fieldValue\":\"" + companyName + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"被邀请人企业\"," +
            "        \"fieldSort\":\"1\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"发起时间\"," +
            "        \"fieldValue\":\"" + DateUtil.getDateToString(new Date()) + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"发起时间\"," +
            "        \"fieldSort\":\"2\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"访客手机号\"," +
            "        \"fieldValue\":\"" + visitor.getTel() + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"访客手机号\"," +
            "        \"fieldSort\":\"3\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"访问对象\"," +
            "        \"fieldValue\":\"" + vo.getInternalStaffUserName() + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"访问对象\"," +
            "        \"fieldSort\":\"4\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"访问事由\"," +
            "        \"fieldValue\":\"" + vo.getVisitCause().getDescription() + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"邀访事由\"," +
            "        \"fieldSort\":\"5\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"访问时间\"," +
            "        \"fieldValue\":\"" + vo.getAppointmentStartTime() + "~" + vo.getAppointmentEndTime() + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"邀访事由\"," +
            "        \"fieldSort\":\"6\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"车牌号\"," +
            "        \"fieldValue\":\"" + vo.getCarNum() + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"车牌号\"," +
            "        \"fieldSort\":\"7\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"随访人数\"," +
            "        \"fieldValue\":\"" + vo.getFollowNum() + "\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"随访人数\"," +
            "        \"fieldSort\":\"8\"" +
            "}" +
            "{" +
            "        \"fieldType\":\"text\"," +
            "        \"fieldText\":\"访客属性\"," +
            "        \"fieldValue\":\"未定义\"," +
            "        \"fieldLength\":\"\"," +
            "        \"fieldDesc\":\"访客属性\"," +
            "        \"fieldSort\":\"9\"" +
            "}" +
            "]";

        List<ApplyFiles> applyFiles = JSON.parseObject(jsonStr, new TypeReference<List<ApplyFiles>>() {
        });
        //2.调uaac审批接口
        ApprovalSubmitVo approvalSubmitVo = new ApprovalSubmitVo();
        approvalSubmitVo.setUserId(vo.getInternalStaffUserId());
        approvalSubmitVo.setOrganizationId(vo.getEnterpriseId());
        approvalSubmitVo.setRelationCode("sysTEST8");
        approvalSubmitVo.setApprovalDescribe("审批流测试");
        approvalSubmitVo.setApprovalFlowUserList(approvalUserList);
        approvalSubmitVo.setApplyFiles(applyFiles);
        String uaacApprovalId = "";
        try {
            uaacApprovalId = uaacService.submitApproval(approvalSubmitVo);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("uaacService.submitApproval == " + e.toString());
            throw new BizException("提交uaac审批失败");
        }
//        uaacApprovalId = "121";
        if (ObjectUtils.isEmpty(uaacApprovalId)) {
            throw new BizException("uaacApprovalId获取失败");
        }
        //3.新增本地审批表
        Approval approval = new Approval();
        approval.setOriginatorId(vo.getInternalStaffUserId());
        approval.setVisitRecordId(visitRecord.getId());
        approval.setState(ApprovalState.STATE_0);
        approval.setApprovalDesc("发起预约");
        approval.setUaacApprovalId(Long.valueOf(uaacApprovalId));
        approvalMapper.insert(approval);

        //3.新增审批人、抄送人信息
        if (!ObjectUtils.isEmpty(approvalUserList)) {
            for (int i = 0; i < approvalUserList.size(); i++) {
                ApprovalDetail approvalDetail = new ApprovalDetail();
                approvalDetail.setApprovalId(approval.getId());
                approvalDetail.setUserId(approvalUserList.get(i).getUserId());
                approvalDetail.setOrganizationId(approvalUserList.get(i).getOrganizationId());
                approvalDetail.setUserName(approvalUserList.get(i).getRealName());
                approvalDetail.setUserTel(approvalUserList.get(i).getUserTel());
                approvalDetail.setSort(i);
                approvalDetail.setType(0);
                approvalDetail.setState(ApprovalState.STATE_0);
                approvalDetailMapper.insert(approvalDetail);
            }
        }


        List<ApprovalForm> formList = JSON.parseObject(jsonStr, new TypeReference<List<ApprovalForm>>() {
        });
        //5.新增审批表单
        for (int j = 0; j < formList.size(); j++) {
            ApprovalForm approvalForm = formList.get(j);
            approvalForm.setApprovalId(approval.getId());
            approvalFormMapper.insert(approvalForm);
        }

        VisitRecordBehaviorTrace trace = new VisitRecordBehaviorTrace();
        trace.setVisitRecordId(visitRecord.getId());
        trace.setVisitStatus(VisitStatus.CHECKWAIT_1);
        trace.setOperationTime(LocalDateTime.now());
        trace.setUserName(visitorList.get(0).getName());
        visitRecordBehaviorTraceMapper.insert(trace);

        sendNotify(NoticeType.YYSPTZ, SmsConstants.YYSQ, visitRecord, visitorList.get(0), null, null, null, null, null, null);

        return visitRecord;
    }
}
