package com.ttn.JPADemoPart2.employee.entities.payment;

import javax.persistence.*;

@Entity
@Table(name = "paymentnew")
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentForJoin {
    @Id
    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
