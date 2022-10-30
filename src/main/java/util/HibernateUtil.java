package util;

import model.Content;
import model.Element;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration cnfg = new Configuration();
                Properties prop = new Properties();
                prop.put(Environment.DRIVER, JDBCConnectionPropereties.driver);
                prop.put(Environment.URL, JDBCConnectionPropereties.url);
                prop.put(Environment.USER, JDBCConnectionPropereties.user);
                prop.put(Environment.PASS, JDBCConnectionPropereties.pass);
                prop.put(Environment.DIALECT, JDBCConnectionPropereties.dial);
                cnfg.setProperties(prop);
                cnfg.addAnnotatedClass(Element.class);
                cnfg.addAnnotatedClass(Content.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(cnfg.getProperties()).build();
                sessionFactory = cnfg.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Config Error!" + e);
            }
        }
        return sessionFactory;
    }
}
