package in.ezeon.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author unknown
 */
@Controller
public class TestController {

    @RequestMapping("/test/ajax_test")
    public String testPage() {
        return "test"; // -> /WEB-INF/view/test.jsp
    }

    @RequestMapping("/test/hello")
    public String helloWorld() {
        return "hello"; // -> /WEB-INF/view/hello.jsp
    }

    @RequestMapping("/test/get_time")
    @ResponseBody
    public String getServerTime() {
        System.out.println("----------getServerTime()-----------");
        Date d = new Date();
        return d.toString();
    }

}
