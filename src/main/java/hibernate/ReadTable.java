package hibernate;

import entity.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadTable {

    public static void main(String[] args) {

        //Create session factory
        //New configuration - configure - addAnnotatedClass - buildSessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Table.class)
                .buildSessionFactory();

        //Create session from factory
        Session session = sessionFactory.getCurrentSession();

        try{

            //Start transaction
            session.beginTransaction();

            //Query read all from table
            List<Table> tables = session.createQuery("from Table").getResultList();
            displayTheTable(tables);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
        }
    }

    public static void displayTheTable(List<Table> tables){
        for (Table foreach : tables){
            System.out.println(foreach);
        }
    }
}
