package com.smart.cn.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 15:58
 */
@Configuration

public class MapperConfig {

    /**
     * 配置 数据库链接
     *
     * @return
     */
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employeeadmin");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    /**
     * 配置 sqlSessionFactoryBean
     *
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
//        配置打印日志  使用  log4j
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(Log4jImpl.class);
        sqlSessionFactory.setConfiguration(configuration);

        //  配置分页插件
        sqlSessionFactory.setPlugins(new PageInterceptor());
        return sqlSessionFactory;
    }

    /**
     * 配置MapperScannerConfigurer  自动扫描并生成 mapper 代理注入到 Spring 中
     */

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.smart.cn.mapper");
        return mapperScannerConfigurer;
    }

}
