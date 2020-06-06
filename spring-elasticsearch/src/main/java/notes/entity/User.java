package notes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/29 16:20
 */
@Document(indexName = "zzy", type = "user")
@Data
public class User {
    @Id
    @Field(type = FieldType.Long, store = true)
    private Long id;

    //ik_smart和ik_max_word
    @Field(type = FieldType.text, store = true, analyzer = "ik_smart")
    private String name;
    /**
     * 复合嵌套对象
     */
    @Field(type = FieldType.Nested, store = true)
    private Dog dog;


    @Field(type = FieldType.Integer, store = true)
    private Integer age;

    /**
     * 职业
     */
    @Field(type = FieldType.text, store = true, analyzer = "ik_smart")
    private String job;

    /**
     * 生日：yyyyMMddHHmmss
     */
    @Field(type = FieldType.Long, store = true)
    private Long birth;

    /**
     * 生日：
     */
    @Field(type = FieldType.Date, store = true)
    private Date date;

    /**
     * 性别
     */
    @Field(type = FieldType.Boolean, store = true)
    private Boolean sex;
}
