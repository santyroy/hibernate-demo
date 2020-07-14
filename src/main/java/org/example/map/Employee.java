package org.example.map;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    private int employeeId;
    private String employeeName;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Account> accountList;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
