package me.choi.springcorereview.aop.dynamicproxy;

import org.junit.jupiter.api.Test;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:44 오후
 */
class BookServiceTest {

    private BookService bookService = new BookServiceProxy(new RealSubjectBookService());

    @Test
    public void bookServiceDiTest() {
        //given
        Book book = new Book(1, "Toby Spring");
        //when
        bookService.rent(book);
        //then
    }
}