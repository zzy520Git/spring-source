package notes.config.initializer;

import notes.config.AppConfig;
import notes.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Description：
 * 推荐在web中使用
 *
 * @author zzy-PC
 * @date 2020/3/26 15:04
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring父容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /**
     * springmvc子容器，找不到bean可以去父容器中找，delegate
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { AppConfig.class };
    }

    /**
     * 前端控制器映射
     * /  推荐,静态资源+正常请求 走前端控制器
     * /* 不推荐,静态资源+正常请求+jsp都走前端控制器
     * *.do 不推荐
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
