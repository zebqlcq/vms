package com.bonade.visitor.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonade.visitor.domain.entity.GateSentry;
import com.bonade.visitor.domain.remote.*;
import com.bonade.visitor.domain.vo.GateSentryInVo;
import com.bonade.visitor.domain.vo.GateSentryOutVo;
import com.bonade.visitor.mapper.GateSentryMapper;
import com.bonade.visitor.mapper.RoleMapper;
import com.bonade.visitor.service.remote.UaacService;
import org.spin.common.throwable.BizException;
import org.spin.common.util.QueryBuilder;
import org.spin.common.vo.CurrentUser;
import org.spin.core.Assert;
import org.spin.core.collection.Pair;
import org.spin.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class GateSentryService extends ServiceImpl<GateSentryMapper, GateSentry> {

    @Autowired
    private GardenAreaService gardenAreaService;

    @Autowired
    private UaacService uaacService;

    @Autowired
    private RoleMapper roleMapper;

    public void addOrUpdate(GateSentryInVo vo) {
        if (vo.getFaceImgTime() == null)
            vo.setFaceImgTime(LocalDateTime.now());
        if (vo.getCardNoNegativeTime() == null)
            vo.setCardNoNegativeTime(LocalDateTime.now());
        if (vo.getCardNoPositiveTime() == null)
            vo.setCardNoPositiveTime(LocalDateTime.now());
        if (vo.getId() == null) {
            LambdaQueryWrapper<GateSentry> query = QueryBuilder.<GateSentry>lambdaQuery()
                .eq(GateSentry::getTel, vo.getTel());
            Integer count = baseMapper.selectCount(query);
            if (count > 0)
                throw new BizException("门岗人员已经存在");
            EmpFormVo empFormVo = new EmpFormVo();
            UserQueryVo queryVo = new UserQueryVo();
            queryVo.setPhone(vo.getTel());
            UserViewVo userViewVo = uaacService.userDetail(queryVo);
            if (userViewVo != null) {
                empFormVo.setUserId(userViewVo.getId());
                vo.setUserId(userViewVo.getId());
                EmpUserQueryVo empUserQueryVo = new EmpUserQueryVo();
                empUserQueryVo.setUserId(userViewVo.getId());
                empUserQueryVo.setEnterpriseId(vo.getEnterpriseId());
                EmployeeViewVo employeeViewVo = uaacService.detailByUser(empUserQueryVo);
                if (employeeViewVo == null || employeeViewVo.getId() == null) {
                    EmpViewVo empViewVo = employeeRegister(vo);
                } else {
                    vo.setEmployeeId(employeeViewVo.getId());
                }
            } else {
                EmpViewVo empViewVo = employeeRegister(vo);
                vo.setUserId(empViewVo.getUserId());
                vo.setEmployeeId(empViewVo.getId());
            }

            GateSentry gateSentry = new GateSentry();
            BeanUtils.copyTo(vo, gateSentry);
            baseMapper.insert(gateSentry);
        } else {
            LambdaQueryWrapper<GateSentry> query = QueryBuilder.<GateSentry>lambdaQuery()
                .eq(GateSentry::getTel, vo.getTel())
                .ne(GateSentry::getId, vo.getId());
            Integer count = baseMapper.selectCount(query);
            if (count > 0)
                throw new BizException("门岗人员手机号码不能重复");
            GateSentry gateSentry = baseMapper.selectById(vo.getId());
            if (gateSentry == null)
                throw new BizException("门岗人员不存在，无法修改");
            BeanUtils.copyTo(vo, gateSentry);
            baseMapper.updateById(gateSentry);
        }

    }

    public GateSentryOutVo getDetail(Long id) {
        GateSentryOutVo outVo = new GateSentryOutVo();
        GateSentry gateSentry = baseMapper.selectById(id);
        if (gateSentry == null)
            return null;
        BeanUtils.copyTo(gateSentry, outVo);
        outVo.setGardenAreaOutVo(gardenAreaService.getDetail(gateSentry.getAreaId()));
        outVo.setRole(roleMapper.selectById(gateSentry.getRoleId()));
        return outVo;
    }

    public GateSentryOutVo getDetailByUserId(Long userId){
        CurrentUser.getCurrentNonNull("必须登录后才能操作");
        Pair<Long, Long> sessionEnterprise = CurrentUser.getCurrent().getSessionEnterprise();
        Assert.notNull(sessionEnterprise, "当前企业信息不存在");
        if (sessionEnterprise.c2.longValue() == 0L)
            throw new BizException("查不到企业信息，请切换企业登录");
        Long enterpriseId = sessionEnterprise.c2.longValue();

        LambdaQueryWrapper<GateSentry> query = QueryBuilder.<GateSentry>lambdaQuery()
            .eq(GateSentry::getUserId,userId).eq(GateSentry::getEnterpriseId,enterpriseId);
        List<GateSentry> gateSentryList = baseMapper.selectList(query);
        if(gateSentryList.size()==0)
            return null;
        GateSentryOutVo outVo = new GateSentryOutVo();
        BeanUtils.copyTo(gateSentryList.get(0), outVo);
        outVo.setGardenAreaOutVo(gardenAreaService.getDetail(gateSentryList.get(0).getAreaId()));
        outVo.setRole(roleMapper.selectById(gateSentryList.get(0).getRoleId()));
        return outVo;
    }

    public GateSentryOutVo getDetail(String tel, Long enterpriseId) {
        GateSentryOutVo outVo = new GateSentryOutVo();
        LambdaQueryWrapper<GateSentry> query = QueryBuilder.<GateSentry>lambdaQuery()
            .eq(GateSentry::getTel, tel)
            .eq(GateSentry::getEnterpriseId, enterpriseId);
        List<GateSentry> gateSentryList = baseMapper.selectList(query);
        if (gateSentryList.size() == 0)
            throw new BizException("门岗人员不存在");
        BeanUtils.copyTo(gateSentryList.get(0), outVo);
        outVo.setGardenAreaOutVo(gardenAreaService.getDetail(gateSentryList.get(0).getAreaId()));
        outVo.setRole(roleMapper.selectById(gateSentryList.get(0).getRoleId()));
        return outVo;
    }

    public IPage<GateSentryOutVo> getPage(GateSentryInVo vo) {
        Page<GateSentry> page = new Page<>(vo.getCurrent(), vo.getSize());
        return baseMapper.getPage(page, vo);
    }

    public void del(Long id) {
        baseMapper.deleteById(id);
    }

    public Map statistics(Long enterpriseId) {
        Page<GateSentry> page = new Page<>(1, 10000);
        GateSentryInVo vo = new GateSentryInVo();
        vo.setEnterpriseId(enterpriseId);
        List<GateSentryOutVo> outVoList = baseMapper.getPage(page, vo).getRecords();
        Map<String, Integer> listMap = new LinkedHashMap<>();
        Integer allCount = outVoList.size();
        Integer monthCount = 0;
        for (GateSentryOutVo g : outVoList) {
            if (g.getCreateTime().isAfter(LocalDateTime.now().minusMonths(1)))
                monthCount++;
            if (listMap.get(g.getAreaName()) == null) {
                listMap.put(g.getAreaName(), 1);
            } else {
                listMap.put(g.getAreaName(), listMap.get(g.getAreaName()) + 1);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("allCount", allCount);
        map.put("monthCount", monthCount);
        map.put("listMap", listMap);
        return map;
    }

    public EmpViewVo employeeRegister(GateSentryInVo vo) {
        EmpFormVo empFormVo = new EmpFormVo();
        if (vo.getUserId() != null)
            empFormVo.setUserId(vo.getUserId());
        empFormVo.setNationality(vo.getNationality());
        empFormVo.setRealName(vo.getName());
        empFormVo.setEnterpriseId(vo.getEnterpriseId());
        empFormVo.setPhone(vo.getTel());
        empFormVo.setCertificateType(vo.getCartType());
        empFormVo.setCertificateCard(vo.getCartNo());
        empFormVo.setGender(0);
        empFormVo.setWorkStatus(WorkStatus.ON_JOB);
        empFormVo.setLicenses(new ArrayList<>());

        LicenseFormVo licenseFormVo1 = new LicenseFormVo();
        licenseFormVo1.setFileId(vo.getFaceImgId());
        licenseFormVo1.setTypeCode("FACE_INFO");
        empFormVo.getLicenses().add(licenseFormVo1);

        LicenseFormVo licenseFormVo2 = new LicenseFormVo();
        licenseFormVo2.setFileId(vo.getCardNoPositiveId());
        licenseFormVo2.setTypeCode("CERTIFICATE_POSITIVE");
        empFormVo.getLicenses().add(licenseFormVo2);

        LicenseFormVo licenseFormVo3 = new LicenseFormVo();
        licenseFormVo3.setFileId(vo.getCardNoNegativeId());
        licenseFormVo3.setTypeCode("CERTIFICATE_NEGATIVE");
        empFormVo.getLicenses().add(licenseFormVo3);

        EmpViewVo empViewVo = uaacService.employeeRegister(empFormVo);
        if (empFormVo == null)
            throw new BizException("员工创建失败，联系管理员");
        return empViewVo;
    }

}
