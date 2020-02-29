package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.Area;
import com.bonade.visitor.domain.entity.GardenArea;
import com.bonade.visitor.domain.entity.Guard;
import com.bonade.visitor.domain.entity.RoleVisitPermission;
import com.bonade.visitor.domain.vo.AccessRuleVo;
import com.bonade.visitor.domain.vo.GuardInVo;
import com.bonade.visitor.domain.vo.GuardOutVo;
import com.bonade.visitor.mapper.AreaMapper;
import com.bonade.visitor.mapper.GardenAreaMapper;
import com.bonade.visitor.mapper.GuardMapper;
import com.bonade.visitor.mapper.RoleVisitPermissionMapper;
import org.spin.common.throwable.BizException;
import org.spin.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GuardService extends ServiceImpl<GuardMapper, Guard> {

    @Autowired
    private GardenAreaMapper gardenAreaMapper;

    @Autowired
    private AreaMapper areaMapper;

    public void addOrUpdateGuard(GuardInVo vo) {
        if (vo.getId() == null) {
            Guard guard = new Guard();
            BeanUtils.copyTo(vo, guard);
            baseMapper.insert(guard);
        } else {
            //修改
            Guard guard = baseMapper.selectById(vo.getId());
            if (guard == null)
                throw new BizException("查不到门禁信息");
            BeanUtils.copyTo(vo, guard);
            baseMapper.updateById(guard);
        }
    }

    public IPage<GuardOutVo> getPage(GuardInVo vo) {
        Page<Guard> page = new Page<>(vo.getCurrent(), vo.getSize());
        IPage<GuardOutVo> voPage;
        if (vo.getAreaType() != null && vo.getAreaType() == 1) {
            voPage = baseMapper.getGardenGuardPage(page, vo);
        } else {
            voPage = baseMapper.getPage(page, vo);
        }
        for (GuardOutVo guardOutVo : voPage.getRecords()) {
            guardOutVo.setStatusDesc(guardOutVo.getStatus().getDescription());
            guardOutVo.setGuardTypeName(guardOutVo.getGuardType().getDescription());
            guardOutVo.setAscriptionTypeName(guardOutVo.getAscriptionType().getDescription());
        }
        return voPage;
    }

    public GuardOutVo getDetail(Long id) {
        Guard guard = baseMapper.selectById(id);
        if (guard == null)
            throw new BizException("查不到门禁信息");
        GuardOutVo outVo = new GuardOutVo();
        BeanUtils.copyTo(guard, outVo);
        if (guard.getAreaType() == 1) {
            GardenArea gardenArea = gardenAreaMapper.selectById(guard.getAreaId());
            if (gardenArea != null)
                outVo.setAreaName(gardenArea.getName());
        }
        if (guard.getAreaType() == 2) {
            Area area = areaMapper.selectById(guard.getAreaId());
            if (area != null)
                outVo.setAreaName(area.getName());
        }
        outVo.setStatusDesc(outVo.getStatus().getDescription());
        outVo.setGuardTypeName(outVo.getGuardType().getDescription());
        return outVo;
    }

    public void del(Long id) {
        baseMapper.deleteById(id);
    }


}
