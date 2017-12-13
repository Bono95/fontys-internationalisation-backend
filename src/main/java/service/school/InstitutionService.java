package service.school;

import model.school.Institution;

import java.util.List;

public interface InstitutionService {
    List getAll();
    Institution find(int id);
}
