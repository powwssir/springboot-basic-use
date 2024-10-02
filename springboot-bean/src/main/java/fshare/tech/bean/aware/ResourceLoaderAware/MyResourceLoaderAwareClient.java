package fshare.tech.bean.aware.ResourceLoaderAware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-29 23:45
 * @description: TODO
 */
@Component
public class MyResourceLoaderAwareClient {

    private final MyResourceLoaderAwareComponent myResourceLoaderAwareComponent;

    @Autowired
    public MyResourceLoaderAwareClient(MyResourceLoaderAwareComponent myResourceLoaderAwareComponent) {
        this.myResourceLoaderAwareComponent = myResourceLoaderAwareComponent;
    }

    // 客户端方法，用于调用加载资源的方法并打印结果
    public void printResourceContent(String location) {
        String content = myResourceLoaderAwareComponent.loadResourceContent(location);
        System.out.println("Resource content from location: " + location);
        System.out.println(content);
    }
}
