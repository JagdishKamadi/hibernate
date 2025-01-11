package org.epam;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Jagdish");
        student.setLastName("Kamadi");


        Session session = HibernateUtil.getSessionInstance();
        // open the transaction first
        Transaction tx = session.beginTransaction();
        session.persist(student);

        Student student1 = session.get(Student.class, 1);

        // close the transaction
        tx.commit();
        
        System.out.println(student1);

        // close the session
        session.close();

    }
}
