import external.dao.CountryDAO;
import external.dao.RegionDAO;
import external.entity.Country;
import external.entity.Region;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CountryDAOTests {
    private static final Logger logger = Logger.getLogger(CountryDAOTests.class);

    private CountryDAO countryDAO;


    @BeforeMethod
    public void setUp(){
        countryDAO = new CountryDAO();
    }


    @Test
    public void shouldFindAllRegions(){
        List<Country> countries = countryDAO.findAll();

        Assert.assertTrue(countries.size()>0);


    }

    @Test
    public void shouldFindByName() {
        Country country = countryDAO.findByName("Australia");
        //Region regionToBeNull = regionDAO.findByName("Africa");

        Assert.assertEquals("Australia", country.getCountryName());
        // Assert.assertNull(regionToBeNull);
    }

    @Test
    public void shouldFindById() {
        Country country = countryDAO.findById(1);

        Assert.assertEquals(1, country.getId());
    }

    @Test
    public void shouldSaveCountry(){
        RegionDAO regionDAO=new RegionDAO();
        Region europe = regionDAO.findByName("Europe");

        Country country =new Country();
        country.setCountryName("France");
        country.setCountryRegion(europe);

        countryDAO.save(country);

        Assert.assertEquals("Europe", regionDAO.findById(4).getRegionName());

    }

    @Test
    public void shouldDeleteCountry(){
        RegionDAO regionDAO=new RegionDAO();
        Region europe = regionDAO.findById(4);

        Country country =new Country();
        country.setCountryName("France");
        country.setCountryRegion(europe);

       countryDAO.delete(country);

        Assert.assertNull(countryDAO.findById(4));


    }
}
