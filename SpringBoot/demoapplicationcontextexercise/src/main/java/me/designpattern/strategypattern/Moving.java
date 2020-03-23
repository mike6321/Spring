package me.designpattern.strategypattern;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 11:50 오후
 */
public class Moving {
    private MovableStrategy movableStrategy;

    public void setMovableStrategy(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        movableStrategy.move();
    }


}
