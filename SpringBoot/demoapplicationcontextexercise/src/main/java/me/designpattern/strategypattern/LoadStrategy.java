package me.designpattern;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 11:49 오후
 */
public class LoadStrategy implements MovableStrategy{
    @Override
    public void move() {
        System.out.println("도로를 이용");
    }
}
