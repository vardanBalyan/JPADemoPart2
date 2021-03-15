package com.ttn.JPADemoPart2;

import com.ttn.JPADemoPart2.employee.entities.EmployeeComponentMapping;
import com.ttn.JPADemoPart2.employee.entities.SalaryComponentMapping;
import com.ttn.JPADemoPart2.employee.entities.payment.Cheque;
import com.ttn.JPADemoPart2.employee.entities.payment.CreditCard;
import com.ttn.JPADemoPart2.employee.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ServiceClass {
    @Autowired
    EmployeeRepository repository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentForTableRepository paymentForTableRepository;
    @Autowired
    PaymentForJoinRepository paymentForJoinRepository;
    @Autowired
    EmpRepository empRepository;

    //JPQL
    //1.

    public void findEmployeeBySalaryGreaterThanAverage()
    {
        List<Object[]> employees = repository.findEmployeeBySalary(
                Sort.by("age").and(Sort.by(Sort.Direction.DESC,"salary")));
        for(Object[] objects: employees)
        {
            System.out.println(objects[0]+" "+objects[1]);
        }

    }

    //2.

    @Transactional
    public void updateSalaryOfEmployeeWithSalaryLessThanAverage()
    {
        List<Integer> ids = repository.getEmployeeIdWithSalaryLessThanAverage();
        for(Integer id : ids)
        {
            repository.incrementSalaryBy(25000, id);
        }
    }

    //3.

    @Transactional
    public void deleteEmployeeWithMinimumSalary()
    {
        Double minSalary = repository.minSalary();
        repository.deleteMinSalaryEmployees(minSalary);
    }

    //Native

    //1.

    public void displayEmployeeWithLastNameSingh()
    {
        List<Object[]> employee = repository.findEmployeeWithLastNameSinghNQ();
        for(Object[] objects : employee)
        {
            System.out.println(objects[0]+" "+objects[1]+" "+objects[2]);
        }
    }

    //2.

    @Transactional
    public void deleteEmployeeHavingAgeMoreThan45()
    {
        repository.deleteEmployeeByAge(45);
    }

    //Inheritance Mapping

    //1.

    public void addPaymentInfoSingleTable()
    {
        Cheque ch = new Cheque();
        ch.setId(2);
        ch.setAmount(23232.6);
        ch.setChequenumber("1234");
        //paymentRepository.save(ch);
    }

    //2. Using Join
    public void addDataInChequeForJoinedInheritance()
    {
        Cheque ch = new Cheque();
        ch.setId(4);
        ch.setAmount(23334);
        ch.setChequenumber("536151");

        paymentForJoinRepository.save(ch);
    }

    public void addDataInCreditCardForJoinedInheritance()
    {
        CreditCard cc = new CreditCard();
        cc.setId(5);
        cc.setAmount(23334);
        cc.setCardnumber("536151");

        paymentForJoinRepository.save(cc);
    }

    // component mapping

    public void componentMapping()
    {
        EmployeeComponentMapping emp = new EmployeeComponentMapping();
        emp.setId(12);
        emp.setFirstName("Vardan");
        emp.setLastName("Balyan");
        emp.setAge(23);
        SalaryComponentMapping sal = new SalaryComponentMapping();
        sal.setBasicSalary(23000);
        sal.setBonusSalary(2000);
        sal.setTaxAmount(1734);
        sal.setSpecialAllowanceSalary(5000);
        emp.setSalaryComponentMapping(sal);

        empRepository.save(emp);
    }
}
