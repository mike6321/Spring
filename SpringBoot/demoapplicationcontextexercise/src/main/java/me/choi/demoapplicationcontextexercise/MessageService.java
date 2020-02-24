package me.choi.demoapplicationcontextexercise;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 7:42 오후
 */
public class MessageService {
    private SimpleConnectionMaker simpleConnectionMaker;

    public MessageService(SimpleConnectionMaker simpleConnectionMaker) {
        this.simpleConnectionMaker = simpleConnectionMaker;
    }
}
