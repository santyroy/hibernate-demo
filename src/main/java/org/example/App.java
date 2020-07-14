package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        System.out.println("Project Started!");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student st = new Student();
        st.setId(102);
        st.setName("Jason");
        st.setCity("Mumbai");
        System.out.println(st.toString());

        // Creating object of address class
        Address ad = new Address();
        ad.setStreet("street 1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(12.345); // data won't be saved as because field x is transient

        // Read image from resource
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/pic.png");
            byte[] data = new byte[fis.available()];
            fis.read(data);
            ad.setImage(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(st);
        session.save(ad);
        session.getTransaction().commit();
        session.close();
        System.out.println("Done...");

        factory.close();
    }
}
