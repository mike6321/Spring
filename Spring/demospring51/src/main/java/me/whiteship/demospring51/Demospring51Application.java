package me.whiteship.demospring51;

import me.whiteship.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class Demospring51Application {

//    @Autowired
//    MyService myService;
//    @AliasFor("basePackages") 이것 때문에 패키지가 다르기때문에 에러가 떨어진다ß
    @Autowired
    MyService myService;

    public static void main(String[] args) {
        //SpringApplication.run(Demospring51Application.class, args);
        var app = new SpringApplication(Demospring51Application.class);
        app.addInitializers(new ApplicationContextInitializer<GenericApplicationContext>() {
            @Override
            public void initialize(GenericApplicationContext ctx) {
                ctx.registerBean(MyService.class);
                ctx.registerBean(ApplicationRunner.class, new Supplier<ApplicationRunner>() {
                    @Override
                    public ApplicationRunner get() {
                        return new ApplicationRunner() {
                            @Override
                            public void run(ApplicationArguments args) throws Exception {
                                System.out.println("Funtional Bean Definition");
                            }
                        };
                    }
                });

            }
        });
        app.run(args);
    }

}
