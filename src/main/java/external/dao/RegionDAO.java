package external.DAO;

import external.connection.HibernateUtil;
import external.entity.Region;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Log4j
public class RegionDAO implements InterfaceDAO<Region> {

    private final Logger logger = Logger.getLogger(RegionDAO.class);

    @Override
    public Region findById(Integer id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Region region = (Region) session.createQuery("FROM Region WHERE id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
            return region;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }

    @Override
    public void save(Region region) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(region);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

    }

    @Override
    public void delete(Region region) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(region);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();
            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public void update(Region region) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(region);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public List<Region> findAll() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List<Region> regionList = (List<Region>) session.createQuery("FROM Region ", Region.class)
                    .getResultList();

            transaction.commit();
            return regionList;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
        return null;
    }

    @Override
    public Region findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Region region = (Region) session.createQuery("FROM Region WHERE region_name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            transaction.commit();
            return region;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }
}
