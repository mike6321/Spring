package me.choi.eatgo.domain;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:40 오후
 */
public class Restaurant {

    private final String name;
    private final String address;

    public Restaurant(String name, String address) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return name+ " in "+address;
    }
}
