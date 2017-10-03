package service.internship;

import model.internship.Internship;
import repository.internship.InternshipRepository;

import java.util.List;

public class DefaultInternshipService implements InternshipService{

    private InternshipRepository repository;


    public List getAll() {
        return repository.getAll();
    }

    public Internship find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters
    public void setRepository(InternshipRepository repository) {
        this.repository = repository;
    }
}
