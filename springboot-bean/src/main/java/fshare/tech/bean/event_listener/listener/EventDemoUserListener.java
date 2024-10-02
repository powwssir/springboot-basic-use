package fshare.tech.bean.event_listener.listener;

import fshare.tech.bean.event_listener.events.EventDemoUser;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-05-07 10:51
 * @description: TODO
 */

/**
 * EventDemoUser 监听器
 */
//  将监听器装载入spring容器
@Component
//@Service
public class EventDemoUserListener implements ApplicationListener<EventDemoUser> {

    @Async
    @Override
    public void onApplicationEvent(EventDemoUser eventDemoUser) {
        System.out.println("自定义事件监听器（EventDemoUserListener）收到发布的消息: " + eventDemoUser.getDemoUser().getUsername());
        System.out.println("自定义事件监听器（EventDemoUserListener）收到发布的消息: " + eventDemoUser.getDemoUser().getPassword());
    }

}