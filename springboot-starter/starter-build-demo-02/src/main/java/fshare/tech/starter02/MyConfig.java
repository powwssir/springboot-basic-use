package fshare.tech.starter02;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yyj
 * @create: 2024-04-19 18:39
 * @description: TODO
 */
@Configuration
@EnableConfigurationProperties(MyConfigProperties.class)
public class MyConfig {
    /**
     * 获取配置文件信息并创建客户端对象
     */
    @Bean("myClient2")
    public Client getPropertiesMap(MyConfigProperties configProperties) {

        Map<String, String> propertiesMap = new HashMap<>(4);
        propertiesMap.put("username", configProperties.getUsername());
        propertiesMap.put("password", configProperties.getPassword());
        propertiesMap.put("ip", configProperties.getIp());
        propertiesMap.put("port", configProperties.getPort());

        return new Client(propertiesMap);
    }
}
