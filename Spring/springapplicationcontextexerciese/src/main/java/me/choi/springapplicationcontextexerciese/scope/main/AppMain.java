package me.choi.springapplicationcontextexerciese.scope.main;

import me.choi.springapplicationcontextexerciese.scope.bean.UserRegistrationBean;
import me.choi.springapplicationcontextexerciese.scope.service.UserInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Project : springapplicationcontextexerciese
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 12:06 오후
 */
public class AppMain {
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                                new AnnotationConfigApplicationContext(Config.class);

        UserRegistrationBean bean = context.getBean(UserRegistrationBean.class);

        while (true) {
            System.out.println("Bean의 인스턴스를 등록 :: "+System.identityHashCode(bean));

            UserInfo userInfo = new UserInfo();
            bean.setUserInfo(userInfo);

            String s;
            System.out.print("email 정보를 입력하세요 :: ");
            s = sc.nextLine();
            userInfo.setEmail(s);

            System.out.print("password 정보를 입력하세요 :: ");
            s = sc.nextLine();
            userInfo.setPassword(s);


            bean.register();

            bean = context.getBean(UserRegistrationBean.class);


        }

    }
}
