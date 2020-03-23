package me.aop.dao;

import me.aop.dto.User;

import java.util.List;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 9:36 오후
 */
public class UserDao {

    private List<User> userList;


    public List<User> getAll() {
        return userList;
    }
}
