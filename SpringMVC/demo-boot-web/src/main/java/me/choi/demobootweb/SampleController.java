package me.choi.demobootweb;

import org.springframework.web.bind.annotation.*;


//preHandler1
    //preHandler2
    //요청처리
    //postHandler2
    //postHandler1
    //뷰 랜더링
    //afterCompletion2
    //afterCompletion1

@RestController
public class SampleController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") Person person) {
        return "hello "+person.getName();
    }

    @GetMapping("/message")
    public @ResponseBody String message (@RequestBody String body) {
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage (@RequestBody Person person) {
        return person;
    }

}
