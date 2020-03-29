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
@Document(indexName = "blogzzy", type = "comment")
@Data
public class Comment {
    /**
     * 推荐主键@Id为text类型，我也不知道为什么
     */
    @Id
    @Field(type = FieldType.text, store = true)
    private String id;
    @Field(type = FieldType.Date, store = true)
    private Date date;
    @Field(type = FieldType.text, store = true, analyzer = "standard", index = true)
    private String content;
}
