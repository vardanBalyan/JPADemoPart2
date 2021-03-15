package com.ttn.JPADemoPart2.employee.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class EmployeeComponentMapping {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    @Embedded
    private SalaryComponentMapping salaryComponentMapping;

    public SalaryComponentMapping getSalaryComponentMapping() {
        return salaryComponentMapping;
    }

    public void setSalaryComponentMapping(SalaryComponentMapping salaryComponentMapping) {
        this.salaryComponentMapping = salaryComponentMapping;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
