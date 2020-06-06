package notes.elastic.repository;

import notes.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Description：
 * spring-data太好用了
 *
 * @author zzy-PC
 * @date 2020/3/29 16:28
 */
public interface UserEsRepository extends ElasticsearchRepository<User, Long> {
    /**
     * 都是默认分页10条
     * 初始页码为0
     *
     * @param id
     * @return
     */
    List<User> getUserById(Long id);

    List<User> getUserByName(String name);

    List<User> getUserByNameAndSex(String name, Boolean sex);

    List<User> getUserByNameContains(String name);

    /**
     * 分页
     * @param name
     * @param sex
     * @param pageable
     * @return
     */
    List<User> getUserByNameContainsAndSex(String name, Boolean sex, Pageable pageable);

    /**
     * 自定义的查询方法需要满足springdata-es的命名规则
     */

}
