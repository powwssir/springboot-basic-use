package fshare.tech.bean.event_listener.listener;

import fshare.tech.bean.event_listener.events.EventDemo;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-05-07 10:55
 * @description: TODO
 */
/**
 * EventDemo 监听器
 */
//  将监听器装载入spring容器
@Component
public class EventDemoListener2 implements ApplicationListener<EventDemo> {
    @Override
    public void onApplicationEvent(EventDemo eventDemo) {
        Object msg = eventDemo.getSource();
        System.out.println("自定义事件监听器（MyEventListener2）收到发布的消息: " + msg);
    }
}
