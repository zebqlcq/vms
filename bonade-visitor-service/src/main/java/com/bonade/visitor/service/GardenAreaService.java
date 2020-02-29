package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.GardenArea;
import com.bonade.visitor.domain.remote.EnterpriseSimpleEditVo;
import com.bonade.visitor.domain.remote.EnterpriseViewVo;
import com.bonade.visitor.domain.vo.GardenAreaInVo;
import com.bonade.visitor.domain.vo.GardenAreaOutVo;
import com.bonade.visitor.mapper.GardenAreaMapper;
import com.bonade.visitor.service.remote.UaacService;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.Assert;
import org.spin.core.collection.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class GardenAreaService extends ServiceImpl<GardenAreaMapper, GardenArea> {

    @Autowired
    private UaacService uaacService;

    public GardenArea addOrUpdateArea(GardenAreaInVo vo) {
        if (vo.getId() == null) {
            //新增
            if (vo.getParentId() != 0) {
                GardenArea parentGardenArea = baseMapper.selectById(vo.getParentId());
                if (parentGardenArea == null)
                    throw new BizException("父级区域不存在");
                if (parentGardenArea.getParentId() != 0 && parentGardenArea.getEnterpriseId() != null)
                    throw new BizException("父级区域已绑定企业，不能再增加区域");
                GardenArea gardenArea = new GardenArea();
                vo.toEntity(gardenArea);
                Long id = IdWorker.getId();
                gardenArea.setIdPath(parentGardenArea.getIdPath() + "-" + id);
                gardenArea.setLevel(gardenArea.getIdPath().split("-").length);
                gardenArea.setId(id);
                baseMapper.insert(gardenArea);
                return gardenArea;
            } else {
                GardenArea gardenArea = new GardenArea();
                vo.toEntity(gardenArea);
                Long id = IdWorker.getId();
                gardenArea.setIdPath(id.toString());
                gardenArea.setLevel(gardenArea.getIdPath().split("-").length);
                gardenArea.setId(id);
                baseMapper.insert(gardenArea);
                return gardenArea;
            }
        } else {
            //修改
            GardenArea gardenArea = baseMapper.selectById(vo.getId());
            if (gardenArea == null)
                throw new BizException("查不到区域信息");
            if (vo.getEnterpriseId() != null) {
                LambdaQueryWrapper<GardenArea> query = QueryBuilder.<GardenArea>lambdaQuery()
                    .eq(GardenArea::getParentId, gardenArea.getId());
                int count = baseMapper.selectCount(query);
                if (count > 0)
                    throw new BizException("存在下级区域，不能绑定企业");
            }
            vo.toEntity(gardenArea);
            if (vo.getParentId() != null && vo.getParentId() != 0) {
                GardenArea parentGardenArea = baseMapper.selectById(vo.getParentId());
                if (parentGardenArea == null)
                    throw new BizException("查不到父级区域信息");
                gardenArea.setIdPath(parentGardenArea.getIdPath() + "-" + vo.getId());
                gardenArea.setLevel(gardenArea.getIdPath().split("-").length);
            } else {
                gardenArea.setIdPath(vo.getId().toString());
                gardenArea.setLevel(gardenArea.getIdPath().split("-").length);
            }
            baseMapper.updateById(gardenArea);
            return gardenArea;
        }
    }

    public void bindEnterprise(GardenAreaInVo vo) {
        GardenArea gardenArea = baseMapper.selectById(vo.getId());
        LambdaQueryWrapper<GardenArea> query = QueryBuilder.<GardenArea>lambdaQuery()
            .eq(GardenArea::getParentId, gardenArea.getId());
        int count = baseMapper.selectCount(query);
        if (count > 0)
            throw new BizException("存在下级区域，不能绑定企业");
        vo.setEnterpriseName(vo.getEntSimpleFormVo().getName());
        EnterpriseViewVo entVo = uaacService.getEmployeeDetailByName(vo.getEnterpriseName());
        if (entVo == null)
            entVo = uaacService.simpleRegister(vo.getEntSimpleFormVo());
        if (entVo == null || entVo.getId() == null)
            throw new BizException("注册企业失败");
        if (gardenArea == null)
            throw new BizException("查不到区域信息");
        LambdaQueryWrapper<GardenArea> queryWrapper = QueryBuilder.<GardenArea>lambdaQuery()
            .eq(GardenArea::getParentId, 0L).eq(GardenArea::getEnterpriseId, vo.getEnterpriseId());
        int countEnt = baseMapper.selectCount(queryWrapper);
        if (countEnt > 0)
            throw new BizException("园区不能绑定到区域");
        gardenArea.setEnterpriseId(entVo.getId());
        gardenArea.setEnterpriseName(entVo.getName());
        gardenArea.setUserName(vo.getUserName());
        gardenArea.setTel(vo.getTel());
        baseMapper.updateById(gardenArea);
    }

    public void unbind(Long id){
        GardenArea gardenArea = baseMapper.selectById(id);
        if(gardenArea==null)
            throw new BizException("园区不存在");
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",CurrentUser.getCurrent().getName());
//        map.put("username","1");
        baseMapper.delEnt(map);
    }

    public List<GardenAreaOutVo> getAreaList(GardenAreaInVo vo) {
        LambdaQueryWrapper<GardenArea> query = QueryBuilder.<GardenArea>lambdaQuery()
            .eq(GardenArea::getEnterpriseId, vo.getEnterpriseId());
        List<GardenArea> gardenAreaList = baseMapper.selectList(query);
        if (gardenAreaList.size() > 1)
            throw new BizException("企业数据异常");
        if (gardenAreaList.size() == 0)
            return new ArrayList<>();
        GardenArea gardenArea = gardenAreaList.get(0);
        LambdaQueryWrapper<GardenArea> queryChild = QueryBuilder.<GardenArea>lambdaQuery()
            .like(GardenArea::getIdPath, gardenArea.getId());
        if (vo.getSearchKey() != null && !vo.getSearchKey().equals("")) {
            queryChild.and(wapper -> wapper.like(GardenArea::getName, vo.getSearchKey()).or().like(GardenArea::getEnterpriseName, vo.getSearchKey()));
        }
        queryChild.orderByAsc(GardenArea::getLevel);

        List<GardenArea> gardenAreaChildList = baseMapper.selectList(queryChild);
        return recursiveGardenArea(gardenAreaChildList);
    }

    public IPage<GardenAreaOutVo> getPage(GardenAreaInVo vo) {
        LambdaQueryWrapper<GardenArea> query = QueryBuilder.<GardenArea>lambdaQuery()
            .eq(GardenArea::getEnterpriseId, vo.getEnterpriseId())
            .eq(GardenArea::getParentId, 0);
        List<GardenArea> gardenAreaList = baseMapper.selectList(query);
        if (gardenAreaList.size() > 0) {
            vo.setId(gardenAreaList.get(0).getId());
            vo.setEnterpriseId(null);
        }
        Page<GardenArea> page = new Page<>(vo.getCurrent(), vo.getSize());
        return baseMapper.getPage(page, vo);
    }

    /**
     * 获取园区下所有可以绑定企业的园区列表 供下拉框使用
     *
     * @param id
     * @return
     */
    public List<GardenAreaOutVo> getList(Long id) {
        return baseMapper.getList(id);
    }

    /**
     * 通过园区id获取企业信息
     *
     * @param id
     * @return
     */
    public GardenAreaOutVo getDetailEnt(Long id) {
        GardenArea gardenArea = baseMapper.selectById(id);
        if (gardenArea == null)
            throw new BizException("查不到区域信息");
        if (gardenArea.getEnterpriseId() == null)
            throw new BizException("查询不到企业信息");
        GardenAreaOutVo outVo = new GardenAreaOutVo();
        outVo.fromEntity(gardenArea);
        EnterpriseViewVo enterpriseViewVo = uaacService.getEnterpriseDetailById(gardenArea.getEnterpriseId());
        outVo.setEnterpriseViewVo(enterpriseViewVo);
        return outVo;
    }

    @Transactional
    public GardenAreaOutVo editEnt(GardenAreaInVo vo) {
        GardenArea gardenArea = new GardenArea();
        if (vo.getNewId() != null) {
            LambdaQueryWrapper<GardenArea> query = QueryBuilder.<GardenArea>lambdaQuery()
                .eq(GardenArea::getParentId, vo.getNewId());
            int count = baseMapper.selectCount(query);
            if (count > 0)
                throw new BizException("存在下级区域，不能绑定企业");
            gardenArea= baseMapper.selectById(vo.getNewId());
            if (gardenArea == null)
                throw new BizException("区域不存在");
            if (gardenArea.getEnterpriseId() != null)
                throw new BizException("该区域已有企业");
            Map<String,Object> map = new HashMap<>();
            map.put("id",vo.getId());
            map.put("username",CurrentUser.getCurrent().getName());
            baseMapper.delEnt(map);
        } else {
            gardenArea = baseMapper.selectById(vo.getId());
        }
        gardenArea.setEnterpriseId(vo.getEntSimpleFormVo().getId());
        gardenArea.setEnterpriseName(vo.getEntSimpleFormVo().getName());
        gardenArea.setUserName(vo.getUserName());
        gardenArea.setTel(vo.getTel());
        baseMapper.updateById(gardenArea);

        EnterpriseSimpleEditVo entVo = new EnterpriseSimpleEditVo();
        entVo.setId(vo.getEntSimpleFormVo().getId());
        entVo.setManager(vo.getEntSimpleFormVo().getManager());
        entVo.setManagerPhone(vo.getEntSimpleFormVo().getManagerPhone());
        entVo.setName(vo.getEntSimpleFormVo().getName());
        entVo.setSummary(vo.getEntSimpleFormVo().getSummary());
        entVo.setVersion(vo.getEntSimpleFormVo().getVersion());
        EnterpriseViewVo enterpriseViewVo = uaacService.editSimple(entVo);
        GardenAreaOutVo outVo = new GardenAreaOutVo().fromEntity(gardenArea);
        outVo.setEnterpriseViewVo(enterpriseViewVo);
        return outVo;

    }

    public GardenAreaOutVo getDetail(Long id) {
        GardenArea gardenArea = baseMapper.selectById(id);
        if (gardenArea == null)
            throw new BizException("查不到区域信息");
        GardenAreaOutVo outVo = new GardenAreaOutVo();
        outVo.fromEntity(gardenArea);
        return outVo;
    }

    public void del(Long id) {
        GardenArea gardenArea = baseMapper.selectById(id);
        if (gardenArea == null)
            throw new BizException("查不到区域信息");
        if (gardenArea.getEnterpriseId() != null) {
            LambdaQueryWrapper<GardenArea> query = QueryBuilder.<GardenArea>lambdaQuery()
                .eq(GardenArea::getParentId, gardenArea.getId());
            int count = baseMapper.selectCount(query);
            if (count > 0)
                throw new BizException("存在下级区域，不能删除");
        }
        baseMapper.deleteById(id);
    }

    public GardenAreaOutVo getEnterpriseList(GardenAreaInVo vo) {
        CurrentUser.getCurrentNonNull("必须登录后才能操作");
        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
        if (sessionEnterprise.c2.longValue() == 0L)
            throw new BizException("查不到企业信息，请切换企业登录");
        Long enterpriseId = sessionEnterprise.c2.longValue();

        LambdaQueryWrapper<GardenArea> tempQuery = QueryBuilder.<GardenArea>lambdaQuery()
            .eq(GardenArea::getEnterpriseId, enterpriseId).eq(GardenArea::getParentId, 0);
        List<GardenArea> tempList = baseMapper.selectList(tempQuery);
        if (tempList.size() == 0)
            throw new BizException("查不到园区信息，请切换企业登录");

        LambdaQueryWrapper<GardenArea> query = QueryBuilder.<GardenArea>lambdaQuery()
            .like(GardenArea::getIdPath, tempList.get(0).getId().toString())
            .isNotNull(GardenArea::getEnterpriseId)
            .ne(GardenArea::getParentId, 0);
        if (vo.getSearchKey() != null && !vo.getSearchKey().equals("")) {
            query.like(GardenArea::getEnterpriseName, vo.getSearchKey());
        }
        query.orderByDesc(GardenArea::getCreateTime);
        List<GardenArea> gardenAreaList = baseMapper.selectList(query);
        List<GardenAreaOutVo> gardenAreaOutVoList = gardenAreaList.stream()
            .map(e -> new GardenAreaOutVo().fromEntity(e))
            .collect(Collectors.toList());
        GardenAreaOutVo outVo = new GardenAreaOutVo().fromEntity(tempList.get(0));
        outVo.setChild(gardenAreaOutVoList);
        return outVo;
    }

    public List<GardenAreaOutVo> recursiveGardenArea(List<GardenArea> gardenAreaList) {
        List<GardenAreaOutVo> voList = new ArrayList<>();
        Map<Long, GardenAreaOutVo> cache = new HashMap<>();

        for (GardenArea g : gardenAreaList) {
            GardenAreaOutVo vo = new GardenAreaOutVo().fromEntity(g);
            if (null != vo.getParentId() && cache.containsKey(vo.getParentId())) {
                GardenAreaOutVo parent = cache.get(vo.getParentId());
                if (Objects.isNull(parent.getChild())) {
                    parent.setChild(new LinkedList<>());
                }
                parent.getChild().add(vo);
            } else {
                voList.add(vo);
            }
            cache.put(vo.getId(), vo);
        }

        return voList;
    }


}
