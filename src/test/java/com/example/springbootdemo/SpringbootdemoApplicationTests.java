package com.example.springbootdemo;

import com.example.springbootdemo.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/*
 * 可以在测试期间进行类似编码一样的自动注入
 * */
@SpringBootTest
class SpringbootdemoApplicationTests {
    @Autowired
    Person person;

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        /*日志的级别由高到低*/
        logger.trace("这是trace日志");
        logger.debug("debug log");
        //SpringBoot默认只会输出info以后的信息，
        /*没有指定的级别就用Spring Boot默认规定的级别*/
        logger.info("info log");
        logger.warn("warn log");
        logger.error("这是error日志");
    }

    /*获取Spring版本*/
    @Test
    public void callVersion() {
        System.out.println(SpringVersion.getVersion());
    }

    /*o获取数据源*/
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoad() throws SQLException {
        //测试数据源获取的链接
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
