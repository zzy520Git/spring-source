package notes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/26 14:48
 */
@ComponentScan(value = "notes", excludeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
@Configuration
public class RootConfig {
}
