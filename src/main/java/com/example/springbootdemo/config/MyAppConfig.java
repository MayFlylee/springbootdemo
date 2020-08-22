package com.example.springbootdemo.config;



import com.example.springbootdemo.componet.MyLocaleResolver;
import com.example.springbootdemo.service.HelloService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


/*这个配置类就相当于SSM中bean配置文件，相当于Spring框架的xml文件*/
@Configuration
public class MyAppConfig {
    /*将方法的返回值添加到容器中，容器中的这个组件默认的id就是方法名*/
    /*@Bean的作用相当于把方法加载到容器中*/
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
