package me.aop.proxy.inflearn_remind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/28
 * Time : 8:40 오후
 */

public class BookService {

    public void rent(Book book) {
        System.out.println("rent :: "+book.getTitle());
    }

    public void returnBook(Book book) {
        System.out.println("return :: "+ book.getTitle());
    }
}
