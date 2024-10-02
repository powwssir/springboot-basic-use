package fshare.tech.bean.aware.ApplicationContextAware;

import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-29 23:48
 * @description: TODO
 */

/**
 * 创建一个简单的bean，稍后将通过MyApplicationContextAwareBean来获取它
 */
@Component
public class MySimpleBean {
    public String sayHello() {
        return "Hello from MySimpleBean!";
    }
}

