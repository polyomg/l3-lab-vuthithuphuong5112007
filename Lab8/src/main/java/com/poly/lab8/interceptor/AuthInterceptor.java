package com.poly.lab8.interceptor;

import com.poly.lab8.entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String uri = req.getRequestURI();
        session.setAttribute("securityUri", uri);
        Account user = (Account) session.getAttribute("user");

        if (user == null) { // chưa đăng nhập
            res.sendRedirect("/auth/login");
            return false;
        }

        if(uri.startsWith("/admin") && !"ADMIN".equalsIgnoreCase(user.getRole())) {
            res.sendRedirect("/auth/login");
            return false;
        }
        return true;
    }
}
