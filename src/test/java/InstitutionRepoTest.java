import data.crud.CrudOperation;
import data.crud.HibernateCrudOperation;
import model.location.Location;
import model.school.Institution;
import org.junit.Assert;
import org.junit.Test;
import repository.school.HibernateInstitutionRepository;
import repository.school.InstitutionRepository;

import java.util.List;

public class InstitutionRepoTest {

    CrudOperation crudRepo = new HibernateCrudOperation();
    InstitutionRepository institutionRepo = new HibernateInstitutionRepository();
    Institution institution = new Institution();

    @Test
    public void CreateTest(){
        institution.setActive(false);
        institution.setCity("TestCity");
        institution.setCountry("TestCountry");
        institution.setEmail("Test@Test.com");
        institution.setHouseNumber("1234");
        Location l = new Location();
        l.setLongitude(51.1234);
        l.setLatitude(52.1234);
        institution.setLocation(l);
        institution.setName("TestName");
        institution.setPhoneNumber("123456789");
        institution.setStreet("TestStreet");
        institution.setUrl("TestUrl");
        institution.setZipCode("TestZipCode");


        Assert.assertTrue(crudRepo.create(institution));


    }

    @Test
    public void FindTest(){
        List<Institution> institutions = institutionRepo.getAll();

        int id = institutions.get(institutions.size() - 1).getId();

        Assert.assertEquals(institutions.get(institutions.size() - 1).getEmail() , institutionRepo.find(id).getEmail());
    }

    @Test
    public void GetAllTest(){
        Assert.assertNotNull(institutionRepo.getAll());
    }

    @Test
    public void UpdateTest(){
        List<Institution> blogs = institutionRepo.getAll();

        Institution updateInstitution = blogs.get(blogs.size() - 1);
        updateInstitution.setName("UpdateTestName");

        Assert.assertTrue(crudRepo.update(updateInstitution));
    }
}
