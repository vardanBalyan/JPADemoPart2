package com.ttn.JPADemoPart2.employee.entities.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/*use for table strategy and single table*///@Table(name = "creditcard")
/*use for joined strategy*/@Table(name = "creditcardnew")
/*use for joined strategy*/@PrimaryKeyJoinColumn(name = "id")
// for single table strategy use @DiscriminatorValue and also extend Payment class
//@DiscriminatorValue(value = "cc")
// for table type extend PaymentForTable class
public class CreditCard extends PaymentForJoin{
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
