package repository.internship;

import model.internship.Internship;

import java.util.List;

public interface InternshipRepository {

    List getAll();

    Internship find(int id);
}
