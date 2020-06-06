package notes.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/6/6 16:02
 */
@Data
public class Dog {

    @Field(type = FieldType.Long, store = true)
    private Long id;

    /**
     * 狗姓名
     */
    @Field(type = FieldType.text, store = true, analyzer = "ik_smart")
    private String name;

    @Field(type = FieldType.Integer, store = true)
    private Integer age;

    /**
     * 狗描述
     */
    @Field(type = FieldType.text, store = true, analyzer = "ik_smart")
    private String desc;

    /**
     * 狗生日：yyyyMMddHHmmss
     */
    @Field(type = FieldType.Long, store = true)
    private Long birth;

    /**
     * 狗生日：
     */
    @Field(type = FieldType.Date, store = true)
    private Date date;

    /**
     * 狗性别
     */
    @Field(type = FieldType.Boolean, store = true)
    private Boolean sex;
}
