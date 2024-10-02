package fshare.tech.bean.processor.InstantiationAwareBeanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: yyj
 * @create: 2024-04-21 23:03
 * @description: TODO
 */

/**
 * 参考
 * https://blog.csdn.net/luzhensmart/article/details/105962536
 * <p>
 * InstantiationAwareBeanPostProcessor继承自BeanPostProcessor 是spring非常重要的拓展接口，
 * 代表这bean的一段生命周期: 实例化(Instantiation)
 * <p>
 * 1、postProcessBeforeInstantiation调用时机为bean实例化(Instantiation)之前 如果返回了bean实例, 则会替代原来正常通过target bean生成的bean的流程. 典型的例如aop返回proxy对象. 此时bean的执行流程将会缩短, 只会执行
 * <p>
 * BeanPostProcessor#postProcessAfterInitialization接口完成初始化。
 * <p>
 * 2、postProcessAfterInstantiation调用时机为bean实例化(Instantiation)之后和任何初始化(Initialization)之前。
 * <p>
 * 3、postProcessProperties调用时机为postProcessAfterInstantiation执行之后并返回true, 返回的PropertyValues将作用于给定bean属性赋值. spring 5.1之后出现以替换@Deprecated标注的postProcessPropertyValues
 * <p>
 * 4、postProcessPropertyValues已经被标注@Deprecated，后续将会被postProcessProperties取代。
 */

@Slf4j
@Component
/**
 *
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    /**
     * postProcessBeforeInstantiation调用时机为bean实例化(Instantiation)之前
     * 如果返回了bean实例, 则会替代原来正常通过target bean生成的bean的流程.
     * 典型的例如aop返回proxy对象. 此时bean的执行流程将会缩短, 只会执行 BeanPostProcessor#postProcessAfterInitialization接口完成初始化。
     * <p>
     * 可以用于动态代理生成代理对象
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("execute InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation for {}", beanName);
        //System.out.print("beanName:"+beanName+"执行..postProcessBeforeInstantiation\n");

//        if (beanClass == Bean.class) {
//            //利用cglib 其 生成动态代理
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(beanClass);
//            enhancer.setCallback(new BeanMethodInterceptor());
//            Bean bean = (Bean) enhancer.create();
//            System.out.print("返回动态代理\n");
//            return bean;
//        }

        return null;

    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("execute InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation for {}", beanName);
        System.out.print("beanName:" + beanName + "执行..postProcessAfterInstantiation\n");
        // 会影响postProcessProperties 是否执行，返回false不执行
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        log.info("execute InstantiationAwareBeanPostProcessor#postProcessProperties for {}", beanName);
        System.out.print("beanName:" + beanName + "执行..postProcessProperties\n");
        if (bean instanceof Bean) {
            //修改bean中name 的属性值
            PropertyValue value = pvs.getPropertyValue("name");
            System.out.print("修改之前 name 的value是：" + value.getValue() + "\n");
            value.setConvertedValue("我修改啦");
            return pvs;
        }
        return pvs;
    }
}
