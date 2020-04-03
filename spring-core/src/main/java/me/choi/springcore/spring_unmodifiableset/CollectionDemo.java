package me.choi.springcore.spring_unmodifiableset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Project : spring-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/03
 * Time : 9:33 오후
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("welcome");
        set.add("to");
        set.add("jw world");

        System.out.println(set);

        Set<String> unmoset = Collections.unmodifiableSet(set);

        System.out.println(unmoset);

        unmoset.add("Hello");

    }
}
