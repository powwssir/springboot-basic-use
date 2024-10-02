package fshare.tech.bean.aware.BeanFactoryAware;

/**
 * @author: yyj
 * @create: 2024-04-29 23:59
 * @description: TODO
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApp {

    public static void main(String[] args) {
        // 创建一个Spring应用上下文
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 获取MyBeanFactoryAwareBean的实例
        MyBeanFactoryAwareBean beanFactoryAwareBean = context.getBean(MyBeanFactoryAwareBean.class);

        // 使用MyBeanFactoryAwareBean来获取MySimpleBean的实例
        MySimpleBean simpleBean = (MySimpleBean) beanFactoryAwareBean.getBean("mySimpleBean");

        // 调用MySimpleBean的方法并打印结果
        System.out.println(simpleBean.sayHello());

        // 关闭应用上下文
        ((AnnotationConfigApplicationContext) context).close();
    }
}