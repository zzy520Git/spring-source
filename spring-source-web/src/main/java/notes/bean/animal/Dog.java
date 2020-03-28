package notes.bean.animal;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/24 19:39
 */
@Data
@NoArgsConstructor
public class Dog {

    private String name;

    public Dog(String name) {
        System.out.println("Dog构造器执行");
        this.name = name;
    }

    public void init() {
        System.out.println("dog.init执行");
    }

    public void destroy() {
        System.out.println("dog.destroy执行");
    }
}
