package controller;

import data.crud.CrudService;
import model.internshipRoute.InternshipRoute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.internshipRoute.InternshipRouteService;

import java.util.List;

@RestController
@RequestMapping("/internshipRoute")
@CrossOrigin("*")
public class InternshipRouteController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private InternshipRouteService service = appContext.getBean("internshipRouteService", InternshipRouteService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);


    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public InternshipRoute find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody InternshipRoute internshipRoute) {
        return crudService.insert(internshipRoute);
    }

    @RequestMapping(value = "", method ={RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody InternshipRoute internshipRoute) {
        return crudService.update(internshipRoute);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return crudService.delete(service.find(id));
    }
}
