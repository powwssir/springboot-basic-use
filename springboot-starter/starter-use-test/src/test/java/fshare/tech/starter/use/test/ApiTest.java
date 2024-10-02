package fshare.tech.starter.use.test;

import fshare.tech.starter01.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: XiaoYe
 * @create: 2024-10-02 13:41
 * @description: TODO
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {
    @Resource
    fshare.tech.starter01.Client myClient1;


    @Resource
    fshare.tech.starter02.Client myClient2;

    /**
     * 基于 SpringFactoryLoader 以及 @SpringBootApplication(本质上 和 @EnableAutoConfiguration 有关) 自动配置原理实现
     */
    @Test
    public void test_starter_demo01() {
        Map<String, String> propertiesMap = myClient1.getPropertiesMap();
        propertiesMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    /**
     * 原理： 基于自定义注解（注解上使用 @import 配置） 需要 配合 @configuration 或者 @Component 注解使用
     *
     * 使用方式
     * 1、直接配置在启动类上
     * 2、配置在@configuration 或者 @Component类上
     */
    @Test
    public void test_starter_demo02() {
        Map<String, String> propertiesMap = myClient2.getPropertiesMap();
        propertiesMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
