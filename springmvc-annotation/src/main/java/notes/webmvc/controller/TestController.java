package notes.webmvc.controller;

import notes.common.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/3/26 14:51
 */
@Controller
public class TestController {
    @ResponseBody
    @RequestMapping("/test")
    public Result<String> getUrl() {
        return Result.successResult("测试中文test");
    }
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
