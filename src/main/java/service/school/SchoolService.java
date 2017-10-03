package service.school;

import model.school.School;

import java.util.List;

public interface SchoolService {
    List getAll();
    School find(int id);
}
