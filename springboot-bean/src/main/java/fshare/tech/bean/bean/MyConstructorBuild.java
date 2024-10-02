package fshare.tech.bean.bean;

/**
 * @author: yyj
 * @create: 2024-04-22 00:04
 * @description: TODO
 */

import fshare.tech.bean.config.MyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * springboot注解方式，@Autowire和有参构造和无参构造使用哪个创建对象_有参无参注解-CSDN博客 https://blog.csdn.net/H_Q_Li/article/details/127693120
 *
 * @Autowire：可以使用在构造器、方法、参数、字段、注解类型上
 * @Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented public @interface Autowired {
 * boolean required() default true;
 * }
 */
@Slf4j
//@Component
//@Lazy
public class MyConstructorBuild {

    private String name;

    private String password;


    public MyConstructorBuild() {
        log.info("execute MyConstructorBuild#MyConstructorBuild()无参构造");
    }

    //    @PostConstruct
    public void init() {

    }


    /**
     * 有参构造用法一 配合@Value注解 配置文件中的信息传入有参构造
     * 注意事项
     * 1、 @Autowired // 如果存在无参构造 需要加上该注解用于识别有参构造 否则默认会使用无参构造
     * 2、当存在多个有参构造时 会发生冲突 只能够使用一个
     *
     * @param name
     * @param password
     */
//    @Autowired // 加上该注解会识别有参构造 而不会使用无参构造
    public MyConstructorBuild(@Value("${my.config.name}") String name, @Value("${my.config.password}") String password) {
        log.info("execute MyConstructorBuild#MyConstructorBuild(String name, String password)有参构造");
        this.name = name;
        this.password = password;
    }

    /**
     * 有参构造用法二 配合@Autowired将容器已经加载对象进行注入
     * 注意事项
     * 1 对于使用这种方式可能会存在注入问题（比如说MyProperties在MyConstructorBuild之后才被注入）
     * 2 如果容器中存在多个
     *
     * @param myProperties
     */
//    @Autowired // 加上该注解会识别有参构造 而不会使用无参构造
    public MyConstructorBuild(MyProperties myProperties) {
        log.info("execute MyConstructorBuild#MyConstructorBuild(MyProperties myProperties)有参构造");
        this.name = myProperties.getName();
        this.password = myProperties.getPassword();
    }

    /**
     * 有参构造用法三 使用配置类注入（推荐） 案例 见BeansConfig类
     * 这种会当bean都被创建才配置 如果创建bean使用到容器中注入的bean 不会出现加载顺序问题
     */

}
