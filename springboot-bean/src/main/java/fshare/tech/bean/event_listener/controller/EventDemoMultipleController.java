package fshare.tech.bean.event_listener.controller;

import fshare.tech.bean.event_listener.events.DemoRole;
import fshare.tech.bean.event_listener.events.DemoUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: yyj
 * @create: 2024-05-07 11:02
 * @description: 监听器触发类
 */

/**
 * DemoUser 、 DemoRole 事件触发
 */
@RestController
@RequestMapping(value="/multipleDemo")
public class EventDemoMultipleController {
    /**
     * 两种触发方式 ApplicationContext  、ApplicationEventPublisher
     */

    @Resource
    private ApplicationContext applicationContext;

    /**
     * http://localhost:8091/multipleDemo/demoUser
     */
    @RequestMapping(value="/demoUser")
    public String demoUser() {
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername("admin");
        demoUser.setPassword("123456");

        applicationContext.publishEvent(demoUser);
        return "testDemoUser";
    }

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    /**
     * http://localhost:8091/multipleDemo/demoRole
     */
    @RequestMapping(value="/demoRole")
    public String demoRole() {
        DemoRole demoRole = new DemoRole();
        demoRole.setRoleId(4);
        demoRole.setRoleName("角色");
        applicationEventPublisher.publishEvent(demoRole);
        return "testDemoRole";
    }

}