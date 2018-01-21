import data.crud.CrudOperation;
import data.crud.HibernateCrudOperation;
import model.blog.Blog;
import model.user.User;
import org.junit.Assert;
import org.junit.Test;
import repository.blog.BlogRepository;
import repository.blog.HibernateBlogRepository;
import repository.user.HibernateUserRepository;
import repository.user.UserRepository;
import service.blog.BlogService;
import service.blog.DefaultBlogService;

import java.util.Date;
import java.util.List;


public class BlogRepositoryTest {

    UserRepository userRepo = new HibernateUserRepository();
    BlogRepository blogRepo = new HibernateBlogRepository();
    CrudOperation crudRepo = new HibernateCrudOperation();

    Blog b = new Blog();

    @Test
    public void CreateTest(){
        List<User> users = userRepo.getAll();
        Date d = new Date();

        b.setAccepted(false);
        b.setRejected(true);
        b.setApprovedBy(users.get(0));
        b.setContent("TestContent");
        b.setContentImage(null);
        b.setCreator(users.get(1));
        b.setDate(d);
        b.setSummary("TestSummary");
        b.setSummaryImage(null);
        b.setTitle("TestTitle");

        Assert.assertTrue(crudRepo.create(b));


    }

    @Test
    public void FindTest(){
        List<Blog> blogs = blogRepo.getAll();

        int id = blogs.get(blogs.size() - 1).getId();

        Assert.assertEquals(blogs.get(blogs.size() - 1).getTitle() , blogRepo.find(id).getTitle());
    }

    @Test
    public void GetAllTest(){
        Assert.assertNotNull(blogRepo.getAll());
    }

    @Test
    public void UpdateTest(){
        List<Blog> blogs = blogRepo.getAll();

        Blog updateBlog = blogs.get(blogs.size() - 1);
        updateBlog.setTitle("UpdatedTitleTest");

        Assert.assertTrue(blogRepo.update(updateBlog));
    }
}
