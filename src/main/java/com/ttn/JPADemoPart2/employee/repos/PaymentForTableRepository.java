package com.ttn.JPADemoPart2.employee.repos;

import com.ttn.JPADemoPart2.employee.entities.payment.PaymentForTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentForTableRepository extends JpaRepository<PaymentForTable, Integer> {
}
