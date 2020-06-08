package me.choi.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:22 오후
 */
@RestController
public class WelcomeController {

    @GetMapping("/")
    public String hello() {
        return "hello, world!!!!";
    }
}
