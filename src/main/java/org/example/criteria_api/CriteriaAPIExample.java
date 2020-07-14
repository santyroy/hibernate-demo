package org.example.criteria_api;

import org.example.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

// Hibernate's legacy org.hibernate.Criteria API is deprecated;
// use the JPA javax.persistence.criteria.CriteriaQuery instead
public class CriteriaAPIExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Student.class);
        // Here we can add any sort of filter or even get all the data

        // restrict fetching of data
//        criteria.add(Restrictions.eq("certificate.course", "Android"));
//        criteria.add(Restrictions.gt("id", 105));
        criteria.add(Restrictions.like("certificate.course", "python%")); // case in-sensitive

        List<Student> students = criteria.list();
        for (Student s: students) {
            System.out.println(s);
        }

        session.close();
        factory.close();
    }
}
