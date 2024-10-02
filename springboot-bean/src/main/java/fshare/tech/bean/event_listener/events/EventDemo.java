package fshare.tech.bean.event_listener.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author: yyj
 * @create: 2024-05-07 10:54
 * @description: TODO
 */
public class EventDemo extends ApplicationEvent {

    public EventDemo(Object source) {
        super(source);
    }
}