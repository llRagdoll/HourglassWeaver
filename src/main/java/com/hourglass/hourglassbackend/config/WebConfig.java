package com.hourglass.hourglassbackend.config;

import com.hourglass.hourglassbackend.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录和注册不拦截
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");
    }
}
