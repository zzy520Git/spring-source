import notes.elastic.repository.UserEsRepository;
import notes.entity.Dog;
import notes.entity.User;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private UserEsRepository userEsRepository;
    @Autowired(required = false)
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void createIndex() {
        //创建索引，并配置映射关系
        elasticsearchTemplate.createIndex(User.class);
        //配置映射关系
        //elasticsearchTemplate.putMapping(User.class);
        System.out.println("索引名必须全部小写");

    }

    @Test
    public void addDocument() {
        //更新文档等同于添加文档，id相同就行
        int k = 0;

        //for (int k=0 ; k<10 ; k++) {
        User user = new User();
        user.setId(1L + k);
        user.setName("中国人民银行");
        user.setAge(18);
        user.setSex(true);
        user.setBirth(19990101060659L);
        user.setJob("房地产开发商之霸道总裁");
        user.setDate(new Date());

        Dog dog = new Dog();
        dog.setId(111L + k);
        dog.setName("小白白");
        dog.setAge(2);
        dog.setDesc("爱犬哈士奇");
        dog.setSex(false);
        dog.setBirth(20201001060659L);

        //user.setDog(dog);

        User save = userEsRepository.save(user);
        //}
    }

    @Test
    public void delDocument() {
        userEsRepository.deleteById(1L);
    }

    @Test
    public void selectDocument() {
        Optional<User> optionalComment = userEsRepository.findById(1L);
        if (optionalComment.isPresent()) {
            System.out.println(optionalComment.get());
        }
        System.out.println("");
    }

    @Test
    public void findAll() {
        Iterable<User> all = userEsRepository.findAll();
        System.out.println(iter2List(all));
    }

    @Test
    public void tesFindByName() {
        List<User> u = userEsRepository.getUserByName("中国");
        System.out.println(u);
    }

    @Test
    public void tesFindByNameContain() {
        List<User> u = userEsRepository.getUserByNameContains("中国");
        System.out.println(u);
    }

    @Test
    public void tesFindById() {
        List<User> u = userEsRepository.getUserById(9L);
        System.out.println(u);
    }

    @Test
    public void tesFindByTwo() {
        List<User> u = userEsRepository.getUserByNameAndSex("中国人民银行", false);
        System.out.println(u);
    }

    @Test
    public void tesFindByPage() {
        List<Sort.Order> orders = new ArrayList<>();
        //不知道为什么不能通过ID排序
        // orders.add(new Sort.Order(Sort.Direction.ASC, "_id"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "age"));
        //0代表第一页
        Pageable pageable = PageRequest.of(0, 3, Sort.by(orders));
        //Pageable pageable = PageRequest.of(0, 3, Sort.)
        List<User> u = userEsRepository.getUserByNameContainsAndSex("银行", true, pageable);
        System.out.println(u);
    }

    private static <T> List<T> iter2List(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        if (iterable != null) {
            iterable.forEach(t -> {
                list.add(t);
            });
        }
        return list;
    }

    @Test
    public void testNativeSearchQuery() {
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("银行").defaultField("name"))
                .withPageable(PageRequest.of(0, 3)).build();
        List<User> users = elasticsearchTemplate.queryForList(query, User.class);
        System.out.println(users);
        users.forEach(System.out::println);
    }

}
