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
public interface UserDao {

    public void add(User user);

    public User get(String id);

    public void deleteAll();

    public List<User> getAll();

    void update(User user);
}
