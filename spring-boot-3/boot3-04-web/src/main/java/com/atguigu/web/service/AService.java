package com.atguigu.web.service;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class AService {
    public void a() {
        // 当前请求的路径
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // 任意位置随时通过 RequestContextHolder 获取到当前请求和响应的信息
        HttpServletResponse response = attribute.getResponse();
        HttpServletRequest request = attribute.getRequest();

        String requestURI = request.getRequestURI();
    }
}
