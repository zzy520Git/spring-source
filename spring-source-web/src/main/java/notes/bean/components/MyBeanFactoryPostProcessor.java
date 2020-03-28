package notes.bean.components;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/28 11:36
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * beanFactory后置处理器工作在bean初始化之前，也工作在BeanPostProcessor之前
     *
     * 但是，工作在所有bean定义信息已经保存在beanFactory中，并且bean还未创建，的那个时机
     *
     * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
     *
     * 通常用于定制或修改beanFactory的内容
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor执行开始");
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("MyBeanFactoryPostProcessor执行完成");
    }
}
