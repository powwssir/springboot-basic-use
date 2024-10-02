package fshare.tech.bean.aware.BeanFactoryAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-29 23:58
 * @description: TODO
 */

/**
 * BeanFactoryAware接口允许一个bean在初始化时获得对BeanFactory的引用，这通常用于需要以编程方式访问其他bean或执行与容器相关的操作的场景。
 * 下面是一个简单的例子，演示了BeanFactoryAware接口使用
 */
@Component
public class MyBeanFactoryAwareBean implements BeanFactoryAware {

    private BeanFactory beanFactory;

    // 实现BeanFactoryAware接口的回调方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    // 一个简单的方法，用于从BeanFactory中获取bean
    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }
}