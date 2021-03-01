package me.choi.springcorereview.aop.dynamicproxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:44 오후
 */
class BookServiceTest {

//    private BookService bookService = new BookServiceProxy(new RealSubjectBookService());

    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new RealSubjectBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("****************logging****************");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("****************logging****************");

                    return invoke;
                }
            });

    @Test
    public void bookServiceDiTest() {
        //given
        Book book = new Book(1, "Toby Spring");
        //when
        // TODO: 현재 rent에만 로깅을 적용하고 싶었으나 returnBook에도 로깅이 적용이 되었다. 2021/03/02 12:19 오전
        bookService.rent(book);
        bookService.returnBook(book);
        //then
    }
}