package fshare.tech.bean.aware.ApplicationContextAware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: yyj
 * @create: 2024-04-29 23:49
 * @description: TODO
 */
public class Application {

    public static void main(String[] args) {
        // 创建一个Spring应用上下文
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 获取MyApplicationContextAwareBean的实例
        MyApplicationContextAwareBean contextAwareBean = context.getBean(MyApplicationContextAwareBean.class);

        // 使用MyApplicationContextAwareBean来获取MySimpleBean的实例
        MySimpleBean simpleBean = (MySimpleBean) contextAwareBean.getBean("mySimpleBean");

        // 调用MySimpleBean的方法并打印结果
        System.out.println(simpleBean.sayHello());

        // 关闭应用上下文（尽管在这个例子中不是必须的，因为main方法结束后JVM会退出）
        ((AnnotationConfigApplicationContext) context).close();
    }
}