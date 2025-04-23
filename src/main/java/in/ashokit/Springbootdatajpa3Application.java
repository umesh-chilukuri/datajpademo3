package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.services.EmployeeService;

@SpringBootApplication
public class Springbootdatajpa3Application {

	public static void main(String[] args) {
ConfigurableApplicationContext run = SpringApplication.run(Springbootdatajpa3Application.class, args);
		
		EmployeeService e=run.getBean(EmployeeService.class);
		//e.insertContact();
		//e.updateContactName();
		//e.deleteContact(110);
		e.getAllEmployee();
		
	}

}
