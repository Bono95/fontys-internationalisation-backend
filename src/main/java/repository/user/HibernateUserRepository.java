package repository.user;

import data.Database;
import model.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateUserRepository implements UserRepository {


    public User login(String email, String password) {

        Session session = Database.SESSION.openSession();

        User user = (User) session.createQuery("FROM User WHERE email = :email AND password = :password")
                .setParameter("email",email)
                .setParameter("password", password)
                .uniqueResult();

        return user;
    }


    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM User ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public User find(int id) {
        Session session = Database.SESSION.openSession();

        User user = session.find(User.class, id);

        session.close();

        return user;
    }
}
