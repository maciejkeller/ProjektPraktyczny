package external.dao;

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
        Region region = null;

        try(Session session = HibernateUtil.getSessionAnnotationFactory().openSession()){
            transaction=session.beginTransaction();

            region = session.get(Region.class, id);

            transaction.commit();

        }catch (HibernateException e){
            if(transaction!=null)
                transaction.rollback();
            logger.error(e.getMessage(),e);
        }

        return region;
    }

    @Override
    public void save(Region region) {

    }

    @Override
    public void delete(Region region) {

    }

    @Override
    public void update(Region region) {

    }

    @Override
    public List<Region> findAll() {
        return null;
    }

    @Override
    public List<Region> findByName(String name) {
        return null;
    }
}
