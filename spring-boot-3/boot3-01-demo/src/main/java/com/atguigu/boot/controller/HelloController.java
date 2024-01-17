package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController // 合成注解
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "Hello,Spring Boot 3!";
    }



}
