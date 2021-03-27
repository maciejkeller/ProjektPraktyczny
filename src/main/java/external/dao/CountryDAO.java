package external.DAO;

import external.connection.HibernateUtil;
import external.entity.Country;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Log4j
public class CountryDAO implements InterfaceDAO<Country> {

    private final Logger logger = Logger.getLogger(RegionDAO.class);


    @Override
    public Country findById(Integer id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Country country = (Country) session.createQuery("FROM Country WHERE id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
            return country;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }

    @Override
    public void save(Country country) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(country);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public void delete(Country country) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(country);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();
            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public void update(Country country) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(country);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public List<Country> findAll() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List<Country> countryList = (List<Country>) session.createQuery("FROM Country ", Country.class)
                    .getResultList();

            transaction.commit();
            return countryList;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
        return null;
    }

    @Override
    public Country findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Country country = (Country) session.createQuery("FROM Country WHERE name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            transaction.commit();
            return country;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }
}
