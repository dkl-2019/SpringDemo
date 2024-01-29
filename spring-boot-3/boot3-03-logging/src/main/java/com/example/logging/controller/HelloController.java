package com.example.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping ("/h")
    public String hello(String a, String b) {

        log.trace("trace日志....");
        log.debug("debug日志....");
        // SpringBoot底层默认的日志级别是info
        log.info("info日志.... 参数a:{} b:{}", a,b);
        log.warn("warn日志....");
        log.error("error日志....");

        return "hello";
    }

}
