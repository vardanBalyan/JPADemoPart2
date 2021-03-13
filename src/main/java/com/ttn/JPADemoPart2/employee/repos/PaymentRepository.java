package com.ttn.JPADemoPart2.employee.repos;

import com.ttn.JPADemoPart2.employee.entities.payment.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
