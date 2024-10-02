package fshare.tech.starter01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: yyj
 * @create: 2024-04-19 18:30
 * @description: TODO
 */

@ConfigurationProperties(prefix = "demo1.config", ignoreInvalidFields = true)
public class MyConfigProperties {

    @Value("${demo1.config.username}")
    private String username;

    @Value("${demo1.config.password}")
    private String password;
    @Value("${demo1.config.ip}")
    private String ip;

    @Value("${demo1.config.port}")
    private String port;

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }
    //    public void setUsername(String username){
//        this.username = username;
//    }
//
//    public void setPassword(String password){
//        this.password = password;
//    }
}
