package me.designpattern.strategypattern;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 11:53 오후
 */
public class Client {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Trail trail = new Trail();

        bus.setMovableStrategy(new RailLoadStrategy());
        trail.setMovableStrategy(new LoadStrategy());

        bus.move();
        trail.move();
    }
}
