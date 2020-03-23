package me.aop.service;

import me.aop.dto.User;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 10:16 오후
 */
public interface UserService {
    void add(User user);

    void upgradeLevels();
}
