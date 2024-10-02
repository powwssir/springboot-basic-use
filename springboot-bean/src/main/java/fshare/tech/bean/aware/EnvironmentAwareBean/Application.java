package fshare.tech.bean.aware.EnvironmentAwareBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: yyj
 * @create: 2024-04-29 23:41
 * @description: TODO
 */
public class Application {
    /**
     * 测试EnvironmentAware 使用
     * @param args
     */
    public static void main(String[] args) {
        // 创建 AnnotationConfigApplicationContext 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 从上下文中获取 MyEnvironmentAwareBean 实例
        MyEnvironmentAwareBean myBean = context.getBean(MyEnvironmentAwareBean.class);

        // 调用 printProperty 方法，打印系统属性 java.version
        myBean.printProperty("java.version");

        // 关闭上下文
        context.close();
    }
}
