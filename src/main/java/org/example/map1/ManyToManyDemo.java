package org.example.map1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Worker w1 = new Worker();
        Worker w2 = new Worker();

        w1.setId(101);
        w1.setName("Ram");
        w2.setId(102);
        w2.setName("Sam");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setId(201);
        p1.setName("Library Management");
        p2.setId(202);
        p2.setName("Chat Bot");

        List<Worker> workerList = new ArrayList<>();
        List<Project> projectList =  new ArrayList<>();
        workerList.add(w1);
        workerList.add(w2);
        projectList.add(p1);
        projectList.add(p2);

        w1.setProjects(projectList);
        p2.setWorkers(workerList);

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(w1);
        session.save(w2);
        session.save(p1);
        session.save(p2);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
