package repository.internshipRoute;

import model.internshipRoute.InternshipRoute;

import java.util.List;

public interface InternshipRouteRepository {

    List getAll();

    InternshipRoute find(int id);
}
