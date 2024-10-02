package fshare.tech.bean.aware.ApplicationContextAware;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-29 23:47
 * @description: TODO
 */

/**
 * ApplicationContextAware接口允许一个bean在初始化时获得对ApplicationContext的引用，
 * 通常用于需要以编程方式访问其他bean或执行与Spring应用上下文相关的操作的场景
 */
@Component
@SpringBootApplication
public class MyApplicationContextAwareBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    // 实现ApplicationContextAware接口的回调方法
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // 一个简单的方法，用于从ApplicationContext中获取bean
    public Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}