package Data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory ourSessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();

        ourSessionFactory = configuration.buildSessionFactory();

    }

    public static SessionFactory getSession() throws HibernateException {
        return ourSessionFactory;
    }
}
