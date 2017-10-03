package repository.location;

import data.Database;
import model.location.Location;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateLocationRepository implements LocationRepository {

    public List getAll() {

        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Location");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public Location find(int id) {

        Session session = Database.SESSION.openSession();

        Location location = session.find(Location.class, id);

        session.close();

        return location;
    }
}
