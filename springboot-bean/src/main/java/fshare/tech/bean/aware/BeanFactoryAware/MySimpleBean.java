package fshare.tech.bean.aware.BeanFactoryAware;

import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-29 23:59
 * @description: TODO
 */
@Component
public class MySimpleBean {
    public String sayHello() {
        return "Hello from MySimpleBean!";
    }
}
