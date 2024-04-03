package com.atguigu.web.controller;


import com.atguigu.web.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    /**
     * 默认使用新版 PathPatterParser 进行路径匹配
     * 性能高
     * 不能匹配 ** 在中间的情况，剩下的和 antPathMatcher 语法兼容
     *
     * 使用默认的路径匹配规则，是由 PathPatternParser 提供的
     * 如果中间需要有 ** ，替换成 antPathMatcher 模式即可
     * @param request
     * @param path
     * @return
     */

    @GetMapping("/a*/b?/{p1:[a-f]+}/**")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path) {
        log.info("路径变量p1: {}", path);
        String uri = request.getRequestURI();
        return uri;
    }

    /**
     * 1、默认支持把对象写为json。因为默认Web场景导入了jackson处理json的包。jackson-core
     * 2、jackson也支持把数据写为xml。导入xml相关依赖
     * @return
     */
    @GetMapping("/persion")
    public Person person() {
        Person person = new Person();
        person.setId(1L);
        person.setUserName("张三");
        person.setEmail("aaa@qq.com");
        person.setAge(18);
        return person;
    }

}







