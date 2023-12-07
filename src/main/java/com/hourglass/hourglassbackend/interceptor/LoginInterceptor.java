package com.hourglass.hourglassbackend.interceptor;

import com.hourglass.hourglassbackend.entity.Result;
import com.hourglass.hourglassbackend.utils.JwtUtil;
import com.hourglass.hourglassbackend.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("Authorization");
        try{
            Map<String,Object> claims= JwtUtil.parseToken(token);
            //存到ThreadLocal
            ThreadLocalUtil.set(claims);

            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}

