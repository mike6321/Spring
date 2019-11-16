package me.choi.demospring51resourceloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //var ctx = new ClassPathXmlApplicationContext("abcd.xml");
        //var ctx = new FileSystemXmlApplicationContext("abcd.xml");
        //var ctx = new WebApplicationContext("abcd.xml");
        //문자열이 리소스로 변환된다.
        //사용하는 문자열은 자신이 사용하는 ApplicationContext가 무엇인가 따라서 달라진다.

        //resource를 가제하려면 prefix를 사용하면 됩니다...!
        System.out.println(resourceLoader.getClass());

        //classpath:를 사용하지 않은 경우에는 오류가 터집니다!
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        Resource resource2 = resourceLoader.getResource("file:///test.txt");
        Resource resource3 = resourceLoader.getResource("file:///test.txt");
        System.out.println(resource.getClass());
        System.out.println(resource2.getClass());
        System.out.println(resource3.getClass());

        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
        System.out.println(Files.readString(Path.of(resource.getURI())));;
    }
}
