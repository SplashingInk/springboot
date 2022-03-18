package com.xtl.config;

import com.xtl.component.LoginHandlerInterceptor;
import com.xtl.component.MyLocaleResolver;
import com.xtl.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 31925
 * @Configuration
 *      标注一个配置类
 *使用WebMvcConfigurer可以来扩展SpringMVC的功能
 */
@Configuration
public class MyConfig  implements WebMvcConfigurer{


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/hello/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
    *  @Bean
     *      方法的返回值添加到容器中，该组件默认的id是方法名
    */
    @Bean
    public HelloService sayHello(){
        return new HelloService();
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
