package fshare.tech.bean.event_listener.controller;

import fshare.tech.bean.event_listener.events.DemoUser;
import fshare.tech.bean.event_listener.events.EventDemoUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: yyj
 * @create: 2024-05-07 10:51
 * @description: TODO
 */

/**
 * EventDemoUser 触发
 */
@RestController
@RequestMapping(value = "/eventDemoUser")
public class EventDemoUserController {
    /**
     * 两种触发方式 ApplicationContext  、ApplicationEventPublisher
     */

    @Resource
    private ApplicationContext applicationContext;

    /**
     * http://localhost:8091/eventDemoUser/test1
     */
    @RequestMapping(value = "/test1")
    public String test1() {
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername("admin");
        demoUser.setPassword("123456");

        applicationContext.publishEvent(new EventDemoUser(this, demoUser));
        return "testEventDemoUser";
    }

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    /**
     * http://localhost:8091/eventDemoUser/test2
     */
    @RequestMapping(value = "/test2")
    public String test2() {
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername("admin2");
        demoUser.setPassword("654321");
        applicationEventPublisher.publishEvent(new EventDemoUser(this, demoUser));
        return "testEventDemoUser";
    }
}
