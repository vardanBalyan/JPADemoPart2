package com.ttn.JPADemoPart2;

import com.ttn.JPADemoPart2.employee.entities.Employee;
import com.ttn.JPADemoPart2.employee.entities.payment.CreditCard;
import com.ttn.JPADemoPart2.employee.repos.EmployeeRepository;
import com.ttn.JPADemoPart2.employee.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JpaDemoPart2ApplicationTests {

	@Autowired
	EmployeeRepository repository;
	@Autowired
	PaymentRepository prepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate()
	{
		Employee employee = new Employee();
		employee.setFirstName("Parth");
		employee.setLastName("Choudhary");
		employee.setSalary(23843);
		employee.setAge(21);

		repository.save(employee);
	}
	@Test
	public void testFindAll()
	{
		System.out.println(repository.findAllEmployees());
	}

	@Test
	public void testPartialInfo()
	{
		List<Object[]> employeePartialInfo = repository.findAllEmployeePartialInfo();
		for (Object[] objects:employeePartialInfo) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	public void testEmployeeByName()
	{
		System.out.println(repository.findAllEmployeeByFirstName("Vardan"));
	}

	@Test
	public void testEmployeeByAge()
	{
		System.out.println(repository.findEmployeeByAge(20,24));
	}

	@Test
	@Transactional
	//@Rollback for junit test only
	@Rollback(value = false)
	public void testDeleteByName()
	{
		repository.deleteEmployeeByName("parth");
	}

	@Test
	public void testFindBySalary()
	{
		List<Object[]> employees = repository.findEmployeeBySalary(
				Sort.by("age").and(Sort.by(Sort.Direction.DESC,"salary")));
		for(Object[] objects: employees)
		{
			System.out.println(objects[0]+" "+objects[1]);
		}

	}

	@Test
	@Transactional
	//@Rollback for junit test only
	@Rollback(value = false)
	public void testIncrementSalary()
	{
		//repository.incrementSalaryBy(3000);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeBySalary()
	{
		//repository.deleteMinSalaryEmployees();
	}

	@Test
	public void testDisplayEmployeeLastNameSingh()
	{
		List<Object[]> employee = repository.findEmployeeWithLastNameSinghNQ();
		for(Object[] objects : employee)
		{
			System.out.println(objects[0]+" "+objects[1]+" "+objects[2]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeByAge()
	{
		repository.deleteEmployeeByAge(45);
	}

	@Test
	public void addPaymentInfoSingleTable()
	{
		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setAmount(23232.6);
		cc.setCardnumber("21552161");
		prepository.save(cc);
	}
}
