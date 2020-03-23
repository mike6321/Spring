package me.aop.service;

import me.aop.dto.TransactionManager;
import me.aop.dto.User;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 9:33 오후
 */
public class UserServiceTx implements UserService{
    private UserService userService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void add(User user) {
        userService.add(user);
    }

    @Override
    public void upgradeLevels() {
        transactionManager.startTransaction();

        try {
            userService.upgradeLevels();
            transactionManager.commit();
        }catch (RuntimeException e) {
            transactionManager.rollback();
            throw e;
        }
    }
}
