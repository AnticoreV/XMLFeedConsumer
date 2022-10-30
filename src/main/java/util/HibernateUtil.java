package util;

import XML.INIReader;
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
            INIReader iniReader = INIReader.getINIReader();
            System.out.println(iniReader.getIniData().get(3) + "TEST");
            String a = iniReader.getIniData().get(3);
            System.out.println(a.length());

            try {
                Configuration cnfg = new Configuration();
                Properties prop = new Properties();
                prop.put(Environment.DRIVER, iniReader.getIniData().get(3));
                prop.put(Environment.URL, "jdbc:mysql://localhost:3306/xml");
                prop.put(Environment.USER, "root");
                prop.put(Environment.PASS, "H78f6bf6ddes3dr9245");
                prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
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
