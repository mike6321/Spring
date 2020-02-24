package me.choi.demoapplicationcontextexercise;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 7:34 오후
 */
public class BookFactory {
    public BookService bookService() {
        SimpleConnectionMaker connectionMaker = new AConnectionMaker();
        BookService bookService = new BookService(connectionMaker);

        return bookService;
    }
}
