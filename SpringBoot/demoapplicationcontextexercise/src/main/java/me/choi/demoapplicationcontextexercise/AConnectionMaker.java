package me.choi.demoapplicationcontextexercise;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 7:06 오후
 */
public class AConnectionMaker implements SimpleConnectionMaker{
    @Override
    public void getConnection() {
        System.out.println("Aconnection complete!");
    }
}
