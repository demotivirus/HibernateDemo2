package hibernate;

import entity.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateTable {

    public static void main(String[] args) {

        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Table.class)
                .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try{

            //Begin transaction
            session.beginTransaction();

            //Create query and update
            System.out.println("Update all employee");
            session.createQuery("update Table set company='IndustryArg'").executeUpdate();

            //Commit
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
        }
    }
}
