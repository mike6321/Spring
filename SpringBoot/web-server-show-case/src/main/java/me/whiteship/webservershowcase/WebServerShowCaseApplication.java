package me.whiteship.webservershowcase;

//import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebServerShowCaseApplication {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring!";
    }

    public static void main(String[] args) {
        SpringApplication.run(WebServerShowCaseApplication.class, args);
    }

//    @Bean
//    public ServletWebServerFactory serverFactory() {
//
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createdStandardConnector());
//
//        return tomcat;
//    }
//
//    //http, https 도 받을 수있는 톰캣 생성
//    private Connector createdStandardConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(8080);
//
//        return connector;
//    }

}
