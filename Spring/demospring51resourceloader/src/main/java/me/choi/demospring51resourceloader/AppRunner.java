package me.choi.demospring51resourceloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    Validator validator;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator.getClass());

        Event event = new Event();
        event.setLimit(-1);
        event.setEmail("aaadfdfdf");
        EventValidator eventValidator = new EventValidator();
        Errors errors = new BeanPropertyBindingResult(event,"event"); //실질적으로 이 클래스를 직접 사용할 일은 없다.
                                                                                 // 스프링 Mvc가 자동으로 생성해주기 때문에
        //eventValidator.validate(event,errors);
        validator.validate(event,errors);
        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e ->{
            System.out.println("========error code======");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });

    }
}
