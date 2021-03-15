package com.ttn.JPADemoPart2.employee.repos;

import com.ttn.JPADemoPart2.employee.entities.payment.PaymentForJoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentForJoinRepository extends JpaRepository<PaymentForJoin, Integer> {
}
