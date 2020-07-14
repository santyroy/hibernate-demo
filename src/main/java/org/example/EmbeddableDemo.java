package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student st1 = new Student();
        st1.setId(102);
        st1.setName("Henry");
        st1.setCity("Mumbai");

        Certificate cert1 = new Certificate();
        cert1.setCourse("Android");
        cert1.setDuration("2 months");
        st1.setCertificate(cert1);

        Student st2 = new Student();
        st2.setId(103);
        st2.setName("Harry");
        st2.setCity("Bangalore");

        Certificate cert2 = new Certificate();
        cert2.setCourse("Hibernate");
        cert2.setDuration("1 month");
        st2.setCertificate(cert2);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
