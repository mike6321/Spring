package me.choi.springcorereview.aop.dynamicproxy.cglib;

import me.choi.springcorereview.aop.dynamicproxy.Book;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:45 오전
 */
public class BookServiceTest {

    @Test
    public void bookServiceDiTest() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new BookService();
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("****************logging****************");
                    Object invoke = method.invoke(bookService, objects);
                    System.out.println("****************logging****************");

                    return invoke;
                }

                return method.invoke(bookService, objects);
            }
        };

        //given
        BookService bookService = (BookService) Enhancer.create(BookService.class, handler);
        Book book = new Book(1, "Toby Spring");
        //when
        bookService.rent(book);
        bookService.returnBook(book);
        //then
    }
}
