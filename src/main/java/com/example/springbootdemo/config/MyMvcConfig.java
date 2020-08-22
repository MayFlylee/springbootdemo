package com.example.springbootdemo.config;

import com.example.springbootdemo.componet.LoginHandlerInterceptor;
import com.example.springbootdemo.componet.MyLocaleResolver;
import com.example.springbootdemo.service.HelloService;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*设置SpringMVC的配置类*/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //注册容器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test1").setViewName("success");
        /*设置模板的主页,所有的Web组件都会生效*/
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/main").setViewName("dashboard");
    }


    //注册拦截器
   @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //* 静态资源：*.css，*.js
         //SpringBoot已经做好了静态资源的映射
        // 表示拦截所有请求，excludePathPatterns表示例放行的*//*

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns(
                        "/",
                        "/index",
                        "/user/login",
                        "/webjars/**",
                        "/asserts/css/**",
                        "/asserts/img/**",
                        "/asserts/js/**",
                        "/sql/**"
                );
    }

    /*注册区域控制器*/
    /*注意方法名必须和类名一致，首字母小写*/
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }



}
