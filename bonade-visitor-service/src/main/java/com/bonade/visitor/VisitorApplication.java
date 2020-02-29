package com.bonade.visitor;

import org.mybatis.spring.annotation.MapperScan;
import org.spin.common.feign.EnableSpinFeignClients;
import org.spin.job.starter.annotation.EnableJobExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * 访客管理服务启动类
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2019/11/5</p>
 *
 * @author xuweinan
 * @version 1.0
 */
@EnableCaching
@EnableDiscoveryClient
@EnableApolloConfig
@MapperScan({"com.bonade.visitor.mapper"})
@EnableJobExecutor
@EnableTransactionManagement(proxyTargetClass = true)
@EnableSpinFeignClients
@SpringBootApplication
public class VisitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisitorApplication.class, args);
    }
}
