package org.example.hql;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HQLExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        System.out.println("-----------------SELECT QUERY---------------------");
        // HQL
        // syntax:
//        String query = "from Student"; // name of the entity
//        String query = "from Student where city='Mumbai'"; // name of the entity
//        String query = "from Student where city=:x"; // name of the entity
        String query = "from Student as s where s.city=:x and s.name=:n"; // name of the entity
        Query<Student> q = session.createQuery(query, Student.class);
        q.setParameter("x", "Mumbai");
        q.setParameter("n", "Henry");
        // single result - unique
        // multiple result - list
        List<Student> students = q.list();
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("-----------------DELETE QUERY---------------------");
        session.beginTransaction();
        Query q1 = session.createQuery("delete from Student as s where s.name=:n"); // delete query should not be typed <Student>
        q1.setParameter("n", "Harish");
        int rows = q1.executeUpdate();
        System.out.println("Deleted " + rows + " rows.");


        System.out.println("-----------------UPDATE QUERY---------------------");
        Query q2 = session.createQuery("update Student set city=:c where name=:n");
        q2.setParameter("c", "Hyderabad");
        q2.setParameter("n", "Henry");
        rows = q2.executeUpdate();
        System.out.println("Updated " + rows + " rows");

        session.getTransaction().commit();

        System.out.println("-----------------JOIN QUERY---------------------");
        Query q3 = session.createQuery("select q.questionId, q.question, a.answerId, a.answer from Question as q INNER JOIN q.questionAnswer as a");
        List<Object[]>  resultList = q3.list();

        for (Object[] arr: resultList) {
            System.out.println(Arrays.toString(arr));
        }
        session.close();
        factory.close();
    }
}
