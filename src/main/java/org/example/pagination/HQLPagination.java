package org.example.pagination;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Query<Student> q = session.createQuery("from Student", Student.class);

        // implementing pagination using hibernate
        q.setFirstResult(5); // from where the records needs to be taken
        q.setMaxResults(5); // how many records are needed to be fetched at a go -> 0,1,2,3,4
        List<Student> studentList = q.list();
        for (Student s:studentList) {
            System.out.println(s.toString());
        }

        session.close();
        factory.close();
    }
}
