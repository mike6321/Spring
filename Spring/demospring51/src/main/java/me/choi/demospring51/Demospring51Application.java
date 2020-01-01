package me.choi.demospring51;

import me.choi.outpackage.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.function.Supplier;

@SpringBootApplication
public class Demospring51Application {

	@Autowired
	MyService myService;


	public static void main(String[] args) {
//		SpringApplication.run(Demospring51Application.class, args);
		var app = new SpringApplication(Demospring51Application.class);
		/*중간에 무엇을 하고 싶을 때*/
		app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx ->
		{
			/*추가적인 코딩을 할 수 있다.*/

			/*추가적인 코딩을 할 수 있다.*/
			ctx.registerBean(MyService.class);
			ctx.registerBean(ApplicationRunner.class, () -> args1 -> System.out.println("Functional Bean Definition"));

		});
		/*중간에 무엇을 하고 싶을 때*/
		app.run(args);
	}
}
