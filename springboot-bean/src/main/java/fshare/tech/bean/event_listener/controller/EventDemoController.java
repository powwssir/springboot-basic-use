package fshare.tech.bean.event_listener.controller;

/**
 * @author: yyj
 * @create: 2024-05-07 11:18
 * @description: TODO
 */

import fshare.tech.bean.event_listener.events.DemoUser;
import fshare.tech.bean.event_listener.events.EventDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * EventDemo 触发
 */

@RestController
@RequestMapping(value = "/eventDemo")
public class EventDemoController {


    /**
     * 两种触发方式 ApplicationContext  、ApplicationEventPublisher
     */
    @Resource
    private ApplicationContext applicationContext;
    /**
     * http://localhost:8091/eventDemo/test1
     */
    @RequestMapping(value = "/test1")
    public String test1() {
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername("root");
        demoUser.setPassword("123");
        EventDemo eventDemo = new EventDemo(demoUser);
        applicationContext.publishEvent(eventDemo);
        return "testEventDemo";
    }

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    /**
     * http://localhost:8091/eventDemo/test2
     */
    @RequestMapping(value = "/test2")
    public String test2() {
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername("root");
        demoUser.setPassword("123");
        EventDemo eventDemo = new EventDemo(demoUser);
        applicationContext.publishEvent(eventDemo);
        return "testEventDemo";
    }

}
