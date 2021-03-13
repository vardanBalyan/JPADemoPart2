package com.ttn.JPADemoPart2.employee.entities.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ch")
public class Cheque extends Payment{
    private String chequenumber;

    public String getChequenumber() {
        return chequenumber;
    }

    public void setChequenumber(String chequenumber) {
        this.chequenumber = chequenumber;
    }
}
