package com.bonade.visitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonade.visitor.service.VisitRecordService;

import io.swagger.annotations.Api;

/**
 * 
 * @ClassName:  VisitRecordController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: lcq 
 * @date:   2019年12月9日 下午2:27:23   
 * @version 1.0
 */
@RestController
@RequestMapping("v1/visit/approval")
@Api(value = "审批", tags = "审批接口")
public class VisitApprovalController {

    @Autowired
    private VisitRecordService visitRecordService;

    

}
