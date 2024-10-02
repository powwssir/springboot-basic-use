package fshare.tech.starter.use;

import fshare.tech.starter02.annotation.EnableOpenClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: yyj
 * @create: 2024-04-19 18:50
 * @description: TODO
 */

@SpringBootApplication
@EnableOpenClient
public class MyStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStarterApplication.class);
    }

}
