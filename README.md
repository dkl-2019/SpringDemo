## 常见注解

SpringBoot摒弃xml配置方式，改为全注解驱动，

**@Configuration**、**@SpringBootConfiguration**		摒弃xml配置文件，直接采用配置类的形式进行全注解开发

**@Bean**、**@Scope**		对比spring中xml文件中的bean标签，scope属性标名单实例或者多实例

**@Controller、 @Service、@Repository、@Component**		这四个和spring中的一样，定义bean对象

**@Import** 	导入第三方组件

@ComponentScan		在spring中需要在xml配置文件中提前写好扫描方式，类似于： 

<context:component-scan base-package="com.atguigu.spring6"><</context:component-scan>>



### <font color=orange>组件注册步骤</font>

1. 编写一个配置类，采用**@Configuration** ，代替以前的配置文件
2. 在配置类当中，自定义方法给容器中注册组件，配合**@Bean**

3. 或者采用**@Import** 导入第三方组件



---

### <font color=orange>条件注解</font>

如果注解指定的条件成立，则触发指定行为。	形如：@ConditionalOnXxx

**@ConditionalOnClass：如果类路径中存在这个类，则触发指定行为**

**@ConditionalOnMissingClass：如果类路径中不存在这个类，则触发指定行为**

**@ConditionalOnBean：如果容器中存在这个Bean（组件），则触发指定行为**

**@ConditionalOnMissingBean：如果容器中不存在这个Bean（组件），则触发指定行为**

---

### <font color=orange>**属性绑定**</font>

将容器中的任意组件（Bean）的属性值和配置文件的配置项的值进行绑定

* 1、给容器中注册组件（@Component、@Bean）
* 2、使用 **@ConfigurationProperties** 声明组件和配置文件的哪些配置项进行绑定

如果我们在使用@ConfigurationProperties的时候并没有把组件放入到容器中，没有注册，也可以使用**@EnableConfigurationProperties**注解进行绑定，它的作用如下：

* 1、开启组件的属性绑定
* 2、默认会把这个组件自己放入到容器中

总结：

* @ConfigurationProperties： 声明组件的属性和配置文件哪些前缀开始项进行绑定

* @EnableConfigurationProperties：快速注册注解，常用于第三方组件的注册绑定，因为第三方包导入后无法标注@Component等注解进行注册，即使标注了注册注解，springboot默认也只扫描主程序下的包，扫描不到的。



