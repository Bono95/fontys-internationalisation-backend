package controller;

import data.crud.CrudService;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.user.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserService service = appContext.getBean("userService", UserService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

//    @Autowired
//    UserService userService;
//    CrudService crudService;

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public User find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "/login", method ={RequestMethod.POST})
    public User login(@RequestBody Map<String, String> values) {
        return service.login(values.get("username"), values.get("password"));
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> register(@RequestBody User user) {
        return crudService.insert(user);
    }

    @RequestMapping(value = "", method ={RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody User user) {
        return crudService.update(user);
    }
}