package notes.bean.components;

import notes.bean.animal.Cat;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/28 11:50
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * 此方法工作在所有bean定义信息（BeanDefinition）将要被加载，还未被加载的阶段
     *
     * 先于BeanFactoryPostProcessor处理器的postProcessBeanFactory执行
     *
     * 可动态添加一些bean定义信息，或者组件
     *
     * @param registry bean定义信息的存储中心
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...Registry;bean数量"
                + registry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Cat.class);
        registry.registerBeanDefinition("catRegistry", rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...post;bean数量"
                + beanFactory.getBeanDefinitionCount());
    }
}
