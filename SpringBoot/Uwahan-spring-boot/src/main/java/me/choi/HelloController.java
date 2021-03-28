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
