package controller;

import data.crud.CrudService;
import model.school.Institution;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.school.InstitutionService;

import java.util.List;

@RestController
@RequestMapping("/institution")
@CrossOrigin("*")
public class InstitutionController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private InstitutionService service = appContext.getBean("institutionService", InstitutionService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() { return service.getAll(); }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Institution find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> create(@RequestBody Institution institution) { return crudService.insert(institution); }

    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Institution institution) { return crudService.update(institution); }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return crudService.delete(service.find(id));
    }

}
