package me.designpattern.proxypattern;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/24
 * Time : 12:09 오전
 */
public class DefaultBookService implements BookService{
    @Override
    public void run(Book book) {
        System.out.println(book.getTitle());
    }
}
