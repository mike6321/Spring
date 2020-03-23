package me.designpattern.proxypattern;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/24
 * Time : 12:07 오전
 */
public class BookServiceProxy implements BookService{

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(Book book) {
        System.out.println("******************************");
        bookService.run(book);
        System.out.println("******************************");
    }
}
