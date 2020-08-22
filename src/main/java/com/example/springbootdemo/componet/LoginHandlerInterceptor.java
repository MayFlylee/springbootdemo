package com.example.springbootdemo.componet;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*拦截器类*/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*获取*/
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            /*未登陆拦截请求，并跳转会主页面*/
            /*转发前需要带上错误消息*/
            request.setAttribute("msg", "没有权限登陆");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        } else {
            //已经登陆放行请求
            return true;
        }
    }
}
