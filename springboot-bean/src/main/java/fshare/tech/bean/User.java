package fshare.tech.bean;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * @author: yyj
 * @create: 2024-04-21 22:32
 * @description: bean 完整生命周期
 */

/**
 * 实例化：Spring Boot 会通过反射机制自动实例化 UserService 对象。
 * 属性赋值：Spring Boot 会自动调用 setName 方法来设置 name 属性的值。
 * 初始化前：Spring Boot 会自动调用 @PostConstruct 注解标注的 init 方法。
 * 初始化：Spring Boot 会自动调用实现 InitializingBean 接口的 afterPropertiesSet 方法。
 * 初始化后：Bean 对象初始化完成之后，Spring Boot 会自动调用 UserService 的 toString 方法。
 * 这个示例中，我们可以在各个生命周期阶段中添加必要的业务逻辑，以确保 Bean 对象能够在正确的时间点执行所需的操作。
 * 一个常见的应用场景是在应用程序启动时，加载一些必要的配置信息。通过在 Bean 对象的初始化阶段执行一些必要的初始化操作，我们可以确保应用程序在启动时就能够正确地加载配置信息，从而避免一些问题的出现。
 */

/**
 * 参考 Spring进阶- Spring IOC实现原理详解之Bean实例化(生命周期,循环依赖等) | Java 全栈知识体系 https://pdai.tech/md/spring/spring-x-framework-ioc-source-3.html
 * 12:38:03.899 [main] INFO com.yezi.springframework.Application - Init application context
 * 12:38:04.326 [main] INFO com.yezi.springframework.config.BeansConfig - execute BeansConfig#afterPropertiesSet
 * 12:38:04.341 [main] INFO com.yezi.springframework.config.BeansConfig - execute BeansConfig#createUser
 * 12:38:04.341 [main] INFO com.yezi.springframework.User - execute User#new User()
 * 12:38:04.341 [main] INFO com.yezi.springframework.User - execute User#setName(pdai)
 * 12:38:04.343 [main] INFO com.yezi.springframework.User - execute User#setAge(18)
 * 12:38:04.343 [main] INFO com.yezi.springframework.User - execute BeanNameAware#setBeanName
 * 12:38:04.343 [main] INFO com.yezi.springframework.User - execute BeanClassLoaderAware#setBeanClassLoader
 * 12:38:04.343 [main] INFO com.yezi.springframework.User - execute BeanFactoryAware#setBeanFactory
 * 12:38:04.343 [main] INFO com.yezi.springframework.User - execute ApplicationContextAware#setApplicationContext
 * 12:38:04.343 [main] INFO com.yezi.springframework.User - execute InitializingBean#afterPropertiesSet: can aquire properties values
 * 12:38:04.344 [main] INFO com.yezi.springframework.User - execute User#doInit
 * 12:38:04.345 [main] INFO com.yezi.springframework.User - execute ProcessBeanFactory#postProcessBeanFactory
 * 12:38:04.445 [main] INFO com.yezi.springframework.Application - User(name=pdai, age=18, beanFactory=org.springframework.beans.factory.support.DefaultListableBeanFactory@682b2fa: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,beansConfig,user]; root of factory hierarchy, applicationContext=org.springframework.context.annotation.AnnotationConfigApplicationContext@5e57643e, started on Mon Apr 22 12:38:04 CST 2024, beanName=user)
 * 12:38:04.445 [main] INFO com.yezi.springframework.Application - Shutdown application context
 * 12:38:04.448 [SpringContextShutdownHook] INFO com.yezi.springframework.User - execute DisposableBean#destroy
 * 12:38:04.448 [SpringContextShutdownHook] INFO com.yezi.springframework.User - execute User#doDestroy
 */

@Slf4j
@ToString
public class User implements BeanFactoryAware, BeanNameAware, ApplicationContextAware,
        InitializingBean, DisposableBean, BeanClassLoaderAware, BeanPostProcessor, BeanFactoryPostProcessor, InstantiationAwareBeanPostProcessor {
    /**
     * user's name.
     */
    private String name;

    /**
     * user's age.
     */
    private int age;

    /**
     * bean factory.
     */
    private BeanFactory beanFactory;

    /**
     * application context.
     */
    private ApplicationContext applicationContext;

    /**
     * bean name.
     */
    private String beanName;

    /**
     * 补充 自动注入
     */
//    @Autowired
//    MyProperties myProperties;

    /**
     * 关于有参构造方式创建bean 见MyConstructorBuild类
     */
    public User() {
        log.info("execute User#new User()");
    }

    public void setName(String name) {
        log.info("execute User#setName({})", name);
        this.name = name;
    }

    public void setAge(int age) {
        log.info("execute User#setAge({})", age);
        this.age = age;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("execute BeanFactoryAware#setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        log.info("execute BeanNameAware#setBeanName");
        this.beanName = s;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("execute ApplicationContextAware#setApplicationContext");
        this.applicationContext = applicationContext;
    }

    @Override
    public void destroy() throws Exception {
        log.info("execute DisposableBean#destroy");
    }

    /**
     * 配合 以下属性使用
     * @Autowired
     * MyProperties myProperties;
     * @throws Exception
     */
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        // 这里可以获取到自动字段属性值
//        String name = myProperties.getName();
//        String password = myProperties.getPassword();
//        log.info("execute InitializingBean#afterPropertiesSet: can aquire properties values");
//    }
    @Override
    public void afterPropertiesSet() throws Exception {
        // 这里可以获取到自动字段属性值
        log.info("execute InitializingBean#afterPropertiesSet: can aquire properties values");
    }

    @PostConstruct
    public void init() {
        log.info("execute User#PostConstruct");
    }

    // 配置类中定义 @Bean(name = "user", initMethod = "doInit", destroyMethod = "doDestroy")
    public void doInit() {
        log.info("execute User#doInit");
    }

    // 配置类中定义 @Bean(name = "user", initMethod = "doInit", destroyMethod = "doDestroy")
    public void doDestroy() {
        log.info("execute User#doDestroy");
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("execute BeanClassLoaderAware#setBeanClassLoader");
    }

    /**
     * bean初始化前执行 注意这个是处理bean使用 处理所有的满足条件的bean
     * 相当于当前的类扮演特殊的角色 扮演BeanPostProcessor角色
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("execute BeanPostProcessor#postProcessBeforeInitialization");
        return bean;
    }

    /**
     * bean初始化后执行 注意这个是处理bean使用 处理所有的满足条件的bean
     * 相当于当前的类扮演特殊的角色 扮演BeanPostProcessor角色
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("execute BeanPostProcessor#postProcessAfterInitialization");
        return bean;
    }

    /**
     * 当前的类扮演特殊角色 扮演ProcessBeanFactory角色
     *
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("execute ProcessBeanFactory#postProcessBeanFactory");
    }

    /**
     * 当前的类扮演特殊角色 扮演InstantiationAwareBeanPostProcessor角色
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 当前的类扮演特殊角色 扮演InstantiationAwareBeanPostProcessor角色
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     * 当前的类扮演特殊角色 扮演InstantiationAwareBeanPostProcessor角色
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
