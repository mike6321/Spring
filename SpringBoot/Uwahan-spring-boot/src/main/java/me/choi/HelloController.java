package me.choi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    MyProperties myProperties;


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return myProperties.getMessage();
    }
}
// TODO: 자동 설정 우선순위 2021/03/28 2:10 오후
/**
 * 1. 애플리케이션에서 설정한 빈 등록
 * 2. 자동설정으로 제공하는 빈 등록
 * META-INF / spring.factories
 * EnableAutoConfiguration
 * */

// TODO: Priority 2021/03/28 3:05 오후
/**
 * 가장 구체적이고 가까운 위치에 있는 설정의 우선순위가 높다.
 *
 * "config"
 * /Applications/WorkingDirectory/repository/Spring/SpringBoot/Uwahan-spring-boot/src/main/resources/config/application.properties
 *
 *
 * */
