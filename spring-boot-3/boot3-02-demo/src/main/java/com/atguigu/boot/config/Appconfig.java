package com.atguigu.boot.config;

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Import(FastsqlException.class) // 给容器中放指定类型的组件，组件的名字默认是全类名
@SpringBootConfiguration  // 和Configuration注解一样
//@Configuration  // 这是一个配置类，替代以前的配置文件
public class Appconfig {

    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig(){
        return new Pig(); //我们自己new新pig
    }

    /**
     *  1. 组件默认是单实例
     * @return
     */
    @Scope("prototype") // 调整组件范围，是单实例或者多实例
    @Bean("userhaha") // 替代以前的Bean标签。组件在容器中的名字默认就是方法名，也可以直接修改注解
    public User user() {
        var user = new User();
        user.setId(1L);
        user.setName("张三");
        return user;
    }

//    @Bean
//    public FastsqlException fastsqlException() {
//
//        return new FastsqlException();
//    }

}
