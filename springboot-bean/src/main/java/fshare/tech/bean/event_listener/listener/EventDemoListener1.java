package fshare.tech.bean.event_listener.listener;

import fshare.tech.bean.event_listener.events.EventDemo;
import org.springframework.context.ApplicationListener;

/**
 * @author: yyj
 * @create: 2024-05-07 10:54
 * @description: TODO
 */
/**
 * EventDemo 监听器
 */
//  手动向ApplicationContext中添加监听器  不要@Component注解就能监听到
public class EventDemoListener1 implements ApplicationListener<EventDemo> {

    @Override
    public void onApplicationEvent(EventDemo eventDemo) {
        Object msg = eventDemo.getSource();
        System.out.println("自定义事件监听器（MyEventListener1）收到发布的消息: " + msg);
    }
}