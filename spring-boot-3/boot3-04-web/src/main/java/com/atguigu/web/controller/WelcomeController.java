package com.atguigu.web.controller;

import com.atguigu.web.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

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
        model.addAttribute("imgUrl","/6.jpg");
        // 数据库查出的样式
        model.addAttribute("style","width: 400px");

        model.addAttribute("show",true);
        return "welcome";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Person> list = Arrays.asList(
                    new Person(1L, "王卓", "", 28, "pm"),
                    new Person(3L, "王昊宇", "zs2@qq.com", 66, "pm"),
                    new Person(4L, "张三3", "zs3@qq.com", 17, "pm"),
                    new Person(7L, "张三4", "zs4@qq.com", 15, "admin"),
                    new Person(8L, "张三5", "zs5@qq.com", 19, "hr")
        );

        // 将list数据共享给页面
        model.addAttribute("persons", list);

        return "list";
    }

}
