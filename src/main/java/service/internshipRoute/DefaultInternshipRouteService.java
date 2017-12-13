package service.internshipRoute;

import model.internshipRoute.InternshipRoute;
import repository.internshipRoute.InternshipRouteRepository;

import java.util.List;

public class DefaultInternshipRouteService implements InternshipRouteService {

    private InternshipRouteRepository repository;


    public List getAll() {
        return repository.getAll();
    }

    public InternshipRoute find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters
    public void setRepository(InternshipRouteRepository repository) {
        this.repository = repository;
    }
}
