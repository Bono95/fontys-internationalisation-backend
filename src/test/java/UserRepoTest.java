import data.crud.CrudOperation;
import data.crud.HibernateCrudOperation;
import model.user.User;
import org.junit.Assert;
import org.junit.Test;
import repository.user.HibernateUserRepository;
import repository.user.UserRepository;

import java.util.Date;
import java.util.List;

public class UserRepoTest {

    UserRepository userRepo = new HibernateUserRepository();
    CrudOperation crudRepo = new HibernateCrudOperation();

    User u = new User();

    @Test
    public void CreateTest(){
        u.setActive(false);
        u.setEmail("Test@Test.com");
        u.setFirstName("FistNameTest");
        u.setInfix("InfixTest");
        u.setLastName("LastNameTest");
        u.setModerator(true);
        u.setPassword("PasswordTest");
        u.setStudy("StudyTest");

        Assert.assertTrue(crudRepo.create(u));


    }

    @Test
    public void FindTest(){
        List<User> users = userRepo.getAll();

        int id = users.get(users.size() - 1).getId();

        Assert.assertEquals(users.get(users.size() - 1).getEmail() , userRepo.find(id).getEmail());
    }

    @Test
    public void GetAllTest(){
        Assert.assertNotNull(userRepo.getAll());
    }

    @Test
    public void UpdateTest(){
        List<User> users = userRepo.getAll();

        User updateUser = users.get(users.size() - 1);
        updateUser.setEmail(updateUser.getEmail() + "1");

        Assert.assertTrue(crudRepo.update(updateUser));
    }

    @Test
    public void LoginTest(){
        Assert.assertNotNull(userRepo.login("Test@Test.com", "PasswordTest"));
    }

}
