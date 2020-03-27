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
    //源码断点debug追踪bean的初始化过程
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Dog whiteDog() {
        Dog dog = new Dog("小白");
        return dog;
    }

}
