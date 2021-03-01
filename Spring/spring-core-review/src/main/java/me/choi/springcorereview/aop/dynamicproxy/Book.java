package me.choi.springcorereview.aop.dynamicproxy;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:34 오후
 */
public class Book {

    private final Integer id;

    private final String name;

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
