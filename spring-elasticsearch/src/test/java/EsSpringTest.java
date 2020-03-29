import notes.elastic.repository.CommentEsRepository;
import notes.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
