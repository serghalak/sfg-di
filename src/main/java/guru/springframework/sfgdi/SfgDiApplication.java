package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = context.getBean("myController", MyController.class);

		I18nController i18nController=context.getBean("i18nController",I18nController.class);
		System.out.println(i18nController.sayGreeting());

		String greeting=myController.sayHello();
		System.out.println("------------Primary Bean");
		System.out.println(greeting);

		System.out.println("------------Property");
		PropertyInjectedController propertyInjectedController=context.getBean(
				"propertyInjectedController",PropertyInjectedController.class);
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------------Set");
		SetterInjectedController setterInjectedController=
				context.getBean("setterInjectedController",SetterInjectedController.class);
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------------Constructor");
		ConstructorInjectedController constructorInjectedController=
				context.getBean("constructorInjectedController",ConstructorInjectedController.class);
		System.out.println(constructorInjectedController.getGreeting());
	}

}
