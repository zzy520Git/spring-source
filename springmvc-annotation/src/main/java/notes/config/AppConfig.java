package notes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/26 14:48
 */
@EnableWebMvc
@ComponentScan(value = "notes", includeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
        useDefaultFilters = false)
@Configuration
public class AppConfig {
}
