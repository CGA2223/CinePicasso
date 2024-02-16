package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

public class HibernateUtiles {
    private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
    private static SessionFactory buildSessionFactory() {
        
            Configuration configuration = new Configuration();
            
            configuration.configure("/main/java/hibernate.cfg.xml");
            EntityScanner.scanPackages("com.fz.epms.db.model.entity").addTo(configuration);
            

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    // applySettings(configuration.getProperties()).build();
            		.configure("/main/java/hibernate.cfg.xml").build();            
            
            Metadata metadata = new MetadataSources( serviceRegistry )
                    .getMetadataBuilder()
                    .build();
            return metadata.getSessionFactoryBuilder().build();
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
