package org.epam;

import org.epam.model.Address;
import org.epam.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Jagdish");
        student.setLastName("Kamadi");

        Address address = Address.builder()
                .place("Pawani")
                .landmark("Near water tank")
                .pinCode("442304")
                .build();

        student.setAddress(address);

        // make the configuration first
        Configuration config = new Configuration()
                .configure("hiberante.cfg.xml")
                .addAnnotatedClass(Student.class);

        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        // open the transaction first
        Transaction tx = session.beginTransaction();
        session.persist(student);

        // close the transaction
        Student student1 = session.get(Student.class,1);
        tx.commit();
        // close the session

        System.out.println(student1);
        session.close();

    }
}
