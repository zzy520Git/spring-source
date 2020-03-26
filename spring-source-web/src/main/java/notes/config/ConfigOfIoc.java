package notes.config;

import notes.bean.animal.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/24 19:37
 */
@ComponentScan(value = "notes.bean")
@Configuration
public class ConfigOfIoc {
    @Bean
    public Dog whiteDog() {
        Dog dog = new Dog("小白");
        return dog;
    }

}
