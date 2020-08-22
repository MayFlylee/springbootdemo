package com.example.springbootdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    /*SpringBoot可以使用PostMapping直接设置post方法
     * */
    //@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Map<String, Object> map,
            /*添加session，只要用户登陆就会在session中存在*/
            HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
           /* 表示登陆成功，*/
            session.setAttribute("loginUser", username);
            //为了防止表单重复提交，可以重定向到主页
            return "redirect:/main";//return "dashboard"
        } else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
