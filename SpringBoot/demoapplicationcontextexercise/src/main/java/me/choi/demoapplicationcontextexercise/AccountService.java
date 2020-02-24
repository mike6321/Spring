package me.choi.demoapplicationcontextexercise;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 7:41 오후
 */
public class AccountService {
    private SimpleConnectionMaker simpleConnectionMaker;

    public AccountService(SimpleConnectionMaker simpleConnectionMaker) {
        this.simpleConnectionMaker = simpleConnectionMaker;
    }
}
