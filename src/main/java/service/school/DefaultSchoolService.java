package service.school;

import model.school.School;
import repository.school.SchoolRepository;

import java.util.List;

public class DefaultSchoolService implements SchoolService {

    private SchoolRepository repository;

    public List getAll() { return repository.getAll(); }

    public School find(int id) { return repository.find(id); }

    public void setRepository(SchoolRepository repository) { this.repository = repository; }
}
