import notes.elastic.repository.CommentEsRepository;
import notes.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Optional;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/29 16:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config-es.xml"})
public class EsSpringTest {
    @Autowired(required = false)
    private CommentEsRepository commentEsRepository;
    @Autowired(required = false)
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test() {
        //创建索引，并配置映射关系
        elasticsearchTemplate.createIndex(Comment.class);
        //配置映射关系
        //elasticsearchTemplate.putMapping(Comment.class);
        System.out.println("索引名必须全部小写");

    }

    @Test
    public void addDocument() {
        //更新文档等同于添加文档，id相同就行
        Comment comment = new Comment();
        comment.setId("1001");
        comment.setDate(new Date());
        comment.setContent("你是是电信1001班的某某某吗？in china!");
        Comment save = commentEsRepository.save(comment);
        //输出true
        System.out.println(save==comment);
    }

    @Test
    public void delDocument() {
        commentEsRepository.deleteById("1001");
    }

    @Test
    public void selectDocument() {
        Optional<Comment> optionalComment = commentEsRepository.findById("1001");
        Comment comment = optionalComment.get();
        System.out.println(comment);
    }

}
