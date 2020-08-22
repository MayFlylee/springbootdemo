package com.example.springbootdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
@ResponseBody//表示。这个类的所有方法返回的数据直接写给浏览器，（如果是对象则转化为json数据）
*/
@Controller
/*
@RestController//替换上面的两个注解
*/
public class MyAppController {
    @ResponseBody//表示。这个类的所有方法返回的数据直接写给浏览器，（如果是对象则转化为json数据
    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, String> map) {
        map.put("hello", "Test");
        return "success";
    }

    /*//设置访问模板下的index主页
    //或者在配置类中写，推荐配置类中写
    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }*/
}
