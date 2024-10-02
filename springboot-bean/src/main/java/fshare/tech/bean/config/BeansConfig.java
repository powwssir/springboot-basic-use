package fshare.tech.bean.config;

import fshare.tech.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yyj
 * @create: 2024-04-21 23:04
 * @description: 通过Java配置方式初始化Bean
 */
@Slf4j
@Configuration
//@EnableConfigurationProperties({MyProperties.class})//如果不指定就为空
/**
 * @EnableConfigurationProperties注解解读：如果不指定配置类就为空
 *
 * @Target({ElementType.TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 * @Import({EnableConfigurationPropertiesRegistrar.class})
 * public @interface EnableConfigurationProperties {
 *     String VALIDATOR_BEAN_NAME = "configurationPropertiesValidator";
 *
 *     Class<?>[] value() default {};//默认没有
 * }
 */
public class BeansConfig implements InitializingBean {
    /**
     *  作用：测试 BeansConfig 进行@Bean操作的时机 是在何时发生的
     *  测试结果： @Bean操作是在afterPropertiesSet执行后
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("execute BeansConfig#afterPropertiesSet");
    }

//    @Autowired
//    private MyProperties myProperties;

    @Bean(name = "user", initMethod = "doInit", destroyMethod = "doDestroy")
    public User create() {
        log.info("execute BeansConfig#createUser");
        User user = new User();
        user.setName("pdai");
        user.setAge(18);
        return user;
    }



//    @Bean(value = "messageMap")
//    @Autowired
    public Map<String, String> getProperties(MyProperties myProperties) {
        String password = myProperties.getPassword();
        String name = myProperties.getName();
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put(name, password);
        log.info("execute BeansConfig#getProperties 获取MyProperties 属性 password {} name{} ", password, name);
        return messageMap;
    }

}
