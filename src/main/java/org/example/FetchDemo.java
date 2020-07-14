package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        // get() and load() methods
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // no need of starting a transaction, transaction is only needed when saving data
        Student student = session.get(Student.class, 10000);
        System.out.println(student); // null object

        // this would first check the cache and then check database to get the value
        // this would run the select query as well
        Student student1 = session.get(Student.class, 102);
        System.out.println(student);

        Address ad = session.load(Address.class, 10000);
        System.out.println(ad.getStreet()); // this would throw ObjectNotFoundException

        // this would first give a proxy object until the object is used, select query is not run
        Address ad1 = session.load(Address.class, 1);
        System.out.println(ad.getStreet());

        session.close();
        factory.close();
    }

}
