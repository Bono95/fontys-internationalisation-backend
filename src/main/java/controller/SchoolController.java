package controller;

import data.crud.CrudService;
import model.school.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.school.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class SchoolController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private SchoolService service = appContext.getBean("schoolService", SchoolService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() { return service.getAll(); }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public School find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> register(@RequestBody School school) { return crudService.insert(school); }

    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody School school) { return crudService.update(school); }

}
