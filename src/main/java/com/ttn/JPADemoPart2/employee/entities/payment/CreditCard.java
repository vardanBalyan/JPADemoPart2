package com.ttn.JPADemoPart2.employee.entities.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "cc")
public class CreditCard extends Payment{
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
