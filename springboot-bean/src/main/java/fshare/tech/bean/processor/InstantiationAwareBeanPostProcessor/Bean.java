package fshare.tech.bean.processor.InstantiationAwareBeanPostProcessor;

import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-30 11:36
 * @description: TODO
 */
@Component
public class Bean {

    public Bean() {

    }

    public Bean(String name) {
        System.out.println("构造函数被调用啦");
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                '}';
    }
}