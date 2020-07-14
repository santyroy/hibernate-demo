package org.example.cache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCacheDemo {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session1 = factory.openSession();
        // 1st Session
        // Second level cache has to be manually added -> associated with SessionFactory
        // Second Level cache -> need to add "Ehcache" jar and "hibernate-ehcache" jar as well

        // for the first time the data will be fetched from database
        Student student1 = session1.get(Student.class, 102);
        System.out.println(student1);

        session1.close();


        Session session2 = factory.openSession();
        // 2nd Session

        // Even when the session is closed still this time database is not queried.
        // Second level cache from SessionFactory returns the data.
        Student student2 = session2.get(Student.class, 102);
        System.out.println(student2);

        session2.close();

        factory.close();
    }
}
