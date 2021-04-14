package me.choi.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
/**
mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=9003'

mvn clean
mvn compile package
java -jar -Dserver.port=9004 ./target/user-service-0.0.1-SNAPSHOT.jar
 * */
