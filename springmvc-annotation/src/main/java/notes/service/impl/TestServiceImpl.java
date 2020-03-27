package notes.service.impl;

import notes.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/27 12:52
 */
@Service("testService")
public class TestServiceImpl implements TestService, ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void print() {
        System.out.print("TestService.applicationContext=");
        System.out.println(applicationContext);
        System.out.print("TestService=");
        System.out.println(this);
//        TestController testController = applicationContext.getBean(TestController.class);
//        System.out.print("TestService.TestController=");
//        System.out.println(testController);
        for (String s : applicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
