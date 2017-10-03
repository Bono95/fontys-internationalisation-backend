package controller;


import data.crud.CrudService;
import model.location.Location;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.location.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private LocationService service = appContext.getBean("locationService", LocationService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() { return service.getAll(); }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Location find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> register(@RequestBody Location location) { return crudService.insert(location); }

    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Location location) { return crudService.update(location); }
}
