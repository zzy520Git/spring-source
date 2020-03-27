package notes.webmvc.controller;

import notes.common.util.Result;
import notes.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/26 14:51
 */
@Controller
public class TestController implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping("/test")
    public Result<String> getUrl() {
        return Result.successResult("测试中文test");
    }
    @RequestMapping("/index")
    public String index() {
        //todo 测试父子容器
        System.out.print("TestController.applicationContext=");
        System.out.println(applicationContext);
        System.out.print("TestController=");
        System.out.println(this);
        TestService testService = applicationContext.getBean(TestService.class);
        System.out.print("TestController.TestService=");
        System.out.println(testService);

        testService.print();
        return "index";

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
