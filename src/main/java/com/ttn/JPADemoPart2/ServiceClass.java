package com.ttn.JPADemoPart2;

import com.ttn.JPADemoPart2.employee.entities.payment.Cheque;
import com.ttn.JPADemoPart2.employee.entities.payment.CreditCard;
import com.ttn.JPADemoPart2.employee.repos.EmployeeRepository;
import com.ttn.JPADemoPart2.employee.repos.PaymentForJoinRepository;
import com.ttn.JPADemoPart2.employee.repos.PaymentForTableRepository;
import com.ttn.JPADemoPart2.employee.repos.PaymentRepository;
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
        //repository.incrementSalaryBy(3000);
    }

    //3.

    @Transactional
    public void deleteEmployeeWithMinimumSalary()
    {
        //repository.deleteMinSalaryEmployees();
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
}
