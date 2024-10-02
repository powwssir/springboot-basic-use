package fshare.tech.bean.aware.ResourceLoaderAware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author: yyj
 * @create: 2024-04-29 23:44
 * @description: TODO
 */
// 声明这是一个Spring组件
@Component
public class MyResourceLoaderAwareComponent implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    // 实现了ResourceLoaderAware接口的setResourceLoader方法
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    // 使用ResourceLoader加载资源并返回资源内容
    public String loadResourceContent(String location) {
        Resource resource = resourceLoader.getResource(location);
        try (InputStream inputStream = resource.getInputStream();
             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {

            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load resource: " + location, e);
        }
    }
}
