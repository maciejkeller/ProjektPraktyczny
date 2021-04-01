package external.DAO;

import external.connection.HibernateUtil;
import external.entity.City;
import external.entity.Region;
import external.entity.WeatherData;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class WeatherDataDAO implements InterfaceDAO<WeatherData> {

    private final Logger logger = Logger.getLogger(RegionDAO.class);

    @Override
    public WeatherData findById(Integer id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            WeatherData weatherData = (WeatherData) session.createQuery("FROM City WHERE id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
            return weatherData;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }

    @Override
    public void save(WeatherData weatherData) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(weatherData);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public void delete(WeatherData weatherData) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(weatherData);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();
            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public void update(WeatherData weatherData) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(weatherData);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
    }

    @Override
    public List<WeatherData> findAll() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List<WeatherData> weatherDataList = (List<WeatherData>) session.createQuery("FROM MainData ", WeatherData.class)
                    .getResultList();

            transaction.commit();
            return weatherDataList;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }
        return null;
    }

    @Override
    public WeatherData findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            WeatherData weatherData = (WeatherData) session.createQuery("FROM MainData WHERE city = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            transaction.commit();
            return weatherData;
        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException.getMessage(), hibernateException);
        }

        return null;
    }
}
