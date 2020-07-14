package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CascadeExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Employee emp1 = new Employee();
        emp1.setEmployeeId(1001);
        emp1.setEmployeeName("Rock");

        Account acc1 = new Account(2001, "Savings Account", emp1);
        Account acc2 = new Account(2002, "Current Account", emp1);
        Account acc3 = new Account(2003, "Salary Account", emp1);
        Account acc4 = new Account(2004, "Fixed Deposit Account", emp1);
        List<Account> accountList = new ArrayList<>();
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
        accountList.add(acc4);

        emp1.setAccountList(accountList);

        session.beginTransaction();
        session.save(emp1); // As cascading is on so accounts will also get saved automatically
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
