package io.zipcoder.persistenceapp.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeNum;
    String firstName;
    String lastName;
    String title;
    String phoneNum;
    String email;
    LocalDate dateOfHire;
    @ManyToOne(fetch = FetchType.LAZY)
    Employee manager;

    //@JoinColumn?

    Integer deptNum;

    public Employee () {}

    public Employee(Long employeeNum, String firstName, String lastName, String title, String phoneNum, String email, LocalDate dateOfHire, Employee manager, Integer deptNum) {
        this.employeeNum = employeeNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNum = phoneNum;
        this.email = email;
        this.dateOfHire = dateOfHire;
        this.manager = manager;
        this.deptNum = deptNum;
    }

    public Employee(String firstName, String lastName, String title, String phoneNum, String email, LocalDate dateOfHire, Employee manager, Integer deptNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNum = phoneNum;
        this.email = email;
        this.dateOfHire = dateOfHire;
        this.manager = manager;
        this.deptNum = deptNum;
    }

    public Long getEmployeeNum() {
        return employeeNum;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Integer getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(Integer deptNum) {
        this.deptNum = deptNum;
    }
}
