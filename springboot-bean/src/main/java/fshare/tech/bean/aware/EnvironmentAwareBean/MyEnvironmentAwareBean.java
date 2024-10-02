package fshare.tech.bean.aware.EnvironmentAwareBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-29 23:25
 * @description: TODO
 */

/**
 * EnvironmentAware 可以从环境配置中获取资源 比如配置文件信息
 */
@Slf4j
@Component//可以直接注入 或者使用配置类 bean 注解注入
public class MyEnvironmentAwareBean implements EnvironmentAware {

    Environment environment;

    // 实现 EnvironmentAware 接口的 setEnvironment 方法
    @Override
    public void setEnvironment(Environment environment) {
        String prefix = "my.config.";

        String name = environment.getProperty(prefix + "name");
        String password = environment.getProperty(prefix + "password");
        log.info("MyPropertiesConfig setEnvironment 获取 my.config name {} password {}", name, password);
        this.environment = environment;
    }


    // 一个简单的方法，用于输出某个属性的值
    public void printProperty(String propertyName) {
        String propertyValue = environment.getProperty(propertyName);
        System.out.println("Property '" + propertyName + "' = " + propertyValue);
    }

}
