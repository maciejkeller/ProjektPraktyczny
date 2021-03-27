import external.dao.RegionDAO;
import external.entity.Region;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j
public class TestsRegionDAO {
    private static final Logger logger = Logger.getLogger(TestsRegionDAO.class);

    private RegionDAO regionDAO;

    @BeforeMethod
    public void setUp(){
        regionDAO = new RegionDAO();
    }

    @Test
    public void shouldRegionFindById(){
        Region region = regionDAO.findById(1);

        Assert.assertEquals("North America", region.getRegionName());
    }

    @Test
    public void shouldSaveRegion(){
      //  Region region = new Region( ,"Europe");

//        regionDAO.save(region);
//
//        Assert.assertEquals(region, regionDAO.findById(4));

    }

}
