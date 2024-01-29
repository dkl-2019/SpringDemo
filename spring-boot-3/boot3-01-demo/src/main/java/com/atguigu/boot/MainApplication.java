package com.atguigu.boot;

import com.atguigu.boot.controller.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // java10: 局部变量类型自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);

        // 1、获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        // 2、遍历

        for (String name :
                names) {
            System.out.println(name);
        }

        Person person = ioc.getBean(Person.class);
        System.out.println("person："+person);
        System.out.println("==== 用|表示大文本，会保留格式");
        String s = person.getChild().getText().get(2);
        System.out.println(s);
        System.out.println("==== 用>表示大文本，会压缩换行变成 空格");
        var ss = person.getChild().getText().get(3);
        System.out.println(ss);

        System.out.println("==== 用|表示大文本，会压缩换行变成 空格");
        var ss2 = person.getChild().getText().get(4);
        System.out.println(ss2);
    }
}