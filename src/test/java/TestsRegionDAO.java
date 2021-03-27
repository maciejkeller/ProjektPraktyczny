import external.DAO.RegionDAO;
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
    public void shouldFindRegionById(){
        Region region = regionDAO.findById(1);

        Assert.assertEquals(region.getRegionName(),"North America");
    }

    @Test
    public void shouldSaveRegion(){
        Region region = new Region();
        region.setRegionName("Europe");

        regionDAO.save(region);

        Region savedRegion = regionDAO.findByName("Europe");

        Assert.assertEquals(savedRegion.getRegionName(), "Europe");

    }

}
