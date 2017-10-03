package service.user;

import model.user.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    List getAll();
    User find(int id);
}
