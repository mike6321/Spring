package me.choi.eatgo.domain;

import jdk.internal.jimage.ImageStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:40 오후
 */
public class Restaurant {

    private  String name;
    private  String address;
    private  Long id;
    private List<MenuItem> menuItems = new ArrayList<>();



    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.address = address;
        this.name = name;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Restaurant() {

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

    public Long getId() {
        return id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            addMenuItem(menuItem);
        }
    }
}
