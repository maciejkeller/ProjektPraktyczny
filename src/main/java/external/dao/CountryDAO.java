package external.dao;

import external.connection.HibernateUtil;
import external.entity.Country;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class CountryDAO implements InterfaceDAO<Country> {
    private final Logger logger = Logger.getLogger(CountryDAO.class);


    @Override
    public List<Country> findAll() {
        Transaction transaction = null;
        List<Country> countries = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            countries = session.createQuery("FROM Country").getResultList();
            transaction.commit();

            String listOfRegions = "";
            for (int i = 0; i < countries.size(); i++) {
                if (i != countries.size() - 1) listOfRegions += countries.get(i).getCountryName() + ", ";
                else listOfRegions += countries.get(i).getCountryName() + ".";
            }
            logger.info("\nFound all countries\n" + listOfRegions);

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }
        return countries;
    }

    @Override
    public Country findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Country Country = (external.entity.Country) session.createQuery("FROM Country WHERE country_name = :name").
                    setParameter("name", name).getSingleResult();
            transaction.commit();

            logger.info("Found Country: " + Country.getId() + ". " + Country.getCountryName());
            return Country;


        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        } catch (NullPointerException e) {
            logger.info("No Country of this name was found.");
        }

        return null;
    }

    @Override
    public Country findById(int id) {
        Transaction transaction = null;
        Country Country = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Country = session.get(external.entity.Country.class, id);

            transaction.commit();

            logger.info("Found Country: " + Country.getId() + ". " + Country.getCountryName());

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        } catch (NullPointerException e) {
            logger.info("No Country of this id was found.");
        }

        return Country;
    }

    @Override
    public void save(Country Country) {
        Transaction transaction = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(Country);
            transaction.commit();
            logger.info("Saved new Country: " + Country.getId() + ". " + Country.getCountryName());
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }

    }

    @Override
    public void delete(Country country) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.createQuery("delete from country where country_name:=" + country.getCountryName());
            transaction.commit();
            logger.info("Deleted Country: " + country.getId() + ". " + country.getCountryName());
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            logger.info("Such Country does not exist.");
        }

    }

    @Override
    public void update(Country Country) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(Country);
            transaction.commit();
            logger.info("The Country was updated.");
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }
    }

}
