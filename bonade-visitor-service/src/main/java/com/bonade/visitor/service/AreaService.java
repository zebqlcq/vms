package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.Abnormal;
import com.bonade.visitor.domain.entity.AbnormalImg;
import com.bonade.visitor.domain.entity.Area;
import com.bonade.visitor.domain.entity.VisitRecord;
import com.bonade.visitor.domain.vo.*;
import com.bonade.visitor.mapper.AbnormalImgMapper;
import com.bonade.visitor.mapper.AbnormalMapper;
import com.bonade.visitor.mapper.AreaMapper;
import com.bonade.visitor.mapper.VisitRecordMapper;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.Assert;
import org.spin.core.collection.Pair;
import org.spin.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AreaService extends ServiceImpl<AreaMapper, Area> {

    public void addOrUpdateArea(AreaInVo vo) {
        if (vo.getId() == null) {
            //新增
            LambdaQueryWrapper<Area> query = QueryBuilder.<Area>lambdaQuery()
                .eq(Area::getEnterpriseId, vo.getEnterpriseId())
                .eq(Area::getName, vo.getName());
            int count = baseMapper.selectCount(query);
            if (count > 0)
                throw new BizException("区域名称重复");
            Area area = new Area();
            BeanUtils.copyTo(vo, area);
            baseMapper.insert(area);
        } else {
            //修改
            Area area = baseMapper.selectById(vo.getId());
            if (area == null)
                throw new BizException("查不到区域信息");
            BeanUtils.copyTo(vo, area);
            baseMapper.updateById(area);
        }
    }

    public IPage<AreaOutVo> getPage(AreaInVo vo) {
        Page<Area> page = new Page<>(vo.getCurrent(), vo.getSize());
        return baseMapper.getPage(page, vo);
    }

    public List<AreaOutVo> getList(AreaInVo vo) {
        return baseMapper.getList(vo);
    }

    public AreaOutVo getDetail(Long id) {
        Area area = baseMapper.selectById(id);
        if (area == null)
            throw new BizException("查不到区域信息");
        AreaOutVo outVo = new AreaOutVo();
        BeanUtils.copyTo(area, outVo);
        return outVo;
    }

    public void del(Long id) {
        baseMapper.deleteById(id);
    }


}
