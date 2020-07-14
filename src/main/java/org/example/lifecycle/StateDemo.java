package org.example.lifecycle;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

    public static void main(String[] args) {

        // States in hibernate:
        // Transient
        // Persistent
        // Detached
        // Removed
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // creating student object
        Student student = new Student();

        student.setId(1001);
        student.setName("Mark");
        student.setCity("Hyderabad");
        student.setCertificate(new Certificate("Java Hibernate Course", "2 months"));
        // student: TRANSIENT STATE

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student); // insert query triggered
        // student: PERSISTENT STATE [associate with Session + Database]
        student.setName("John"); // because it is a persistent state so data automatically gets updated. update query triggered
        tx.commit();

        session.close(); // session.clear() -> student: DETACHED STATE
        student.setName("Henry"); // this data won't get saved in database.

        session = factory.openSession();
        session.beginTransaction();
        Student removeStudent = session.get(Student.class, 1001);
        session.remove(removeStudent); // student: REMOVED STATE , delete query triggered
        session.getTransaction().commit();
        factory.close();
    }
}
