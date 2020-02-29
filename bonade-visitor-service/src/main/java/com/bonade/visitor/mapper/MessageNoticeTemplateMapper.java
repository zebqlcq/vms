package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.MessageNoticeTemplate;
import com.bonade.visitor.domain.vo.MessageNoticeTemplateInVo;
import com.bonade.visitor.domain.vo.MessageNoticeTemplateOutVo;
import com.bonade.visitor.domain.vo.VisitOutVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageNoticeTemplateMapper extends BaseMapper<MessageNoticeTemplate> {

    public Page<MessageNoticeTemplateOutVo> getPage(Page<MessageNoticeTemplate> page, @Param("vo")MessageNoticeTemplateInVo vo);

    public Page<VisitOutVo> getMessageNoticeUserPage(Page<MessageNoticeTemplate> page, @Param("vo")MessageNoticeTemplateInVo vo);

    public Page<VisitOutVo> getMessageNoticeUserConPage(Page<MessageNoticeTemplate> page, @Param("vo")MessageNoticeTemplateInVo vo);
}
