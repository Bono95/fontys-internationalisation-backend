import data.crud.CrudOperation;
import data.crud.HibernateCrudOperation;
import model.blog.Blog;
import model.internship.Internship;
import model.internshipRoute.InternshipRoute;
import model.school.Institution;
import model.user.User;
import org.junit.Assert;
import org.junit.Test;
import repository.blog.BlogRepository;
import repository.blog.HibernateBlogRepository;
import repository.internship.HibernateInternshipRepository;
import repository.internship.InternshipRepository;
import repository.internshipRoute.HibernateInternshipRouteRepository;
import repository.internshipRoute.InternshipRouteRepository;
import repository.school.HibernateInstitutionRepository;
import repository.school.InstitutionRepository;
import repository.user.HibernateUserRepository;
import repository.user.UserRepository;

import java.util.Date;
import java.util.List;

public class InternshipRepoTest {

    CrudOperation crudRepo = new HibernateCrudOperation();
    InternshipRepository internshipRepo = new HibernateInternshipRepository();
    Internship internship = new Internship();
    BlogRepository blogRepo = new HibernateBlogRepository();
    InstitutionRepository institutionRepo = new HibernateInstitutionRepository();
    InternshipRouteRepository internshipRouteRepo = new HibernateInternshipRouteRepository();
    UserRepository userRepo = new HibernateUserRepository();

    @Test
    public void CreateTest(){
        internship.setActive(false);
        internship.setBlog((Blog) blogRepo.getAll().get(0));
        internship.setEndDate(new Date());
        internship.setInstitution((Institution) institutionRepo.getAll().get(0));
        internship.setInternshipRoute((InternshipRoute) internshipRouteRepo.getAll().get(0));
        internship.setSemester(3);
        internship.setStartDate(new Date());
        internship.setSummary("TestSummary");
        internship.setTitle("TestTitle");
        internship.setUser((User) userRepo.getAll().get(0));

        Assert.assertTrue(crudRepo.create(internship));


    }

    @Test
    public void FindTest(){
        List<Internship> internships = internshipRepo.getAll();

        int id = internships.get(internships.size() - 1).getId();

        Assert.assertEquals(internships.get(internships.size() - 1).getTitle() , internshipRepo.find(id).getTitle());
    }

    @Test
    public void GetAllTest(){
        Assert.assertNotNull(internshipRepo.getAll());
    }

    @Test
    public void UpdateTest(){
        List<Internship> blogs = internshipRepo.getAll();

        Internship updateInternship = blogs.get(blogs.size() - 1);
        updateInternship.setTitle("UpdateTitle");

        Assert.assertTrue(crudRepo.update(updateInternship));
    }
}
