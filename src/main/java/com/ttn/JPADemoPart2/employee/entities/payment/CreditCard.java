package com.ttn.JPADemoPart2.employee.entities.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard")
// for single table strategy use @DiscriminatorValue and also extend Payment class
//@DiscriminatorValue(value = "cc")
public class CreditCard extends PaymentForTable{
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
