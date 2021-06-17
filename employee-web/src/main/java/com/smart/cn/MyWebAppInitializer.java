package com.smart.cn;

import com.smart.cn.config.MapperConfig;
import com.smart.cn.config.ServiceConfig;
import com.smart.cn.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 17:07
 */

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 加载父容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MapperConfig.class, ServiceConfig.class};
    }

    /**
     * 加载子容器
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 加载 DispatcherServlet  拦截
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
