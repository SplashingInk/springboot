package com.xtl.config;

import com.xtl.filter.MyFilter;
import com.xtl.listener.MyListener;
import com.xtl.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;

/**
 * @author 31925
 */
@Configuration
public class MyServerConfig {

    /**
     * 注册三大组件
     */
    @Bean
    public ServletRegistrationBean<Servlet> myServlet(){
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> myFilter(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/watcher","/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener(){
        return new ServletListenerRegistrationBean<>(new MyListener());
    }

}
