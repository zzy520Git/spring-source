package notes.config;

import notes.webmvc.converter.CustomDateConverter;
import notes.webmvc.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Description：springmvc子容器配置类
 *
 * 1.@EnableWebMvc类似<mvc:annotation-driven/>功能等价
 *      1）也可以直接继承DelegatingWebMvcConfiguration ，而不用使用此注解
 *      2）实现WebMvcConfigurer接口也是一种方法，开启springmvc
 * 2.@ComponentScan包扫描，在使用includeFilters时，要注意禁用默认过滤器useDefaultFilters = false
 *
 * @author zzy-PC
 * @date 2020/3/26 14:48
 */
@EnableWebMvc
@ComponentScan(value = "notes", includeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
        useDefaultFilters = false)
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(customDateConverter());
//        registry.addFormatter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /static/*代表只当前目录；/static/** 代表当前目录及其子目录；
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/*", "/assets/**/*");
        //registry.addInterceptor(contextInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**", "/assets/**/*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //todo 重点：不能写成classpath:/static/**
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    /**
     * 扩展转换器，不要用configureMessageConverters
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverter());
    }

    /**
     * 视图解析器配置，freemarker配置详见官方文档，更详细
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //简化jsp的视图解析器
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        //registry.jsp().prefix("/WEB-INF/").suffix(".jsp");
        //等价与上面配置
        registry.jsp();
    }

    /**
     * 等价配置<mvc:default-servlet-handler/>
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public CustomDateConverter customDateConverter() {
        return new CustomDateConverter();
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter stringHttpMessageConverter =
                new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return stringHttpMessageConverter;
    }


    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //单位字节，设置-1代表不限制
        multipartResolver.setMaxUploadSize(10000000);
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
    }
}
