package me.choi.webserver;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebServerApplication {

public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addContext("","/");

        /*서블릿 작성*/
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                System.out.println("doGet");
            }
        };
        tomcat.addServlet("", "servlet", servlet);
        context.addServletMappingDecoded("/hello", "servlet");
        /*서블릿 작성*/

        tomcat.getConnector();
        tomcat.start();
    }

}
