package me.choi.springapplicationcontextexerciese.scope.bean;

import me.choi.springapplicationcontextexerciese.scope.service.UserInfo;

import java.util.Map;

/**
 * Project : springapplicationcontextexerciese
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 12:05 오후
 */
public interface UserRegistrationBean {

    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";



    void setUserInfo(UserInfo userInfo);

    Map<String, String> validate();

    void register();
}
