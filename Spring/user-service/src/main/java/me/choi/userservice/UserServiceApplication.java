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
 * VM OPTION : -Dserver.port=9002
 * mvn run : mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=9003'
 * commandLine run :
 * mvn clean
 * mvn compile package
 * java -jar -Dserver.port=9004 ./target/user-service-0.0.1-SNAPSHOT.jar
 *
 * 랜덤포트 일때
 * mvn spring-boot:run
 * */
