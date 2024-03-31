package com.atguigu.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 适配服务端渲染技术，前后端不分离模式
public class WelcomeController {

    /**
     * 利用模板引擎跳转到指定页面
     * @return
     */
    @GetMapping("/well")
    public String hello(@RequestParam("name") String name
            , Model model
            , HttpServletRequest request
    ) {

        // 模板的逻辑视图地址
        // 物理视图 = 前缀 + 逻辑视图名 + 后缀
        // 真实地址 = classpath:/templates/welcome.html

        // 把需要给页面共享的数据放到model中
        String text = "<span style='color:red'>"+name+"</span>";
        model.addAttribute("msg",text);

        model.addAttribute("name",name);


        // 路径是动态的
        model.addAttribute("imgUrl","/4.jpg");
        // 数据库查出的样式
        model.addAttribute("style","width: 400px");

        model.addAttribute("show",true);
        return "welcome";
    }

}
