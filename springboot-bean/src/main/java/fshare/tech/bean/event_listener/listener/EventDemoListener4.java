package fshare.tech.bean.event_listener.listener;

import fshare.tech.bean.event_listener.events.EventDemo;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-05-07 10:58
 * @description: TODO
 */
/**
 * EventDemo 监听器
 */
//  通过@EventListener注解实现事件监听(比较方便)
@Component
public class EventDemoListener4 {
    @EventListener
    public void listener(EventDemo eventDemo) {
        Object msg = eventDemo.getSource();
        System.out.println("自定义事件监听器（MyEventListener4）收到发布的消息: " + msg);
    }

}
