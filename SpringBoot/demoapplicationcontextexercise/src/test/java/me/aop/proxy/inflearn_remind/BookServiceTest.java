package me.aop.proxy.inflearn_remind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/28
 * Time : 8:42 오후
 */

class BookServiceTest {


    @Test
    public void di() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new BookService();

            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                if (method.getName().equals("rent")) {
                    System.out.println("************************************");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("************************************");
                    return invoke;
                }
                return method.invoke(bookService, args);
            }
        };


        BookService bookservice = (BookService)Enhancer.create(BookService.class, handler);


        Book book = new Book();
        book.setTitle("spring");

        bookservice.rent(book);
        bookservice.returnBook(book);
    }
}