package notes;

import lombok.extern.slf4j.Slf4j;
import notes.bean.animal.Dog;
import notes.config.ConfigOfIoc;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/24 19:22
 */
@Slf4j
public class IocTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigOfIoc.class);
        log.warn("spring初始化完成");
        Dog whiteDog = applicationContext.getBean(Dog.class);
        log.warn("whiteDog=" + whiteDog);

        applicationContext.close();
    }
}
