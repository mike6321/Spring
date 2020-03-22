package me.choi.demoapplicationcontextexercise;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
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
        BookService bean = context.getBean(BookService.class);
        //BookService bookService = context.getBean("bookService", BookService.class);



        //Book book = new Book();
        //book.setId("junwoobook");
        //book.setName("junwoo");

        //bookService.add(book);
        //System.out.println(bookService.get("junwoobook"));
    }
}

