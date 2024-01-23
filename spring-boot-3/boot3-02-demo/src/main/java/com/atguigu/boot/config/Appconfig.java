package com.atguigu.boot.config;

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.Sheep;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;


@EnableConfigurationProperties(Sheep.class) // 1.开启Sheep组件的属性绑定  2.默认会把这个组件放在容器中
// 导入第三方写好的组件进行绑定，SpringBoot默认只扫描自己主程序所在的包，如果导入第三方包，即使组件上标注了@Component、@ConfigurationProperties
// 也没有用，因为组件都扫描不进来

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
