package fshare.tech.bean.processor.InstantiationAwareBeanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: yyj
 * @create: 2024-04-21 22:33
 * @description: TODO
 */
@Slf4j
public class Application {
    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        log.info("Init application context");
        // create and configure beans
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.yezi.springframework.processor.InstantiationAwareBeanPostProcessor");

        // retrieve configured instance
        Bean bean = (Bean) context.getBean("bean");
        System.out.println(bean);

        log.info("Shutdown application context");
        context.registerShutdownHook();
    }


}
