package external.DAO;

import external.connection.HibernateUtil;
import external.entity.City;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Log4j
public class CityDAO implements InterfaceDAO<City> {

    private final Logger logger = Logger.getLogger(RegionDAO.class);

    @Override
    public City findById(Integer id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            City city = (City) session.createQuery("FROM City WHERE id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
            return city;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }

    @Override
    public void save(City city) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(city);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public void delete(City city) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(city);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();
            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public void update(City city) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(city);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public List<City> findAll() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List<City> cityList = (List<City>) session.createQuery("SELECT * FROM City", City.class)
                    .getResultList();

            transaction.commit();
            return cityList;
        } catch (HibernateException hibernateException) {
            if (transaction!=null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
        return null;
    }

    @Override
    public City findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            City city = (City) session.createQuery("FROM City WHERE name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            transaction.commit();
            return city;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }
}
