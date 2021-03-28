package me.blackship;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : uwahan-config
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:36 오후
 */
@RestController
public class UwahanController {

    @GetMapping("/lol")
    public String lol() {
        return "바텀은 서폿이 8할이다.";
    }
}
