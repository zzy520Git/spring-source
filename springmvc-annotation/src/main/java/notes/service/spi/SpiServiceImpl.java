package notes.service.spi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/26 22:00
 */
@Slf4j
public class SpiServiceImpl implements SpiService, WebApplicationInitializer {
    //WebApplicationInitializer
    public SpiServiceImpl() {
        log.error("观察spi机制。。。");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.error("观察spi机制onStartup。。。");
    }
}
