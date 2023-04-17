package com.emplpyee.HrManager;

import Service.HRManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {HRManagerService.class})
@EntityScan("Model")
@EnableJpaRepositories("Repository")
public class HrManagerApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(HrManagerApplication.class, args);
		HRManagerService service = (HRManagerService)  ctx.getBean("HRManagerService");
		// service.Test();
		service.Question1();
		service.Question2();
		service.Question3();
		service.Question4();
		service.Question5();
		service.Question6();
		service.Question7();
	}

}
