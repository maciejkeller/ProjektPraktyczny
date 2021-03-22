package external.connection;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final Logger logger = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory sessionAnnotationFactory;

    private static SessionFactory buildAnnotationSessionFactory() {
        SessionFactory sessionFactory;
        try {
            // Create the SessionFactory from hibernate-local.cfg.xml
           sessionFactory = new Configuration().configure("hibernate-local.cfg.xml").buildSessionFactory();
            } catch (HibernateException ex) {
            // Make sure you log the exception, as it might be swallowed
            logger.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if(sessionAnnotationFactory==null){
            sessionAnnotationFactory=buildAnnotationSessionFactory();
        }
        return sessionAnnotationFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionAnnotationFactory().close();
    }
}
