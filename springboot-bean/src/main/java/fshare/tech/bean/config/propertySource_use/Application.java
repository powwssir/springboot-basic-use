package fshare.tech.bean.config.propertySource_use;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: yyj
 * @create: 2024-05-07 13:03
 * @description: TODO
 */
@Slf4j
public class Application {
    public static void main(String[] args) {
        log.info("Init application context");
        // create and configure beans
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.yezi.springframework.config.propertySource_use");

        // retrieve configured instance
        MyPropertySourceConfig config = (MyPropertySourceConfig) context.getBean("myPropertySourceConfig");




        // print info from beans
        log.info(config.getName());//

        log.info("Shutdown application context");
        context.registerShutdownHook();
    }
}
