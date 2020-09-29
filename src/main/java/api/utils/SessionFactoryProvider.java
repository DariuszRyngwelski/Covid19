package api.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static SessionFactory sfApi;

    public SessionFactory getSessionFactory(Series series) {
        switch (series) {
            case API:
                return getSessionFactoryApi();
            case BASE:
                return null;
        }
        return null;
    }

    private SessionFactory getSessionFactoryApi() {
        if (sfApi == null) {
            sfApi = new Configuration().configure("api.cfg.xml")
                    .buildSessionFactory();
        }
        return sfApi;
    }


}
