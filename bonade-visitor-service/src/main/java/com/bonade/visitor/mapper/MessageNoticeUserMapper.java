package com.bonade.visitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bonade.visitor.domain.entity.MessageNoticeTemplate;
import com.bonade.visitor.domain.entity.MessageNoticeUser;
import com.bonade.visitor.domain.vo.MessageNoticeTemplateInVo;
import com.bonade.visitor.domain.vo.MessageNoticeTemplateOutVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageNoticeUserMapper extends BaseMapper<MessageNoticeUser> {

}
