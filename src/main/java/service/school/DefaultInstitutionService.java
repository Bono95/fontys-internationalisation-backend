package service.school;

import model.school.Institution;
import repository.school.InstitutionRepository;

import java.util.List;

public class DefaultInstitutionService implements InstitutionService {

    private InstitutionRepository repository;

    public List getAll() { return repository.getAll(); }

    public Institution find(int id) { return repository.find(id); }

    public void setRepository(InstitutionRepository repository) { this.repository = repository; }
}
