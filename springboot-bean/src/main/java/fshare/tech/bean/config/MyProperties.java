package fshare.tech.bean.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: yyj
 * @create: 2024-04-21 23:23
 * @description: TODO
 */

/**
 * 使用注意事项 https://mp.weixin.qq.com/s/zkDj73GVtE4oBaK2ucHfLw
 *
 */
@Slf4j
//@ConfigurationProperties(prefix = "my.config",ignoreInvalidFields = true)

public class MyProperties {

    @Value("${my.config.name}")
    private String name;

    @Value("${my.config.password}")
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
