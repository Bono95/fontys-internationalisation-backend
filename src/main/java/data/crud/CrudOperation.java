package data.crud;

import model.Crudable;

public interface CrudOperation {
    boolean create(Crudable object);

    boolean update(Crudable object);

    boolean delete(Crudable object);
}
