package me.choi.demoapplicationcontextexercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/08
 * Time : 10:12 오전
 */
public class AutoServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BookFactory.class);
        applicationContext.getBean("bookService", BookService.class);
        //System.out.println(applicationContext.getBean("autoService", AutoService.class));
        //System.out.println(applicationContext.getBean("bookService", BookService.class));

        ApplicationContext applicationContext2 =
                new AnnotationConfigApplicationContext(AutoService.class);


        applicationContext2.getBean("bookService", BookService.class);
        AutoRepository autoRepository = applicationContext2.getBean("autoRepository", AutoRepository.class);
        AutoRepository autoRepository2 = applicationContext2.getBean("autoRepository", AutoRepository.class);
        autoRepository.test();

        System.out.println(autoRepository);
        System.out.println(autoRepository2);


    }
}
