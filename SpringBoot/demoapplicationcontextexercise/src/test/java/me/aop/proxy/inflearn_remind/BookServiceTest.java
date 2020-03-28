package me.aop.proxy.inflearn_remind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

//    BookService bookService = new BookServiceProxy(new RealSubjectDefaultBookService());
    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(),
        new Class[]{BookService.class},
        new InvocationHandler() {
            BookService bookService = new RealSubjectDefaultBookService();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("##################################");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("##################################");

                    return invoke;
                }


                return method.invoke(bookService, args);
            }
        });

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);

        bookService.returnBook(book);
    }
}