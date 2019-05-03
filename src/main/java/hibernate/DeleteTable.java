package hibernate;

import entity.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteTable {

    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Table.class)
                .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try{

            //Begin transaction
            session.beginTransaction();

            System.out.println("Delete all from Table");
            session.createQuery("delete from Table ").executeUpdate();

            //Commit
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
        }

    }
}
