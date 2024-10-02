package fshare.tech.bean.aware.ApplicationContextAware;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yyj
 * @create: 2024-04-29 23:48
 * @description: TODO
 */

/**
 *
 */
@Configuration
@ComponentScan(basePackages = "com.yezi.springframework.aware.ApplicationContextAware") // 假设上面的类在com.example包下
public class AppConfig {
    // 这里不需要额外的bean定义，因为@Component注解已经足够
}
