package me.aop.proxy.inflearn_remind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/28
 * Time : 8:34 오후
 */
public interface BookService {

    public void rent(Book book);
}
