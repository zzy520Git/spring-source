package notes.elastic.dao;

import lombok.Data;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/29 14:11
 */
@Data
@Component
public class EsClientFactory {
    private TransportClient transportClient;

    @Value("${elasticsearch.cluster.name.master}")
    private String masterClusterName = "elasticsearch";

    @Value("${elasticsearch.cluster.address.master}")
    private String masterClusterAddress = "127.0.0.1";

    public TransportClient getTransportClient() {
        return transportClient;
    }

    @PostConstruct
    public void init() throws Exception {
        if (transportClient == null) {
            synchronized (EsClientFactory.class) {
                if (transportClient == null) {
                    Settings settings = Settings.builder()
                            .put("cluster.name", masterClusterName)
                            .put("client.transport.sniff", false)
                            .put("transport.netty.worker_count",1)
                            .build();
                    transportClient = new PreBuiltTransportClient(settings);
                    transportClient.addTransportAddress(
                            new InetSocketTransportAddress(InetAddress.getByName(masterClusterAddress), 9300));
                    //可以有多个addTransportAddress连接集群
                }
            }
        }

    }

    @PreDestroy
    public void destroy() {
        synchronized(EsClientFactory.class) {
            if (transportClient != null) {
                transportClient.close();
            }
        }
    }
}
