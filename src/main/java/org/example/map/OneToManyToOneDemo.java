package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyToOneDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // creating employee
        Employee e1 = new Employee();
        e1.setEmployeeId(101);
        e1.setEmployeeName("Martin");

        // creating account
        Account a1 = new Account();
        a1.setAccountId(101);
        a1.setAccountType("Saving");
        a1.setEmployee(e1);

        Account a2 = new Account();
        a2.setAccountId(102);
        a2.setAccountType("Current");
        a2.setEmployee(e1);

        List<Account> e1accounts = new ArrayList<>();
        e1accounts.add(a1);
        e1accounts.add(a2);

        e1.setAccountList(e1accounts);

        Session session = factory.openSession();
        session.beginTransaction();
//        session.save(a1);
//        session.save(a2);
//        session.save(e1);
        session.getTransaction().commit();

        Employee emp1 = session.get(Employee.class, 101);
        System.out.println(emp1.getEmployeeId());
        System.out.println(emp1.getEmployeeName());
//        System.out.println(emp1.getAccountList().size());

//        for(Account account: emp1.getAccountList()) {
//            System.out.println(account.getAccountType());
//        }
        session.close();
        factory.close();
    }
}
