package fshare.tech.bean.config.propertySource_use;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: yyj
 * @create: 2024-05-07 12:55
 * @description: TODO
 */
@Configuration
@PropertySource(value = {"classpath:my-config.properties", "classpath:my-config2.properties"}, ignoreResourceNotFound = true)
//可以指定多个 ignoreResourceNotFound = true 如果没有找到就忽略
public class MyPropertySourceConfig {

    @Value("${my.properties.config.value}")//获取到my-config.properties文件中的值
    private String name;

    public String getName() {
        return name;
    }
}
