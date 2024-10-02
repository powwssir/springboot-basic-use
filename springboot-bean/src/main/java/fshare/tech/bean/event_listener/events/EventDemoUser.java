package fshare.tech.bean.event_listener.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author: yyj
 * @create: 2024-05-07 10:50
 * @description: TODO
 */
public class EventDemoUser extends ApplicationEvent {

    private final DemoUser demoUser;

    public EventDemoUser(Object source, DemoUser demoUser) {
        super(source);
        this.demoUser = demoUser;
    }

    public DemoUser getDemoUser() {
        return demoUser;
    }
}