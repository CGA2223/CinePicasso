package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtiles {
    private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
    private static SessionFactory buildSessionFactory() {
        
            Configuration configuration = new Configuration();
            configuration.configure("/main/java/hibernate.cfg.xml");

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
     
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
