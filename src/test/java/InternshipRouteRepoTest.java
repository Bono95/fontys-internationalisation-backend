import data.crud.CrudOperation;
import data.crud.HibernateCrudOperation;
import model.internshipRoute.InternshipRoute;
import org.junit.Assert;
import org.junit.Test;
import repository.internshipRoute.HibernateInternshipRouteRepository;
import repository.internshipRoute.InternshipRouteRepository;

import java.util.List;

public class InternshipRouteRepoTest {

    CrudOperation crudRepo = new HibernateCrudOperation();
    InternshipRouteRepository internshipRouteRepo = new HibernateInternshipRouteRepository();
    InternshipRoute ir = new InternshipRoute();

    @Test
    public void CreateTest(){
        ir.setActive(false);
        ir.setInstitution(null);
        ir.setName("Test");

        Assert.assertTrue(crudRepo.create(ir));


    }

    @Test
    public void FindTest(){
        List<InternshipRoute> internshipRoutes = internshipRouteRepo.getAll();

        int id = internshipRoutes.get(internshipRoutes.size() - 1).getId();

        Assert.assertEquals(internshipRoutes.get(internshipRoutes.size() - 1).getName() , internshipRouteRepo.find(id).getName());
    }

    @Test
    public void GetAllTest(){
        Assert.assertNotNull(internshipRouteRepo.getAll());
    }

    @Test
    public void UpdateTest(){
        List<InternshipRoute> internshipRoutes = internshipRouteRepo.getAll();

        InternshipRoute updateInternshipRoute = internshipRoutes.get(internshipRoutes.size() - 1);
        updateInternshipRoute.setName("UpdateNameTest");

        Assert.assertTrue(crudRepo.update(updateInternshipRoute));
    }
}
