package com.ttn.JPADemoPart2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaDemoPart2Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(JpaDemoPart2Application.class, args);
		ServiceClass service = applicationContext.getBean(ServiceClass.class);
		//service.findEmployeeBySalaryGreaterThanAverage();
		//service.updateSalaryOfEmployeeWithSalaryLessThanAverage();
		//service.deleteEmployeeWithMinimumSalary();
		//service.displayEmployeeWithLastNameSingh();
		//service.deleteEmployeeHavingAgeMoreThan45();
		//service.addDataInChequeForJoinedInheritance();
		//service.addDataInCreditCardForJoinedInheritance();
		service.componentMapping();
	}

}
