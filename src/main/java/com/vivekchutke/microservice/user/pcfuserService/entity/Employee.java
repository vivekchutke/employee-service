package com.vivekchutke.microservice.user.pcfuserService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String userName;
    private String password;
    private String phoneNumber;
    private Date doj;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", userName='" + userName + '\'' +
                ", doj='" + doj + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Employee(String firstName, String lastName, Date dob, String userName, String password, String phoneNumber, Date doj) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.doj = doj;
    }

    public Employee(){

    }

}
