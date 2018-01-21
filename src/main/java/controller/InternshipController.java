package controller;

import data.crud.CrudService;
import model.internship.Internship;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.internship.InternshipService;

import java.util.List;

@RestController
@RequestMapping("/internship")
@CrossOrigin("*")
public class InternshipController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private InternshipService service = appContext.getBean("internshipService", InternshipService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);


    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Internship find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody Internship internship) {
        return crudService.insert(internship);
    }

    @RequestMapping(value = "", method ={RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Internship internship) {
        return crudService.update(internship);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return crudService.delete(service.find(id));
    }
}
