package notes.elastic.repository;

import notes.entity.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/29 16:28
 */
public interface CommentEsRepository extends ElasticsearchRepository<Comment, String> {
}
