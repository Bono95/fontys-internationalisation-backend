package repository.school;

import model.school.Institution;

import java.util.List;

public interface InstitutionRepository {
    List getAll();
    Institution find(int id);
}
