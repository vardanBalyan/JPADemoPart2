package com.ttn.JPADemoPart2.employee.entities.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/*use for table strategy and single table *///@Table(name = "cheque")
/*use for joined strategy*/@Table(name = "chequenew")
/*use for joined strategy*/@PrimaryKeyJoinColumn(name = "id")
//@DiscriminatorValue(value = "ch")
public class Cheque extends PaymentForJoin{
    private String chequenumber;

    public String getChequenumber() {
        return chequenumber;
    }

    public void setChequenumber(String chequenumber) {
        this.chequenumber = chequenumber;
    }
}
