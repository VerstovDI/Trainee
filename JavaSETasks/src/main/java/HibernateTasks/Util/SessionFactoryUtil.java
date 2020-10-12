package HibernateTasks.Util;

import HibernateTasks.Entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private  SessionFactoryUtil() {};

    protected static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                //configuration.addAnnotatedClass(Auto.class);
                //https://javastudy.ru/hibernate/hibernate-quick-start/
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                // .getProperties() - здесь мы как раз получаем файл hibernate.cfg.xml,
                // т.к. там есть тег hibernate-configuration
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                //StandardServiceRegistryBuilder.destroy(registry);
                throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
            }
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
