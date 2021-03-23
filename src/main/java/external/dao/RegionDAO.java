package external.dao;

import com.google.gson.internal.$Gson$Preconditions;
import com.sun.xml.fastinfoset.util.StringArray;
import external.connection.HibernateUtil;
import external.entity.Region;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.List;

@Log4j
public class RegionDAO implements InterfaceDAO<Region> {

    private final Logger logger = Logger.getLogger(RegionDAO.class);


    @Override
    public Region findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Region region = (Region) session.createQuery("FROM Region WHERE region_name = :name").
                    setParameter("name", name).getSingleResult();
            transaction.commit();
            return region;


        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    @Override
    public Region findById(int id) {
        Transaction transaction = null;
        Region region = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            region = session.get(Region.class, id);

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }

        return region;
    }

    @Override
    public void save(Region region) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if (!session.contains(findByName(region.getRegionName()))) {
                session.save(region);
                transaction.commit();
            } else {
                session.close();
            }
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Region region) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if (session.contains(region)) {
                session.delete(region);
                transaction.commit();
            } else {
                session.close();
            }
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(Region region) {

    }

    @Override
    public List<Region> findAll() {
        return null;
    }


}
