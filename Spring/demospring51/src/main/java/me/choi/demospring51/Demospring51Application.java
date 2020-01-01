package me.choi.demospring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Demospring51Application {

	public static void main(String[] args) {
//		ConfigurableApplicationContext run = SpringApplication.run(Demospring51Application.class, args);
////		String[] beanDefinitionNames = run.getBeanDefinitionNames();
////		System.out.println(Arrays.toString(beanDefinitionNames));
		SpringApplication.run(Demospring51Application.class, args);
	}

}
