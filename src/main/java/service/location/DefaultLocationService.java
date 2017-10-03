package service.location;

import model.location.Location;
import repository.location.LocationRepository;

import java.util.List;

public class DefaultLocationService implements LocationService {

    private LocationRepository repository;

    public List getAll() { return repository.getAll(); }

    public Location find(int id) { return repository.find(id); }

    public void setRepository(LocationRepository repository) { this.repository = repository; }

}
