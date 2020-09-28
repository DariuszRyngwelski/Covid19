package api.utils;

import api.entity.api.GetApi;
import api.entity.api.GetListCountry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    // Test hibernate

    public static void main(String[] args) {
        SessionFactory sessionFactory = new SessionFactoryProvider().getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        GetApi<?> g = new GetListCountry();
        System.out.println(g.getList());
        System.out.println(g.getUri());
        System.out.println(g.getTime());

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
