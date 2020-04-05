package me.choi.springapplicationcontextexerciese.scope.bean;

import me.choi.springapplicationcontextexerciese.scope.service.RegistrationService;
import me.choi.springapplicationcontextexerciese.scope.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Project : springapplicationcontextexerciese
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 12:19 오후
 */
public class UserRegistrationBeanImpl implements UserRegistrationBean{

    private UserInfo userInfo;

    @Autowired
    private RegistrationService registrationService;

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public Map<String, String> validate() {
        return null;
    }

    @Override
    public void register() {
        registrationService.register(userInfo);
    }

    //@PostConstruct
    public void init() {
        System.out.println("initializing :: "+System.identityHashCode(this));
    }
}
