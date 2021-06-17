package com.smart.cn.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @Author MG LV
 * @Date Created in 2021/6/15 16:50
 */
@Configuration
@ComponentScan(basePackages = {"com.smart.cn.service"})     // 配置包扫描
@EnableTransactionManagement    //  开启事务注解驱动  相当于  <tx:annotation-driven/>
public class ServiceConfig {

    @Autowired
    private DruidDataSource dataSource;

    /**
     * 配置事务注解驱动
     */
    @Bean
    public DataSourceTransactionManager getTransactionManager (){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
