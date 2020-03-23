package me.designpattern.proxypattern;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/24
 * Time : 12:10 오전
 */
public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookServiceProxy(new DefaultBookService());

        Book book = new Book();
        book.setTitle("토비의 스프링");
        bookService.run(book);

    }
}
