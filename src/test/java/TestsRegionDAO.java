import external.dao.RegionDAO;
import external.entity.Region;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.criteria.CriteriaBuilder;

@Log4j
public class TestsRegionDAO {
    private static final Logger logger = Logger.getLogger(TestsRegionDAO.class);

    private RegionDAO regionDAO;

    @BeforeMethod
    public void setUp(){
        regionDAO = new RegionDAO();
    }

    @Test
    public void shouldFindByName() {
        Region regionToBeNotNull = regionDAO.findByName("Australia");
        //Region regionToBeNull = regionDAO.findByName("Africa");

        Assert.assertEquals("Australia", regionToBeNotNull.getRegionName());
     // Assert.assertNull(regionToBeNull);
    }

    @Test
    public void shouldFindById() {
        Region region = regionDAO.findById(1);

        Assert.assertEquals(1, region.getId());
    }

    @Test
    public void shouldSaveRegion(){

        Region region = new Region();
        region.setRegionName("Europe");
      // region.setId(3);

        regionDAO.save(region);

        Assert.assertEquals("Europe", regionDAO.findById(4).getRegionName());

    }

    @Test
    public void shouldDeleteRegion(){

        Region region = new Region();
        region.setRegionName("Europe");
        region.setId(7);

        regionDAO.delete(region);

        Assert.assertNull(regionDAO.findById(7));

    }

}
