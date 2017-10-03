package repository.location;

import model.location.Location;

import java.util.List;

public interface LocationRepository {
    List getAll();
    Location find(int id);
}
