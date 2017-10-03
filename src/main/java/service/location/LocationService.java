package service.location;

import model.location.Location;

import java.util.List;

public interface LocationService {
    List getAll();
    Location find(int id);
}
