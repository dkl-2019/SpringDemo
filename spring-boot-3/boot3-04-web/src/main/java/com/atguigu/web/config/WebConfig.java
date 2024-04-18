package com.atguigu.web.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 全面接管SpringMVC
@Configuration
@EnableWebMvc   // 禁用MVC的默认功能
public class WebConfig implements WebMvcConfigurer {
}
