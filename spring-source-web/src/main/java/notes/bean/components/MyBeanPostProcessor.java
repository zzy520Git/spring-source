package notes.bean.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/24 20:01
 */
//@Component
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * BeanPostProcessor before方法工作在bean初始化方法init之前
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor在bean初始化之前调用" + beanName);
        return bean;
    }

    /**
     *
     * BeanPostProcessor after方法工作在bean初始化方法init之后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor在bean初始化之后调用：" + beanName);
        return bean;
    }
}
