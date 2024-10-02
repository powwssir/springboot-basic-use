package fshare.tech.starter02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: yyj
 * @create: 2024-04-19 18:30
 * @description: TODO
 */

@ConfigurationProperties(prefix = "demo2.config", ignoreInvalidFields = true)
public class MyConfigProperties {

    @Value("${demo2.config.username}")
    private String username;

    @Value("${demo2.config.password}")
    private String password;
    @Value("${demo2.config.ip}")
    private String ip;

    @Value("${demo2.config.port}")
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
