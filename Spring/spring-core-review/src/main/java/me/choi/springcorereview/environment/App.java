package me.choi.springcorereview.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:04 오전
 */
@Component
public class App implements ApplicationRunner {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ctx.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        
        // TODO: Environment property 설정 : VM Option 2021/04/07 1:29 오전
        /**
         * VM Option
         * -Dapp.name=junwoo
         * */

        String name1 = environment.getProperty("app.name");
        String name2 = environment.getProperty("app.about");
        System.out.println(name1);
        System.out.println(name2);

        // TODO: Environment property 설정 : 파일생성 2021/04/07 1:34 오전
        /**
         * @PropertySource("파일위치") 사용
         *
         * @SpringBootApplication
         * @PropertySource("classpath:/app.properties")
         * public class EnvironmentExercise {
         *     public static void main(String[] args) {
         *         SpringApplication.run(EnvironmentExercise.class, args);
         *     }
         * }
         * */
    }
}
