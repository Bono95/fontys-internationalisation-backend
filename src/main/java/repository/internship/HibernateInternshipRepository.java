package repository.internship;

import data.Database;
import model.internship.Internship;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateInternshipRepository implements InternshipRepository {

    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Internschip ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public Internship find(int id) {
        Session session = Database.SESSION.openSession();

        Internship internship = session.find(Internship.class, id);

        session.close();

        return internship;
    }
}
