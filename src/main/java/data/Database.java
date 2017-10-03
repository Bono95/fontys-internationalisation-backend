package data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Database {
//    private static SessionFactory sessionFactory;
//    private static ServiceRegistry serviceRegistry;
//
//    public static SessionFactory createSessionFactory() {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
//                configuration.getProperties()). build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        return sessionFactory;
//    }

    public static final SessionFactory SESSION = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

}