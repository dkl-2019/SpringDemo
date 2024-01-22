package com.atguigu.boot;

import com.atguigu.boot.bean.Cat;
import com.atguigu.boot.bean.Dog;
import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages = "com.atguigu") // 自定义指定扫描路径
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu")
public class Boot302DemoApplication {

    public static void main(String[] args) {

        // Java10：局部变量类型的自动推断
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        // 1、获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        // 2、遍历查看
        // SpringBoot   把以前配置的核心组件现在都自动配好了
//        for (String name:
//             names) {
//            System.out.println(name);
//        }

//        for (String s : ioc.getBeanNamesForType(User.class)) {
//            System.out.println(s);
//        }
//
//        Object userhaha1 = ioc.getBean("userhaha");
//        Object userhaha2 = ioc.getBean("userhaha");
//        System.out.println(userhaha1 == userhaha2);

//        for (String s : ioc.getBeanNamesForType(Cat.class)) {
//            System.out.println("cat: " + s);
//        }
//        for (String s : ioc.getBeanNamesForType(Dog.class)) {
//            System.out.println("dog: " + s);
//        }
//
//        for (String s : ioc.getBeanNamesForType(User.class)) {
//            System.out.println("user: " + s);
//        }

        Pig pig = ioc.getBean(Pig.class);
        System.out.println("pig: " + pig);
    }

}
