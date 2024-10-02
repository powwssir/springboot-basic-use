package fshare.tech.bean.event_listener.listener;

import fshare.tech.bean.event_listener.events.DemoRole;
import fshare.tech.bean.event_listener.events.DemoUser;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-05-07 11:01
 * @description: 监听类
 */
/**
 * DemoUser DemoRole 监听器
 */
@Component
//@Service
public class EventDemoListenerMultiple {

    @Async
    @EventListener(DemoUser.class)
    public void listenerDemoUser(DemoUser demoUser) {
        String name = demoUser.getUsername();
        System.out.println("listenerDemoUser---"+name);
    }

    @Async
    @EventListener(DemoRole.class)
    public void listenerDemoUser(DemoRole demoRole) {
        String name = demoRole.getRoleName();
        System.out.println("listenerDemoUser---"+name);
    }

}