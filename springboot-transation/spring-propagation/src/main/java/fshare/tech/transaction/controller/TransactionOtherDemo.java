package fshare.tech.transaction.controller;

import fshare.tech.transaction.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: XiaoYe
 * @create: 2024-10-02 16:41
 * @description: 测试其他事务属性
 */
@Slf4j
@RestController
@RequestMapping("/other_test/")
public class TransactionOtherDemo {
    @Resource
    DemoService demoService;
    /**
     * 测试 @Transactional 其他属性
     */

    /**
     *
     *  <a href="http://127.0.0.1:8084/other_test/rollback1?username=小白&id=1&type=1">...</a>
     *
     *  事务回滚测试1
     *
     *  注解类型 Exception
     *  方法内异常为 Exception
     *
     *  测试结果 回滚
     *  无论 是否使用 try catch 捕获异常，都会回滚
     */
    @RequestMapping(value = "rollback1", method = RequestMethod.GET)
    public void test_rollbackFor1(@RequestParam String username, @RequestParam Integer id, @RequestParam Integer type) throws Exception {
        if (type == 1) {
            try {
                demoService.rollback1(username, id);
            } catch (Exception e) {
                log.error("rollback1 error");
            }
        } else {
            demoService.rollback1(username, id);
        }

    }

    /**
     *  事务回滚测试2
     *
     *  注解类型 RuntimeException
     * 方法内异常为 Exception
     */
    @RequestMapping(value = "rollback2", method = RequestMethod.GET)
    public void test_rollbackFor2(@RequestParam String username, @RequestParam Integer id, @RequestParam Integer type) throws Exception {
        if (type == 1) {
            try {
                demoService.rollback2(username, id);
            } catch (Exception e) {
                log.error("rollback2error");
            }
        } else {
            demoService.rollback2(username, id);
        }

    }

    /**
     * <a href="http://127.0.0.1:8084/other_test/rollback2?username=小夏&id=1&type=1</a>">...</a>
     *
     *   注解类型 Exception
     *  方法内异常为 RuntimeException
     *
     *  测试结果
     *  1、使用 try catch 捕获异常，不抛出异常，回滚
     *  2、不使用 try catch 捕获异常，抛出异常，不回滚
     */
    @RequestMapping(value = "norollback1", method = RequestMethod.GET)
    public void test_noRollbackFor1(@RequestParam String username, @RequestParam Integer id, @RequestParam Integer type) {
        if (type == 1) {
            try {
                demoService.noRollback1(username, id);
            } catch (Exception e) {
                log.error("rollback2 error");
            }
        } else {
            demoService.noRollback1(username, id);
        }
    }

    /**
     *
     *  注解类型 RuntimeException
     *  方法内异常为 RuntimeException
     */
    @RequestMapping(value = "norollback2", method = RequestMethod.GET)
    public void test_noRollbackFor2(@RequestParam String username, @RequestParam Integer id, @RequestParam Integer type) {
        if (type == 1) {
            try {
                demoService.noRollback2(username, id);
            } catch (Exception e) {
                log.error("rollback2 error");
            }
        } else {
            demoService.noRollback2(username, id);
        }
    }
}
