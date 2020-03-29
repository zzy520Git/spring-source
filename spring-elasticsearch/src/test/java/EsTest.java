import notes.config.EsConfig;
import notes.elastic.dao.EsClientFactory;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;
import java.util.Map;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/29 14:45
 */
public class EsTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(EsConfig.class);

        EsClientFactory esClientFactory = applicationContext.getBean(EsClientFactory.class);
        TransportClient transportClient = esClientFactory.getTransportClient();

        //es相关api 查询
        QueryBuilder queryBuilder = new TermQueryBuilder("title", "money");
        //在这个索引上,这个type上，执行查询
        SearchResponse searchResponse = transportClient.prepareSearch("blog")
                .setTypes("article").setQuery(queryBuilder).get();

        //取查询结果
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询结果总记录数：" + hits.getTotalHits());

        //取查询结果列表
        Iterator<SearchHit> iterator = hits.iterator();

        while (iterator.hasNext()) {
            SearchHit next = iterator.next();
            //打印文档对象，以json形式输出
            System.out.println(next.getSourceAsString());
            //取文档属性字段
            System.out.println("===========取文档的属性===========");
            Map<String, Object> source = next.getSource();
            System.out.println(source.get("id"));
            System.out.println(source.get("title"));
            System.out.println(source.get("content"));
        }


        applicationContext.close();
    }
}
