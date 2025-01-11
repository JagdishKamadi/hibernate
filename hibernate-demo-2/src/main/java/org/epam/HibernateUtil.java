package org.epam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static Session INSTANCE;

    private HibernateUtil() {

    }

    public static Session getSessionInstance() {

        synchronized (HibernateUtil.class) {
            // make the configuration first
            Configuration config = new Configuration()
                    .configure("hiberante.cfg.xml")
                    .addAnnotatedClass(Student.class);

            // local SessionFactory bean created
            SessionFactory sessionFactory = config.buildSessionFactory();
            INSTANCE = sessionFactory.getCurrentSession();
        }

        return INSTANCE;
    }

}