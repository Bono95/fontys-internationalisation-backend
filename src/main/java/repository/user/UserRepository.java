package repository.user;

import model.user.User;

import java.util.List;

public interface UserRepository {
    User login(String username, String password);

    List getAll();

    User find(int id);
}
