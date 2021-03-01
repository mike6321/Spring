package me.choi.springcorereview.aop.dynamicproxy.cglib;

import me.choi.springcorereview.aop.dynamicproxy.Book;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:42 오전
 */
public class BookService {

    public void rent(Book book) {
        System.out.println("rent : " + book.getName());
    }

    public void returnBook(Book book) {
        System.out.println("return : " + book.getName());
    }
}
