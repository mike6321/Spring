package me.choi.springapplicationcontextexerciese;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class DemoApplication {

	public static void main(String[] args) {
		//해당 클래스르 빈 설정 파일로 사용
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		String[] beanDefinitionName = applicationContext.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionName));

		BookService bookService = (BookService) applicationContext.getBean("bookService");
		System.out.println(bookService.bookRepository != null);
	}
}
