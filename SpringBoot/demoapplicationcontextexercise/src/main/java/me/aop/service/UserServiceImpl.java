package me.aop.service;

import me.aop.dao.UserDao;
import me.aop.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 9:30 오후
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;



    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void upgradeLevels() {
        List<User> users = userDao.getAll();
        for (User user : users) {

        }
    }

}
