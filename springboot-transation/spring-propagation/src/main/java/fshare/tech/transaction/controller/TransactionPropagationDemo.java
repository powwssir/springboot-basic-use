package fshare.tech.transaction.controller;

import fshare.tech.transaction.service.DemoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: XiaoYe
 * @create: 2024-10-02 16:07
 * @description: TODO
 */
@RestController
@RequestMapping("/propagation_test/")
public class TransactionPropagationDemo {
    /**
     * 包括两种使用方式 编程式事务 以及 声明式事务
     */
    @Resource
    TransactionTemplate transactionTemplate;

    @Resource
    DemoService demoService;

    /**
     * 声明式事务使用
     */
    /**
     * <a href="http://127.0.0.1:8084/propagation_test/test1">...</a>
     *
     * 嵌套事务测试1
     *
     * 两个都是 REQUIRED
     *
     */
    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public void test1() {
        demoService.propagationRequired1();
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public void test2() {
        demoService.propagationRequiredNew1();
    }
    @RequestMapping(value = "test3", method = RequestMethod.GET)
    public void test3() {
        demoService.propagationNested1();
    }
}
