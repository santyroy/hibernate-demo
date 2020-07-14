package org.example.cache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // First level cache is by default active -> associated with Session

        // for the first time student is fetched from database.
        Student student = session.get(Student.class, 102);
        System.out.println(student);

        System.out.println("Working something....");

        // this time as because session is not closed so data is first checked inside first level cache (Session Object),
        // if found then data is returned from there itself, if not then database is called.
        Student student1 = session.get(Student.class, 102);
        System.out.println(student1);
        boolean found = session.contains(student1);
        System.out.println(found); // true

        session.close();
        factory.close();
    }
}
