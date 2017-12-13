package repository.internshipRoute;

import data.Database;
import model.internshipRoute.InternshipRoute;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateInternshipRouteRepository implements InternshipRouteRepository {

    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM InternshipRoute ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public InternshipRoute find(int id) {
        Session session = Database.SESSION.openSession();

        InternshipRoute internshipRoute = session.find(InternshipRoute.class, id);

        session.close();

        return internshipRoute;
    }

}
