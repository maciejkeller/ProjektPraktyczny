package external.dao;

import external.connection.HibernateUtil;
import external.entity.Region;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class RegionDAO implements InterfaceDAO<Region> {

    private final Logger logger = Logger.getLogger(RegionDAO.class);


    @Override
    public List<Region> findAll() {
        Transaction transaction = null;
        List<Region> regions = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            regions = session.createQuery("FROM Region").getResultList();
            transaction.commit();

            String listOfRegions = "";
            for (int i = 0; i < regions.size(); i++) {
                if (i != regions.size() - 1) listOfRegions += regions.get(i).getRegionName() + ", ";
                else listOfRegions += regions.get(i).getRegionName() + ".";
            }
            logger.info("\nFound all regions\n" + listOfRegions);

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }
        return regions;
    }

    @Override
    public Region findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Region region = (Region) session.createQuery("FROM Region WHERE region_name = :name").
                    setParameter("name", name).getSingleResult();
            transaction.commit();

            logger.info("Found region: " + region.getId() + ". " + region.getRegionName());
            return region;


        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        } catch (NullPointerException e) {
            logger.info("No region of this name was found.");
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

            logger.info("Found region: " + region.getId() + ". " + region.getRegionName());

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        } catch (NullPointerException e) {
            logger.info("No region of this id was found.");
        }

        return region;
    }

    @Override
    public void save(Region region) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(region);
            transaction.commit();
            logger.info("Saved new region: " + region.getId() + ". " + region.getRegionName());
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

            session.createQuery("delete from Region where region_name:=" + region.getRegionName());
            transaction.commit();
            logger.info("Deleted region: " + region.getId() + ". " + region.getRegionName());
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            logger.info("Such region does not exist.");
        }

    }

    @Override
    public void update(Region region) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(region);
            transaction.commit();
            logger.info("The region was updated.");
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error(e.getMessage(), e);
        }
    }


}

