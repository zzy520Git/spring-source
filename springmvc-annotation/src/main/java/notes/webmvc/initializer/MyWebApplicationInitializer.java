package notes.webmvc.initializer;

/**
 * Description：
 * In addition to using the ServletContext API directly,
 * you can also extend AbstractAnnotationConfigDispatcherServletInitializer
 * and override specific methods (see the example under Context Hierarchy).
 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
 *
 * 涉及父子容器
 *
 *
 * @author zzy-PC
 * @date 2020/3/26 14:47
 */
public class MyWebApplicationInitializer /* implements WebApplicationInitializer */{
    /*
    @Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
    */
}
