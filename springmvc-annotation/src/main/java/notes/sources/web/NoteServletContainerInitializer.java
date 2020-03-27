package notes.sources.web;

/**
 * Description：
 *
 * 1.servlet容器的spi机制
 *  0）会扫描当前应用里面每一个jar包的META-INF/services/javax.servlet.ServletContainerInitializer的实现类
 *  1）会加载并运行所有ServletContainerInitializer的实现类（那个文件里面的实现类）
 *  2）然而spring-web包下有spi
 *  @HandlesTypes(WebApplicationInitializer.class)
 *  public class SpringServletContainerInitializer
 *      implements ServletContainerInitializer {
 *  3）@HandlesTypes也就是说，会加载所有实现了WebApplicationInitializer接口的实现类，传入onStartup的第一个参数
 *
 *
 * @see javax.servlet.ServletContainerInitializer
 * @see org.springframework.web.SpringServletContainerInitializer
 * @see org.springframework.web.WebApplicationInitializer
 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
 *
 *
 * @author zzy-PC
 * @date 2020/3/27 16:06
 */
public interface NoteServletContainerInitializer {
}
