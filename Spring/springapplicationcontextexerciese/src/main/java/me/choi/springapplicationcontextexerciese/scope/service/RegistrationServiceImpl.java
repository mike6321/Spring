package me.choi.springapplicationcontextexerciese.scope.service;

import javax.annotation.PostConstruct;

/**
 * Project : springapplicationcontextexerciese
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 12:24 오후
 */
public class RegistrationServiceImpl implements RegistrationService{
    @Override
    public void register(UserInfo userInfo) {
        System.out.println("성공적으로 등록되었습니다...!  "+userInfo.toString());
    }

    //@PostConstruct
    public void init() {
        System.out.println("initializing :: "+System.identityHashCode(this));
    }
}
