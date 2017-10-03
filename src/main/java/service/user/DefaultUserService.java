package service.user;

import model.user.User;
import repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private UserRepository repository;

    public User login(String username, String password) {
        return repository.login(username, password);
    }

    public List getAll() {
        return repository.getAll();
    }

    public User find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
