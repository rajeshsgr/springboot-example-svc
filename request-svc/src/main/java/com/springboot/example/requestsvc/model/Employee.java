package com.springboot.example.requestsvc.model
        ;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * @author rajeshp
 * @Date 10/8/22
 */
public class Employee {

    private String firstName;
    private String lastName;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private LocalDate startDate;
    private int empID;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startDate=" + startDate +
                ", empID=" + empID +
                '}';
    }
}
