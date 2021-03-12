package com.ttn.JPADemoPart2.employee.entities;

import org.hibernate.annotations.GeneratorType;
import org.springframework.cglib.core.KeyFactory;

import javax.persistence.*;

@Entity
@Table(name = "employeettn")
public class Employee {
    @Id
    @Column(name = "empId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="empFirstName")
    private String firstName;
    @Column(name = "empLastName")
    private String lastName;
    @Column(name = "empSalary")
    private double salary;
    @Column(name = "empAge")
    private int age;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                "}\n";
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
