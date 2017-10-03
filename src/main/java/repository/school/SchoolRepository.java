package repository.school;

import model.school.School;

import java.util.List;

public interface SchoolRepository {
    List getAll();
    School find(int id);
}
