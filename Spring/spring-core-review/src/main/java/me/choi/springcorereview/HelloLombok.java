package me.choi.springcorereview;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:04 오후
 */
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("junwoo");
        helloLombok.setAge(31);

        System.out.println(helloLombok.toString());
    }
}
