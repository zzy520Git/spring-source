package notes.controller;

import notes.common.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/26 14:51
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public Result<String> getUrl() {
        return Result.successResult("测试中文test");
    }
}
