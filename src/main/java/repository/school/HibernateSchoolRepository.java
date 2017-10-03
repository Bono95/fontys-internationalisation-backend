package repository.school;

import data.Database;
import model.school.School;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class HibernateSchoolRepository implements SchoolRepository {


    public List getAll() {

        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM School");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public School find(int id) {

        Session session = Database.SESSION.openSession();

        School school = session.find(School.class, id);

        return school;
    }
}
