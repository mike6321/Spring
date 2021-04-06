package me.choi.springcorereview.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:38 오전
 */
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private Single single;

    @Autowired
    private Proto proto;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(proto);
//        System.out.println(single.getProto());

        System.out.println(applicationContext.getBean(Proto.class));
        System.out.println(applicationContext.getBean(Proto.class));
        System.out.println(applicationContext.getBean(Proto.class));

        System.out.println(applicationContext.getBean(Single.class));
        System.out.println(applicationContext.getBean(Single.class));
        System.out.println(applicationContext.getBean(Single.class));
        
        // TODO: 싱글톤 Scope내에 프로토타입 빈은 싱글톤과 같은 빈 생명주기를 가지기 때문에 같은 인스턴스를 가진다. 2021/04/07 12:54 오전
        /**
         * 해결방법 : @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
         * Proxy[ Proto[ ] ]
         * */
        System.out.println(single.getProto());
        System.out.println(single.getProto());
        System.out.println(single.getProto());


    }
}
