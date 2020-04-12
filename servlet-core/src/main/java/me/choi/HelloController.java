package me.choi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : servlet-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/12
 * Time : 7:41 오후
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, "+helloService.getName();
    }

    /* case 02 :
    * response body 없이 문자열만 리턴하는 경우
    * */
    @GetMapping("/sample")
    public String sample() {
        return "/WEB-INF/sample.jsp";
    }
}
