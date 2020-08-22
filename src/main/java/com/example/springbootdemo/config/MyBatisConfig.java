package com.example.springbootdemo.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;


@org.springframework.context.annotation.Configuration
public class MyBatisConfig {
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                /*开启驼峰命名法*/
                configuration.setMapUnderscoreToCamelCase(true);

            }
        };
    }
}
