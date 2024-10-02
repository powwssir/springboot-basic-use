package fshare.tech.bean.factory.mybatisdemo;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: yyj
 * @create: 2024-04-25 15:10
 * @description: TODO
 */

/**
 * 参考
 * https://bugstack.cn/md/java/interview/2021-03-30-%E9%9D%A2%E7%BB%8F%E6%89%8B%E5%86%8C%20%C2%B7%20%E7%AC%AC28%E7%AF%87%E3%80%8A%E4%BD%A0%E8%AF%B4%EF%BC%8C%E6%80%8E%E4%B9%88%E6%8A%8ABean%E5%A1%9E%E5%88%B0Spring%E5%AE%B9%E5%99%A8%E3%80%8B.html
 */
public class ProxyBeanFactory implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class[] classes = {IUserDao.class};
        InvocationHandler handler = (proxy, method, args) -> "你被代理了 " + method.getName();
        return Proxy.newProxyInstance(classLoader, classes, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

}
