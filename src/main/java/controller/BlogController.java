package controller;

import data.crud.CrudService;
import model.blog.Blog;
import model.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.blog.BlogService;
import service.user.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private BlogService service = appContext.getBean("blogService", BlogService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

//    @Autowired
//    UserService userService;
//    CrudService crudService;

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() {
        return service.getAll();
    }

    @RequestMapping("/{id}")
    public Blog find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> register(@RequestBody Blog blog) {
        return crudService.insert(blog);
    }

    @RequestMapping(value = "", method ={RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Blog blog) {
        return crudService.update(blog);
    }
}
