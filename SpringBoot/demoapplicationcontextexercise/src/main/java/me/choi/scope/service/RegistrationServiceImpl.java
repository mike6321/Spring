package me.choi.scope.service;

import javax.annotation.PostConstruct;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 2:20 오전
 */
public class RegistrationServiceImpl implements RegistrationService {

    //Ideally we should be injecting some DAO here

    @PostConstruct
    public void init() {
        System.out.println("initializing: " + System.identityHashCode(this));
    }

    @Override
    public void register(UserInfo userInfo) {
        //in real app we should pass userInfo to DAO to create user in Database
        System.out.println("User has been registered successfully: "+userInfo);
    }
}
