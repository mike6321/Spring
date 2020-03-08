package me.choi.demoapplicationcontextexercise;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/09
 * Time : 12:06 오전
 */
public class AutoRepository {

    @Autowired
    AutoService autoService;


    public void test() {
        System.out.println(autoService);
    }
}
