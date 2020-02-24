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
        return new BookService(connectionMaker());
    }

    public AccountService accountService() {
        return new AccountService(connectionMaker());
    }

    public MessageService messageService() {
        return new MessageService(connectionMaker());
    }

    private AConnectionMaker connectionMaker() {
        return new AConnectionMaker();
    }
}
