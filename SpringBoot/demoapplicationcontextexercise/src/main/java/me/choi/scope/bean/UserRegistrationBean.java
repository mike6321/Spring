package me.choi.scope.bean;

import me.choi.scope.service.UserInfo;

import java.util.Map;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 2:06 오전
 */
public interface UserRegistrationBean {
    public static String KEY_EMAIL = "email";
    public static String KEY_PASSWORD = "password";

    /**
     * @param userInfo
     */
    void setUserInfo(UserInfo userInfo);

    /**
     * @return list of validation errors otherwise null
     */
    Map<String, String> validate();

    /**
     * Perform registration for the new user.
     */
    void register();

}
