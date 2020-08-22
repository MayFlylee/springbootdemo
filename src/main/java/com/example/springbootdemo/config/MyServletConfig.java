package com.example.springbootdemo.config;

import com.example.springbootdemo.filter.MyFilter;
import com.example.springbootdemo.listener.MyListener;
import com.example.springbootdemo.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


/*此类作为Servlet的配置类*/
@Configuration
public class MyServletConfig {

    /*定制嵌入式的Servlet容器*/
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            /*定制嵌入式Servlet容器的相关规则*/
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                //factory.setPort(8081);
            }
        };
    }

    //注册三大组件
    private final String myServlet = "/myServlet";
    private final String hello = "/hello";
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new MyServlet(),myServlet);
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList(myServlet,hello));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<MyListener>(new MyListener());
    }
}
