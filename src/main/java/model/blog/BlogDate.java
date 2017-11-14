package model.blog;

import model.Crudable;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class BlogDate implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private Timestamp date;

    public BlogDate() {
    }

    public BlogDate(int id, Timestamp date) {
        this.id = id;
        this.date = date;
    }

    public boolean isIncomplete() {
        return false;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
