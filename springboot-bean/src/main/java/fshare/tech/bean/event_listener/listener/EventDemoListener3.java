package fshare.tech.bean.event_listener.listener;

import fshare.tech.bean.event_listener.events.EventDemo;
import org.springframework.context.ApplicationListener;

/**
 * @author: yyj
 * @create: 2024-05-07 10:57
 * @description: TODO
 */
/**
 * EventDemo 监听器
 */
//  在application.properties中配置监听器,可以不用注解
public class EventDemoListener3 implements ApplicationListener<EventDemo> {
    @Override
    public void onApplicationEvent(EventDemo eventDemo) {
        Object msg = eventDemo.getSource();
        System.out.println("自定义事件监听器（MyEventListener3）收到发布的消息: " + msg);
    }

}