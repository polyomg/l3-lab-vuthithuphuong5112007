package com.poly.lab8.config;

import com.poly.lab8.interceptor.AuthInterceptor;
import com.poly.lab8.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor auth;
    @Autowired
    LogInterceptor log;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auth)
                .addPathPatterns("/admin/**", "/account/change-password", "/account/edit-profile", "/order/**")
                .excludePathPatterns("/admin/home/index");

        registry.addInterceptor(log)
                .addPathPatterns("/admin/**", "/account/**", "/order/**");
    }
}
