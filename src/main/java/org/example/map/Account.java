package org.example.map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
    @Id
    private int accountId;
    private String accountType;

    @ManyToOne
    private Employee employee;

    public Account() {
    }

    public Account(int accountId, String accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public Account(int accountId, String accountType, Employee employee) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.employee = employee;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
