package fshare.tech.bean.aware.EnvironmentAwareBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yyj
 * @create: 2024-04-29 23:42
 * @description: TODO
 */
@Configuration
public class AppConfig {

    // 声明 MyEnvironmentAwareBean 为一个 bean
    @Bean
    public MyEnvironmentAwareBean myEnvironmentAwareBean() {
        return new MyEnvironmentAwareBean();
    }
}
