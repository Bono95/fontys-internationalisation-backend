import data.crud.CrudOperation;
import data.crud.HibernateCrudOperation;
import model.location.Location;
import org.junit.Assert;
import org.junit.Test;
import repository.location.HibernateLocationRepository;
import repository.location.LocationRepository;

import java.util.List;

public class LocationRepoTest {

    CrudOperation crudRepo = new HibernateCrudOperation();
    LocationRepository locationRepo = new HibernateLocationRepository();
    Location l = new Location();

    @Test
    public void CreateTest(){
        l.setLatitude(51.1234);
        l.setLongitude(52.1234);

        Assert.assertTrue(crudRepo.create(l));


    }

    @Test
    public void FindTest(){
        List<Location> locations = locationRepo.getAll();

        int id = locations.get(locations.size() - 1).getId();

        Assert.assertEquals(locations.get(locations.size() - 1).getLatitude() , locationRepo.find(id).getLatitude(), 0.001);
    }

    @Test
    public void GetAllTest(){
        Assert.assertNotNull(locationRepo.getAll());
    }

    @Test
    public void UpdateTest(){
        List<Location> blogs = locationRepo.getAll();

        Location updateLocation = blogs.get(blogs.size() - 1);
        updateLocation.setLongitude(53.1234);

        Assert.assertTrue(crudRepo.update(updateLocation));
    }

}
