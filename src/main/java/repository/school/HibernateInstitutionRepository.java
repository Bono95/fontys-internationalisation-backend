package repository.school;

import data.Database;
import model.school.Institution;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class HibernateInstitutionRepository implements InstitutionRepository {


    public List getAll() {

        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Institution");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public Institution find(int id) {

        Session session = Database.SESSION.openSession();

        Institution institution = session.find(Institution.class, id);

        return institution;
    }
}
