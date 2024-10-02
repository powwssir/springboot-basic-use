package fshare.tech.bean.event_listener;

import fshare.tech.bean.event_listener.listener.EventDemoListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author: yyj
 * @create: 2024-05-07 10:54
 * @description: TODO
 */
@SpringBootApplication
@EnableAsync
public class AppEventApplication {
    /**
     * SpringBoot使用自定义事件监听器的demo_springboot 事件监听demo-CSDN博客
     * https://blog.csdn.net/myyhtw/article/details/131864725
     *
     */

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppEventApplication.class, args);

        // 手动向ApplicationContext中添加监听器
        context.addApplicationListener(new EventDemoListener1());
        System.out.println("Hello World!");
    }

    //  事件监听，自定义事件和自定义监听器类
    //  自定义事件：继承自ApplicationEvent抽象类，定义自己的构造器
    //  自定义监听：实现ApplicationListener接口，实现onApplicationEvent方法


}
