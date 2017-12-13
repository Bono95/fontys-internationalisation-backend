package service.internshipRoute;

import model.internshipRoute.InternshipRoute;

import java.util.List;

public interface InternshipRouteService {
    List getAll();
    InternshipRoute find(int id);
}
