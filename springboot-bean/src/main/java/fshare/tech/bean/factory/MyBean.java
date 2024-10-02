package fshare.tech.bean.factory;

/**
 * @author: yyj
 * @create: 2024-04-22 22:46
 * @description: TODO
 */
public class MyBean<T> {
    private String beanName;

    private Class<T> beanType;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setBeanType(Class<T> beanType) {
        this.beanType = beanType;
    }

    public String getBeanName() {
        return beanName;
    }

    public Class<T> getBeanType() {
        return beanType;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "beanName='" + beanName + '\'' +
                ", beanType='" + beanType + '\'' +
                '}';
    }
}
