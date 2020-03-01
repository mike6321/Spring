package me.choi.demoapplicationcontextexercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project : demoapplicationcontextexercise
 * Created by  n,InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 8:13 오후
 */
public class BookServiceTest {
    public static void main(String[] args) {
    ApplicationContext context = new
            AnnotationConfigApplicationContext(BookFactory.class);

        context.getBean("BookService", BookService.class);



    }}
