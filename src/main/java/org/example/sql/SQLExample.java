package org.example.sql;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SQLExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // SQL Query
        String query1 = "select * from Student";
        NativeQuery nativeQuery = session.createSQLQuery(query1);
        List<Object[]> objects = nativeQuery.list();
        for (Object[] student: objects) {
            System.out.println(Arrays.toString(student));
        }

        session.close();
        factory.close();
    }
}
