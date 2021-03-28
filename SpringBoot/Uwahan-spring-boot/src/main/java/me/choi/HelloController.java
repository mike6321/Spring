package me.choi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : Uwahan-spring-boot
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:05 오후
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "index";
    }
}
// TODO: 자동 설정 우선순위 2021/03/28 2:10 오후
/**
 * 1. 애플리케이션에서 설정한 빈 등록
 * 2. 자동설정으로 제공하는 빈 등록
 * META-INF / spring.factories
 * EnableAutoConfiguration
 * */
