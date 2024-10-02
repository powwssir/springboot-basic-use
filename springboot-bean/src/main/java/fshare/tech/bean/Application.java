package fshare.tech.bean;

import fshare.tech.bean.factory.mybatisdemo.IUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: yyj
 * @create: 2024-04-21 22:33
 * @description: TODO
 */
@Slf4j
public class Application {
    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        log.info("Init application context");
        // create and configure beans
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.yezi.springframework");

        // retrieve configured instance
        User user = (User) context.getBean("user");

        // mybatis接口代理实现
        // 相关代码见 com.yezi.springframework.factory.mybatisdemo
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        System.out.println(userDao.queryUserInfo());//你被代理了 queryUserInfo



        // print info from beans
        log.info(user.toString());

        log.info("Shutdown application context");
        context.registerShutdownHook();
    }


}
