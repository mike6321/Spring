package me.choi.springcorereview.singleton;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:34 오전
 */
public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name" + name + " price = " + price);
        // TODO: 여기가 문제다!!! (Singleton)  
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
