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
public class UserService {

    @Autowired
    private TransactionManager transactionManager;

    @Autowired
    private UserDao userDao;



    public void upgradeLevels() {
        this.transactionManager.startTransaction();

        try {

            upgradeLevelInternal();
            this.transactionManager.commit();

        }catch (Exception e) {
            this.transactionManager.rollback();
        }

    }

    public void upgradeLevelInternal() {
        System.out.println("Business Logic!");
    }
}
