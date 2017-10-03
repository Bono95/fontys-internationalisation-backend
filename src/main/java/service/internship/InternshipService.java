package service.internship;

import model.internship.Internship;

import java.util.List;

public interface InternshipService {
    List getAll();
    Internship find(int id);
}
