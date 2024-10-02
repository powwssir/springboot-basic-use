package fshare.tech.bean.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: yyj
 * @create: 2024-04-21 23:45
 * @description: TODO
 */
@Slf4j
@Component
public class MyFactoryBean implements FactoryBean<MyBean> {

    @Autowired
    MyBean myBean;

    @PostConstruct
    public void checkBeanIsExist() {
        if (myBean != null) {
            log.info("execute FactoryBean#checkBeanIsExist {}", true);
        } else {
            log.info("execute FactoryBean#checkBeanIsExist {}", false);
        }
    }

    // 返回实例对象
    @Override
    public MyBean getObject() throws Exception {
        MyBean myBean = new MyBean();
        myBean.setBeanName(MyBean.class.getName());
        myBean.setBeanType(MyBean.class);
        log.info("execute FactoryBean#getObject()");
        return myBean;
    }

    // 返回对象类型
    @Override
    public Class<?> getObjectType() {
        log.info("execute FactoryBean#getObjectType()");
        return MyBean.class;
    }


    // 是否是单例
    @Override
    public boolean isSingleton() {
        log.info("execute FactoryBean#isSingleton()");
        return true;
    }
}
