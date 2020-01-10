package me.choi.demospringmvc.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

@GetMapping("/hello")
    /*@ResponseBody 가 생략되어 있다.*/
    public @ResponseBody String hello() {
        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {

        return user;
    }
}
