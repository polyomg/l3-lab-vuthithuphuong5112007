package com.poly.lab8.interceptor;

import com.poly.lab8.entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Date;

@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        Account user = (Account) req.getSession().getAttribute("user");
        System.out.println(req.getRequestURI() + " | " + new Date() + " | " + user.getFullname());
        return true;
    }
}

