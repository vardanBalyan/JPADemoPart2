package com.ttn.JPADemoPart2.employee.entities.payment;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)
public class Payment {
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
