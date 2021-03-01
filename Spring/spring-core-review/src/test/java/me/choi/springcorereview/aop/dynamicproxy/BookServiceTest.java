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

    // TODO: 자바의 프록시는 인터페이스 기반의 프록시만을 생성할 수 있다. 2021/03/02 12:29 오전
    /**
     * 클래스 기반의 프록시 생성 불가
     * RealSubjectBookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
     * 불가!
     * */
    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new RealSubjectBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // TODO: rent에만 적용할 수 있게끔 적용하였으나 코드의 복잡성이 올라간다. 2021/03/02 12:21 오전
                    if (method.getName().equals("rent")) {
                        System.out.println("****************logging****************");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("****************logging****************");

                        return invoke;
                    }

                    // TODO: 현재 rent에만 로깅을 적용하고 싶었으나 returnBook에도 로깅이 적용이 되었다. 2021/03/02 12:19 오전
//                    System.out.println("****************logging****************");
//                    Object invoke = method.invoke(bookService, args);
//                    System.out.println("****************logging****************");

                    return method.invoke(bookService, args);
                }
            });

    @Test
    public void bookServiceDiTest() {
        //given
        Book book = new Book(1, "Toby Spring");
        //when
        bookService.rent(book);
        bookService.returnBook(book);
        //then
    }
}