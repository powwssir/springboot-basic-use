package fshare.tech.starter02.annotation;

import fshare.tech.starter02.MyConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 用于导入自动配置类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyConfig.class)
@Inherited
public @interface EnableOpenClient {
}
