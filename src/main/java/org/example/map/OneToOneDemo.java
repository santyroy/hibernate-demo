package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // creating question
        Question q1 = new Question();
        q1.setQuestionId(101);
        q1.setQuestion("What is Java?");

        // creating answer
        Answer a1 = new Answer();
        a1.setAnswerId(201);
        a1.setAnswer("Java is a platform independent programming language");
        a1.setQ(q1);
        q1.setQuestionAnswer(a1);

        // creating question
        Question q2 = new Question();
        q2.setQuestionId(102);
        q2.setQuestion("What is Collection framework");

        // creating answer
        Answer a2 = new Answer();
        a2.setAnswerId(202);
        a2.setAnswer("API to work with group of objects in java");
        a2.setQ(q2);
        q2.setQuestionAnswer(a2);


        Session session = factory.openSession();
        session.beginTransaction();

        session.save(a1);
        session.save(a2);
        session.save(q1);
        session.save(q2);

        session.getTransaction().commit();

        // fetching...
        Question question1 = session.get(Question.class, 101);
        System.out.println(question1.getQuestion());
        System.out.println(question1.getQuestionAnswer().getAnswer());

        session.close();
        factory.close();
    }
}
