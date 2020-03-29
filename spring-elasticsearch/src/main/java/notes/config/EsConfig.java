package notes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/29 14:43
 */
@ComponentScan(value = "notes.elastic")
@PropertySource(value = "classpath:/es.properties", encoding = "utf-8")
@Configuration
public class EsConfig {
}
