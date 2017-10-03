package data.crud;

 import data.Database;
 import model.Crudable;
 import org.hibernate.Session;

public class HibernateCrudOperation implements CrudOperation {

    public boolean create(Crudable crudable) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        boolean result = session.save(crudable) != null;

        session.getTransaction().commit();

        session.close();

        return result;
    }

    public boolean update(Crudable crudable) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.saveOrUpdate(crudable);

        session.getTransaction().commit();

        session.close();

        return true;
    }

    public boolean delete(Crudable crudable){
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.delete(crudable);

        session.getTransaction().commit();

        session.close();

        return true;
    }

}